package kr.co.iei.baseball.vo;

public abstract class Grade {
	private String name;
	private String phoneNum;
	private String grade;
	private int price;
	private int seatNum; //좌석수
	private String seatName; //좌석명

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String name, String phoneNum, String grade,int price, int seatNum, String seatName) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.grade = grade;
		this.price = price;
		this.seatNum = seatNum;
		this.seatName = seatName;
	}
	
	public Grade(String name, String phoneNum, String grade) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.grade = grade;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public abstract double getDiscount();
	
}

