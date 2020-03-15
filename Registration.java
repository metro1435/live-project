import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Registration {
    private String name;
    private String telNumber;
    private String id;
    private int sum;
    private static int number=0;
    
    public Registration(String name_,String telNumber_,String id_,int sum_) {
        name=name_;
        telNumber=telNumber_;
        id=id_;
        sum=sum_;
    }
    public String isLegal()throws Exception{
        String s="";
        
        Order order=new Order();
        order.setBallot(0);
        order.setIdNum(id);
        order.setMaskNum(sum);
        order.setOrderID(s);
        order.setPhoneNum(telNumber);
        OrderDAO orderdao=new OrderDAO();
        
        
        
            if(orderdao.find(order)) {
                //告知重复预约，结束运行当前函数
               return "预约失败";
                
            }else {
                number+=1;
                s=String.format("%08d",number-1);
                order.setOrderID(s);
                
                orderdao.update(order);
              
                
                User user=new User();
                user.setFirst(2);
                user.setSecond(2);
                user.setThird(2);
                user.setToday(0);
                user.setName(name);
                user.setPhoneNum(telNumber);
                user.setIdNum(id);
                
                UserDAO userDao=new UserDAO();
                if(userDao. getUserById(id)==null) {
                    userDao.add(user);
                }
                
            }
            
           
      
         return s;
        
    }
    

}
