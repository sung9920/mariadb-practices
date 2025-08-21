package bookmall.app;

import java.util.List;

import bookmall.dao.UserDao;
import bookmall.vo.UserVo;
import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookMallApp {

	public static void main(String[] args) {

		installDB();
//		displayBookInfo();
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("대여하고 싶은 책의 번호를 입력하세요:");
//		Long id = scanner.nextLong();
//		scanner.close();
//		new BookDao().update(id, "대여중");
//		displayBookInfo();
	}

	private static void displayBookInfo() {
		System.out.println("*****도서 정보 출력*****");
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			String info = String.format("[%d] 제목: %s, 작가: %s, 대여유무: %s", vo.getId(), vo.getTitle(), vo.getAuthorName(),
					vo.getStatus());
			System.out.println(info);
		}
	}

	private static void installDB() {
		UserDao userDao = new UserDao();

//		bookDao.deleteAll();
//		authorDao.deleteAll();

		UserVo userVo = null;

		//
		userVo = new UserVo("데스트유저01", "test01@test.com", "1234", "010-0000-0000");
		userDao.insert(userVo);

	}

}
