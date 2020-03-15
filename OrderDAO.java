import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public int getTotal() {
        int total = 0;
        String sql = "SELECT COUNT(*) AS totalCount FROM mask.order";
        try (Connection c = DBUtil.getConnection(); PreparedStatement s = c.prepareStatement(sql)) {

            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                total = rs.getInt("totalCount");
            }
            DBUtil.close(rs,s,c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public void add(Order order) {
        String sql = "insert into mask.order values(?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, order.getOrderID());
            ps.setString(2, order.getIdNum());
            ps.setString(3, order.getPhoneNum());
            ps.setInt(4,order.getMaskNum());
            ps.setInt(5,order.getBallot());
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Order order) {
        String sql="update mask.order set order_ID=?,ID_num=?,phone_num=?," +
                "mask_num=?,ballot=? where order_ID=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, order.getIdNum());
            ps.setString(2, order.getPhoneNum());
            ps.setInt(3,order.getMaskNum());
            ps.setInt(4,order.getBallot());
            ps.setString(5, order.getOrderID());
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void delete(User user) {
//        String sql = "delete from user where id=?";
//        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, user.getName());
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static List<Order> get() throws Exception {
        List<Order> orderList=new ArrayList<Order>();
        Order order = null;
        String sql = "select * from mask.order";
        try (Connection c = DBUtil.getConnection(); Statement stmt=c.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                order = new Order();
                order.setOrderID(rs.getString("order_ID"));
                order.setIdNum(rs.getString("ID_num"));
                order.setPhoneNum(rs.getString("phone_num"));
                order.setMaskNum(rs.getInt("mask_num"));
                order.setBallot(rs.getInt("ballot"));
                orderList.add(order);
            }
            DBUtil.close(rs,stmt,c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
    
    public void updateInfo(String id) {
        String sql="update order set ballot=? where order_ID=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,1);
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUserById(String id){
        String sql="select * from mask.user where ID_num = ?";
        User user=null;
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setName(rs.getString("name"));
                user.setIdNum(rs.getString("ID_num"));
                user.setPhoneNum(rs.getString("phone_num"));
                user.setFirst(rs.getInt("first"));
                user.setSecond(rs.getInt("second"));
                user.setThird(rs.getInt("third"));
                user.setToday(rs.getInt("today"));
            }
            else{
                System.out.println("Can not found user where id="+id);
          
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		return user;
    }

    
    public void addList(String id,int today,int first,int second,int third) {
        String sql = "update user set today=? where ID_num=?";
        String sql1 = "update user set first=? where ID_num=?";
        String sql2 = "update user set second=? where ID_num=?";
        String sql3 = "update user set third=? where ID_num=?";
        try (Connection c = DBUtil.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, today);
            ps.setString(2, id);
            ps.execute();
            PreparedStatement ps1 = c.prepareStatement(sql1);
            ps1.setInt(1, first);
            ps1.setString(2, id);
            ps1.execute();
            PreparedStatement ps2 = c.prepareStatement(sql2);
            ps2.setInt(1, second);
            ps2.setString(2, id);
            ps2.execute();
            PreparedStatement ps3 = c.prepareStatement(sql3);
            ps3.setInt(1, third);
            ps3.setString(2, id);
            ps3.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   


}