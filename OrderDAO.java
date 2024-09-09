import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	static OrderModel order=new OrderModel();
	 int product_id,product_amount,customer_id;
	 String product_name,product_curr_location="goa";
	 OrderModel getProduct(int Proid) throws SQLException {
		
		String sql="select * from product_details where `pro_id`=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, Proid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//			order.setName(customer.getName());
			
			product_id=(rs.getInt(1));
			product_name=(rs.getString(2));
			product_amount=(rs.getInt(3));
			
		}
		
		
		
		return null;
	}
	OrderModel getCustomer(String name) throws SQLException {
//		CustomerModel customer =new CustomerModel();
		String sql="select cus_id from customer_details where `name`=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1,name);
		
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			customer_id=(res.getInt(1));
//			order.setName(res.getString(2));
		}
		return null;
	}
//	
//	List<String> get_curr_location(int order_id) throws SQLException{
//		String sql="select product_curr_location from order_details where order_id=?";
//		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
//		ps.setInt(1, order_id);
//		
//		
//	}
//	
	boolean insertOrder(OrderModel order,String location,String name,int Pro_id) throws SQLException {
		order.setProduct_order_location(location);
		order.setName(name);
		order.setCus_id(customer_id);
		order.setProduct_curr_location(product_curr_location);
		order.setProduct_id(product_id);
		order.setProduct_name(product_name);
		order.setProduct_amount(product_amount);
		String sql="INSERT INTO `order_details`( `cus_id`, `name`, `pro_id`, "
				+ "`product_name`, `product_order_location`, `product_curr_location`, `product_amount`) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, order.getCus_id());
		ps.setString(2, order.getName());
		ps.setInt(3, order.getProduct_id());
		ps.setString(4, order.getProduct_name());
		ps.setString(5, order.getProduct_order_location());
		ps.setString(6, order.getProduct_curr_location());
		ps.setInt(7, order.getProduct_amount());
		return ps.executeUpdate()>0;		
	}
	OrderModel getOrder(int cus_id) throws SQLException {
		String sql="select * from order_details where cus_id=?";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, cus_id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("Order_Id: "+rs.getInt(1)+" Customer_Id: "+rs.getInt(2)+" Customer_Name: "+rs.getString(3)+" Product_Id: "+rs.getInt(4)+" Product_name: "+rs.getString(5)+" Product_Deliver_Location: "+rs.getString(6)+" Product_Current_Location: "+rs.getString(7)+" Product_Amount: "+rs.getInt(8));
		}
		return null;
	}
	OrderModel getOrder_del() throws SQLException {
		String sql="select order_id,cus_id,name,pro_id,product_name,product_order_location from order_details ";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(" Order_Id: "+rs.getInt(1)+" Customer_Id: "+rs.getInt(2)+" Customer_Name: "+rs.getString(3)+" Product_Id: "+rs.getInt(4)+" Product_name: "+rs.getString(5)+" Product_Deliver_Location: "+rs.getString(6));
		}
		return null;
	}
	boolean updateUser(int order_id,String curr_location) throws SQLException {
//		List<String> arr=new ArrayList<>();
		
		String sql = "UPDATE `order_details` SET product_curr_location =? where order_id=?  ";
//		String sql="Updarte `order_details`"
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ps.setString(1, curr_location);
		ps.setInt(2, order_id);
		
		return  ps.executeUpdate()>0;
		  
		  

		
		
	}
}
