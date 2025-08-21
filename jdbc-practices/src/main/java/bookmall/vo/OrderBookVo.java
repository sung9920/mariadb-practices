package bookmall.vo;

public class OrderBookVo {
	private Long no;
	private int quantity;
	private int price;
	
	// orders
	private Long orderNo;
	
	// book
	private Long bookNo;
	private String bookTitle;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long ordersNo) {
		this.orderNo = ordersNo;
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
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", quantity=" + quantity + ", price=" + price + ", orderNo=" + orderNo
				+ ", bookNo=" + bookNo + ", bookTitle=" + bookTitle + "]";
	}

}
