package kr.co.iei.student.vo;

//학생 1명 정보를 저장할 객체
public class Student {
	private String name;
	private int age;
	private String addr;
	//기본 생성자
	//매개변수가 있는 생성자(매개변수 3개짜리)
	//getter
	//setter
	
	//기본생성자
	public Student() {
		
	}
	
	//매개변수가 있는 생성자
	public Student(String name, int age, String addr) {
		this.name  = name;
		this.age = age;
		this.addr = addr;
	}
	//오버로딩으로 변수 여러개 만들어도 된다. 
	//일반적으로 많이 쓰는건 위에 2개이다. 
	
	//getter
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
