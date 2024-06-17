package kr.co.iei.baseball.vo;

public class General extends Grade {

	
	public General() {
		super();
		// TODO Auto-generated constructor stub
	}

	public General(String name, String phoneNum, String grade, int price, int seatNum, String seatName) {
		super(name, phoneNum, grade, price, seatNum, seatName);
		// TODO Auto-generated constructor stub
	}

	public General(String name, String phoneNum, String grade) {
		super(name, phoneNum, grade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getDiscount() {
		return getPrice()*0.95;
	}

}
