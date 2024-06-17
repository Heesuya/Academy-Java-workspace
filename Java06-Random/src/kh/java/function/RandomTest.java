package kh.java.function;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	// 웹사이트 가입할때 문자나 이메일로 인증 코드를 받을때, 랜덤 코드사용한다
	public void test1() {
		// 난수(Random숫자) : 무작위 수 / 임의의 수
		// 자바에서 난수를 제공하는 제공 : Random
		// 1. import java.util.Random;
		// 2. Random r = new Random();
		Random r = new Random();
		int num = r.nextInt();// int 범위에서 random숫자 1개 가져옴
		System.out.println("랜덤 수 : " + num);

		// random수 범위를 제한
		int num1 = r.nextInt(10);// r.nextInt(숫자); 0부터 해당숫자 갯수만큼의 범위내에서 랜덤으로 가져옴
		// 범위숫자의 시작숫자는 0부터~ (2)=> 0,1
		System.out.println("랜덤 수 : " + num1);

		int num2 = r.nextInt(13);// 0~12까지의 중 1개의 수를 랜덤으로 가져옴
		System.out.println("랜덤 수 : " + num2);

		// 0~26까지 중 1개의 수를 랜덤으로 가져옴
		int num3 = r.nextInt(27);
		System.out.println("랜덤 수 : " + num3);

		// 1~10까지 중 1개의 수를 랜덤으로 가져옴
		// 숫자1 : 랜덤 경우의 수
		// 숫자 2 : 랜덤 시작 숫자
		// r.nextInt(숫자1)+숫자2; //숫자1
		int num4 = r.nextInt(10) + 1;
		System.out.println("랜덤 수 : " + num4);

		// 10~30 : 21 10~19 / 20~29 / 31 21개
		int num5 = r.nextInt(21) + 10;
		System.out.println("랜덤 수 : " + num5);
	}

