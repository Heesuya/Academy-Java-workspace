package kh.java.test4;

//미완성된 메소드가 포함되어서 에러가 생긴다.  >> public class TestClass2 extends TextClass1
//객체를 못만들게 하는 목적으로 abstract(추상클래스) 강제 선언 가능하다.
public class TestClass2 extends TestClass1{
	
	@Override
	public void testMethod2() {
		System.out.println("testMethod2");
	}
}
