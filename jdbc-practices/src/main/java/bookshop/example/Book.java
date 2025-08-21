package bookshop.example;

public class Book {
	private int no; // 책 번호
	private String title; // 책 제목
	private String author; // 저자명
	private int status; // 상태코드 0: 대여중 1: 재고있음
	
	public Book(int no, String title, String author) {
		this.no = no;
		this.title = title;
		this.author = author;
		status = 1;
	}
	
	public void rent() {
		if (status == 1) {
		status = 0;
		System.out.println(title + "이(가) 대여 됐습니다.");
		} else {
			System.out.println(title + "은(는) 이미 대여 중입니다.");
		}
	}
	
	public void print() {
		System.out.println(
				"책번호:" + no +
				", 제목:" + title + 
				", 작가:" + author +
				", 상태:" + (status == 0 ? "대여중" : "재고있음"));
	}

	public int getNo() {
		return no;
	}
	
}
