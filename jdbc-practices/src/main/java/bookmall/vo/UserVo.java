package bookmall.vo;

public class UserVo {
	private Long no;
	private String name;
	private String email;
	private String pw;
	private String phone;
	
	public UserVo(String name, String email, String pw, String phone) {
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.phone = phone;
	}

	public UserVo() {
		
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", pw=" + pw + ", phone=" + phone + "]";
	}

}
