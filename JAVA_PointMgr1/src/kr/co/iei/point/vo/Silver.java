package kr.co.iei.point.vo;

public class Silver {
	//전역변수
	private String grade;
	private String name;
	private int point;

	
	

	//기본생성자
	public Silver() {
		
	}
	//매개변수 생성자
	public Silver(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
	
	}
	
	//getter
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	
	
	//1.Silver 클래스에 bonus변수를 추가한 경우
	//2.출력할 때 getPoint()*0.02   >> 등급 처리로 바뀌게 되면 if를 해야한다.
	//bonus는 현재 포인트에 2%..  
	//등급이 바뀔때마다 포인트가 자동으로 바뀔수 있게 할수 있을까?
	//bounus는 point의 종속적인 데이터이므로 따로 변수처리를 하지않고
	//데이터가 필요한겨웅 point를 연산해서 값을 주는 getter만 추가 
	public double getBonus() {
		return point*0.02;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
