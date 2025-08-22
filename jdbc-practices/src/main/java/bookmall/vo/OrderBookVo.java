package bookmall.vo;

public class OrderBookVo {
	private Long no;
	private int quantity;
	private int price;
	
	// orders
	private Long orderNo;
	private String number;
	private String status;
	private int payment;
	private String shipping;
	
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
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
				+ ", number=" + number + ", status=" + status + ", payment=" + payment + ", shipping=" + shipping
				+ ", bookNo=" + bookNo + ", bookTitle=" + bookTitle + "]";
	}

}
