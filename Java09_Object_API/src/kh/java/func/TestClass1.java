package kh.java.func;

//vo클래스                
//클론을 구현하려면 인터페이스를 사용해야한다. Cloneable 사용하겠다 선언하는 의미로 사용하는 것. 
public class TestClass1 implements Cloneable{
	private String str;
	private int num;

	public TestClass1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestClass1(String str, int num) {
		super();
		this.str = str;
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	//데이터 확인 목적으로 자주 쓰인다. 
	@Override
	public String toString() {
		return "TestClass1(str=" + str + ", num = " + num + ")";
		// 변수에 있는 데이터값 바로 확인
		//자동완성 단축키 : Alt + Shift + s -> S
	}
	

	public void test1() {
		System.out.println("hi");
	}
	
	//TestClass1객체를 복제하는 기능을 구현
	//1. Cloneable Interface 상속
	//2. clone 메소드 오버라이딩 
	//return super.clone(); -> surround catch -> return null;
	@Override
	public Object clone() { //surround catch
		try {
			//부모의 clone 메소드를 호출하여 리턴
			//clone메소드의 소스코드는 확인 할 수 없음
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
