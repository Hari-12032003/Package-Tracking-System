import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryBoyDAO {
	boolean insertDel(DeliveryBoyModel cus) throws SQLException {
		String sql="INSERT INTO `deliverboy_details`(`name`, `phoneno`, `email`, `password`) VALUES (?,?,?,?)";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1, cus.getName());
		ps.setString(2, cus.getPhoneno());
		ps.setString(3, cus.getEmail());
		ps.setString(4, cus.getPassword());
		return ps.executeUpdate()>0;
	}
	boolean delete_cus(int id) throws SQLException {
		String sql="DELETE FROM `deliverboy_details` WHERE `del_id`=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate()>0;
	}
	boolean delete_del(int del_id) throws SQLException {
		String sql="DELETE FROM `deliverboy_details` WHERE `del_id`=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, del_id);
		return ps.executeUpdate()>0;
	}
	boolean login(String name,String password) throws SQLException {
		boolean bool=false;
		String sql="Select name,password from `deliverboy_details` where `name`=? and `password`=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,password);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			if(res.getString(1).equalsIgnoreCase(name)&&res.getString(2).equalsIgnoreCase(password)) {
				bool=true;
			}
			
		}
		return bool;
	}
	int getdeliver_Id(String name,String password) throws SQLException {
		int id =0;
		String sql="Select del_id from `deliverboy_details` where `name` =? and password=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			id=res.getInt(1);
		}
		return id;
		
	}
	DeliveryBoyModel getDeliver(int id) throws SQLException{
		String sql="Select * from deliverboy_details where del_id=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(" Id: "+rs.getInt(1)+" Name: "+rs.getString(2)+" PhoneNo: "+rs.getString(3)+" Email: "+rs.getString(4)+" Password: "+rs.getString(5));
		}
		return null;
	}
}
