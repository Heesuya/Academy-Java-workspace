package kh.java.fuction;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ArrayTest {
	public void test1() {
		// 1,2,3,4,5 라는 데이터를 각각 저장하고 출력
		// 1) 변수를 이용해서 처리
		int num0 = 1;
		int num1 = 2;
		int num2 = 3;
		int num3 = 4;
		int num4 = 5;
		System.out.println("변수를 이용한 값 출력");
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);

//		for(int i = 0; i < 5; i++) {  //여러개의 데이터를 제어문으로 컨트롤 할수없다. 
//			System.out.println(numi);
//		}

		// 2)배열을 이용해서 처리
		// 배열 선언 방법
		// 자료형[] 변수이름 = new 자료형[배열길이]; //인트가 아니고 배열이다 => 기본적으로 참조형이다.
		// 주소를 따라가다보면 정수형 칸에 0으로 세팅되어있다.
		int[] arr = new int[5];// 스택에 arr 변수를 만듦 -> 주소 따라가보니 -> 힙메모리에 5칸짜리의 초기값 0으로 세팅이 되어있다.
								// 0 0 0 0 0 -> 1 2 3 4 5
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		// arr[5] = 6; //error
		System.out.println("배열을 이용한 값 출력");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		// System.out.println(arr[5]); //error
		System.out.println("배열 데이터를 for문을 이용해서 출력");
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]); // 대괄호는 칸 번호구나, 따로 숫자를 가져올수 있구나. 여러개의 데이터를 제어문으로 컨트롤 가능.
		}
	}

	public void test2() {
		// 배열을 선언해서 데이터 1,2,3,4,5각각 저장한 후 출력
		int[] arr1 = new int[5];

		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		// 배열은 할당을 하면 기본값으로 데이터가 초기화 되어있음
		// 기본값 : 정수(0), 실수(0.0), 문자(' '), 논리형(false), 참조형(null->주소가 비어있다.)

		arr1[0] = 1;
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;
		System.out.println("--------------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		// 배열을 선언하면서 바로 값을 대입
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println("--------------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + arr1[i]);
		}
	}

	public void test3() {// 문자열 배열
		String[] arr = new String[4]; // 문자열 3개를 관리한다.
		arr[0] = "오늘은 금요일이죠";
		arr[1] = "집에 너무 가고 싶어요";
		arr[2] = "저 먼저 들어가도 될까요??";
		arr[3] = "여러분은 자습하고 가세요";
		for (int i = 0; i < 4; i++) {
			System.out.println(i + " : " + arr[i]);
		}
	}

	public void test4() {
		int[] arr = new int[3];
		arr[0] = 200;

		System.out.println(arr[0]);// 여러 데이터를 한번에 관리한다는게 아니라 같은 타입을 여러개 관리하는것이다.
		arr[1] = 'a'; // 자동형변환이 되는 타입은 가능하다.
	}

	public void exam1() { // 인덱스 = 숫자 , 넘버링
		String[] fruit = { "딸기", "복숭아", "키위", "사과", "바나나" };
		System.out.println(fruit[0]);
		System.out.println(fruit[1]);
		System.out.println(fruit[2]);
		System.out.println(fruit[3]);
		System.out.println(fruit[4]);
		System.out.println("--------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + fruit[i]);
		}
	}

	public void exam2() {
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			System.out.println("arr[" + i + "] : " + (arr[i] = (i + 1)));
		}
//		for(int i = 0; i < 100; i++) {
//			arr[i]=(i+1);
//		}
//		for(int i = 0; i < 100; i++) {
//			System.out.println(arr[i]);
//		}
	}

	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요 : ");
		double kor = sc.nextDouble();
		System.out.print("영어 점수를 입력하세요 : ");
		double eng = sc.nextDouble();
		System.out.print("수학 점수를 입력하세요 : ");
		double math = sc.nextDouble();
		double total = kor + eng + math;
		double ave = total / 3;
		double[] arr = new double[5];
		arr[0] = kor;
		arr[1] = eng;
		arr[2] = math;
		arr[3] = total;
		arr[4] = ave;
		for (int i = 0; i < 4; i++) {
			System.out.println(arr[i]);
		}
		System.out.printf("국어점수 : %.0f\n", arr[0]);
		System.out.printf("영어점수 : %.0f\n", arr[0]);
		System.out.printf("수학점수 : %.0f\n", arr[0]);
		System.out.printf("합계 : %.0f\n", arr[0]);
		System.out.printf("평균 : %.2f", arr[0]);
	}

	public void exam31() {
		int[] arr = new int[4];
		Scanner sc = new Scanner(System.in);
		String[] subject = { "국어", "영어", "수학" };

		for (int i = 0; i < 3; i++) {
			System.out.println(subject[i] + " 점수 입력 : ");
			int score = sc.nextInt();
			arr[i] = score;
			arr[3] += arr[i];// 합계를 자동으로 계산
		}
		/*
		 * System.out.print("국어 점수 입력 : "); arr[0] = sc.nextInt();
		 * System.out.print("영어 점수 입력 : "); arr[1] = sc.nextInt();
		 * System.out.print("수학 점수 입력 : "); arr[2] = sc.nextInt();
		 */
		// arr[3] = arr[0] + arr[1] +arr[2];
		/*
		 * for(int i = 0; i < 4; i++) { System.out.println(subject[i]+" : "+arr[i]); }
		 */
//		System.out.println("국어 점수 : " + arr[0]);
//		System.out.println("영어 점수 : " + arr[1]);
//		System.out.println("수학 점수 : " + arr[2]);

		System.out.println("합계 : " + arr[3]); // 합계는 입력 받는 for 문이 끝나야 출력이 가능하다.
		System.out.printf("평균 : %.2f", arr[3] / 3.0);
	}

	public void sort() {// 버블 정렬 //내림 차순 정렬도 금방 끝낼수 있다. //데이터 베이스에서 정렬해서 다 쓰지만, 논리를 잡기 위해서 함.
		int[] arr = { 5, 4, 2, 1, 3 };
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		for (int i = 0; i < 4; i++) {// 배열길이가 더 짧거나, 길면 정렬이 안된다. //4번 바뀌는 순간
			for (int j = 0; j < 4 - i; j++) { // 위에서 한번 바뀌었으니, 수는 점점 줄어들어야 수의 교차가 일어난다.
				if (arr[j] > arr[j + 1]) { // arr[j] < arr[j+1] 내림 차순
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		/*
		 * //총 수가 바뀌는 순간이 4번 for(int i = 0; i < 4; i++) { if(arr[i] > arr[i+1]) { int
		 * temp = arr[i]; arr[i] = arr[i+1]; arr[i+1] = temp; } } for(int i = 0; i < 3;
		 * i++) { if(arr[i] > arr[i+1]) { int temp = arr[i]; arr[i] = arr[i+1]; arr[i+1]
		 * = temp; } } for(int i = 0; i < 2; i++) { if(arr[i] > arr[i+1]) { int temp =
		 * arr[i]; arr[i] = arr[i+1]; arr[i+1] = temp; } } for(int i = 0; i < 1; i++) {
		 * if(arr[i] > arr[i+1]) { int temp = arr[i]; arr[i] = arr[i+1]; arr[i+1] =
		 * temp; } }
		 */

		// 버블정렬의 기본논리 -> 두 수를 비교해서 큰수를 배열의 뒤쪽에 배치

		/*
		 * if(arr[0] > arr[1]) { // arr[0] = 5; , arr[1] = 4; //두개 자리바꾸는 코드 int temp =
		 * arr[0]; //오버라이트 하게 되면 [0]의 값이 사라지기에 사라지는 값의 변수를 저장해야 한다. arr[0] = arr[1];
		 * //arr[0] 에 4를 대입하고 싶다. arr[1] = temp; //임의로 빼놓은 변수를 집어넣는다. }// 4, 5, 2, 1, 3
		 * 로 바껴있다. if(arr[1] > arr[2]) {// 5 와 2 의 값을 바꾼다. int temp = arr[1]; arr[1] =
		 * arr[2]; arr[2] = temp; }// 4, 2, 5, 1, 3 로 바뀐다. 두번째와 세번재의 수가 비교하여 바뀜.
		 * if(arr[2] > arr[3]) { int temp = arr[2]; arr[3] = temp; } if(arr[3] > arr[4])
		 * { int temp = arr[3]; arr[3] = arr[4]; arr[4] = temp; }
		 */
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public void sort2() {// 어떤 배열에도 가져다가 쓸수 있는 완성된 형태
		int[] arr = { 100, 36, 50, 78, 24, 35 };
		// 버블정렬로 오름차순 정렬해서 출력 //36, 50, 78, 100
		for (int i = 0; i < arr.length - 1; i++) {// length 사용하면 for 문을 일일히 수정할 필요가 없다.
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} // 오류 조심해야 한다. 프고르램이 느려진다 1초도 엄청 느려진것이다. 이런 코드 잘 안쓰지만 알고리즘과 코딩테스트에서는 감정 표현이 됨.
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public void test5() {
		int[] arr1 = new int[5];
		System.out.println(arr1.length);// 배열의 길이를 구하는 방법(데이터타입은 int)
		String[] arr2 = new String[3];
		System.out.println(arr2.length);// 항상 정수로 나온다~

		int[] arr = { 5, 4, 2, 1, 3 };
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		for (int i = 0; i < arr1.length - 1; i++) {// 배열길이가 더 짧거나, 길면 정렬이 안된다. //4번 바뀌는 순간
			for (int j = 0; j < arr1.length - 1 - i; j++) { // 위에서 한번 바뀌었으니, 수는 점점 줄어들어야 수의 교차가 일어난다.
				if (arr[j] > arr[j + 1]) { // arr[j] < arr[j+1] 내림 차순
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public void test6() {
		Scanner sc = new Scanner(System.in);
		// 다섯개 숫자를 입력받아서 오름차순 정렬해서 출력
		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 정수 입력 : ");
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < arr.length - 1; i++) {// 이런 로직은 매번 짤 필요가 없고, 가져다 쓰면 된다.
			for (int j = 0; j < arr.length - 1 - i; j++) { // 필요로 인해 바꿀때는 논리를 알아야 바꿔서 사용할수 있다.
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

//		System.out.print("첫번째 정수 입력 : ");
//		arr[0] = sc.nextInt();
//		System.out.print("두번째 정수 입력 : ");
//		arr[1] = sc.nextInt();
		// ...
		// num1,num2,num3,num4,num5
	}

	public void exam4() {
		Scanner sc = new Scanner(System.in);

		int[] room = new int[10]; // 10개의 배열 ... 0 ~ 9 의 순서로 시작.

		boolean power = true;
		while (power) {
			System.out.println("모텔관리프로그램 v1.0");
			System.out.println("1. 입실");
			System.out.println("2. 퇴실");
			System.out.println("3. 방보기");
			System.out.println("4. 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();

			switch (select) {
			case 1:// IN(입실)...방 번호를 입력받아서 들어가는 방에 값을 넣어준다.
				System.out.print("몇번방에 입실하시겠습니까?");
				int in = sc.nextInt();
				for (int i = 0; i < room.length; i++) {
					if (room[in - 1] == 0) { // 입력받은 번호에서 -1을 해야 해당 배열로 가게된다.
						int temp = in;
						room[in - 1] += 1;
						System.out.println(temp + "번방에 입실했습니다.");
						break; //
					} else {
						System.out.println(in + "번방에는 손님이 있습니다.");
						break;
					}
				}
				break;// case1 종료
			case 2:// OUT(퇴실)
				System.out.print("몇번방에 퇴실하시겠습니까?");
				int Out = sc.nextInt();
				for (int i = 0; i < room.length; i++) {
					if (room[Out - 1] != 0) {
						int temp = Out;
						room[Out - 1] -= 1;
						System.out.println(temp + "번방에 퇴실 하였습니다.");
						break;
					} else {
						System.out.println(Out + "번방은 빈방입니다.");
						break;
					}
				}
				break;// case2 종료
			case 3:
//0 1 2 3 4 5 6 7 8 9    1~10인덱스
//0 0 0 0 0 0 0 0 0 0
				// n번째 방에 현재 손님이 있습니다. or n번째 방이 현재 비어있습니다. n번째 방에 값을 대입하여 배열이 나오도록 하자.
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						System.out.println((i + 1) + "번방이 현재 비어있습니다.");
					} else if (room[i] == 1) {
						System.out.println((i + 1) + "번방에는 현재 손님이 있습니다.");
					}
				}
				break;
			case 4:
				power = false;
				break;
			}
		}
		//강사님 풀이와 내꺼 비교 _ 코멘트 
		//한개의 배열에 값을 넣는것이기 때문에 굳이 반복되는 곳에 넣는것이 아니여서 값 저장->새로운 temp 변수를 만들 필요 없음
	}

	public void motel() {
		// 강사님 풀이
		Scanner sc = new Scanner(System.in);
		// 정수배열
		// 방을 관리하기위한 배열
		// 배열안에 데이터가 0이면 빈방 / 1이면 손님이 있는방
		boolean[] rooms = new boolean[10];//기본값이 -> false 
		//배열안에 데이터가 false면 빈방 / true면 손님이 있는방
		
		
		//int[] rooms = new int[10];// 배열은 할당하면 기본값이 세팅(정수면 -> 0, 최오에 모두 빈방인 상태)
		//논리형으로 사용할수 있으나, 굳이 쓰진 않음. case가 둘중 하나일 경우. 

		boolean power = true;
		while (power) {
			System.out.println("모텔 관리 프로그램 v1.0");
			System.out.println("1.입실\t2.퇴실\t3.방보기\t4.종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.print("몇번방에 입실하시겠습니까?");
				int inRoomNo = sc.nextInt();
				//입실처리(데이터를 0->1로 변경) : 입실의 조건은 현재 빈방이어야 함(현재값이 0이어야 함)
				if(rooms[inRoomNo-1] == false) {
					rooms[inRoomNo-1] = true;
					System.out.println(inRoomNo+"번방에는 입실했습니다.");
				}else {
					System.out.println(inRoomNo+"번방에는 손님이 있습니다.");
				}
				break;
			case 2://case1 과 방법 다르게 
				System.out.println("몇번방에서 퇴실하겠습니까?");
				//퇴실처리(데이터를 1->0으로 변경) : 퇴실 조건은 현재 손님이 있는방이어야 함(현재값이 1)
				int outRoomNo = sc.nextInt() -1 ;
				if(rooms[outRoomNo] == true) {
					rooms[outRoomNo] = false;
					System.out.println((outRoomNo+1)+"빈방에서 퇴실하겠습니다.");
				}else {
					System.out.println((outRoomNo+1)+"번방은 빈방입니다.");
				}
				break;
			case 3:
				for(int i = 0; i <rooms.length; i++) {
					if(rooms[i] == true) {
						System.out.println((i+1)+"번방에는 손님이 있습니다.");
					}else {
						System.out.println(i+1+"번방은 빈방이 입니다.");
					}
				}
				/*
				if(rooms[0] == 1 ) {
					System.out.println("1번방에는 손님이 있습니다.");
				}else {
					System.out.println("1번방은 빈방이 입니다.");
				}
				
				if(rooms[1] == 1 ) {
					System.out.println("1번방에는 손님이 있습니다.");
				}else {
					System.out.println("1번방은 빈방이 입니다.");
				}
				*/
				
				break;
			case 4:
				power = false;
				break;
			}

		}
	}


}
