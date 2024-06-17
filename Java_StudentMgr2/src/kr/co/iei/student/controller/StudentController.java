package kr.co.iei.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.student.vo.Student;

public class StudentController {
	private Scanner sc;
	private ArrayList<Student> students;
	// private Student[] students;
	// private int index;

	public StudentController() {
		super();
		sc = new Scanner(System.in);
		// students = new Student[30];
		students = new ArrayList<Student>();
		Student s1 = new Student("학생1", 20, "서울");
		Student s2 = new Student("학생2", 30, "부산");
		// students[index++] = s1;
		students.add(s1);
		// students[index++] = s2;
		students.add(s2);
		// students[index++] = new Student("학생3", 40, "경기");
		students.add(new Student("학생", 40, "경기"));
	}

	public void main() {
		while (true) {
			System.out.println("\n----------- 학생 관리 프로그램v2 ----------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 전체 학생 출력");
			System.out.println("3. 학생 1명 출력");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deletStudent();
				break;
			case 0:
				return;
			}// switch 종료
		} // while 종료
	}// main();

	public void insertStudent() {
		System.out.println("\n---------- 학생 정보 등록 ----------\n");
		System.out.print("등록 할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("등록 할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		// 1) 빈 Student객체 생성한 후 setter로 값을 대입
		/*
		 * Student s = new Student(); s.setName(name); s.setAge(age); s.setAddr(addr);
		 */

		// 2) 매개변수 있는 생성자를 통해서 Student객체를 만들면서 값을 바로 대입
		Student s = new Student(name, age, addr);

		// 배열사용 코드
		// students[index] = s; //배열의 학생객체를 저장
		// index++; //다음에 넣을 배열 위치 조정

		students.add(s);
		System.out.println("학생 정보 등록 완료!");
	}// insertStudent();

	public void printAllStudent() {
		System.out.println("\n---------- 전체 학생 출력 ----------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("---------------------------------");
		// 배열사용 코드
		/*
		 * for(int i = 0; i <index; i++) { Student s = students[i];
		 * System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr()); }
		 */
		/*
		 * for(int i = 0; i <students.size(); i ++) { Student s = students.get(i);
		 * System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr()); }
		 */
		// foreach 왼쪽은 타입 : 꺼낼꺼
		for (Student s : students) {
			System.out.println(s.getName() + "\t" + s.getAge() + "\t" + s.getAddr());
		}
	}//printAllStudent();

	public void printOneStudent() {
		System.out.println("\n---------- 학생 정보 출력 ----------\n");
		System.out.print("조회하고 싶은 학생 이름 입력 : ");
		String name = sc.next();
			
		//indexOf 는 Object 타입이여서 오류가 안난다. 
		//같은 데이터로 Student s = new Student 를 만들어도 메모리에 새로운 데이터이지, 다른 객체여서 안된다. 
		int searchNum = searchStudent(name);
		
		if(searchNum == -1) {
			System.out.println("학생 정보를 정회할 수 없습니다.");
		}else {
			Student s = students.get(searchNum);
			System.out.println("이름 : "+s.getName()+"\n나이 : "+s.getAge()+"\n주소 : "+s.getAddr());
		}
	}//printOneStudent();
	
	public void updateStudent() {
		System.out.println("\n---------- 학생 정보 수정 ----------\n");
		System.out.print("수정 할 학생 이름 : " );
		String name = sc.next();
		int searchNum = searchStudent(name);
		if(searchNum == -1) {
			System.out.println("입력한 정보가 없습니다.");
		}else {
			System.out.print("수정 할 이름 입력 : ");
			String modifyName = sc.next();
			System.out.print("수정 할 나이 입력 : ");
			int modifyAge = sc.nextInt();
			System.out.print("수정 할 주소 입력 : ");
			sc.nextLine();
			String modifyAddr = sc.nextLine();
			Student s = new Student(modifyName, modifyAge, modifyAddr);
			students.add(searchNum, s);
			System.out.println("정보 수정 완료");
		}
	}//updateStudent();
	
	public void deletStudent() {
		System.out.println("\n---------- 학생 정보 삭제 ----------\n");
		System.out.print("삭제 할 학생 이름 : " );
		String name = sc.next();
		int searchNum = searchStudent(name);
		if(searchNum == -1) {
			System.out.println("입력한 정보가 없습니다.");
		}else {
			//배열인경우 삭제 로직
			/*
			for(int i = searchIndex; i <index-1; i++) {
				Studnets[i] = students[i+1];
			}
			*/
			students.remove(searchNum);
		}
	}//deletStudent();
	
	//foreach 문으로 하게 되면 되돌려주는 숫자값이 없어서 사용이 힘들다. 쓰려면 i선언하고 i++하면된다.
	public int searchStudent(String name) {
		//int searchIndex = -1;
		for (int i = 0; i < students.size(); i++) {
			//Student s = students[i];
			Student s = students.get(i);//get()으로 대체 
			if (name.equals(s.getName())) {
				//searchIndex = i;
				//break;
				return i;
			}
		}
		//return searchIndex;
		return -1;
	}//searchStudent();
}//main();
