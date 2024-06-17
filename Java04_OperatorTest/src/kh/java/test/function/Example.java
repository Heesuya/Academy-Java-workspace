package kh.java.test.function;
import java.util.Scanner;
public class Example {

	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.println("국어 점수 입력 : "+kor);
		System.out.print("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.println("영어 점수 입력 : "+eng);
		System.out.print("수학 점수를 입력하세요 : ");
		int math = sc.nextInt();
		System.out.println("수학 점수 입력 : "+math);

		int total = kor + eng + math;
		double ever = (double)total / 3;
		System.out.println("합계 : "+total);
		System.out.printf("평균 : %.2f\n",ever);

	//	boolean totalScore1 = kor >= 40 && eng >= 40;
	//	boolean totalScore2 = math >= 40 && kor >= 40;
	//	boolean totalScoreMain = totalScore1 && totalScore2;   //t f 로 도출이 됨 
		boolean totalSocre = kor >= 40 && eng >= 40 && math >=40 && ever >= 60;
		
	//	boolean eveResult= ever >= 60;
		
	//	boolean result = totalSocre && eveResult;
		String resultSting = totalSocre?"합격":"불합격";
		
		System.out.println(resultSting);
		
		//각점수가 40점 이상 / 평균 60점 이상 
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int num = sc.nextInt();
		boolean number = num/2 < 1;  //
		String numberSring = number?"짝수 입니다":"홀수 입니다";
		System.out.println(numberSring);
	}
}
