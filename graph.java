package dbChart;

public class graph {
	
}

class Order{
	private int orderID;//���
	private String idNum;//���֤��
	private String phoneNum;//�绰����
	private int maskNum;
	private int ballot;
	
	public int getOrderID(){return orderID;}
	public String getIdNum(){return idNum;}
	public String getPhoneNum(){return phoneNum;}
	public int getMaskNum(){return maskNum;}
	public int getBallot(){return ballot;}
	//public void setOrderID(int id){}
	public void setIdNum(String id){idNum=id;}
	public void setPhoneNum(String phone){phoneNum=phone;}
	public void setMaskNum(int mask){maskNum=mask;}
	public void setBallot(int ba){ballot=ba;}
}




