package kr.co.iei.point.vo;

public class Vip extends Silver {

	public Vip() {
		super();
	}

	public Vip(String grade, String name, int point) {
		super(grade, name, point);
	}
	
	@Override
	public double getBonus() {
		return 0.07*getPoint();
	}
	
	
//	private String grade;
//	private String name;
//	private int point;
//	public Vip() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	//alt+shift+s    o/c/r
//	public Vip(String grade, String name, int point) {
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
//		return 0.07*point;
//	}
	
}
