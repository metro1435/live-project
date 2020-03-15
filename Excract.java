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

}



