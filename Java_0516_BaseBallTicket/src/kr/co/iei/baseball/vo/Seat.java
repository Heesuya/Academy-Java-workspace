package kr.co.iei.baseball.vo;

public class Seat {	
	private String name;
	private int price;
	private int num;//남은 좌석
	
	public Seat() {
		super();
	}
	
	public Seat(String name, int price, int num) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
