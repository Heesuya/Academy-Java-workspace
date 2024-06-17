package kh.java.function;

import java.util.Random;
import java.util.Scanner;

import javax.xml.transform.stax.StAXSource;

public class RandomTestExplanation {
	public void upAndDawn() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int rank = 0;// 최고기록 저장용 변수,
		boolean power = true;
		while (power) {
			System.out.println("============= UP & DOWN GAME =============");
			System.out.println("1. GAME START");
			System.out.println("2. GAME SCORE");
			System.out.println("3. END GAME");
			System.out.print("선택 >> ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				// 컴퓨터가 1~100사이 정수 중 1개를 랜덤으로 생성
				// 사용자가 생성된 번호를 맞춤(1번 번호 입력 시 마다 up/down 으로 정답에 대한 힌트 제공)
				System.out.println("<< GAME START >>");

				int randomNum = r.nextInt(100) + 1;// 정답숫자
				System.out.println("randomNum : " + randomNum);
				int count = 1;// count 누적
				// count = 1; //count 라는 변수가 switch 에 있지만 1이 실행되면 사라진다.
				while (true) {
					System.out.println(count + "회차 번호 입력 : ");
					int userNum = sc.nextInt();
					if (userNum < randomNum) {
						System.out.println("<< UP >>");
					} else if (userNum > randomNum) { // 독립 시행이 아니라 함께 동작 동작 있게 if-else if 로 묶어야 한다.
						count++;
						System.out.println("<< DOWN >>");
					}
					if (userNum == randomNum) {
						// 변수값을 키워서 하는게 아니다. 연산자 사용으로 해결.
						if (rank == 0 || rank > count) {// 최고기록을 저장하는 로직
							rank = count;
						}
						System.out.println("<< 정답 >>");
						break;
					}
					count++;
				}
				break;// case 1 종료
			case 2: // 최고기록은 전 사용자의 기록이다. 제일 빨리 맞춘 사람의 기록.
				if (rank == 0) {
					System.out.println("아직 기록이 없습니다.");
				} else {
					System.out.println("최고 기록은 " + rank + "회 입니다.");// count 라는 변수가 switch 에 있지만 1이 실행되면 사라진다.
				}
				break;
			case 3:
				power = false;
				break;
			}
		}
	}// 메소드 등록

	public void br31() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int win = 0;
		int lose = 0;
		boolean power = true;
		while (power) {
			System.out.println("======= BR 31 =======");
			System.out.println("1. GAME START");
			System.out.println("2. GAME SCORE");
			System.out.println("3. END  GAME");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				// 턴게임 -> 사용자랑 컴퓨터가 1~3 사이의 숫자를 외치면 숫자 커짐
				// -> 31이되면 종료(31을 외치는 쪽이 패배)
				int count = 0; // 화면에 출력하는 숫자를 관리하기 위한 변수
								// while 문 안에 넣을 경우 while 문이 끝나면 누적이 안된다.

				while (true) {
					System.out.println("<< YOUR TURN >>");
					System.out.println("Input Number(1~3) : ");
					int userNum = sc.nextInt();
					if (1 <= userNum && userNum <= 3) {
						for (int i = 0; i < userNum; i++) { // 입력한 만큼 반복을 하는 for 문을 사용하면 된다
							count++;
							System.out.println(count + "!");// 0부터 시작이 되어도, 올리고 출력 한다.
															// ++count 로 전위 연산을 해서 코드를 줄일수도 있다~
							if (count == 31) {
								lose++;
								System.out.println("패배 !!!!!!!!!");
								break; // for문을 나감
							}
						} // for 문(userNum) 종료
//						if (count == 31) {                   //실행이 안되는 이유는 count 가 31이상의 수가 나올수도 있기에 안된다. 
//							System.out.println("패배!!!!!");
//							break;
//						}
						if (count == 31) {
							break;
						}
						System.out.println("<< COMPUTER TURN >>");
						int comNum = r.nextInt(3) + 1;
						for (int i = 0; i < comNum; i++) {
							count++;
							System.out.println(count + "!");
							if (count == 31) {
								win++;
								System.out.println("승!!!!!");
								break;
							}
						} // for 문(comNum) 종료
						if (count == 31) {
							break;
						}
					} else {
						System.out.println("잘못 입력하셨습니다. 1~3 사이 숫자를 입력하세요 .");
					}
				} // 전체 while 종료
				break;
			case 2:
				System.out.println("WIN : +"+win);
				System.out.println("LOSE : "+lose);
				break;
			case 3:
				power = false;
				break;
			}

		}

	}
}
