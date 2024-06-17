package kh.java.func;

import java.beans.beancontext.BeanContextMembershipListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class SetTest {
	public void setTest() {
		// Arraylist 는 선형이여서 직선으로 관리한다고 생각하면 된다.
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println("set 내부의 데이터 수 : " + set.size());

		// add(param1) : 파라미터로 받은 데이터를 set에 추가
		set.add(10);
		System.out.println("set 내부의 데이터 수 : " + set.size());
		System.out.println(set);
		set.add(20);
		System.out.println(set);// 넣은 순서를 유지시켜주는 애가 아니다.
		set.add(30);
		System.out.println(set);// 규칙을 찾으려 하면 안된다. 규칙이 없다.
		// HashSet은 중복된 데이터를 저장할 수 없음
		set.add(10);
		System.out.println(set);

		// add(param1) : 파라미터로 받은 데이터를 set에 추가하고, 그 결과를 리턴(추가되면 true, 추가안되면 false)
		boolean bool1 = set.add(20);
		boolean bool2 = set.add(100);
		System.out.println(bool1);
		System.out.println(bool2);
		System.out.println(set);

		// remove(param1) : 파라미터로 받은 데이터를 set에서 삭제하고, 삭제에 성공하면 true/실패하면 false를 리턴
		boolean bool3 = set.remove(100);
		boolean bool4 = set.remove(1000);
		System.out.println(bool3);
		System.out.println(bool4);
		System.out.println(set);

		// CRUD update 는 없다.
		// set은 여러 데이터를 index로 관리하지 않음
		// -> 여러 데이터 중 특정 데이터에 접근할 방법이 없음 -> 수정이라는 개념이 없음(수정이 필요하면 삭제 후 다시 삽입)
		// -> index로 관리하지 않는다는건 특정데이터 하나만 꺼내오는것도 불가능
		// -> 꺼내는 방법이 필요

		// 1) 반복자(iterator)를 이용한 방법
		Iterator<Integer> iter = set.iterator();
		// hasNest() : 꺼내올 값이 남아있으면 true/ 없으면 false를 리턴하는 메소드 //StringTokenizer 와 비슷하다
		// next() : 값 한개를 꺼내옴
		while (iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}

		// 2) foreach 사용
		for (int num : set) {
			System.out.println(num);
		}

		// 3) HashSet을 ArrayList로 변환
		// ArrayList객체 생성 시 생성자에 set을 넣으면 ArrayList로 변환
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		for (int i = 0; i < list.size(); i++) {
			int num = list.get(i);
			System.out.println(i + " : " + num);
		}
	}

	public void lotto() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("\n----------- LOTTO -----------\n");
		ArrayList<Integer> userList = new ArrayList<Integer>();
		while (userList.size() < 6) {
			System.out.print("사용자 번호 입력[1~45] : ");
			int num = sc.nextInt();
			// 범위가 1~45사이
			// 중복숫자는 입력 불가능
			if (1 <= num && num <= 45) {
				// 2. 중복숫자는 입력 불가능(정상적으로 입력한 경우)
				boolean check = true;
				for(int i = 0; i < userList.size(); i++) {
					int checkNum = userList.get(i);
					if(checkNum == num) {
						System.out.println("중복된 숫자입니다.");
						check = false;
						break;
					}
				}
				if(check) {
					userList.add(num);
				}
			} else {
				System.out.println("1~45 사이 숫자를 입력하세요.");
			}
		}
	
		
		ArrayList<Integer> comNum = new ArrayList<Integer>();
		while(comNum.size() < 6) {
			int num = r.nextInt(45)+1;
			//랜덤으로 범위를 1~45 설정했으므로 중복체크만 하면 됨 
			boolean check = true;
			for(int i = 0; i < comNum.size(); i++) {
				int checkNum = comNum.get(i);
				if(checkNum == num) {
					check = false;
					break;
				}
			}
			if(check) {
				comNum.add(num);
			}
		}
	
		Collections.sort(userList);
		Collections.sort(comNum);
		System.out.println(userList);
		System.out.println(comNum);
	}//lotto();
	
	
	//set은 중복을 체크하는 목적으로 쓰면 편하게 쓸수 있다. 
	public void lotte2() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("\n---------- LOTTO v2 ----------\n");
		HashSet<Integer> userSet = new HashSet<Integer>();
		
		while(userSet.size() < 6) {
			System.out.print("사용자 번호 입력[1~45] : ");
			int num = sc.nextInt();
			if(1 <= num && num <= 45) {
				boolean result = userSet.add(num);
				if(!result) {
					System.out.println("중복된 숫자입니다.");
				}
			}else {
				System.out.println("1~45 사이 숫자를 입력하세요.");
			}
		}
		HashSet<Integer> comSet = new HashSet<Integer>();
		while(comSet.size() < 6) {
			int num = r.nextInt(45)+1;
			comSet.add(num);
		}
		ArrayList<Integer> userList = new ArrayList<Integer>(userSet);
		ArrayList<Integer> comList = new ArrayList<Integer>(comSet);
		Collections.sort(userList);
		Collections.sort(comList);
		System.out.println(userList);
		System.out.println(comList);
		
		int count = 0;
		
		for(int i = 0; i < userList.size(); i++) {
			int userNum = userList.get(i);
			boolean result = comSet.add(userNum);
			if(!result) {
				count++;
			}
		}	
		System.out.println("맞은 번호 수 : "+count);
		/*
		for(int i = 0; i < userList.size(); i++) {
			int userNum = userList.get(i);
			for(int j = 0; j < comList.size(); j++) {
				int comNum = comList.get(i);
				if(userNum == comNum) {
					count++;
					break;
				}
			}
		}
		*/
	
	}
}
