package initial_interface;

import java.util.ArrayList;
import java.util.List;

class Excract {
    int maskNum=0;
     
    Excract(int num) {
        maskNum=num;
    }
    public String[] getOrderNum() throws Exception {
    	List<Order> orderList=drawLots();
    	final int size=orderList.size();
        List<String> orderId=new ArrayList<String>();
        for (int i=0;i<size;i++) {
        	if (orderList.get(i).getBallot()==1) {
        		orderId.add(orderList.get(i).getOrderID());
        	}
        }
        String[]res = new String[orderList.size()];
        for(int i=0;i<orderList.size();i++){
            res[i]=orderList.get(i).getOrderID();
        }
        return res;
    }
 public List<Order> drawLots() throws Exception {
    	int sum=0;
    	OrderDAO od=new OrderDAO();
    	List<Order> orderList=OrderDAO.get();
        List<String> orderId=new ArrayList<String>();
        for (int i=0;i<orderList.size();i++) {
        	orderId.add(orderList.get(i).getOrderID());
        }
    	while (true) {
    		int random=(int)(Math.random()*orderId.size());
    		Order order=orderList.get(random);
    		sum+=order.getMaskNum();
    		User user=od.getUserById(order.getIdNum());
    		if (maskNum-sum<=0) break;
    		if (user.getFirst()==1||user.getSecond()==1||user.getThird()==1) continue;
    		else {
    			order.setBallot(1);
                od.updateInfo(order.getOrderID());
    			orderId.remove(random);
    		}
    	}
        changeStatus();
    	return orderList;
    }
private void changeStatus() throws Exception {
    	List<User> userList=UserDAO.get();
        for (int i=0;i<userList.size();i++) {
            User user=userList.get(i);
            int today=user.getToday();
            int first=user.getFirst();
            int second=user.getSecond();
            user.setToday(0);
            user.setFirst(today);
            user.setSecond(first);
            user.setThird(second);
            userList.set(i,user);
        }
        OrderDAO od=new OrderDAO();
        for (int i=0;i<userList.size();i++) {
            User user=userList.get(i);
            od.addList(user.getIdNum(),user.getToday(),user.getFirst(),
                    user.getSecond(),user.getThird());
        }
    }

}



