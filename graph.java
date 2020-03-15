class Order{

	private String orderID;//
	private String idNum;//
	private String phoneNum;//
	private int maskNum;
	private int ballot;

	public String getOrderID(){return orderID;}
	public String getIdNum(){return idNum;}
	public String getPhoneNum(){return phoneNum;}
	public int getMaskNum(){return maskNum;}
	public int getBallot(){return ballot;}

	public void setOrderID(String id){orderID = orderID;}
	public void setIdNum(String id){idNum = id;}
	public void setPhoneNum(String phone){phoneNum = phone;}
	public void setMaskNum(int mask){maskNum = mask;}
	public void setBallot(int ba){ballot = ba;}
}

class User{
	private String name;
	private String idNum;
	private String phoneNum;
	private int first;
	private int second;
	private int third;
	private int today;

	public String getName(){return name;}
	public String getIdNum(){return idNum;}
	public String getPhoneNum(){return phoneNum;}
	public int getFirst(){return first;}
	public int getSecond(){return second;}
	public int getThird(){return third;}
	public int getToday(){return today;}

	public void setName(String na){name=na;}
	public void setIdNum(String id){idNum=id;}
	public void setPhoneNum(String phone){phoneNum=phone;}
	public void setFirst(int fi){first=fi;}
	public void setSecond(int se){second=se;}
	public void setThird(int th){third=th;}
	public void setToday(int to){today=to;}

}



