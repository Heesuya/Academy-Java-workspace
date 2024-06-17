package kr.co.iei.student.controller;

import java.util.Scanner;

import kr.co.iei.student.vo.Student;
//개발을 하게 되면 전체적인 부분을 계획하고, 필요한 중복 기능(메소드)를 먼저 만든다. 
public class StudentController {
	// 동명이인 없음
	// 학생정보 10명 정보를 저장하고 관리할 배열
	private Student[] students;
	private Scanner sc;
	// 1) 학생정보를 입력받으면 배열에 몇번째에 넣을지 기억하고있는 변수
	// 2) 저장되어있는 학생의 수
	private int index;

	public StudentController() {// 값 초기화 하는 작업은 안쪽에서 한다.
		// 생성자에서 전역변수를 사용할 수 있도록 초기화
		students = new Student[10];
		sc = new Scanner(System.in);
		index = 0;
//		Student s1 = new Student("학생1",20,"인천");
//		students[index] = s1;
//		index++;
	}

	// 메인메뉴를 진행하는 메소드
	public void main() {
		while (true) {// CRUD create read update delete
			System.out.println("\n----------- 학생 관리 프로그램 -----------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 학생 정보 출력(전체)");
			System.out.println("3. 학생 정보 출력(이름입력받아서 이름과 일치하는 학생 1명)");
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
				deleteStudent();
				break;
			case 0:
				System.out.println("시스템을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}//witch 종료
		}//메뉴 while 종료
	}// main() 종료
	
	//학생 정보를 입력받아서 배열에 저장하는 메소드
	public void insertStudent() {
		System.out.println("\n----------- 학생 정보 등록 -----------\n");
		//학생정보를 입력을 받음(이름,나이,주소)
		System.out.print("등록 할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("등록 할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		//입력받은 정보를 바탕으로 Student 객체를 생성해서 배열에 저장
		
		/*
		//1) 기본생성자를 이용해서 Student 객체를 생성하고 값을 저장
		Student s = new Student();//기본생성자로 객체를 생성하면 내부 변수에 값이 저장되지 않음
		//setter를 통해서 데이터를 저장 
		s.setName(name);
		s.setAge(age);
		s.setAddr(addr);
		//Student객체로 저장된 데이터를 전역변수배열에 추가
		students[index] = s;
		index++;//학생이 새로 추가되었으면 다음번에 저장할 배열 번호로 index 값을 조정
		*/
		
		//2) 매개변수가 있는 생성자를 이용해서 Student 객체를 생성하고 값을 저장 
		//-> 생성자의 매개변수로 전달할 데이터를 내가 가지고 있으면 사용 가능
		Student s = new Student(name,age,addr);
		students[index++] = s;
		//객체를 생성하면서 생정자에서 데이터를 모두 저장해놨으므로 setter로 데이터를 저장하는 작업이 불필요
		System.out.println("학생 정보 등록 완료");
		
		//1) 로 만들경우 
	}//insertStudent() 종료
	
	//전체 학생 정보 출력
	public void printAllStudent() {
		System.out.println("\n----------- 전체 학생 정보 출력 -----------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("----------------------------------------");
		//전체학생정보는 배열에 순서대로 저장되어있음
		//전체를 출력하려면 배열에 있는 모든 정보를 출력 
		for(int i = 0; i < index; i++) {
			//students배열을 Student객체를 여러개 저장
			//students[숫자] -> 해당 위치에 있는 Student객체를 가져옴
			Student s = students[i];
			//Student객체 내부의 변수의 값을 가져오기위해서는 getter를 사용해야 함(변수 private이므로 접근불가)
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
	}//printAllStudent() 종료
	
	//이름을 입력 받아서 해당 이름과 일치하는 학생 정보를 출력하는 메소드
	//입력받은 이름의 학생이 존재하지 않으면, "학생 정보를 조회할 수 없습니다."출력
	public void printOneStudent() {
		System.out.println("\n----------- 학생 정보 조회 -----------\n");
		System.out.print("조회하고 싶은 학생 이름 입력 : ");//실제로는 아이디로 조회하겠죵?
		String name = sc.next(); //프로그램 동명이인 없다라는 전제이기에 실제 회사에서 운영하는 기능으로는 이렇게 하면 안됨. 
		//배열에 입력받은 이름을 가진 학생이 있는지 조회
		//입력받은 이름의 학생정보가 배열에 몇번째에 저장되어있는지 조회 
		int searchIndex = -1; //배열에 음수가 들어갈 수 없으니까 사용하지 않는 값으로 없는 값을 표현
		for(int i = 0; i < index; i++) {
			Student searchStudent = students[i];
			String studentName = searchStudent.getName();
			if(name.equals(studentName))
				searchIndex = i;
			break;
		}
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			Student s = students[searchIndex];
		System.out.println("학생이름 : "+s.getName());
		System.out.println("학생 나이 : "+s.getAge());
		System.out.println("학생 주소 : "+s.getAddr());
		}
		/*
		//입력받은 이름의 학생정보를 저장할 지역변수를 생성
		Student s = null;//참조형변수에 주소값을 할당하지 않은 값을 대입(null)
		
		for(int i = 0; i < index; i++) {
			Student searchStudent = students[i];//배열에서 학생객체주소를 가져옴
			String studentName = searchStudent.getName();//학생객체주소를 통해서 학생 이름을 가져옴
			if(name.equals(studentName)) {//입력받은 이름이랑, 가져온 학생이름이 같은지 비교
				s = searchStudent;//이름이 일치하면 학생객체주소를 지역변수에 저장
				break;//동명이인이 없는 조건이므로 일치하는 학생을 찾으면 그 이후는 검사하지 않아도 상관없음
			}
		}//for 종료
		if(s == null) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
		System.out.println("학생이름 : "+s.getName());
		System.out.println("학생 나이 : "+s.getAge());
		System.out.println("학생 주소 : "+s.getAddr());
		}
		*/
	}//printAllStudent() 종료
	
	//학생 이름을 입력받아서 해당 학생의 정보를 수정하는 메소드 
	public void updateStudent() {
		System.out.println("\n----------- 학생 정보 수정 -----------\n");
		System.out.print("정보를 수정할 학생 이름 입력 :  ");
		String name = sc.next();
		int searchIndex = searchStudent(name);//여러곳에 사용하는 조회 로직을 메소드 호출로 사용 
	
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회 할 수 없습니다.");
		}else {
			//수정할 정보를 입력받아서 데이터를 수정
			System.out.print("수정 할 이름 입력 : ");
			String modifyName = sc.next();
			System.out.print("수정 할 나이 입력 : ");
			int modifyAge = sc.nextInt();
			System.out.print("수정 할 주소 입력 : ");
			sc.nextLine();
			String modifyAddr = sc.nextLine();
			/*
			//1) 기존 Student 객체의 변수 값을 수정하는 방법(setter를 사용)
			Student s = students[searchIndex];
			s.setName(modifyName);//변수에 직접 수정은 불가능하고 setter
			s.setAge(modifyAge);
			s.setName(modifyName);
			System.out.println("정보 수정 완료!");	
			*/
			//2) 새로운 Student객체를 생성한 후 배열의 해당위치에 새 주소를 대입
			Student s = new Student(modifyName, modifyAge, modifyAddr);
			//ex students : 주소 1 ->> 배열 0(데이터 있다는 가정사에 ) 0 : 주소 2 ->> s = 주소 3  ==> 3의 주소르 0에 복사
			students[searchIndex] = s;
			System.out.println("정보 수정 완료!");	
		}
	}//updateStudent() 종료
	
	//학생 이름을 입력받아서 해당 학생 정보를 배열에 삭제하는 메소드
	public void deleteStudent() {
		System.out.println("\n----------- 학생 정보 삭제 -----------\n");
		System.out.print("삭제 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		
		if(searchIndex == -1) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}else {
			for(int i = searchIndex; i < index-1; i++) { //마지막은 null을 넣어주기 위해서 
				students[i]= students[i+1];
			}
			students[index-1] = null;
			index--;
			System.out.println("삭제완료");
			
			//index --;   students[index]; 
			//studentx[--index];
			/*//제일 뒤의 학생을 지울때의 일
			students[searchIndex] = null;
			index--; 
			*/
		}
	}//deleteStudent() 종료
	
	//매개변수로 받은 이름이 배열의 몇번째에 존재하는지 리턴하는 메소드/존재하지않으면 -1을 리턴
	public int searchStudent(String name) {
		int searchIndex = -1;
		for(int i = 0; i < index; i++) {
			Student searchStudent = students[i];
			String searchName = searchStudent.getName();
			if(name.equals(searchName)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}
}//클래스 종료
