package kh.java.run;
//1. import
//-> 실행하고 싶은 메소드가 소속된 클래스의 위치를 알려주는 것 
import kh.java.func.VariableTest;
import kh.java.func.ScanTest;
public class Start {

	public static void main(String[] args) {
		//2. 약어 설정
		//클래스이름 약어 = new 클래스이름();
		//VariableTest vt = new VariableTest();
		ScanTest st = new ScanTest();
		//3. 약어.메소드이름();
		//vt.test5();
		//vt.test7();
		//st.scanTest5();
		st.scanTest4();
	}

}