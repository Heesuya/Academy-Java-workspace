package kr.co.iei.student.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.student.model.vo.Student;

//컨트롤러에서 준 데이터를 통해서 사용자 화면에 출력
//사용자한테 데이터를 입력받아서 컨트롤러에 되돌려주는 역할
public class StudentView {
	private Scanner sc;
	private ArrayList<Student> students;

	public StudentView() {
		super();
		sc = new Scanner(System.in);
		
	}
	
	//메인메뉴를 화면에 출력하고, 사용자의 선택값을 받아서 리턴
	public int main() {
		System.out.println("\n-------- 학생관리프로그램v4--------\n");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 전체 학생 출력");
		System.out.println("3. 학생 1명 출력");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int selcet = sc.nextInt();
		return selcet;
	}
	
	public Student insertStudent() {
		System.out.println("\n-------- 학생 정보 등록 --------\n");
		System.out.print("학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name, age, addr);
		return s;
	}
	
	public void printAllStudent(ArrayList<Student> students) {
		System.out.println("\n-------- 전체 학생 정보 출력 --------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("-----------------------------");
		for(int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
	}
	public String getName(String str) {
		System.out.println("\n-------- 학생 정보 "+str+" --------\n");
		System.out.println(str+" 할 학생 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	/*
	public String getName(String str) {
		System.out.println("\n-------- 학생 정보 "+str+" --------\n");
		System.out.println(str+" 할 학생 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	public String updateGetName() {
		System.out.println("\n--------- 학생 정보 수정 --------\n");
		System.out.println("수정 할 학생 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	public String deleteGetName() {
		System.out.println("\n-------- 회원 정보 삭제 --------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	*/
	public void noSearchStudent() {
		System.out.println("학생 정보를 찾을 수 없습니다.");
	}
	
	public void printOneStudent(Student s) {
		System.out.println("이름 : "+s.getName());
		System.out.println("나이 : "+s.getAge());
		System.out.println("주소 : "+s.getAddr());
	}
	
	
	public Student updateStudent() {
		System.out.print("수정 할 이름 입력 : ");
		String name = sc.next();
		System.out.print("수정 할 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("수정 할 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name, age, addr);
		return s;
	}
	
	public void completeMessate(String str) {
		System.out.println("학생 정보 "+str+" 완료!");
	}
}
