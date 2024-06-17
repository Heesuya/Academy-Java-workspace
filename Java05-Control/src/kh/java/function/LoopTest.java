package kh.java.function;

import java.util.Scanner;

public class LoopTest {
	// 횟수가 정해져 있을때는 for문을 사용한다 //반복해야 할경우 while문을 사용.
	// 무한 루프는 프로그램이 종류가 될때가지 무한으로 진행하겠다는 것.
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();

		for (int i = 0; i < (num2 - num1 + 1); i++) {
			System.out.println(i); // 무한루프에 빠진다.
		}
	}

	public void test2() {
		for (;;) { // 의도적으로 무한히 할게라는 표현
			System.out.println("무한반복");
		}
	}

	public void test3() {
		while (true) { // 의도적으로 무한히 할게라는 표현
			System.out.println("무한반복");
		}
	}

	public void test4() {
		// 분기문 : 반복문의 실행흐름을 제어하는 구문
		// 1)break :반복문을 빠져 나가는 구문
		// 2)continue : 반복문 수행중 아래를 실행하지 않고 반복문 다시 실행

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("정수를 입력하세요 : ");
			int num = sc.nextInt();

			if (num == 1) {
				break; // 즉시 반복문을 빠져 나감
				// System.out.println("break 이후 코드"); //error::이 뒤에는 절대로 실행할수 없기에 //unreachable
				// code
			} else if (num == 2) {
				continue; // 즉시 다음 반복회차로 이동
				// System.out.println("continue 이후 코드"); //error::이 뒤에는 절대로 실행할수 없기에
				// //unreachable code
			} else {
				System.out.println("입력한 숫자는 " + num);
			}
			System.out.println("반복문의 마지막 위치");
		}
		System.out.println("반복문을 나오면 보이는 문구!");
	}

	public void test5() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("정수를 입력하세요 : ");
			int num = sc.nextInt();
			if (num == 1) {
				break;
			}
			System.out.println("입력한 정수는 : " + num);
		}
		System.out.println("이건 반복문 종료 시 나오는 구문"); // error 나갈수 있는 가능성의 문제를 생각해야 한다.
	}

	public void test6() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("----------- 카카오톡 -----------");
			System.out.println("1. 친구");
			System.out.println("2. 채팅");
			System.out.println("3. 오픈채팅");
			System.out.println("4. 쇼핑");
			System.out.println("0. 프로그램종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.println("여기는 내 친구 목록이 쭉 나올예정임(나중에)");
			} else if (select == 2) {
				System.out.println("여기서는 내 채팅목록이 쭉 나올 예정(이것도 나중에)");
			} else if (select == 3) {
				System.out.println("여기는 내가 참여한 오픈채팅 목록이 나옴");
			} else if (select == 4) {
				System.out.println("여기는 쇼핑 목록이 나옴");
			} else if (select == 0) {
				break;
			}
		}
	}

