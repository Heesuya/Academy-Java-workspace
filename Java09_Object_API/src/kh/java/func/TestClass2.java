package kh.java.func;

import java.util.Scanner;

public class TestClass2 {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요 : ");
		String str1 = sc.next();
		System.out.println("문자열을 입력하세요 : ");
		String str2 = sc.next();
		
		if(str1.equals(str2)) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
	}
	public void test2() {
		String str1 = "aaa";//참조형(객체타입이다)  //문자열은 생성자를 쓰지않고 사용할수 있다. 
		String str2 = "aaa";
		if(str1 == str2) {
			System.out.println("두 문자열이 같습니다.");
		}else {
			System.out.println("두 문자열이 다릅니다. ");
		}
	}
	//equals 는 객체와 객체가 같은지 비교, 문자와 문자의 비교가 아니다. 
}
