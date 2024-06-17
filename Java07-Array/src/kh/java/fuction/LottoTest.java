package kh.java.fuction;

import java.util.Random;
import java.util.Scanner;

public class LottoTest {
	public void lotto() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int[] userNum = new int[6];
		boolean[] sameNum = new boolean[6];
		// 1~45 의 수를 입력 받아야 한다.
		System.out.println("====== 로또 프로그램 ======");
		while (true) {
			for (int i = 0; i < 6; i++) {
				System.out.print(i + 1 + "번째 번호 입력 : ");
				int num = sc.nextInt();
				if (num > 0 && num < 46) {// 1~45
					for (int j = 0; j < userNum.length; j++) {
						userNum[j] = num;
						sameNum[j] = true;
					}
				} else {
					System.out.println("잘못입력했습니다. 1~45 중 한개를 입력하세요.");
					// break;
				}
				break;
			}
			for (int i = 0; i < sameNum.length; i++) {
				if (sameNum[i] == true) {
					System.out.println("이미 중복된 번호입니다.");
					break;
				}
			}
		}
		// 잘못 된 이유 : 값을 넣으면 무조건 true가 되어버리기 때문에 공식이 잘못 세움
		//
	}

	public void lotto2() {
		// 강사님 풀이
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int[] userNum = new int[6];
		for (int i = 0; i < 6; i++) {
			System.out.print(i + 1 + "번째 번호 입력 : ");
			int num = sc.nextInt();
			// 검증이끝나면 배열에 대입
			// 검증작업 총 2가지
			// 1) 입력한 숫자가 1~45 사이의 숫자인디
			// 2) 입력한 숫자가 배열에 존재하지 않은지
			if (num >= 1 && num <= 45) {
				// 정상적인 범위의 입력한 경우 -> 배열에 중복인지 체크
				// 같은지 비교하자.
				boolean check = true;// 중복체크 확인용 변수 __ 제어문 기본기 익히기(뒤에서는 어렵게 중복체크를 안한다)
				for (int j = 0; j < i; j++) {// 중복체크 하기; 코드 최적화
					if (userNum[j] == num) {
						check = false;
						// break;//중복인 숫자를 찾으면 그 이후 검사는 의미가 없으니까 중복체크 반복문 종료; 최적화
						// 위에서 굳이 최적화 했기에 break; 안해도 된다.
					}
				}
				if (check) {// if문 boolean 으로 사용 check라는 변수로 우리가 확인을 하겠다.
					userNum[i] = num;
				} else {
					i--;
					System.out.println("이미 중복된 번호입니다.");
				}

			} else {
				// 비정상적인 범위를 입력한경우 -> 배열 중복체크가 의미가 없다.
				System.out.println("1~45 범위의 숫자를 입력하세요.");
				i--; // 회차 반복 => for 문이 i--이면 반복이 되는 성질을 이용한다.
			}
		} // for문 종료

		// 컴퓨터 번호 받기
		int[] comNum = new int[6];
		for (int i = 0; i < comNum.length; i++) {
			int randomNum = r.nextInt(45) + 1;  //랜덤 숫자 1~6으로 고정하면 당첨 번호 확인이 편하다. 
			boolean check = true;
			for (int j = 0; j < i; j++) {
				if (comNum[j] == randomNum) {
					check = false;
				}
			}
			if (check) {
				comNum[i] = randomNum;
			} else {
				i--;
			}
		}
		
		// 사용자 번호 오름차순 변경
		for (int i = 0; i < userNum.length - 1; i++) {
			for (int j = 0; j < userNum.length - 1 - i; j++) {
				if (userNum[j] > userNum[j + 1]) {
					int temp = userNum[j];
					userNum[j] = userNum[j + 1];
					userNum[j + 1] = temp;
				}
			}
		}
		
		// 컴퓨터 번호오름차순 변경
		for (int i = 0; i < comNum.length - 1; i++) {
			for (int j = 0; j < comNum.length - 1 - i; j++) {
				if (comNum[j] > comNum[j + 1]) {
					int temp = comNum[j];
					comNum[j] = comNum[j + 1];
					comNum[j + 1] = temp;
				}
			}
		}
		
		// 최종 출력
		System.out.println("최종 결과");
		System.out.print("사용자 번호 : ");
		for (int i = 0; i < userNum.length; i++) {
			System.out.print(userNum[i] + " ");
		}
		System.out.println();
		System.out.print("당첨 번호 : ");
		for (int i = 0; i < comNum.length; i++) {
			System.out.print(comNum[i] + " ");
		}
		System.out.println();
		
		// 등수체크
		int count = 0;
		for (int i = 0; i < userNum.length; i++) {
			int num = userNum[i];

			for (int j = 0; j < comNum.length; j++) {
				if (comNum[j] == num) {
					count++;
					break;
				}
			}
		}
		System.out.println("맞은 개수 : "+count);
		switch(count) {
		case 6 : 
			System.out.println("1등!!");
			break;
		case 5:
			System.out.println("2등!");
			break;
		case 4:
			System.out.println("3등");
			break;
		default : 
			System.out.println("꽝!!!!!!");
		}
	}
}