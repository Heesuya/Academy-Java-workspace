package kh.java.fuction;

public class ArrayTest2 {
	public void test1() {
		// 자바라는 언어의 근간 // 이전꺼는 다른 언어와 기본과 비슷하다.
		int num1 = 100;
		System.out.println("num1 : " + num1);// 100
		int num2 = num1;
		System.out.println("num2 : " + num2);// 100

		num2 = 200;
		System.out.println("num2 : " + num2);// 200
		System.out.println("num1 : " + num1);// 100

		int[] arr1 = { 1, 2, 3, 4, 5 };
		System.out.println("arr 출력");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		int[] arr2 = arr1;// 얕은복사(한 배열의 주소를 두개의 변수가 공유)

		System.out.println("arr2 출력");

		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.println();

		System.out.println("arr2 출력");
		arr2[2] = 300; // 복사된 배열의 데이터를 수정하면 우너본데이터도 같이 수정(왜 -> 두 배열은 같은배열이니까)
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.println();

		System.out.println("arr 출력"); // 이건 왜 바뀌는가? 참조형은 heap 메모리에 저장 : 주소가 있다. 주소
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		// 같은 데이터를 바라보게 되기에, 하나의 데이터를 복사하면 같은 주소를 쓴다.

	}

	public void test2() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		// 배열의 깊은 복사(한 배열의 주소를 공유하는 것이아니라 동일한 형태의 배열을 새로운 주소에 복하나는 개념)
		// 깊은 복사하는 방법 3가지
		// 1) 직접 복사
		int[] arr2 = new int[arr1.length];// 원본배열과 같은 자료형과 길이로 기본배열 생성
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		System.out.println("arr1 출력");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		System.out.println("arr2 출력");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.println();
		System.out.println("arr2 출력");
		arr2[2] = 300;
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + "\t");
		}
		System.out.println();

		System.out.println("arr 출력");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		// 2) System.arraycopy를 사용(배열의 일부 데이터만 복사 가능)
		int[] arr3 = new int[arr1.length];
		// System.arraycopy(5개 값 설정)
		/*
		 * 1.원본배열, 2.원본배열 중 복사를 시작할 인덱스번호, 3.데이터가 복사될 배열, 4.데이터가 복사 될 배열 중 데이터가 들어갈
		 * 시작위치, 5.복사할 데이터 길이
		 */
		System.arraycopy(arr1, 1, arr3, 0, 3); // 배열 데이터 중에 일부만 복사할때 쓰면 된다.
		System.out.println("arr3 출력");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + "\t");
		}
		// 3) clone() : 복제의 개념
		int[] arr4 = arr1.clone();
		System.out.println("arr4 출력");
		for (int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i] + "\t");
		}
		System.out.println();
	}

	public void test3() {
		// 2차원 배열 -> 배열의 자료형이 배열인 데이터 형태
		int[][] arr = new int[2][3];
		arr[0][0] = 100;
		arr[0][1] = 200;
		arr[0][2] = 300;
		arr[1][0] = 400;
		arr[1][1] = 500;
		arr[1][2] = 600;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
		}
	}

	public void test4() {
		int[][] arr = new int[5][5];

		int k = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = k++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam1() {
		int[][] arr = new int[5][5];

		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][4 - j] = k++; // j 값에 변화를 준다.
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam2() {
		int[][] arr = new int[5][5];

		int k = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[j][i] = k++; // j 값에 변화를 준다.
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void exam4() {
		int[][] arr = new int[5][5];

		int k = 1;


		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = k++;
				}
			} else {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][4 - j] = k++;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		/*
		 * for (int j = 0; j < arr.length; j++) { 
		 		arr[0][j] = k++; }   1 2 3 4 5
		  
		  for (int j = 0; j < arr[1].length; j++) { 
		 		arr[1][4-j] = k++; } 10 9 8 7 6 
		 		
		  for (int j = 0; j < arr[2].length; j++) {
			 	arr[2][j] = k++; } 11 12 13 14 15
		 
		  for (int j = 0; j < arr[3].length; j++) {
		        arr[3][4-j] = k++; } 21 22 23 24 25
		
		
		  for (int i = 0; i < arr.length; i++) { for (int j = 0; j < arr[i].length;
		 * j++) { System.out.print(arr[i][j] + "\t"); } System.out.println(); }
		 */

		/*
		 * arr [0][1] = 1; arr [0][2] = 2; arr [0][3] = 3; arr [0][4] = 4; arr [0][5] =
		 * 5;
		 * 
		 * arr [1][1] = 10; arr [1][2] = 9; arr [1][3] = 8; arr [1][4] = 7; arr [1][5] =
		 * 6;
		 */
	}
	public void exam5() {
		int[][] arr = new int[5][5];

		int k = 1;

		/*
		for(int i = 0; i <arr.length-1; i++) {
			for(int j = 0; j <arr[i].length-1; j++) {
				arr[4-i][3-j] = k++;
			}
		}
		*/
		for (int i = 0; i < arr.length-1; i++) { 
	 		arr[0][i] = k++; }   //1 2 3 4 5
	
		for (int i = 0; i < arr.length; i++) {
			arr[i][4] = k++;
			}
		
		for(int i = 0; i <arr.length-1; i++) {
			arr[4][3-i] = k++;
		}
		for(int i = 0; i <arr.length-2; i++) {
			arr[3-i][0] = k++;
		}
		
		
	
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
