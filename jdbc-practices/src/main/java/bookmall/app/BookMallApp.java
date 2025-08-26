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
    }

    private static void installDB() {
        UserDao userDao = new UserDao();
        CategoryDao categoryDao = new CategoryDao();
        BookDao bookDao = new BookDao();
        CartDao cartDao = new CartDao();
        OrderDao orderDao = new OrderDao();

        // 유저 등록
        UserVo user01 = new UserVo("테스트유저01", "test01@test.com", "1234", "010-0000-0000");
        userDao.insert(user01);

        UserVo user02 = new UserVo("테스트유저02", "test02@test.com", "1234", "010-1111-1111");
        userDao.insert(user02);

        // 카테고리 등록
        CategoryVo cateHuman = new CategoryVo("인문");
        categoryDao.insert(cateHuman);

        CategoryVo cateComputer = new CategoryVo("컴퓨터");
        categoryDao.insert(cateComputer);

        CategoryVo cateArt = new CategoryVo("예술");
        categoryDao.insert(cateArt);

        // 도서 등록
        BookVo book01 = new BookVo("과학혁명의 구조", 20000);
        book01.setCategoryNo(cateHuman.getNo());
        bookDao.insert(book01);

        BookVo book02 = new BookVo("J2EE Development Without EJB", 32000);
        book02.setCategoryNo(cateComputer.getNo());
        bookDao.insert(book02);

        BookVo book03 = new BookVo("서양미술사", 50000);
        book03.setCategoryNo(cateArt.getNo());
        bookDao.insert(book03);

        // 장바구니 등록 
        CartVo cart01 = new CartVo();
        cart01.setUserNo(user02.getNo());
        cart01.setBookNo(book03.getNo());
        cart01.setQuantity(1);
        cartDao.insert(cart01);

        // 주문 등록
        OrderVo order01 = new OrderVo();
        order01.setUserNo(user02.getNo());
        order01.setNumber("202401213-000012");
        order01.setPayment(82000);
        order01.setShipping("서울시 은평구 진관3로 77 구파발 래미안 926-801");
        order01.setStatus("배송준비");
        orderDao.insert(order01);

        // 주문 도서 등록
        OrderBookVo orderBook01 = new OrderBookVo();
        orderBook01.setOrderNo(order01.getNo());
        orderBook01.setBookNo(book03.getNo());
        orderBook01.setQuantity(1);
        orderBook01.setPrice(book03.getPrice());
        orderDao.insertBook(orderBook01);
    }

    // 유저 정보 출력
     
    private static void testUser() {
        System.out.println("***** 회원 리스트 *****");
        List<UserVo> list = new UserDao().findAll();
        for (UserVo vo : list) {
            System.out.println(vo);
        }
        System.out.println();
    }

    // 카테고리 정보 출력
   
    private static void testCategory() {
        System.out.println("***** 카테고리 리스트 *****");
        List<CategoryVo> list = new CategoryDao().findAll();
        for (CategoryVo vo : list) {
            System.out.println(vo);
        }
        System.out.println();
    }
}