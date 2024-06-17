package kh.java.practice;
import java.util.Scanner;
public class Sample {

	public void sample1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		int chInt = ch;
		System.out.println("A의 유니코드 값 : "+(chInt));
		System.out.println("A의 유니코드 값 : "+(int)ch);
		System.out.printf("%c의 유니코드 값 : %d",ch,(int)ch);

	}
	public void sample2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		double kor = sc.nextDouble();
		System.out.print("수학 점수 입력 : ");
		double math = sc.nextDouble();
		System.out.print("영어 점수 입력 : ");		
		double eng = sc.nextDouble();
		double total = kor+math+eng;
		//		double total = (int)kor+math+eng;   : 210.9 -> 210 
		// 		double total = (int)kor+(int)math+(int)eng;  : 211->211  한개씩 변환 / 전체 변환  : 형변환 결과 다름. 
		double ave = total/3;
		System.out.println("총점 : "+(int)total);
		System.out.println("평균 : "+(int)ave);
	}
}
