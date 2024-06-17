package kh.java.test5;

//extends(상속) 과 개념이 다르다. interface 는 줄게 없다.
public class TestInterfaceImpl implements TestInterface {

	//상속의 개념보다는 구현이라는 개념을 가져간다. 
	@Override
	public void test1() {
		System.out.println("test1");
	}
	
	@Override
	public void test2() {
		System.out.println("test2");
	}
	
	public void test3() {//private 사용하지 않아도 사용제한 가능
		System.out.println("test3");
	}
}
