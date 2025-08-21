package bookmall.vo;

public class CartVo {
	private Long no;
	private int quantity;
	
	// user
	private Long userNo;
	
	// book
	private Long bookNo;
	private String bookTitle;
	private int bookPrice;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", quantity=" + quantity + ", userNo=" + userNo + ", bookNo=" + bookNo
				+ ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
	}
}
