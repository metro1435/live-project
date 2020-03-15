public class Order{
	private String orderID;//编号
	private String idNum;//身份证号
	private String phoneNum;//电话号码
	private int maskNum;
	private int ballot;
	
	public String getOrderID(){return orderID;}
	public String getIdNum(){return idNum;}
	public String getPhoneNum(){return phoneNum;}
	public int getMaskNum(){return maskNum;}
	public int getBallot(){return ballot;}
	public void setOrderID(String id){orderID=id;}
	public void setIdNum(String id){idNum=id;}
	public void setPhoneNum(String phone){phoneNum=phone;}
	public void setMaskNum(int mask){maskNum=mask;}
	public void setBallot(int ba){ballot=ba;}
}
