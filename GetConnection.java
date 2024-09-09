import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	static Connection con;
	public static Connection getConnection () {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
}
}
