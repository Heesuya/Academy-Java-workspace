package kr.co.iei.student.controller;

import java.util.ArrayList;

import kr.co.iei.student.model.vo.Student;
import kr.co.iei.student.view.StudentView;

//데이터가 있는 쪽이 중심이다. 
public class StudentController {
	private ArrayList<Student> students;
	private StudentView view;//부르면 응답만 주는 애
	public StudentController() {
		super();
		view = new StudentView();
		students = new ArrayList<Student>();
		students.add(new Student("학생1", 20, "인천"));
		students.add(new Student("학생2", 30, "서울"));
	}
	
	public void main() {
		while(true) {
			int select = view.main();
			switch(select) {
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
			 	return;
			}
		}
	}//main();
	
	public void insertStudent() {
		//view를 통해서 학생정보를 입력받고 입력받은 결과를 Student 타입으로 받아옴. 
		Student s = view.insertStudent();
		students.add(s);
		view.completeMessate("등록");
	}
	
	public void printAllStudent() {
		//매개변수로 출력할 데이터 전송
		view.printAllStudent(students);//참조형이기에 얕은 복사를 해서 준다. 
	}
	
	public void printOneStudent() {
		String name = view.getName("조회");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			view.noSearchStudent();
		}else {
			Student s = students.get(searchIndex);
			view.printOneStudent(s);
		}
	}
	
	public void updateStudent() {
		String name = view.getName("수정");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			view.noSearchStudent();
		}else {
			Student s = view.updateStudent();
			/*
			//1) 기존 객체 정보 수정
			Student student = students.get(searchIndex);
			student.setName(s.getName());
			student.setAge(s.getAge());
			student.setAddr(s.getAddr());
			*/
			//2) 새로 입력받은 객체로 리스틀 변경 
			students.set(searchIndex, s);
		}
		view.completeMessate("수정");
	}
	
	public void deleteStudent() {
		String name = view.getName("삭제");
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			view.noSearchStudent();
		}else {
			students.remove(searchIndex);
		}
		view.completeMessate("삭제");
	}
	
	public int searchStudent(String name) {
		for(int i = 0; i < students.size(); i++) {
			Student s = students.get(i);
			String studentName = s.getName();
			if(name.equals(studentName)) {
				return i;
			}
		}
		return -1;
	}

}
