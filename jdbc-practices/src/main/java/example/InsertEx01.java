package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertEx01 {

	public static void main(String[] args) {
		insert("기획1팀");
		insert("기획2팀");
	}

		public static boolean insert(String department) {
			Connection con = null;
			
			try {
				// 1. JDBC Driver 로딩
				Class.forName("org.mariadb.jdbc.Driver");
				
				// 2. 연결하기 
				String url  = "jdbc:mariadb://192.168.0.176:3306/webdb";
				con =  DriverManager.getConnection (url, "webdb", "webdb");
				
				// 3. d
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Class Not Found");
			} catch (SQLException e) {
				 System.out.println("error:" + e);
			} finally {
				try {
					if(con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
