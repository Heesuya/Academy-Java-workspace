package kh.java.func;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ExceptionTest {
	private Scanner sc;

	public ExceptionTest() {
		super();
		sc = new Scanner(System.in);
	}

	public void test1() {
		// int num = 0; //쓰레기가 들어있어서 초기화를 해주고 사용해야 한다.
		try {
			System.out.print("정수를 입력하세요 : ");
			int num = sc.nextInt();
			System.out.println("입력한 정수 : " + num);
			System.out.println("두번째 정수를 입력하세요 : ");
			int num2 = sc.nextInt();
			int data = num / num2; // 0으로 나오면 무한대가 된다.
			System.out.println(data);
		} catch (InputMismatchException e) {
			System.out.println("에러가 발생하면 이게 보임");
		}
	}

	// error 코드가 그 순간 멈춘다.
	// 비정상적인 사용자 많다 ㅋㅋ
	// 집에서 개인서버를 운영하면 안된다 조항. 공격하는 사람이 있어성
	// 업체 이름이 바껴도 도메인은 5년 10년 남긴다. 돈이라서~
	// 비밀번호도 다 돌려보기때문에 5회로 막는다.
	// 개발한 후 test는 개발에 참여하지 않은 사람이 정확하다. 베타 테스터. 알타,베타 -> 모아서 수정한다.

	public void test2() {
		//중괄호가 열리면서 어려워 지는것이다. 
		try {
			System.out.print("첫번째 정수 입력 : ");
			int num1 = sc.nextInt();
			System.out.print("두번째 정수 입력 : ");
			int num2 = sc.nextInt();
			try {
				System.out.println("결과 : " + (num1 / num2));
			} catch (ArithmeticException e) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
		} catch (InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
		}

	}
	
	public void test3() {
		try {
			System.out.print("첫번째 정수 입력 : ");
			int num1 = sc.nextInt();
			System.out.print("두번째 정수 입력 : ");
			int num2 = sc.nextInt();
			System.out.println("결과 : " + (num1 / num2));
		}catch(Exception e) {
			System.out.println("에러가 발생했습니다.");
		}
	}
	
	public void test4() {
		try {
			System.out.print("첫번째 정수 입력 : ");
			int num1 = sc.nextInt();
			System.out.print("두번째 정수 입력 : ");
			int num2 = sc.nextInt();
			System.out.println("결과 : " + (num1 / num2));
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}
	}
	public void test5() {
		try {
			System.out.print("첫번째 정수 입력 : ");
			int num1 = sc.nextInt();
			System.out.print("두번째 정수 입력 : ");
			int num2 = sc.nextInt();
			System.out.println("결과 : " + (num1 / num2));
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}finally {
			//이후에 반환하는 코드가 없으면 프로그램과 프로그램 사이 연결이 안된다. 
			//보통 자원을 반환하는 코드를 쓴다. 
			System.out.println("try가 문제가 있건, 없든 무조건 동작하는 구문");
		}
	}
	
	public void test6() {//우리는 이 방식을 사용 함.
		try {
			FileInputStream fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//error 원인을 여기에 띄워죠.
			//System.out.println("그런 파일은 없어");
		}
	}
	
	public void test7() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("test.txt");
		//예외를 반드시 처리해야한다. throws 던지겠다. 예외처리 알고 있긴한데, 테스트7번을 사용하는 너가해
	}
	public void test8() throws FileNotFoundException {
		test7();//나를 사용하는 애가 처리해 ,, 또 던질수 있음. 
	}
}
