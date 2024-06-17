package kh.java.test1;
//같은 패키지 안에 있는 다른 클래스의 경우는 import 생략 가능
//import kh.java.test1.MethodTest1;


public class MethodTest2 {
	public void test3() {
		MethodTest1 mt1 = new MethodTest1();
		mt1.test1();
	}
}
