package kr.co.iei.point.controller;

import java.util.Scanner;


import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;
import kr.co.iei.point.vo.Vvip;

public class PointMgr implements PointMgrInterface {

	private Scanner sc; // 키보드 입력을 받기위한 Scanner
	private Grade[] members; // 회원정보를 저장할 배열(Silver,Gold,Vip 전부 다 Grade를 상속했으므로)
	private int index; // 배열의 회원 수를 관리하기 위한 변수
	private String searchMember;

	public PointMgr() {
		super();
		sc = new Scanner(System.in);
		members = new Grade[30];
		index = 0;
//		members[index++] = new Silver("silver", "윤희수", 300);
//		members[index++] = new Gold("gold", "윤희정", 300);
//		members[index++] = new Vvip("vvip", "김숙이", 300);
	}

	@Override
	public void main() {
		while (true) {
			System.out.println("\n ----- 회원 관리 프로그램v3 -----\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				insertMember();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printOneMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deletMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("잘 못 입력했습니다.");
				break;
			}
		}
	}

	@Override
	public void insertMember() {
		System.out.println("\n------- 회원 등록 --------\n");
		System.out.print("등록할 회원의 등급(silver/gold/vip/vvip) : ");
		String grade = sc.next();
		System.out.print("등록할 회원의 이름 : ");
		String name = sc.next();
		System.out.print("등록할 회원의 포인트 : ");
		int point = sc.nextInt();
		//다형성 : 부모타입 변수에 자식타입 객체의 주소를 저장할 수 있는 기능
		
		//Grade gra = new Grade(grade,name,point); //abstract 클래스(추상 클래스)은 객체를 만드는건 불가능하다. 
		switch (grade) {
		case "silver":
			//members[index++] = new Silver(grade, name, point);
			
			Silver s = new Silver();
			s.setGrade(grade);
			s.setName(name);
			s.setPoint(point);
			Grade gra = (Grade)s;//업캐스팅(자료형을 상위자료형 형태로 저장하는 것 -> 다형성)
			members[index++] = gra;
			//직접 객체를 사용하는것 못하지만 부모타입을 자료형으로 사용하는건 가능하다.
			//캡슐화를 하여서 상속해서 쓰는것. 
			break;
		case "gold":
			//members[index++] = new Gold(grade, name, point);
			
			Gold g = new Gold(grade, name, point);
			Grade gra2 = g; //업캐스팅(업캐스팅은 강제형변환을 하지않아도 조건이 맞으면 자동으로 형변환 가능)
			members[index++] = gra2;
			break;
		case "vip":
			//members[index++] = new Vip(grade, name, point);
			
			Vip v = new Vip(grade, name, point);
			members[index++] = v;//자동 업캐스팅 
			
			break;
		case "vvip":
			members[index++] = new Vvip(grade, name, point);
		default:
			System.out.println("등급을 잘 못 입력했습니다.");
		}
		System.out.println("회원 등록 완료");
	}

	@Override
	public void printAllMember() {
		System.out.println("\n-------- 전체 회원 정보 출력 ---------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("------------------------------------");
		for (int i = 0; i < index; i++) {
			Grade g = members[i];
			//다향성은 방향은 같다. 하위 클래스를 상위 클래스를 받을순 없다. 
			System.out.println(g.getGrade() +"\t"+ g.getName() +"\t"+ g.getPoint() +"\t"+ g.getBonus());
		}
	}

	@Override
	public void printOneMember() {
		System.out.println("\n------ 회원 조회 ------\n");
		System.out.print("조회할 회원 이름 : ");
		String name = sc.next();

		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {			
			Grade g = members[searchIndex];
			System.out.println("등급 : " + g.getGrade() + "\t이름 : " + g.getName() + "\t포인트 : " + g.getPoint() + "\t보너스 : "
					+ g.getBonus());
		}
	}
	//동적바인딩

	@Override
	public void updateMember() {
		System.out.println("\n------ 회원 수정 ------\n");
		System.out.print("수정할 회원 이름 : ");
		String name = sc.next();

		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {			
			System.out.println("수정 회원 등급 입력[silver/gold/vip/vvip] : ");
			String modifyGrade = sc.next();
			System.out.println("수정 회원 이름 입력 : ");
			String modifyName = sc.next();
			System.out.println("수정 회원 포인트 입력 : ");
			int modifyPoint = sc.nextInt();
			switch (modifyGrade) {
			case "silver":
				members[searchIndex] = new Silver(modifyGrade, modifyName, modifyPoint);
				break;
			case "gold":
				members[searchIndex] = new Gold(modifyGrade, modifyName, modifyPoint);
				break;
			case "vip":
				members[searchIndex] = new Vip(modifyGrade, modifyName, modifyPoint);
				break;
			case "vvip":
				members[searchIndex] = new Vvip(modifyGrade, modifyName, modifyPoint);
			}
			System.out.println("회원 수정 완료");
		}
	}

	@Override
	public void deletMember() {
		System.out.println("\n------ 회원 삭제 ------\n");
		System.out.print("삭제할 회원 이름 : ");
		String name = sc.next();

		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			for (int i = 0; i < searchIndex - 1; i++) {
				members[i] = members[i + 1];
			}
			members[--searchIndex] = null;
			System.out.println("회원 삭제 완료!");
		}

	}

	@Override
	public int searchMember(String name) {
		for (int i = 0; i < index; i++) {
			Grade gName = members[i];
			if (name.equals(gName.getName())) {
				return i;
			}
		}
		return -1;
	}

}
