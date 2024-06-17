package kh.java.function;

import java.util.Scanner;

public class SwitchTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		switch(num) {     //괄호 안에 true false 가 아닌, 변수가 들어간다.
		case 1:           //변수 값이 case 와 같으면 실행이 된다.
			System.out.println("11111111111");
			break;        //break가 없으면 다음 구문이 실행이 된다. 
		case 2:
			System.out.println("22222222222");
			break;
		case 5:         //해당케이스 실행할때 동작해라. break 만날때까지 다음케이스가 실행이 된다. 
		case 3:
			System.out.println("33333333333");
			break;
		default :         //위에 일치하는게 없다면 아래 실행 _ else 와 비슷한 실행을 함. //필수는 아니다 else를 안쓰듯 안써도 된다. 
			System.out.println("???????????");
			break;
			//범위값을 줄수 없다 :: 범위가 겹칠일이 없다. //순서 무의미. 
		}
		/*
		if(num == 1) {    //범위값 입력 가능. 
			System.out.println("11111111111");
		}else if(num == 2) {
			System.out.println("22222222222");
		}else if(num ==3){
			System.out.println("33333333333");
		}else {
			System.out.println("???????????");
		}*/
		//if문이 switch문이 되려면 검사하는 수가 단일할때 가능. 
		//같은 값을 가지고 조건을 체크해야한다. 
	}
	//if 문과 switch문은 범위가 겹치지 않는다면 순서가 바뀌어도 상관이 없다. 
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
		char ch = sc.next().charAt(0);
		switch(ch) {
		case 97:
			System.out.println("aaaaaaaaaaaa");
			break;
		case 'b':
			System.out.println("bbbbbbbbbbbb");
			break;
		case 'c':
			System.out.println("cccccccccccc");
			break;
		/*
		'1' + 1 = 50  //아스키=> 1 = 49
		ch == 'a'     //50 true
		ch == 97      //A = 97 true
		*/
		}
		
		}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		switch(str) {
		case "aa": //case 문에서는 문자.  if문의 문자 받는 조건 : equal(문자열) -> switch는 equal생략 가능
			System.out.println("aaaa");
			break;
		case "bb":
			System.out.println("bbbb");
			break;
		case "cc":
			System.out.println("cccc");
			break;
		}
		//자바 최신 버전 22버전. 자바 1.7에서부터 추가된 기능  에러가 나면 자바 버전이 낮아서 안됨. 
		//금융권(보수적)은 최신 잘 안씀. 버전을 새로 바꾸면 구축된 에러 대응이 얼마나 바뀔지 예측이 안되기 때문 
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("일수를 알고싶은 달을 입력하세요 : ");
		int num = sc.nextInt();
		switch(num) { 
		case 1, 3, 5, 7, 8, 11:    //겹쳐놓기도 가능하다. case 1:  case 2:  case 3: 
			System.out.println(num+"월달은 31일까지 있습니다.");
			break;
		case 2: 
			System.out.println(num+"월달은 29일까지 있습니다.");
			break;
		case 4, 6, 9, 10, 12:
			System.out.println(num+"월달은 30일까지 있습니다.");
			break;
		}
	}
}
