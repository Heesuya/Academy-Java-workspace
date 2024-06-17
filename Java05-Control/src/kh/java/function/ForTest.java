package kh.java.function;

import java.util.Scanner;

public class ForTest {
	public void test2() {
		// 안녕하세요 3번 출력
		/*
		 * 초기값 : 반복문의 횟수를 처리할 변수를 선언 또는 초기화 조건식 : 반복문의 수행 여부를 결정하는 조건식(논리데이터가 나와야
		 * 함(true/false)) 증감식 : 초기값에서 사용하는 변수를 조작해서 조건식을 이용해서 횟수를 조절하기위한 증가/감소
		 * for(초기값설정;조건식;조건처리를위한 증감식){ 실행코드 }
		 */
		//입력하고 반복하는 하는 조건문 
		for (int i = 0; i < 3; i++) { // 언제 돌아갈지 안갈지 선택하는 것은 조건식이다. //이 방식이 제일 좋음. 컴퓨터는 숫자를 셀때 0부터 센다.
			System.out.println("안녕하세요");
		}
		for (int i = 1; i <= 3; i++) {
			System.out.println("안녕");
		}
		for (int i = 3; i > 0; i--) {
			System.out.println("잘가~");

		}
	}

	public void exam1() {
		for (int i = 0; i < 5; i++) {
			System.out.println("안녕하세요");
		}
	}

	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇번 출력하시겠습니까? ");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) { // 규칙을 찾으면 된다. 입력받는 숫자만 바뀌면 된다.
			System.out.println("안녕하세요");
		}
	}

	public void exam3() {
		System.out.println("2단 입니다.");
		for (int i = 0; i < 9; i++) {
			System.out.println(2 + "*" + (i + 1) + "=" + 2 * (i + 1));
		}
		/*
		 * for(int i=0; i < 9; i++) { //배열받을때 0부터 사용하는게 편해서 0부터 익숙해지는게 좋다.
		 * System.out.println("2 * "+(i+1)+" = "+2*(i+1)); // for 문안에서 자유자재로 바꿔도 된다. }
		 */
	}

	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까?");
		int dan = sc.nextInt();
		System.out.println(dan + "단 입니다.");
		for (int i = 0; i < 9; i++) {
			System.out.println(dan + " * " + (i + 1) + " = " + (dan * (i + 1)));
		}
	}

	public void exam5() {
		Scanner sc = new Scanner(System.in);		
		int sum = 0;   //3)사용하고자 하는 변수를 초기화 하여 반복문 안에서도 사용할수 있다. 
		for(int i = 0; i < 5; i++) {
			System.out.print("정수 값을 입력하시오 : ");
			int num = sc.nextInt();		//2)변수를 사용하고자 할때 포함하는 중괄호 안에서만 쓸수 있다. 변수가 사라진다. 
			sum += num;   //1)num <= 누적된 수를 더하고 싶다. 
		} // num = 받은 수이다. 
		System.out.println("입력한 5개의 정수의 합 : "+sum);
	}
	public void exam6() {  
		Scanner sc = new Scanner(System.in);
		int total = 0;
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번재 수 입력 : ");
		int num2 = sc.nextInt();
		for (int i = num1 ; i <= num2; i++) {    //반복해서 도는건 i이다. 
			total += i;
		}
		System.out.println(num1+" ~ "+num2+"의 정수의 합 : "+total);
		/*
		 강사님 풀이    count 생각하기
		 10  ~   13     >> 10  11  12  13
		 int count = num2 - num1 + 1;    
		 for(int i=0;i<count;i++) {
		 	//sum = sum + num1;   하게 되면 누적된 값+ 받은 값  계속 더해짐.
		 	 sum = sum + num1 + i;
		 	 }
		 */
	}
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++) {
			if(i%2 == 0) {       //속도가 중요하면 i+2로 진행. 
				total += i;
			}
		}
		System.out.println("짝수들의 합은 : "+total);  
	}
	/*
	 for(int i=0; i<num+1; i+=2){     //if 문 없이도 가능하다. 
	 	1) sum += i; 
	 	2) i++;    << 이렇게 쓰는건 거의 없긴하다.    
	 }
	 */
}
