import java.sql.*;
import java.util.List;



public class ProductDAO {
	List<ProductModel> getAllItem() throws SQLException{
		String sql="select*from product_details";
		PreparedStatement ps=GetConnection.getConnection().prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(" Product_Id: "+rs.getInt(1)+" Product_Name: "+rs.getString(2)+" Product_Price: "+rs.getString(3));
		}
		return null;
		
	}
	
}
