package kh.java.test5;

import java.util.Scanner;

//협업을 가정화
//프론트 화면 구현 1일 / 백 구현 1일 -> 서로 규약을 걸지 않으면 
public class CalcFront {
	public void view() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[2];
		System.out.print("정수 입력 : ");
		arr[0] = sc.nextInt();
		System.out.print("정수 입력 : ");
		arr[1] = sc.nextInt();
		//Calc calc = new CalcTest(); 다형성을 이용해서 같은 인터페이스를 구연한것이니 가져오면 된다. 
		Calc calc = new CalcBack(); //다형성을 이용하면 코드의 변화도 최대한 줄여나갈수 있다. 
		int result = calc.sum(arr);
		System.out.println("결과 : "+result);
	}//실행하고 오류가 없어야 퇴근한다 ^ㅠ^....
}
