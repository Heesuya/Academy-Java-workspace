package kh.java.test1;

import java.util.Scanner;

public class MethodTest1 {
	protected void test1() { // 접근지시자를 public으로 해놓아서 가능. 같은 클래스 안에서는 적용 가능
		System.out.println("메소드 테스트111");
	}
	// public : 어디서든 쓰든 가능해
	// private : 같은 class 안에서는 가능하지만 외부에서는 쓸수가 없다.
	// protected : 같은 class 와 같은 package 에서 가능
	// default : 지우면 default

	public void test2() {
		System.out.println("메소드 테스트222");
		// 같은 클래스 내부에 다른 메소드를 호출하는 방법
		test1();// 메소드명();으로 호출
		// int num = test1(); == int num = ; 과 같다 :: 변수로 저장할수 없다.
		int num22 = test3(); // tes3에 있는 num이라는 값과 다른것이다.
		test5();
	}

	// 반환자료형을 선언한 경우에는 해당 타입의 데이터를 반드시 되돌려주는 코드를 작성해야함
	// 데이터를 되돌려주는 코드를 작성하지 않으면 에러가 발생
	// 데이터를 되뎔려주는 코드 -> return 데이터;
	public int test3() {
		System.out.println("이건 테스트3 메소드");
		System.out.println("내부에서 어떤 코드를 작성해도 상관은 없으나");
		System.out.println("반드시 반환형에 해당하는 데이터를 되돌려줘야함");
		int num = 200;
		return num;// return은 해당데이터를 되돌려주면서 그즉시 메소드를 종료
		// System.out.println("리턴이후코드");//리턴은 즉시 메소드를 종료하기때문에 이후코드는 dead code
	}

	public int test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 1을 입력하세요 : ");
		int data = sc.nextInt();
		if (data == 1) {
			return 10;// if 조건문만 적으면 반환이 안되서 error
		}
		return 9;
		/*
		 * if(data != 1) 
		 * { return 9;//상황에 대한 부분이기에 이클립스는 인식 못한다. }
		 */
	}

	// 모든메소드는 반환형과 상관없이 반드시 return 코드가 존재해야 함
	// 반환형이 void인경우 return 생략 가능
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 10을 입력하세요 : ");
		int data = sc.nextInt();
		if (data == 10) {
			return;// 메소드를 중간에 종료시키고 싶을때
			// System.out.println("잘했어요");
		} else {
			System.out.println("10 입력 하라니까요?????????");
		}

		// return; //생략되어 있을 뿐이다. 안적어도 된다.
	}

	public String test6(int data) {// 2)복사한 변수의 데이터를 집어넣어준다. 변수이름은 상관이 없다. 보통 맞춰서 쓰긴함.
		// System.out.println(data);
		if (data == 1000) {
			return "커피";
		} else {
			return "콜라";
		}
	}

	public void test7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("돈 얼마 줄까?");
		int money = sc.nextInt();// int의 사용범위는 text7 안의 중괄호이기에 test6의 money와 아무 상관없다.
		String str = test6(money);// 1)변수의 데이터를 복사해서 보내준다.
		System.out.println(str);
	}

	public void test8() {
		System.out.println("test8메소드");
		test9(1, "hi");// 메소드의 매개변수는 이름이 중요한게아니라 자료형, 순서가 중요
		// test10("hello",100); //자료형 순서에 매칭하는것이다.
		int num = 100;//대부분 맞춰 쓴다
		String data = "문자열";
		test9(num, data);// 데이터라는 변수에 주는게 아니라 데이터 값을 변수를 주는것.
	}

	public void test9(int num, String data) {
		System.out.println("num : " + num);
		System.out.println("data : " + data);
	}

	public void test10() {
		int num1 = 100;
		int num2 = 200;
		test11(num2, num1);
	}

	public void test11(int num1, int num2) {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}

	// 메소드를 왜 쓰는데? 동일한 작업을 여러번 할때 메소드를 사용한다.
	public void test12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();

		int sum = sum1(num1,num2);

		System.out.println("두 수의 합은 : " + sum);
		
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		System.out.print("네번째 정수 입력 : ");
		int num4 = sc.nextInt();
		sum2(num3, num4);

	}
	/**
	 * @author 윤희수  <<퇴사하면 바꾸면 바꾼 사람 이름으로 수정 
	 * @data 2024-05-08
	 * @version 1.1
	 * @param su1 합쳐질 수 1
	 * @param su2 합쳐질 수 2
	 * @return 매개변수로 받은 숫자 2개를 합친 값
	 */
	public int sum1(int su1, int su2) {//(모듈화 작업) 메소드가 하나의 기능만 담당한다고 생각하면 된다. 
		//단일 기능으로 만들어야지 여러군데에서 사용하기 좋다. 
		int data = su1 + su2;// 이건 BigData와 AI를 이용한 아주 어렵고 복잡한 코드(약 10000줄 정도의 코드)
		return data;
	}
	/**
	 * 
	 * @param su1
	 * @param su2
	 */
	public void sum2(int su1, int su2) {//더하는 기능 + 출력 기능 //메소드의 여러 기능을 합치면 많은 곳에 쓰기가 없다. 
		int data = su1 + su2;
		System.out.println("두 수의 합은 : " + data);
	}
	
	public void test13() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번재 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		int result1 = add(num1,num2);
		int result2 = add(num1,num2,num3);
		
		add(num1, num2);
	}
	
	//숫자를 매개변수로 받아서 합친 결과를 리턴하는 메소드
	//메소드 오버로딩 조건  
	//1) 이름이 같다  
	//2)매개변수 선언부를 가지고 구분할수 있어야 한다.(=파라미터 자리로 구분이 되어야한다.)
	//3) 리턴타입은 오버로딩에 영향을 주지 않는다. 
	public int add(int su1, int su2) {
		int data = su1 + su2;
		return data;
	}
	
	public String add(int num1, String num2) {
		String data = num1 + num2;
		return data;//숫자를 리턴하겠다 하였는데 리턴 타입/  
	}
	
	public int add(int su1, int su2, int su3) {
		int data = su1 + su2 + su3;
		return data;
	}
}
