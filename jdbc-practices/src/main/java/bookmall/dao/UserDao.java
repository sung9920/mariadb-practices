package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.vo.UserVo;

public class UserDao {

	public int insert(UserVo vo) {
		
		int count = 0;

		try (
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement("insert into user(name,email,pw,phone) values (?, ?, ?, ?)");
//				PreparedStatement pstmt2 = conn.prepareStatement("select last_insert_id() from dual");
				) {
			pstmt1.setString(1, vo.getName());
			pstmt1.setString(2, vo.getEmail());
			pstmt1.setString(3, vo.getPw());
			pstmt1.setString(4, vo.getPhone());
			count = pstmt1.executeUpdate();

//			ResultSet rs = pstmt2.executeQuery();
//			vo.setNo(rs.next() ? rs.getLong(1) : null);
//			rs.close();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return count;
	}

	private Connection getConnection() throws SQLException {
		Connection con = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.0.176:3306/bookmall";
			con = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class Not Found");

		}

		return con;
	}


	public List<CartVo> findAll() {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	public void deleteByNo(Long no) {
		// TODO 자동 생성된 메소드 스텁

	}

}
