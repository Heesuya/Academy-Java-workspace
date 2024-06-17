package kr.co.iei.baseball.vo;

public class Guest extends Grade{


	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(String name, String phoneNum, String grade, int price, int seatNum, String seatName) {
		super(name, phoneNum, grade, price, seatNum, seatName);
		// TODO Auto-generated constructor stub
	}

	public Guest(String name, String phoneNum, String grade) {
		super(name, phoneNum, grade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscount() {
		return getPrice();
	}
}
