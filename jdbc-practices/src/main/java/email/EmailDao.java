package email;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailDao {
	
	public int insert(EmailVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url  = "jdbc:mariadb://192.168.0.177:3306/webdb";
			con =  DriverManager.getConnection (url, "webdb", "webdb");
			
			// 3. Statement 준비
			String sql = "insert into email(first_name, last_name, email) values (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			// 4. Parameter Binding
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			
			// 5. SQL 실행
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class Not Found");
		} catch (SQLException e) {
			 System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

    public List<EmailVo> findAll() {
        List<EmailVo> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. JDBC Driver 로딩
            Class.forName("org.mariadb.jdbc.Driver");

            // 2. 연결하기
            String url  = "jdbc:mariadb://192.168.0.177:3306/webdb";
            con =  DriverManager.getConnection (url, "webdb", "webdb");

            // 3. Statement 준비
            String sql = "select * from email";
            pstmt = con.prepareStatement(sql);

            // 4. SQL 실행
            rs = pstmt.executeQuery();

            // 5. 결과 처리
            while(rs.next()) {
                EmailVo vo = new EmailVo();
                vo.setId(rs.getLong("id"));
                vo.setFirstName(rs.getString("first_name"));
                vo.setLastName(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));

                list.add(vo);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class Not Found");
        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public int delete(Long deleteId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            // 1. JDBC Driver 로딩
            Class.forName("org.mariadb.jdbc.Driver");

            // 2. 연결하기
            String url  = "jdbc:mariadb://192.168.0.177:3306/webdb";
            con =  DriverManager.getConnection (url, "webdb", "webdb");

            // 3. Statement 준비
            String sql = "delete from email where id = ?";
            pstmt = con.prepareStatement(sql);

            // 4. Parameter Binding
            pstmt.setLong(1, deleteId);

            // 5. SQL 실행
            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class Not Found");
        } catch (SQLException e) {
            System.out.println("error:" + e);
        } finally {
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}