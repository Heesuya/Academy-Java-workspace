package kh.java.function;

import java.util.Scanner;

public class WhileTest {
	public void test1() {
		//안녕하세요 3번 출력
		/*
		 //조건식이 true이면 실행코드를 반복해서 수행
		 //한번 실행되면 다시 실행하기전에 조건식을 1번식 다시 검사
		 while(조건식){
		 	//실행코드
		 }
		 */
		int i = 0;     //초기변수 선언
		while(i<3) {
			System.out.println("안녕하세요");
			i++;       //증감도 직접 넣어야 함.
		}
		/*
		for(int i = 0; i < 3; i++) {
			System.out.println("안녕하세요");
		}
		*/
		//계속 반복되다가 사용자가 종료하면 끝낼때 
		//메세지가 반복해서 올때는 반복해서 메세지 오는것처럼 for 문 사용
	}
	public void exam1() {
		int i = 0;
		while(i<5) {
			System.out.println("안녕하세요");
			i++;
		}
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇번 출력하시겠습니까? ");
		int count = sc.nextInt();
		int i = 0;
		while(i < count) {
			System.out.println("안녕하세요");
			i++;
		}
	}
	public void exam3() {
		int i = 1;
		while(i<10) {
			System.out.println("2 * "+i+" = "+(2*i));
			i++;
		}
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까? ");
		int dan = sc.nextInt();
		System.out.println(dan+"단 입니다.");
		int i = 0;          //내가 입력한 코드 : i = 1;     >>아래식에서 i 에 +1을 해도 같은 값이 나온다.  
		while(i <9) {
			System.out.println(dan+" * "+(i+1)+" = "+(dan*(i+1)));
			i++;
		}
	}
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		while(i < 5) {
			System.out.print("정수 값을 입력하시오 : ");
			int num = sc.nextInt();
			sum += num;
			//sum += sc.nextInt();
			i++;
		}
		System.out.println("입력한 5개의 정수의 합 : "+sum);
	}
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		int sum = 0;
		int i = num1;
		while(i <= num2) {       //(i <= num2+1)  도 가능
			sum += i;
			i++;
		}
		System.out.println(num1+" ~ "+num2+"의 정수의 합 : "+sum);
		//System.out.printf("%d ~ %d의 정수의 합 : %d",num1,num2,sum);
	}
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int sum = 0;
		int i = 1;
		while(i <= num) {     //(i <num+1)
			if(i%2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("짝수들의 합은 : "+sum);
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		//일단 실행을 하고 조건을 검사해!!   무조건 한번은 실행이 된다. 
		do {  
			System.out.println(num);
			num++;
		}while(num < 10);
		/*   
		//조건을 검사하고 실행해!!
		while(num < 10) {
			System.out.println(num);
			num++;
		}
		*/
	}
}
