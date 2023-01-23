package numero1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private final String url = "jdbc:postgresql://localhost:5432/azienda?useSSL=false";
	private final String username = "postgres";
	private final String password = "1234";
	public static Connection conn = null;
	
	public void connect() {
        try {
            System.out.println("Connecting to database " + url);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is successful!");
          }
          catch(Exception e) {
              e.printStackTrace();
          }
	}
	
	public void disconnect() {
		if( conn != null ) {
	          try {
	              conn.close();
	              System.out.println("Disconnection is successful!");
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	        }
	}
	
}
