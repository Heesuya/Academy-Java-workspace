package kh.java.run;

import kh.java.func.ApiTest;
import kh.java.func.StringTest;
import kh.java.func.TestClass1;
import kh.java.func.TestClass2;

public class Start {

	public static void main(String[] args) {
		/*
		TestClass1 tc1 = new TestClass1();
		TestClass1 tc2 = new TestClass1();
		TestClass1 tc3 = tc1;
		//tc1과 tc2는 같은 자료이지만 독립적인다. 
	
		//:(클론)void 다음 있는건 리턴타입
		//괄호안에 있는건 매개변수
		//- 나머지 상속하는 클래스이다. object가 사용하는 메소드 사용할수 있다. //적어도 이정도는 있어야해 
		*/
		
		/*
		//Object - hashCode
		System.out.println(tc1.hashCode());
		System.out.println(tc2.hashCode());
		System.out.println(tc3.hashCode());//복사한것.
		//객체를 구분하는 고유 정보값이다. 객체 주소는 아니다.
		//객체가 같으면 같은 값이 나오고, 다르면 다른 값이 나온다.
		//비밀번호 찾기를 할때, 비밀번호 찾기로 임시비밀번호 받기. 실제 비밀번호를 찾으려 해도, 암호화 되어서 본인인증해서 다시 찾아라. 
		//hashCode - 객체를 구분하기 위함. 
		 */
		
		/*
		//Object - toString
		System.out.println(tc1.toString());
		//패키지 경로랑 클래스 경로를 알려줌, 골뱅이는 구분 문자, 고유값을 16진수로 바꿔줌 (계산기 = 프로그래머)에서 확인 가능
		//객체에 대한 기본 정보에 대해 알려준다. 
		System.out.println(tc1);//객체의 아무메소드도 사용하지않고 출력하면 자동으로 toString메소드를 호출
		//오버라이딩이 가능한다. 데이터 확인용. 
		*/
		
		/*
		//Object - Clone
		TestClass2 tc = new TestClass2();
		//tc.test1();
		tc.test2();
		TestClass1 tc1 = new TestClass1();
		TestClass1 tc2 = (TestClass1)tc1.clone();// clone은 object 타입이여서 다운캐스팅해야한다.
		*/
		
		/*
		int[] arr = new int[5];
		int[] arr2 = arr.clone(); //깊은 복사중 쉬운 방법 //clone 도 object가 가지고 있다. 
		*/
		
		/*
		API 사용법 맛보기
		String str1 = "Hello";
		String str2 = str1.toLowerCase();
		System.out.println(str2);
		String str3 = str1.toUpperCase();
		System.out.println(str3);
		System.out.println(str1);//원본은 안바꾼다. 
		String str4 = "1,2,3,4";
		String[] arr = str4.split(","); //API 는 아는 만큼 쓴다. 모르면 고생하면 된다~~~
		for(int i = 0; i <arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		
		/*
		StringTest st = new StringTest();
		//st.test1();
		//st.test2();
		//st.examsam1();
		st.test3();
		*/
		ApiTest at = new ApiTest();
		//at.math();
		//at.test1();
		//at.test2();
		//at.exam2();
		//at.examsam2();
		//at.wrap();
		at.wrap2();
	}

}
