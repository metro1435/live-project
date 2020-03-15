import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    //获得几个数据段
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "select count(*) from order";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    //增加
    public void add(Order order) {
        String sql = "insert into order values(?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, order.getOrderID());
            ps.setString(2, order.getIdNum());
            ps.setString(3, order.getPhoneNum());
            ps.setInt(4,order.getMaskNum());
            ps.setInt(5,order.getBallot());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //改
    public void update(Order order) {
        String sql="update order set order_ID=?,ID_num=?,phone_num=?," +
                "mask_num=?,ballot=? where order_ID=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, order.getIdNum());
            ps.setString(2, order.getPhoneNum());
            ps.setInt(3,order.getMaskNum());
            ps.setInt(4,order.getBallot());
            ps.setString(5, order.getOrderID());
            ps.execute();
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
        String sql = "select * from order";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }



}