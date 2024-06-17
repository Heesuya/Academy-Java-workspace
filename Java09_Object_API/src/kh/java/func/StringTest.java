package kh.java.func;

import java.util.Random;
import java.util.StringTokenizer;

public class StringTest {
	public void test1() {
		// String 클래스에서 자주 사용하는 메소드

		String str1 = "AbcdEfg";
		// toUpperCase() : 문자열을 모두 대문자로 변환해서 리턴(원본문자열은 영향 없음)
		System.out.println(str1.toUpperCase());
		System.out.println(str1);// 원본은 원래 상태 유지
		// toLowerCase() : 문자열을 모두 소문자로 변환해서 리턴(원본문자열은 영향 없음)
		System.out.println(str1.toLowerCase());
		System.out.println(str1);// 원본 확인용
		String str2 = "한글aAbExs";
		System.out.println(str2.toLowerCase());
		System.out.println(str2.toUpperCase());

		String str3 = "abcabdc";
		// replace(문자열1, 문자열2) : 문자열 1을 찾아서 문자열 2로 대체
		System.out.println(str3.replace("a", "A"));// 소문자 a 를 찾아서 대문자 A 로 바꿔라
		System.out.println(str3);// 원본에 아무런 변화가 없다.

		// indexOf() : 매개변수로 준 문자열 위치를 정수로 리턴(앞에서부터 검색)
		str3.indexOf("b");
		System.out.println(str3.indexOf("b"));

		// lastIndexOf(문자열) : 매개변수로 준 문자열 위치를 정수로 리턴(뒤에서부터 검색)
		System.out.println(str3.lastIndexOf("a"));

		// split(구분자) : 문자열을 구분자 기준으로 잘라서 문자열 배열로 리턴
		String str4 = "이윤수/서울/강사/kh";
		String[] arr = str4.split("/");
		System.out.println(arr[1]);
	}

	public void test2() {
		// 외부클래스 사용 시 import 생략 가능 조건
		// 1. 같은 패키지 내부에 있는 클래스
		// 2. java.lang. 패키지에 있는 클래스들은 improt없이 사용 가능
		StringBuilder sb = new StringBuilder(); // => ""
		System.out.println("문자열 길이 : " + sb.length());

		// append(param) : 현재 저장된 문자열에 매개변수로 전달한 값을 뒤로 추가
		sb.append("test");
		System.out.println(sb);
		System.out.println("문자열 길이 : " + sb.length());
		sb.append(1);// 늘려가면서 사용 하고, 객체 주소는 바뀌지 않는다.
		System.out.println(sb);// 오버로딩이 여러 타입으로되어 있는 것이다.
		sb.append(" 안녕");
		System.out.println(sb);// 길이 제한 없음
		System.out.println("문자열 길이 : " + sb.length());// 띄어쓰기도 데이터여서 포함

		// insert(정수, data) : 첫번째 매개변수 위치에 두번째 데이터를 삽입
		sb.insert(3, "data");
		System.out.println(sb);

		// replace(정수, 정수, 데이터) : 첫번째 매개변수부터 두번째 매개변수 앞까지 데이터를 세번째 매개변수로 변환
		sb.replace(3, 6, "수정구문");// 3, 4, 5 까지의 // 보통 첫번째는 포함, 두번째는 안포함
		// for문 생각하자.
		// for(int i = 3; i < 6; i ++)
		System.out.println(sb);

		// delete(정수, 정수) : 첫번째 매개변수부터 두번째 매개변수 앞까지 데이터를 삭제
		sb.delete(4, 9);
		System.out.println(sb);

		// reverse() : 현재 문자열 순서를 뒤집음
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);

		System.out.println(sb.toString());// StringBuilder 타입이여서 toString 으로 출력해야 한다.
	}

	public void exam1() {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		sb.append(r.nextInt(8));
		System.out.println(sb);
		char[] code = new char[8];
		for (int i = 0; i < code.length; i++) {
			// code[i] = r.nextInt();
		}

		int[] num = new int[8];
		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt();
		}
		// 영어대문자/영어소문자/숫자 를 무작위로 8개를 조합
		System.out.println("KH 정보교육원 입니다. 인증코드는 [" + num + "]입니다.");
	}

	public void examsam1() {		
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < 8; i++) {
			int flag = r.nextInt(3); // 0:숫자 / 1:대문자 / 2.소문자
			if (flag == 0) {
				int radomNum = r.nextInt(10);
				sb.append(radomNum);
			} else if (flag == 1) {
				int radomNum = r.nextInt(26) + 65;
				char ch = (char) radomNum;
				sb.append(ch);
			} else if (flag == 2) {
				int radomNum = r.nextInt(26) + 97;
				char ch = (char) radomNum;
				sb.append(ch);
			}
		}
		System.out.print(sb.toString());
	}
	
	public void test3() {
		String str = "이윤수/서울/강사/kh";
		//첫번째 매개변수 문자열을 두번째 매개변수 문자열(구분자)를 기준으로 잘라서 토큰으로 관리
		StringTokenizer sT = new StringTokenizer(str,"/");
	
		while(sT.hasMoreTokens()) { //자동완성이 있다. 토큰이 0이 아닐때가지 반복해라. 
			String str1 = sT.nextToken();
			System.out.println(str1);
		}
		
		/*
		while(sT.countTokens() != 0) {
			String str1 = sT.nextToken();
			System.out.println(str1);
		}
		*/
		/*
		int count = sT.countTokens();
		for(int i = 0; i <count; i++) {
			String str1 = sT.nextToken();
			System.out.println(str1);
		}
		*/
		/*
		System.out.println("토큰 수 : "+sT.countTokens());//현재 남아있는 토큰 수를 정수로 리턴
		String str1 = sT.nextToken();
		System.out.println(str1);
		System.out.println("토큰 수 : "+sT.countTokens());//꺼내오는 개념으로 보자
		String str2 = sT.nextToken();
		System.out.println(str2);
		System.out.println("토큰 수 : "+sT.countTokens());//꺼내오는 개념으로 보자
		System.out.println(str2);
		System.out.println("토큰 수 : "+sT.countTokens());
		String str3 = sT.nextToken();
		System.out.println(str3);
		System.out.println("토큰 수 : "+sT.countTokens());
		String str4 = sT.nextToken();
		System.out.println(str4);
		System.out.println("토큰 수 : "+sT.countTokens());
		String str5 = sT.nextToken();//error 다 꺼냈는데 어떻게 꺼내~
		System.out.println(str5);
		System.out.println("토큰 수 : "+sT.countTokens());
		*/
	}
}
