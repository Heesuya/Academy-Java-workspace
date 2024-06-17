package kr.co.iei.point.vo;

//자료의 형태로만 쓸것이다.
public abstract class Grade {
	private String grade;
	private String name;
	private int point;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Grade(String grade, String name, int point) {
		super();
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public abstract double getBonus();
	//silver, gold, vip 에 따로 적용해서 사용하겠다. 
}
