package kh.java.function;
import java.util.Scanner;
public class Example {
	
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번 째 정수 입력 : ");
		int first = sc.nextInt();
		
		System.out.print("두번 째 정수 입력 : ");
		int second = sc.nextInt();
		
		System.out.println("더하기 결과 : "+(first+second));
		System.out.println("빼기 결과 : "+(first-second));
		System.out.println("곱하기 결과 : "+first*second);
		System.out.println("나누기 몫 : "+first/second);
		System.out.println("나누기 나머지 : "+first%second);
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 길이 입력 : ");
		double garo = sc.nextDouble();
		System.out.println();
		
		System.out.print("세로 길이 입력 : ");
		double sero = sc.nextDouble();
		System.out.println();
		
		System.out.println("면적 : "+garo*sero);
		System.out.println("둘레 : "+2*(garo+sero));
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("영단어 입력 : ");
		String word = sc.next(); 
		char fir = word.charAt(0);
		char sed = word.charAt(1);
		char th = word.charAt(2);
		
		//char word2 = sc.next().charAt(0);
		
		System.out.println("첫번재 문자 : "+fir);
		System.out.println("두번째 문자 : "+sed);
		System.out.println("세번재 문자 : "+th);
	}
}
