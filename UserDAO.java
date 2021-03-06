import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //获得几个数据段
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "select count(*) from mask.user";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            DBUtil.close(rs,s,c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
    //通过ID_num获取用户
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
                return user;
            }
            DBUtil.close(rs,ps,c);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }
    //增加
    public void add(User user) {
        String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getIdNum());
            ps.setString(3, user.getPhoneNum());
            ps.setInt(4,user.getFirst());
            ps.setInt(5,user.getSecond());
            ps.setInt(6,user.getThird());
            ps.setInt(7,user.getToday());
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //改
    public void update(User user) {
        String sql="update user set name=?,phone_num=?,first=?," +
                "second=?,third=?,today=? where ID_num=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhoneNum());
            ps.setInt(3,user.getFirst());
            ps.setInt(4,user.getSecond());
            ps.setInt(5,user.getThird());
            ps.setInt(6,user.getToday());
            ps.setString(7, user.getIdNum());
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

    public static List<User> get() throws Exception {
        List<User> userList=new ArrayList<User>();
        User user = null;
        String sql = "select * from user";
        try (Connection c = DBUtil.getConnection(); Statement stmt=c.createStatement()) {
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
            DBUtil.close(rs,stmt,c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }



}