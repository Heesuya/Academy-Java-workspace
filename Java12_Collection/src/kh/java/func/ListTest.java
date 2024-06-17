package kh.java.func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListTest {
	public void listTest1() {//해봤던 자료형과 비교하면서 해본거
		//길이가 3인 문자열 배열
		String[] arr = new String[3];//배열은 처음 만들때 길이를 지정해줘야 함
		System.out.println("배열의 길이 : "+arr.length);
		arr[0] = "hi";
		arr[1] = "hello";
		arr[2] = "bye";
		//arr[3] = "test";
		//문자열을 관리하기위한 ArrayList
		//ArrayList로 관리할 자료형을 제네릭으로 지정
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(arr[1]);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		//size() : 해당리스트의 현재 길이(데이터가 들어있는 숫자)
		System.out.println("리스트의 길이 : "+list.size());
		list.add("hi");//리스트의 가장 뒤에 매개변수로 받은 데이터를 추가 
		list.add("hello");
		list.add("bye");
		//list.add("test");
		System.out.println("리스트의 길이 : "+list.size());
		System.out.println(list.get(1));//get(index) : 매개변수로 준 index번째의 데이터를 가져옴
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println();
	}
	
	public void listTest2() {
		Scanner sc = new Scanner(System.in);
		//정수를 저장하는 리스트를 생성 -> 정수(int) 기본자료형
		//제네릭은 기본자료형은 사용불가 -> wrapper클래스로 처리
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(true) {
			System.out.print("리스트에 추가 할 숫자 입력 : ");
			int num = sc.nextInt();
			list.add(num);
			System.out.print("한번 더 입력하시겠습니까?[y/n]");
			String select = sc.next();
			if(select.toLowerCase().equals("n")) {
				break;
			}//중복되는 데이터도 상관이 없다. 
		}
		/*
		for(int i = 0; i < list.size(); i++) {
			Integer num = list.get(i);
			System.out.println(num);
		}
		*/
		//foreach : 컬레션 전체를 순회하는 반복문
		//1. 컬렉션을 처음부터 끝까지 전부다 돌아야할 때
		//2. i값이 데이터를 꺼내오는 목적외에 사용되지 않을때
		for(int num : list) {//int 를 써도 오토 언박싱  //Integer 도 사용가능 
			System.out.println(num);
		}
	}
	public void listTest3() {
		//정수를 저장할 리스트 생성
		//위치를 표현할때는 정수, 데이터는 제네릭
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		list.add(100);
		list.add(55);
		list.add(80);
		System.out.println(list);
		
		//get(index) : 매개변수로 전달한 정수의 위치에 있는 객체를 가져옴 
		int data = list.get(2);
		System.out.println(data);
		
		//add(param1) : 매개변수로 전달된 값을 리스트의 가장 뒤에 추가 
		list.add(20);
		System.out.println(list);
		
		//add(param1,param2) : 첫번째 매개변수 위치에, 두번재 매개변수 값을 추가 
		//추가한 데이터 기준으로 이후 데이터들은 모두 한칸씩 뒤로 밀림 
		list.add(3, 200);
		System.out.println(list);
		
		//set(param1,param2) : 첫번째 매개변수 위치의 데이터를 두번째 매개변수 값으로 수정 
		list.set(3, 1000);
		System.out.println(list);
		
		//remove(param1) : 매개변수 위치의 데이터를 삭제 -> 지워진 인덱스 기준으로 뒤의 데이터를 1칸씩 땡기는 작업 포함
		list.remove(3);
		System.out.println(list);
		
		//contains(param1) : 매개변수로 전달한 값이 리스트에 있는지 확인
		boolean bool1 = list.contains(100);
		boolean bool2 = list.contains(1000);
		System.out.println("bool1 : "+bool1);
		System.out.println("bool2 : "+bool2);
		
		//indexOf(param1) : 매개변수로 전달한 값이 리스트에 몇번째 있는지 확인 
		//-> 매개변수로 전달한 데이터가 리스트에 존재하지 않으면 -1을 리턴 
		int num1 = list.indexOf(100);
		int num2 = list.indexOf(1000);
		System.out.println(num1);
		System.out.println(num2);
		
		//정렬 -> 매개변수로 전달한 리스트를 정렬
		Collections.sort(list); //Collections 에 sort라는 메소드가 있고 매개변수로 list를 전달한다.
		System.out.println(list);
		
		//리스트 데이터 순서를 반전
		Collections.reverse(list);
		System.out.println(list);
		
		//isEmpty() : list.size() == 0 -> 리스트의 데이터가 한개도 없는지 체크해서 결과 리턴 
		System.out.println(list.isEmpty());//데이터가 들어있어서 false 
		
		//clear() : 리스트 내부 데이터를 모두 삭제
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());//데이터가 없으면 true
	}
	
}
