package bookmall.vo;

public class OrderVo {
	private Long no;
	private String number;
	private String status;
	private int payment;
	private String shipping;
	
	// user
	private Long userNo;
	private String userName;
	private String userEmail;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", number=" + number + ", status=" + status + ", payment=" + payment
				+ ", shipping=" + shipping + ", userNo=" + userNo + ", userName=" + userName + ", userEmail="
				+ userEmail + "]";
	}

}
