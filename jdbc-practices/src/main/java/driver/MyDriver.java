package driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriver implements Driver {
	static {
//		System.out.println("static area");
//		드라이버 등록
		try {
			DriverManager.registerDriver(new MyDriver());
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		System.out.println("url:" + url);
		System.out.println(info);
		return new MyConnection();
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO 자동 생성된 메소드 스텁
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO 자동 생성된 메소드 스텁
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

}
