import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class sql {

	public static Connection getCon()throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mask?serverTimezone" +
						"=UTC&characterEncoding=utf-8&useSSL=false", "root", "misswang");
		return con;
	}

	public static void closeCon(Connection con)throws Exception {
		if(con!=null){
			con.close();
		}
	}

	public static List<Order> getOrder () throws Exception {
		Connection con = getCon();
		Statement stmt = con.createStatement();
		List<Order> orderList = new ArrayList<Order>();
		Order order = null;
		String sql = "select * from order";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()){
			order = new Order();
			order.setOrderID(rs.getInt("order_ID"));
			order.setIdNum(rs.getString("ID_num"));
			order.setPhoneNum(rs.getString("phone_num"));
			order.setMaskNum(rs.getInt("mask_num"));
			order.setBallot(rs.getInt("ballot"));
			orderList.add(order);
		}
		rs.close();
		stmt.close();
		closeCon(con);
		return orderList;
	}

	public static List<User> getUser() throws Exception {
		Connection con=sql.getCon();
		Statement stmt=con.createStatement();
		List<User> userList=new ArrayList<User>();
		User user = null;
		String sql = "select * from user";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()){
			user = new User();
			user.setName(rs.getString("name"));
			user.setIdNum(rs.getString("ID_num"));
			user.setPhoneNum(rs.getString("phone_num"));
			user.setFirst(rs.getInt("first"));
			user.setSecond(rs.getInt("second"));
			user.setThird(rs.getInt("third"));
			user.setToday(rs.getInt("today"));
			userList.add(user);
		}
		rs.close();
		stmt.close();
		closeCon(con);
		return userList;
	}


}