//ctr+shift+f 자동정렬		//error 가 있을경우 사용이 안됨.	//돌이킬 수 없기 전에 미리 미리 누르자. 
	public void test7() {
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		while (power) {
			System.out.println("----------- 카카오톡 -----------");
			System.out.println("1. 친구");
			System.out.println("2. 채팅");
			System.out.println("3. 오픈채팅");
			System.out.println("4. 쇼핑");
			System.out.println("0. 프로그램종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			switch (select) { // 메뉴를 만들때는 switch 문을 많이 사용한다.
			case 1:
				System.out.println("여기는 내 친구 목록이 쭉 나올 예정");
				break;
			case 2:
				System.out.println("여기는 내 채팅목록이 쭉 나올 예정");
				break;
			case 3:
				System.out.println("여기는 내가 참여한 오픈채팅목록이 쭉 나올 예정");
				break;
			case 4:
				System.out.println("여기는 내가돈쓴 내역이 나올꺼야");
				break;
			case 0:
				power = false;
				break; // 왜 switch를 나가냐 나를 감싼 제일 가까운 애를 나간다.
			// break; //error::동작이 안됨. while문과 switch를 나가는 용도로 사용한다.
			}// switch 종료
		} // 메뉴 반복용 while 종료
	}// 메소드종료

	public void test8() {
		for (int i = 0; i < 5; i++) { // 중첩 for문은 여러가지 사고를 하기 좋다.
			// System.out.println(i+". 안녕");
			for (int j = 0; j < 5; j++) {
				System.out.println("i : " + i + " /j : " + j);
			}
		}
	}

	public void test9() {
		for (int j = 0; j < 8; j++) { // 헷가리면 (j = 2; j < 10; j++)
			for (int i = 0; i < 9; i++) {
				System.out.printf("%d*%d=%d\t", (j + 2), (i + 1), (j + 2) * (i + 1));
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 8; i++) { // 헷가리면 (j = 2; j < 10; j++)
			for (int j = 0; j < 9; j++) {
				System.out.printf("%d*%d=%d\t", (i + 2), (j + 1), (i + 2) * (j + 1));
			}
			System.out.println();
		}
		/*
		 * for (int i = 0; i < 9; i++) { System.out.printf("%d*%d =%d\t", 2, (i + 1), 2
		 * * (i + 1)); } System.out.println(); for (int i = 0; i < 9; i++) {
		 * System.out.printf("%d*%d =%d\t", 3, (i + 1), 3 * (i + 1)); }
		 * System.out.println(); for (int i = 0; i < 9; i++) {
		 * System.out.printf("%d*%d =%d\t", 4, (i + 1), 4 * (i + 1)); }
		 */
	}

	public void test10() {
		for (int i = 0; i < 8; i++) {
			System.out.printf("%d*%d=%d\t", (i + 2), 1, (i + 2) * 1);
		}

		System.out.println("\n\n");

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%d*%d=%d\t", (j + 2), (i + 1), (j + 2) * (i + 1));
			}
			System.out.println();
		}

		System.out.println("\n\n");

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.printf("%d*%d=%d\t", (i + 2), (j + 1), (i + 2) * (j + 1));
			}
			System.out.println();
		}
		// 안쪽의 for문은 가로줄이다.
	}

	public void star1() {
		for (int i = 0; i < 5; i++) {
			System.out.print("*");
		}
	}

	public void star2() {
		for (int j = 0; j < 5; j++) {
			System.out.println("*");
		}
	}

	public void star3() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star4() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(i + 1);
			}
			System.out.println();
		}
		/*
		 * for(int j = 0; j < 5; j++) { System.out.print(1); } System.out.println();
		 * for(int j = 0; j < 5; j++) { System.out.print(2); } System.out.println();
		 * for(int j = 0; j < 5; j++) { System.out.print(3); }
		 */
	}

	public void star5() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(j + 1);
			}
			System.out.println();
		}
	}

	public void star6() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(j + i + 1);
			}
			System.out.println();
		}
	}

	public void star7() {
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j < 10; j++) {
				System.out.print(j - i);
			}
			System.out.println();
		}
	}

	public void star8() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star9() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star10() {
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star11() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int s = 0; s < i + 1; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star12() {
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < i; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < 5 - i; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void starFor12() {
		for (int i = 0; i < 10; i++) {
			if (i < 6) {
				for (int k = 0; k < i; k++) {
					System.out.print("*");
				}
			} else {
				for (int j = 0; j < 10 - i; j++) {
					// (int j = 0; j <9-i; j++)
					System.out.print("*");
				}
			}
			System.out.println();
		} // for 종료
	}// class 종료

	public void starFor121() { // 보기편한 코드가 좋은 코드이다. 짧다고 다 좋은 코드는 아니다.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; i < 4 ? j < i + 1 : j < 9 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star13() {
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < 5 - i; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 4; i++) {
			for (int s = 0; s < i + 2; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star16() {
		for (int i = 1; i <= 5; i++) {
			for (int k = 0; k < 5 - i; k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < (i * 2 - 1); s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star17() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int s = 0; s < 9 - (i * 2); s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star18() {
		for (int i = 1; i <= 5; i++) {
			for (int k = 0; k < 5 - i; k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < (i * 2 - 1); s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			for (int s = 0; s < 7 - (i * 2); s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star19() {
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < 5 - i; s++) {
				System.out.print("*");
			}
			for (int k = 0; k < i + 1 + (i * 1); k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < 5 - i; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 4; i++) {
			for (int s = 0; s < i + 2; s++) {
				System.out.print("*");
			}
			for (int k = 0; k < 7 - (i * 2); k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < i + 2; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void starFor19() {
		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				for (int s = 0; s < 5 - i; s++) {
					System.out.print("*");
				}
				for (int k = 0; k < 1 + (i * 2); k++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 5 - i; j++) {
					System.out.print("*");
				}
			} else {
				for (int s = 0; s < i - 4; s++) {
					System.out.print("*");
				}
				for (int k = 9; k - (i * 2 - 10) > 0; k--) {
					System.out.print(" ");
				}
				for (int s = 0; s < i - 4; s++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public void star20() {
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < i + 1; s++) {
				System.out.print("*");
			}
			for (int k = 0; k < 9 - (i * 2); k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < i + 1; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 4; i++) {
			for (int s = 0; s < 4 - i; s++) {
				System.out.print("*");
			}
			for (int k = 0; k < i + 3 + (i * 1); k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < 4 - i; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star21() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			for (int s = 0; s < 9 - (i * 2); s++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= 4; i++) {
			for (int k = 0; k < 5 - i; k++) {
				System.out.print(" ");
			}
			for (int s = 0; s < 1 + (i * 2); s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void starAll() {
		System.out.println("Q4.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(i + 1);
			}
			System.out.println();
		}
		System.out.println("Q5.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(j + 1);
			}
			System.out.println();
		}
		System.out.println("Q6.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(j + i + 1);
			}
			System.out.println();
		}
		System.out.println("Q7.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(j + 5 - i);
			}
			System.out.println();
		}
		System.out.println("Q8.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q9.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q10.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q11.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q12.");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; (i < 5) ? j < i : j < 10 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q13.");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; (i < 5) ? j < 5 - i : j < i - 3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q16.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q17.");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 9 - 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q18.");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; i < 5 ? j < 4 - i : j < i - 4; j++) {
				System.out.print(" ");
			}
			for (int j = 0; i < 5 ? j < 2 * i + 1 : j < 17 - 2 * i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q19.");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; i < 5 ? j < 5 - i : j < i - 3; j++) {
				System.out.print("*");
			}
			for (int j = 0; i < 5 ? j < 2 * i + 1 : j < 17 - 2 * i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; i < 5 ? j < 5 - i : j < i - 3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q20.");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; i < 5 ? j < i + 1 : j < 9 - i; j++) {
				System.out.print("*");
			}
			for (int j = 0; i < 5 ? j < 9 - 2 * i : j < 2 * i - 7; j++) {
				System.out.print(" ");
			}
			for (int j = 0; i < 5 ? j < i + 1 : j < 9 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("Q21.");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; i < 5 ? j < i + 1 : j < 9 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; i < 5 ? j < 9 - 2 * i : j < 2 * i - 7; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}// 클래 종료