//이클립스 console 반복 되지 않게 종료 해놓아야 함. 
	public void coin() {
		// 컴퓨터랑 동전 앞/뒤 맞추기 게임
		// 컴퓨터가 동전을 던지고, 사람이 맞추는 게임
		Random r = new Random(); // 컴퓨터가 앞/뒤를 랜덤으로 결정하기 위함
		Scanner sc = new Scanner(System.in); // 사용자가 앞/뒤를 입력해서 선택하도록 하기 위함
		boolean power = true;
		int win = 0; // while문이 돌면 switch안의 내용이 사라진다. 그래서 while문 밖에 변수를 넣어야하지 누적이 된다.
		int lose = 0;
		while (power) { // 무한반복이 되는곳을 false가 될수 있게 코드를 바꿔줘야 한다.
			System.out.println("========== 동전 앞/뒤 맞추기 ==========");
			System.out.println("1. 게임시작");
			System.out.println("2. 전적확인");
			System.out.println("3. 게임종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				// 게임 로직
				// 동전을 컴퓨터가 던진다 -> 앞/뒤 중 1개를 결정
				int coin = r.nextInt(2) + 1;// 1 또는 2 중 1개의 값이 랜덤으로 나옴
				System.out.print("앞면/뒷면 선택하세요(1.앞면 / 2.뒷면) : ");
				// 0이 나오면 앞면, 1이나오면 뒷면
				int select = sc.nextInt();
				if (coin == select) {
					++win;
					System.out.println("정답입니다!!");
				} else {
					++lose;
					System.out.println("틀렸습니다!!!!!!!!!!!!!!!!!!!!");
				}
				break;
			case 2:
				// 전적 출력
				System.out.println("WIN : " + win + " LOSE : " + lose);
				break;
			case 3:
				// 게임 종료
				power = false;
				System.out.println("잘가라~");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}// switch 종료
		} // while 종료
		/*
		 * System.out.println("========== 동전 앞/뒤 맞추기 =========="); // 동전을 컴퓨터가 던진다 ->
		 * 앞/뒤 중 1개를 결정 int coin = r.nextInt(2) + 1;// 1 또는 2 중 1개의 값이 랜덤으로 나옴
		 * //System.out.println("coin : " + coin); //개발 확인용 : 먼저 코드가 잘 짜였는지 확인하기 위해서는 값을
		 * 확인한다. // 0이 나오면 앞면, 1이나오면 뒷면 System.out.print("앞면/뒷면 선택하세요(1.앞면 / 2.뒷면) : ");
		 * int select = sc.nextInt();
		 * 
		 * if (coin == select) { System.out.println("정답입니다!!"); } else {
		 * System.out.println("틀렸습니다!!!!!!!!!!!!!!!!!!!!"); } // 맞춘경우 : coin == 1 /
		 * select == 1, coin == 2 / select == 2 // 틀린경우 : coin == 1 / select == 2, coin
		 * == 2 / select == 1
		 */
	}// 메소드 종료

	public void rps1() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("=== 가위 바위 보 게임 ===");
		int com = r.nextInt(3) + 1;
		System.out.println("컴퓨터의 (1.가위 / 2.바위 / 3.보) : " + com);
		System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
		int sel = sc.nextInt();

		System.out.println("====== 결과 ======");

		switch (sel) {
		case 1: // 사용자 가위
			System.out.println("당신은 가위를 냈습니다.");
			if (com == 1) { // 컴퓨터 가위
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신은 비겼습니다.");
			} else if (com == 2) {// 바위
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신은 이겼습니다.ㅠ.ㅠ.");
			} else {// 보
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신이 졌습니다.");
			}
			break;
		case 2:
			System.out.println("당신은 바위를 냈습니다.");
			if (com == 1) { // 가위
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신은 이겼습니다.ㅠ.ㅠ.");
			} else if (com == 2) {// 바위
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신은 비겼습니다.");
			} else {// 보
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신이 졌습니다.");
			}
			break;
		case 3:// 보
			System.out.println("당신은 가위를 냈습니다.");

			if (com == 1) { // 가위
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신은 이겼습니다ㅠ.ㅠ");
			} else if (com == 2) {// 바위
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신은 졌습니다.");
			} else {// 보
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("=====================");
				System.out.println("당신이 비겼습니다");
			}
			break;
		default:
			System.out.println("잘못 입력했습니다.");
		}// switch 종료
	}// 메소드 종료

	public void rps2() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("=== 가위 바위 보 게임 ===");
		System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
		int sel = sc.nextInt();

		if (sel == 1) { // 독립 시행이 아닐대는 else if로 묶어주면 된다.
			System.out.println("당신은 가위를 냈습니다.");
		} else if (sel == 2) {
			System.out.println("당신은 바위를 냈습니다.");
		} else if (sel == 3) {
			System.out.println("당신은 보를 냈습니다.");
		}
		// 컴퓨터가 가위/바위/보를 선택할 차례 -> 컴퓨터는 랜덤수로 선택 -> 경우의 수 3개
		// 1 : 가위 / 2 : 바위 / 3 : 보
		int com = r.nextInt(3) + 1; // 1,2,3
		switch (com) {
		case 1:
			System.out.println("컴퓨터는 가위를 냈습니다.");
			break;
		case 2:
			System.out.println("컴퓨터는 바위를 냈습니다.");
			break;
		case 3:
			System.out.println("컴퓨터는 보를 냈습니다.");
			break;
		}
		if (sel < com || sel > com) {
			switch (sel) {
			case 1:
				break;
			case 2:
				if (com == 3) {
				}
				break;
			case 3:
				if (com == 1) {
				}
				break;
			}
			System.out.println("====== 결과 ======");

			System.out.println("당신은 이겼습니다ㅠ.ㅠ");
		}
	}

	public void rpsSam() {
		// 강사님 풀이
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		boolean power = true;
		int win = 0;
		int lose = 0;
		int draw = 0;
		while (power) {

			System.out.println("=== 가위 바위 보 게임 ===");
			System.out.println();
			System.out.println("1. 게임시작");
			System.out.println("2. 전적확인");
			System.out.println("3. 게임종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				while (true) {
					System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
					int user = sc.nextInt();
					System.out.println("========== 결과 ==========");
					// System.out.println("당신은 "+user+"를 냈습니다."); //실행 해보니 지금 이게 필요한게 아니란걸 알수 있다.
					if (user == 1) { // 독립 시행이 아닐대는 else if로 묶어주면 된다.
						System.out.println("당신은 가위를 냈습니다.");
					} else if (user == 2) {
						System.out.println("당신은 바위를 냈습니다.");
					} else if (user == 3) {
						System.out.println("당신은 보를 냈습니다.");
					}
					// 컴퓨터가 가위/바위/보를 선택할 차례 -> 컴퓨터는 랜덤수로 선택 -> 경우의 수 3개
					// 1 : 가위 / 2 : 바위 / 3 : 보
					int com = r.nextInt(3) + 1; // 1,2,3
					switch (com) {
					case 1:
						System.out.println("컴퓨터는 가위를 냈습니다.");
						break;
					case 2:
						System.out.println("컴퓨터는 바위를 냈습니다.");
						break;
					case 3:
						System.out.println("컴퓨터는 보를 냈습니다.");
						break;
					}

					if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
						win++;
						System.out.println("당신이 이겼습니다.");
						break;
					} else if (user == com) {
						draw++;
						System.out.println("비겼습니다.");
					} else {
						lose++;
						System.out.println("내가 이겼음 ㅋㅋㅋㅋㅋ");
					} // 승패를 판단한 if ~ else if
				} // 게임이 승부가 날때까지 반복하는 while
				break;
			case 2:
				System.out.println("WIN : " + win);
				System.out.println("DARW : " + draw);
				System.out.println("LOST : " + lose);
				break;
			case 3:
				System.out.println("Bye~");
				power = false;// 전체메뉴 반복 종료
				break;// switch 종료용
			}// 전체 메뉴 switch
		} // 전체 메뉴 반복용 while
	}// 메소드 종료

	public void nansu() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		boolean power = true;
		while (power) {// 게임 시작 메인 메뉴
			System.out.println("--------난수 발생 게임---------");
			System.out.println("1. UpAndDown");
			System.out.println("2. Bask inRobbins");
			System.out.println("3. Dice");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			switch (select) {
			case 1: // 업앤다운 게임 실행
				int rank = 0;// 승리 누적 변수 case 1에서 받은 누적된 승리 값 case2에서 사용
				System.out.println("==== UpAndDown ====");

				boolean upAndDownpower = true;
				while (upAndDownpower) {// 업앤다운게임 메뉴
					System.out.println("1. Game Start");
					System.out.println("2. Game Score");
					System.out.println("3. End Garme");
					System.out.print("선택 > ");
					int select1 = sc.nextInt();
					switch (select1) {
					case 1:// 게임 스타트
						int num = r.nextInt();// 사용자의 수 받기
						System.out.println("Game Start");
						int count = 1;// 입력된 회차 번호

						int comNum = r.nextInt(100) + 1;// 컴퓨터의 임의의 수 발생

						while (true) {//while 문을 빠져나가면 을 빠져 나가면 -> (while 반복 문 안의) switch 문 실행 
										//
							System.out.print(count + 1 + " 회차 번호 입력 : ");
							int num1 = sc.nextInt();
							if (comNum == num1) {
								System.out.println("<<정답>>");
								if(rank == 0 || rank > count) {
									rank = count;
								}
								break;
							} else if (num1 > comNum) {// 컴퓨터보다 내가 쓴 수가 크다.
								System.out.println("<< DOWN >>");
							} else { //
								System.out.println("<< UP >>");
							} // if ~ else 종료
						} // while 종료
						count++; // 수를 입력 받을 때마다 카운트 누적
						break;// case 1 _ 게임 종료

					case 2:// 스코어 입력
						System.out.println("현재 기록은 " + rank + "회 입니다.");
						break;

					case 3:// 종료 _ 시작 메인 메뉴로 이동
						System.out.println("메뉴로 이동합니다.");
						upAndDownpower = false;
						break;
					}// switch 종료
				} // while 종료
				break;// case 1 종료 _ 업앤다운 게임 종료

			case 2: // 베라31 게임 실행
				int baskinWin = 0; // 승률 받을 변수
				int lose = 0; // 패배 받을 변수
				System.out.println("===== Baskin Robbins31 Game =====");

				boolean baskinRobbinsPower = true; // false => 메인 메뉴 이동
				while (baskinRobbinsPower) { // 베라 게임 메뉴
					System.out.println("1. Game Start");
					System.out.println("2. Game Score");
					System.out.println("3. End Game");
					System.out.print("선택 > ");

					int baskinSelect = sc.nextInt();
					switch (baskinSelect) { // 메뉴선택에 따른 입장

					case 1:// 베라 게임 시작
						int countBaskin = 0; //
						System.out.println("<< Game Start >>");
						System.out.println("<< Your Turn >>");
						while (true) {
							System.out.print("Input Number : ");
							int inputNum = sc.nextInt();// 사용자가 적는 번호

							if (inputNum == 1 || inputNum == 2 || inputNum == 3) { // 조건문을 통해서 사용자에게 받은 변수에 따라 baskin의
																					// 수가 누적되게 한다.
								for (int i = 0; i < inputNum; i++) {// for 반복문을 통해서 코드를 짧게 입력 가능
									countBaskin++; // 반복문 쓸 경우 대다수 // 특정 조건 : for __ 정해지진 않을때는 : while
									System.out.println(countBaskin + "!");
									if (countBaskin == 31) { // 유저가 31을 입력받으면 패 조건문
										System.out.println("패");
										lose++;// 패배할 경우 값을 입력받는 변수
										break;
									} // if문 종료_사용자가 패배할 경우
								} // for문 종료_사용자

								if (countBaskin == 31) { // 중간에 번호 더이상 입력 받지 않게 설정
									break;
								} // if문 종료_31 까지 나온다.

								int com = r.nextInt(3) + 1;
								System.out.println("Computer Turn"); // 컴퓨터의 변수 랜덤 받기

								for (int i = 0; i < com; i++) { // for 반복문 _ 컴퓨터에게 입력받은 임의의 수 출력
									countBaskin++;
									System.out.println(countBaskin + "!");
									if (countBaskin == 31) { // 조건문
										System.out.println("승");
										baskinWin++; // 승리할 경우 값이 누적되는 변수
										break;
									} // if문 종료_컴퓨터가 패배할 경우
								} // for문 종료_컴퓨터의 임이의 수 입력 종료
								if (countBaskin == 31) { // 중간에 번호 더이상 입력 받지 않게 설정
									break;
								} // if문 종료_31 까지 나온다.
							} else {// 1~3외의 수가 입력이 되면 새로운 수를 입력하게끔 while 문을 이용하여 처음으로 돌아가 한다.
								System.out.println("1~3의 수를 입력하세요");
							} // if-else 종료
						} // while 문 종료
						break; // case1 종료 _ 베라 게임 종료

					case 2:// 전적 받기
						System.out.println("당신의 전적");
						System.out.println("WIN : " + baskinWin);
						System.out.println("LOSE : " + lose);
						break;

					case 3:
						baskinRobbinsPower = false;// 베라 게임을 종료 _ 메인 게임 메뉴 이동
						break;
					}// switch 종료
				} // while 종료
				break;

			case 3:// dice 게임 시작
				int batting = 0;// 배팅 할
				int money = 10000;// 가진 돈
				int DiceDraw = 0;
				int DiceWin = 0;
				int DiceLose = 0;
				char yesNo, game;
				System.out.println("===== Dice =====");

				boolean dicePower = true; // false => 게임 메인 메뉴 이동
				while (dicePower) { // dice 게임 메뉴
					System.out.println("1. Game Start");
					System.out.println("2. Game Score");
					System.out.println("3. End Game");
					System.out.print("선택 > ");
					int select3 = sc.nextInt();
					switch (select3) {

					case 1: // dice 게임

						boolean power1 = true; // false => dice 메뉴 이동
						while (power1) {// 배팅을 할지 물어본다.
							int user1 = r.nextInt(6) + 1;
							System.out.println("1번째 주사위 값 : " + user1);
							int user2 = r.nextInt(6) + 1;
							System.out.println("2번째 주사위 값 : " + user2);
							int user3 = r.nextInt(6) + 1;
							System.out.println("3번째 주사위 값 : " + user3);
							int userTotal = user1 + user2 + user3;
							System.out.println("내 주사위 총 합 : " + (userTotal));

							System.out.print("배팅 하시겠습니까[y/n] : ");
							game = sc.next().charAt(0);

							boolean power2 = true;// poser2 = false > dice 메뉴 이동
							while (power2) {
								if (money == 0 && money < 0) {
									System.out.println("돈을 다 잃었습니다.");
									System.out.println("메뉴로 돌아갑니다.");
									power2 = false;
									break;
								}
								if (game == 'y') {
									System.out.print("얼마를 배팅하시겠습니까(현재 내 소지금 " + money + "원) : ");
									batting = sc.nextInt();
									int com1 = r.nextInt(6) + 1;
									System.out.println("1번째 주사위 값 : " + com1);
									int com2 = r.nextInt(6) + 1;
									System.out.println("2번째 주사위 값 : " + com2);
									int com3 = r.nextInt(6) + 1;
									System.out.println("3번째 주사위 값 : " + com3);
									int comTotal = com1 + com2 + com3;
									System.out.println("내 주사위 총 합 : " + (comTotal));

									if (userTotal == comTotal) {
										DiceDraw++;
										System.out.println("비겼습니다.");
									} else if (userTotal > comTotal) {
										DiceWin++;
										System.out.println("승리!!");
										System.out.println("+" + batting + "원");
										money += batting;
									} else if (userTotal < comTotal) {
										DiceLose++;
										System.out.println("패배");
										System.out.println("-" + batting + "원");
										money -= batting;
									}

									System.out.println("한번 더 하시겠습니까[y/n] : ");
									yesNo = sc.next().charAt(0);
									if (yesNo == 'y') {
										break;
									} else if (yesNo == 'n') {
										power2 = false; // dice 메뉴 이동
										break;
									}

								} else if (game == 'n') {
									System.out.println("==== 메뉴로 돌아갑니다 ====");
									power2 = false;
									power1 = false;
									break;
								} else {
									System.out.println("=== 잘못 입력했습니다 ===");
									System.out.println("=== 다시 입력해주세요 ===");
									break;
								} // if ~ else 종료
							} // powoer2 _ while 문 종료
						} // power1 _ while 문 종료
						break;// case 1 종료 _ dice 게임 종료
					case 2:
						System.out.println("<<당신의 전적>>");
						System.out.println("WIN : " + DiceWin);
						System.out.println("LOSE : " + DiceLose);
						System.out.println("DRAW : " + DiceDraw);
						System.out.println("내 소지금 : " + money);
						break;
					case 3:
						dicePower = false;
						break;
					}// while 종료
				} // switch 종료
				break;

			}// switch 종료
		} // while 종료
	}// 메소드 종료

	public void upAndDown() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int win = 0;
		int count = 0;
		boolean power = true;
		while (power) {
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Garme");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			switch (select) {
			case 1:// 게임 실행
				int num = r.nextInt();
				System.out.println("Game Start");

				int comNum = r.nextInt(100) + 1;// 임의의 수 발생

				boolean power1 = true;
				while (power1) {
					System.out.print(count + 1 + " 회차 번호 입력 : ");
					int num1 = sc.nextInt();
					if (comNum == num1) {
						count++;
						System.out.println("<<정답>>");
						power1 = false;// 정답일 경우 while 문에서 빠져나온다.
					} else if (num1 > comNum) {// 컴퓨터보다 내가 쓴 수가 크다.
						count++;
						System.out.println("<< DOWN >>");
					} else { //
						count++;
						System.out.println("<< UP >>");
					} // if ~ else 종료
					if(comNum == num1) {
						if(win == 0 || win > count) {
							win = count;
						}
					}
				} // while 종료
				
				
				break;// case 종료
			case 2:// 스코어 입력
				System.out.println("현재 기록은 " + win + "회 입니다.");
				break;
			case 3:// 종료
				power = false;
				break;
			}// switch 종료
		} // while 종료
	}

	public void baskin() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		boolean power = true;
		int win = 0;
		int lose = 0;
		System.out.println("===== Baskin Robbins31 Game =====");
		while (power) {
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");

			int select = sc.nextInt();

			switch (select) {

			case 1:
				int count = 0;
				System.out.println("<< Game Start >>");
				System.out.println("<< Your Turn >>");
				boolean power1 = true;
				while (power1) {
					System.out.print("Input Number : ");
					int user = sc.nextInt();

					// 특정 조건 for .. 정해지진 않을때는 while
					if (user == 1 || user == 2 || user == 3) {
						for (int i = 0; i < user; i++) {
							count++;
							System.out.println(count + "!");
							if (count == 31) {
								System.out.println("패");
								power1 = false;
								lose++;
								break;
							} // for문 안의 if문 종료문
						} // for문 종료

						if (count == 31) {
							power1 = false;
							break;
						} // for문 안의 if문 종료문

						int com = r.nextInt(3) + 1;
						System.out.println("Computer Turn"); // 랜덤 받기를 이용해서 계속 번호를 누적해서 한다.

						for (int j = 0; j < com; j++) {
							count++;
							System.out.println(count + "!");
							if (count == 31) {
								System.out.println("승");
								win++;
								power1 = false;
								break;
							} // for2 - if문 종료
						} // for2문 종료
					} else {
						System.out.println("1~3의 수를 입력하세요");
					} // if-else 종료
				} // while 문 종료
				break;

			case 2:
				System.out.println("당신의 전적");
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				break;
			case 3:
				power = false;
				break;
			}// switch 종료
		} // while 종료

	}// 메소드 종료

	public void baskin1() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int count = 0;
		System.out.println("<< Game Start >>");
		System.out.println("<< Your Turn >>");
		boolean power = true;
		while (power) {
			System.out.print("Input Number : ");
			int user = sc.nextInt();

			// 특정 조건 for .. 정해지진 않을때는 while
			if (user == 1 || user == 2 || user == 3) {
				for (int i = 0; i < user; i++) {
					count++;
					System.out.println(count + "!");
					if (count == 31) {
						System.out.println("패");
						power = false;
						break;
					} // for문 안의 if문 종료문
				} // for문 종료

				if (count == 31) {
					power = false;
					break;
				} // for문 안의 if문 종료문

				int com = r.nextInt(3) + 1;
				System.out.println("Computer Turn"); // 랜덤 받기를 이용해서 계속 번호를 누적해서 한다.

				for (int j = 0; j < com; j++) {
					count++;
					System.out.println(count + "!");
					if (count == 31) {
						System.out.println("승");
						power = false;
						break;
					} // for2 - if문 종료
				} // for2문 종료
			} else {
				System.out.println("1~3의 수를 입력하세요");
			} // if-else 종료
		} // while 문 종료
	}// 메소드 종료

	public void dice1() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int batting = 0;
		int money = 10000;
		int draw = 0;
		int win = 0;
		int lose = 0;
		System.out.println("===== Dice =====");

		boolean dicePower = true; // 메뉴
		while (dicePower) {
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");

			int select = sc.nextInt();

			switch (select) {

			case 1:
				boolean power1 = true;
				while (power1) {
					int user1 = r.nextInt(6) + 1;
					System.out.println("1번째 주사위 값 : " + user1);
					int user2 = r.nextInt(6) + 1;
					System.out.println("2번째 주사위 값 : " + user2);
					int user3 = r.nextInt(6) + 1;
					System.out.println("3번째 주사위 값 : " + user3);
					int userTotal = user1 + user2 + user3;
					System.out.println("내 주사위 총 합 : " + (userTotal));

					System.out.print("배팅 하시겠습니까[y/n] : ");
					char game = sc.next().charAt(0);

					boolean power2 = true;
					while (power2) {
						switch (game) {
						case 'y':
							System.out.print("얼마를 배팅하시겠습니까(현재 내 소지금 " + money + "원) : ");
							batting = sc.nextInt();
							int com1 = r.nextInt(6) + 1;
							System.out.println("1번째 주사위 값 : " + com1);
							int com2 = r.nextInt(6) + 1;
							System.out.println("2번째 주사위 값 : " + com2);
							int com3 = r.nextInt(6) + 1;
							System.out.println("3번째 주사위 값 : " + com3);
							int comTotal = com1 + com2 + com3;
							System.out.println("내 주사위 총 합 : " + (comTotal));

							if (userTotal == comTotal) {
								draw++;
								System.out.println("비겼습니다.");
							} else if (userTotal > comTotal) {
								win++;
								System.out.println("승리!!");
								System.out.println("+" + batting + "원");
								money += batting;
							} else if (userTotal < comTotal) {
								lose++;
								System.out.println("패배");
								System.out.println("-" + batting + "원");
								money -= batting;
							}

							System.out.println("한번 더 하시겠습니까[y/n] : ");
							char yesNo = sc.next().charAt(0);
							if (yesNo == 'y') {
								break;
							} else if (yesNo == 'n') {
								power2 = false;
								power1 = false;
								break;
							}
							break;
						case 'n':
							System.out.println("메뉴로 돌아갑니다.");
							power2 = false;
							power1 = false;
							break;
						default:
							System.out.println("메뉴로 돌아갑니다.");
							power2 = false;
							power1 = false;
							break;
						}// switch 종료
					} // while2 종료
				} // while1 종료
				break;
			case 2:
				System.out.println("<<당신의 전적>>");
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				System.out.println("DRAW : " + draw);
				System.out.println("내 소지금 : " + money);
				break;
			case 3:
				dicePower = false;
				break;
			}
		} // while 종료

	}

	public void dice2() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int batting = 0;
		int money = 10000;
		char game, yesNo;

		boolean power1 = true; // false => dice 메뉴 이동
		while (power1) {// 배팅을 할지 물어본다.
			int user1 = r.nextInt(6) + 1;
			System.out.println("1번째 주사위 값 : " + user1);
			int user2 = r.nextInt(6) + 1;
			System.out.println("2번째 주사위 값 : " + user2);
			int user3 = r.nextInt(6) + 1;
			System.out.println("3번째 주사위 값 : " + user3);
			int userTotal = user1 + user2 + user3;
			System.out.println("내 주사위 총 합 : " + (userTotal));

			System.out.print("배팅 하시겠습니까[y/n] : ");
			game = sc.next().charAt(0);

			boolean power2 = true;// y/n 선택에 따른 게임 시작 유무
			while (power2) {

				if (game == 'y') {
					System.out.print("얼마를 배팅하시겠습니까(현재 내 소지금 " + money + "원) : ");
					batting = sc.nextInt();
					int com1 = r.nextInt(6) + 1;
					System.out.println("1번째 주사위 값 : " + com1);
					int com2 = r.nextInt(6) + 1;
					System.out.println("2번째 주사위 값 : " + com2);
					int com3 = r.nextInt(6) + 1;
					System.out.println("3번째 주사위 값 : " + com3);
					int comTotal = com1 + com2 + com3;
					System.out.println("내 주사위 총 합 : " + (comTotal));

					if (userTotal == comTotal) {
						System.out.println("비겼습니다.");
					} else if (userTotal > comTotal) {
						System.out.println("승리!!");
						System.out.println("+" + batting + "원");
						money += batting;
					} else if (userTotal < comTotal) {
						System.out.println("패배");
						System.out.println("-" + batting + "원");
						money -= batting;
					}

					System.out.println("한번 더 하시겠습니까[y/n] : ");
					yesNo = sc.next().charAt(0);
					if (yesNo == 'y') {

						break;
					} else if (yesNo == 'n') {
						power2 = false;
						power1 = false;
						break;
					} else if (money <= 0) {
						System.out.println("돈을 다 잃었습니다.");
						System.out.println("메뉴로 돌아갑니다.");
						power2 = false;
						break;
					}
				} else if (game == 'n') {
					System.out.println("==== 메뉴로 돌아갑니다 ====");
					power2 = false;
					power1 = false;
					break;
				} else {
					System.out.println("=== 잘못 입력했습니다 ===");
					System.out.println("=== 다시 입력해주세요 ===");
					break;
				} // if ~ else 종료
			} // powoer2 _ while 문 종료
		}

	}// 메소드 종료
}// class 종료
