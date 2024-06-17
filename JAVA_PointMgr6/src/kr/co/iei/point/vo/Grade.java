package kr.co.iei.point.vo;

import java.io.Serializable;

//Interface 는 완성되지 않은 메소드 쓸게
//Serializable 완성된 메소드를 상속해서 쓸게 한곳만 넣으면 나머지 다 상속된다. 보통 규약 만든다.
public abstract class Grade implements Serializable {
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
	@Override
	public String toString() {
		return "Grade [grade=" + grade + ", name=" + name + ", point=" + point + "]";
	}
	
	public abstract double getBonus();
	
}
