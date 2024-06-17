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
		double avg = (double)total/3;
		System.out.println("합계 : "+total);
		System.out.printf("평균 : %.2f\n",avg);

		boolean totalSocre = kor >= 40 && eng >= 40 && math >=40 && avg >= 60;
		//String resultSting = totalSocre?"합격":"불합격";
		//System.out.println(resultSting);  
		
		System.out.println(totalSocre?"합격":"불합격");  //boolean 을 출력에 결과값 넣어서도 가능.  
		
		//강사님 풀이 1)
		//boolean korCheck = kor >=40;
		//boolean engCheck = eng >=40;
		//boolean mathCheck = math >=40;
		//boolean avgCheck = avg >=40;    
		//boolean resultCheck = kor && eng && math && ave ;
		//System.out.println(resultCheck?"합격":"불합격");
		
		//Stirng msg = kor?(eng?(math?:"불합격"):"불합격"):"불합격"  
		//논리 연산자 사용을 못하면 코드가 길어진다. 위와 같이는 쓰면 안되는 코드.  

	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println(	num%2 == 0? "짝수":"홀수");
		
		//어떤수 x2 /2 나누면 0으로 나누어 떨어진다.
		// 2,4,6 .. 2로 나눌경우 나머지 0이면 or 나머지가 있으면 
		//설계를 하고 이렇게 만들어야 겠다 코드를 짜야 한다. 
	}
}
