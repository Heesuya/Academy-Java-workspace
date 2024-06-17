package kh.java.test4;

//testMethod2()는 추상메소드 -> TestClass1은 추상메소드를 포함하고 있는 클래스 -> 추상클래스 
public abstract class TestClass1 {
	private int num;
	public TestClass1() {
		super();
	}

	public TestClass1(int num) {
		super();
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void testMethod1() {
		System.out.println("testMethod1");
	}
	//미완성된 메소드 -> 코드실행부({})가 없는 메소드 -> 추상메소드
	//아파트 설계도를 만든다. 그런데 특정한 부분이 설계가 안되었을 경우.
	//아무코드가 없어도 상관이 없지만, 완성이 된것과 되지 않은 것은 다른것이다. 
	//미완성된 클래스로 객체는 못만든다. 
	public abstract void testMethod2();
}
