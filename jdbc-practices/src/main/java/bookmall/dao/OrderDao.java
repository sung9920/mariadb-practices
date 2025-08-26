package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao {

	public int insert(OrderVo vo) {
		int count = 0;

		try (
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement("insert into orders(number, status, payment, shipping, user_no) values (?, ?, ?, ?, ?)");
				PreparedStatement pstmt2 = conn.prepareStatement("select last_insert_id()");
				) {
			pstmt1.setString(1, vo.getNumber());
			pstmt1.setString(2, vo.getStatus());
			pstmt1.setLong(3, vo.getPayment());
			pstmt1.setString(4, vo.getShipping());
			pstmt1.setLong(5, vo.getUserNo());
			count = pstmt1.executeUpdate();
			
			ResultSet rs = pstmt2.executeQuery();
			vo.setNo(rs.next() ? rs.getLong(1) : null);
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return count;
		
	}

	public int insertBook(OrderBookVo vo) {
		int count = 0;

		try (
				Connection conn = getConnection();
				PreparedStatement pstmt1 = conn.prepareStatement("insert into orders_book(orders_no, book_no, quantity, price) values (?, ?, ?, ?)");
//				PreparedStatement pstmt2 = conn.prepareStatement("select last_insert_id()");
				) {
			pstmt1.setLong(1, vo.getOrderNo());
			pstmt1.setLong(2, vo.getBookNo());
			pstmt1.setInt(3, vo.getQuantity());
			pstmt1.setInt(4, vo.getPrice());
			count = pstmt1.executeUpdate();
			
//			ResultSet rs = pstmt2.executeQuery();
//			vo.setNo(rs.next() ? rs.getLong(1) : null);
//			rs.close();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return count;
	}

	public OrderVo findByNoAndUserNo(Long orderNo, Long userNo) {
		OrderVo vo = null;
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select number, status, payment, shipping "
																+ "from orders "
																+ "where no = ? "
																+ "and user_no = ?;");	
				) {
			pstmt.setLong(1, orderNo); 
			pstmt.setLong(2, userNo); 
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String number = rs.getString(1);
				String status = rs.getString(2);
				int payment = rs.getInt(3);
				String shipping = rs.getString(4);
				
				vo = new OrderVo();
				vo.setNumber(number);
				vo.setStatus(status);
				vo.setPayment(payment);
				vo.setShipping(shipping);
				

			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return vo;
	}

	public List<OrderBookVo> findBooksByNoAndUserNo(Long orderNo, Long userNo) {
		
		List<OrderBookVo> result = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select a.orders_no, a.quantity, a.price, a.book_no, b.title "
																+ "from orders_book a, book b "
																+ "where a.book_no = b.no "
																+ "and a.orders_no = (select no from orders where user_no = ?) "
																+ "and a.orders_no = ?;");
				) {
			pstmt.setLong(1, userNo);
			pstmt.setLong(2, orderNo);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Long orders_no = rs.getLong(1);
				int quantity = rs.getInt(2);
				int price = rs.getInt(3);
				Long book_no = rs.getLong(4);
				String title = rs.getString(5);
						
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNo(orders_no);
				vo.setQuantity(quantity);
				vo.setPrice(price);
				vo.setBookNo(book_no);
				vo.setBookTitle(title);
				
				result.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return result;
	}

	public void deleteBooksByNo(Long no) {
		try (
				Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement("delete from orders_book where orders_no = ?");
				) {
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	public void deleteByNo(Long no) {
		try (
				Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement("delete from orders where no = ?");
				) {
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
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

}
