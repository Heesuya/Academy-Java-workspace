package kr.co.iei.point.vo;

public class Gold extends Silver {
	
	//생성자는 상속이 안된다.
	public Gold() {
		super();
	}

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
	}
 
	@Override
	public double getBonus() {
		return 0.05*getPoint();
	}
	
	
	
//	private String grade;
//	private String name;
//	private int point;
//	
//	public Gold() {
//		super();
//	}
//	
//	public Gold(String grade, String name, int point) {
//		super();
//		this.grade = grade;
//		this.name = name;
//		this.point = point;
//	}
//	
//	public String getGrade() {
//		return grade;
//	}
//
//	public void setGrade(String grade) {
//		this.grade = grade;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getPoint() {
//		return point;
//	}
//
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	public double getBouns() {
//		return 0.05*point;
//	}
	
}
