package kr.co.iei.point.controller;

import java.util.Scanner;
import kr.co.iei.point.vo.Silver;


public class PointMgr {
	//전역변수 
	private Scanner sc;
	private Silver[] members;
	 int index;
	
	//생성자에 전역변수 초기화 
	//PointMgr 이라는 객체를 사용하고 싶을때 생성자가 필요하다. (생성자를 만들지 않으면 기본 생성자를 자동으로 만들어준다.)
	//전역변수로 사용하게 되면 기본값이 세팅이 된다. 
	public PointMgr() {
		sc = new Scanner(System.in);
		members = new Silver[10];
		index = 0;	
		members[index++] = new Silver("silver","윤희수",100);
		members[index++] = new Silver("silver","윤희정",100);
		members[index++] = new Silver("silver","김숙이",100);
	
	}
	
	
	//지역변수는 쓰레기 값이 있어서 안에서 세팅을 해야 한다. 
	public void main() {
		while(true) {
			System.out.println(" \n==== 포인트 관리 프로그램v1 ====\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				insertMembers();
				break;
			case 2:
				printAllMembers();
				break;
			case 3:
				printOneMembers();
				break;
			case 4:
				updateMebers();
				break;
			case 5:
				deletMebers();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				return;
				default:
					System.out.println("잘못 입력했습니다.");
					break;
			}
		}
		
	}
	
	//회원 정보 등록
	public void insertMembers() {
		System.out.println("==== 회원 정보 등록 ====");
		System.out.print("등급입력 : ");
		String grade = sc.next();
		System.out.print("이름입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
	
		Silver s = new Silver(grade, name, point);
		members[index++] = s;
		System.out.println("등록완료!");
	}//inserMembers() 종료
	
	public void printAllMembers() {
		System.out.println("==== 전체 회원 출력 ====");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(int i = 0; i < index; i++) {
			Silver s = members[i];
			System.out.println(s.getGrade()+"\t"+s.getName()+"\t"+s.getPoint()+"\t"+s.getBonus());
		}
	//bonus 는 마치 변수인것처럼 사용하면 된다. 	
		
	}//printAllMembers() 종료
	
	public void printOneMembers() {
		System.out.println("==== 회원 정보 출력 ====");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		
		int searchIndex = searchMebers(name);
		
		if(searchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			Silver s = members[searchIndex];
			System.out.println("등급 : "+s.getGrade()+"\n이름 : "+s.getName()+"\n포인트 : "+s.getPoint()
								+"\n보너스 : "+s.getBonus());
		}//printOneMembers() 종료
		
	}//printOneMembers() 종료
	
	public void updateMebers() {
		System.out.println("==== 회원 정보 수정 ====");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMebers(name);
		
		if(searchIndex == -1 ) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			System.out.print("수정 등급 입력 : ");
			String modifyGrade = sc.next();
			System.out.print("수정 이름 입력 : ");
			String modifyName = sc.next();
			System.out.print("수정 포인트 입력  ");
			int modifyPoint = sc.nextInt();
			
			members[searchIndex] = new Silver(modifyGrade,modifyName,modifyPoint);
			
			//얕은복사 
			/*
			 Silver s = members[searchIndex];
			 s.getGrad(modifyGrade);
			 s.setName(modifyName);
			 s.setPoint(modifyPoint);
			 
			 위에가 이해가 가면 아래 코드로 해도 된다. 주소는 타고 들어가기에. 
			 members[serarchIndex].setPoint(modifyPoint);
			 */
			System.out.println("수정완료");
		}
	}//updateMebers() 종료
	
	public void deletMebers() {
		System.out.println("==== 회원 정보 삭제 ====");
		System.out.print("삭제할 회원 이름 입력 : ");
		String name = sc.next();
		
		int serchIndex = searchMebers(name);
		
		if(serchIndex == -1) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			for(int i = serchIndex; i < index-1; i++) {
				members[i] = members[i+1];
			}
			members[index] = null;
			index--;
			System.out.println("삭제 완료");
		}
	}//deletMebers() 종료
	
	
	//이름을 가지고 배열의 몇번째인지 찾아보는 기능
	//메소드를 만들어서 불러다가 쓰는게 편하다. 
	public int searchMebers(String name) {
		int searchIndex = -1;
		for(int i = 0; i < index; i++) {
			Silver s = members[i];
			String searchName = s.getName();
			if(name.equals(searchName)){
				searchIndex = i;  
				break;
			}
		}
		//return -1;
		return searchIndex;
	}//searchMebers() 종료
}
