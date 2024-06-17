package kh.java.test3;

public class Aclass {
	//클래스를 만들었다는 것은 변수와 메소드를 사용할수 있다. 
	
	private int num;
	private String str;
	
	public Aclass() {
		super();
	}
	
	public Aclass(int num, String str) {
		super();//아무것도 입력하지 않으면 extends Object(최고조상클래스) 자동으로 상속하게 된다. 
		this.num = num;
		this.str = str;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}

	public void test1() {
		System.out.println("난 Aclass의 test1메소드");
	}
}
