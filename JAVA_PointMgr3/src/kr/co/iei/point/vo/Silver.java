package kr.co.iei.point.vo;

public class Silver extends Grade{

	//생성자는 따로 만들어야 함~
	public Silver() {
		super();
	}

	public Silver(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getBonus() {
		return 0.02*getPoint();
	}

}
