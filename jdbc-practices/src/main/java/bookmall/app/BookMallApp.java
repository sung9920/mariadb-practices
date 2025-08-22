package bookmall.app;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.OrderDao;
import bookmall.dao.UserDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;
import bookmall.vo.UserVo;

public class BookMallApp {

	public static void main(String[] args) {

		installDB();
		testUser();
		testCategory();
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("대여하고 싶은 책의 번호를 입력하세요:");
//		Long id = scanner.nextLong();
//		scanner.close();
//		new BookDao().update(id, "대여중");
//		displayBookInfo();
	}

//	private static void displayBookInfo() {
//		System.out.println("*****도서 정보 출력*****");
//		List<BookVo> list = new BookDao().findAll();
//		for (BookVo vo : list) {
//			String info = String.format("[%d] 제목: %s, 작가: %s, 대여유무: %s", vo.getId(), vo.getTitle(), vo.getAuthorName(),
//					vo.getStatus());
//			System.out.println(info);
//		}
//	}

	private static void installDB() {
		UserDao userDao = new UserDao();
		UserVo userVo = null;
		userVo = new UserVo("데스트유저01", "test01@test.com", "1234", "010-0000-0000");
		userDao.insert(userVo);

		userVo = new UserVo("데스트유저02", "test01@test.com", "1234", "010-0000-0000");
		userDao.insert(userVo);
		
		CategoryDao categoryDao = new CategoryDao();
		CategoryVo categoryVo = null;
		categoryVo = new CategoryVo("인문");
		categoryDao.insert(categoryVo);

		categoryVo = new CategoryVo("컴퓨터");
		categoryDao.insert(categoryVo);
		
		categoryVo = new CategoryVo("예술");
		categoryDao.insert(categoryVo);
		
		
		BookDao bookDao = new BookDao();
		BookVo bookVo = null;
		bookVo = new BookVo("과학혁명의 구조", 20000);
		bookVo.setCategoryNo(categoryVo.getNo());
		bookDao.insert(bookVo);

		
		bookVo = new BookVo("J2EE Development Without EJB", 32000);
		bookVo.setCategoryNo(categoryVo.getNo());
		bookDao.insert(bookVo);
		
		bookVo = new BookVo("서양미술사", 50000);
		bookVo.setCategoryNo(categoryVo.getNo());
		bookDao.insert(bookVo);
		
		CartVo cartVo = new CartVo();
		OrderVo orderVo = new OrderVo();
		OrderBookVo orderBookVo = new OrderBookVo();

		CartDao cartDao = new CartDao();
		OrderDao orderDao = new OrderDao();

		cartVo.setUserNo(userVo.getNo());
		cartVo.setBookNo(bookVo.getNo());
		cartVo.setQuantity(1);
		cartDao.insert(cartVo);

		orderVo.setUserNo(userVo.getNo());
		orderVo.setNumber("202401213-000012");
		orderVo.setPayment(82400);
		orderVo.setShipping("서울시 은평구 진관3로 77 구파발 래미안 926-801");
		orderVo.setStatus("배송준비");
		orderDao.insert(orderVo);

		orderBookVo.setOrderNo(orderVo.getNo());
		orderBookVo.setBookNo(bookVo.getNo());
		orderBookVo.setQuantity(1);
		orderBookVo.setPrice(20000);
		orderDao.insertBook(orderBookVo);

		List<CartVo> list = cartDao.findByUserNo(userVo.getNo());
		for (CartVo vo : list) {
			System.out.println(vo);
		}
		OrderVo vo = orderDao.findByNoAndUserNo(orderVo.getNo(), userVo.getNo());
		System.out.println(vo);
	}

	public static void testUser() {
		List<UserVo> list = new UserDao().findAll();
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testCategory() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	

}
