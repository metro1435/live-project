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
        
        
        
            
            
           
      
         return s;
        
    }
    

}
