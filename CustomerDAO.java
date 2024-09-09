import java.sql.*;
import java.util.List;

public class CustomerDAO {
	boolean insertCus(CustomerModel cus) throws SQLException {
		String sql="INSERT INTO `customer_details`( `name`, `phoneno`, `email`, `location`, `password`) VALUES (?,?,?,?,?)";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1, cus.getName());
		ps.setString(2, cus.getPhoneno());
		ps.setString(3, cus.getEmail());
		ps.setString(4, cus.getLocation());
		ps.setString(5, cus.getPassword());
		return ps.executeUpdate()>0;
	}

	boolean delete_cus(int cus_id) throws SQLException {
		String sql="DELETE FROM `customer_details` WHERE `cus_id`=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, cus_id);
		return ps.executeUpdate()>0;
	}
	boolean login(String name,String password) throws SQLException {
		boolean bool=false;
		String sql="Select name,password from `customer_details` where `name`=? and `password`=?";
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
	int getCustomer_Id(String name,String password) throws SQLException {
		int id =0;
		String sql="Select cus_id from `customer_details` where `name` =? and password=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			id=res.getInt(1);
		}
		return id;
		
	}
	CustomerModel getCustomer(int id) throws SQLException{
		String sql="Select * from customer_details where cus_id=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(" Id: "+rs.getInt(1)+" Name: "+rs.getString(2)+" PhoneNo: "+rs.getString(3)+" Email: "+rs.getString(4)+" Location: "+rs.getString(5)+" Password: "+rs.getString(6));
		}
		return null;
	}
	
}
