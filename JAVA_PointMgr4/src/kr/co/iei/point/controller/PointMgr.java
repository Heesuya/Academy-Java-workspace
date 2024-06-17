package kr.co.iei.point.controller;


import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

//ArrayList를 이용한 회원 관리 프로그램
public class PointMgr {

	ArrayList<Grade> members;
	Scanner sc;

	public PointMgr() {
		super();
		members = new ArrayList<Grade>();
		sc = new Scanner(System.in);
	}

	public void main() {
		while (true) {
			System.out.println("\n ----- 회원 관리 프로그램v4 -----\n");
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
				System.out.println("잘못 입력했습니다.");
				break;
			}
		}
	}// main();

	public void insertMember() {
		System.out.println("---------- 회원 정보 등록 ----------");
		System.out.print("등록할 회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("회원 등급 입력 [gold/silver/vip] : ");
		String grade = sc.next();
		System.out.print("회원 포인트 입력 : ");
		int point = sc.nextInt();

		switch (grade.toLowerCase()) {
		case "gold":
			Gold g = new Gold(grade, name, point);
			members.add(g);
			break;
		case "silver":
			Silver s = new Silver(grade, name, point);
			members.add(s);
			break;
		case "vip":
			Vip v = new Vip(grade, name, point);
			members.add(v);
			break;
		default:
			System.out.println("잘못 입력했습니다.");
			return;
		}
		System.out.println("회원 정보 입력 완료!");
	}// insertMember();

	public void printAllMember() {
		System.out.println("------- 전체 회원 정보 출력 -------");
		System.out.println("등급\t이름\t포인트\t보너스");

		for (Grade g : members) {
			System.out.println(g.getGrade() + "\t" + g.getName() + "\t" + g.getPoint() + "\t" + g.getBonus());
		}
	}//printAllMember();

	public void printOneMember() {
		System.out.println("---------- 회원 정보 조회 ----------");
		System.out.print("조회할 회원 이름 : ");
		String name = sc.next();
		
		int searchNum = searchIndex(name);

		if(searchNum == -1) {
			System.out.println("등록되지 않은 회원입니다.");
		}else {
			Grade g = members.get(searchNum);
			System.out.println("등급 : "+g.getGrade());
			System.out.println("이름 : "+g.getName());
			System.out.println("포인트 : "+ g.getPoint());
			System.out.println("보너스 : "+ g.getBonus());
		}
	}//printOneMember();
	
	public void updateMember() {
		System.out.println("--------- 회원 정보 수정 ----------");
		System.out.print("수정할 회원 이름 : ");
		String name = sc.next();
		
		int searchNum = searchIndex(name);
		
		if(searchNum == -1) {
			System.out.println("등록되지 않은 회원입니다.");
		}else {
			System.out.println("수정 회원 등급 입력[gold/silver/vip] : ");
			String modifyGrade = sc.next();
			System.out.println("수정 회원 이름 입력 : ");
			String modifyName = sc.next();
			System.out.println("수정 회원 포인트 입력 : ");
			int modifyPoint = sc.nextInt();
			
			switch(modifyGrade.toLowerCase()) {
			case "gold" :
				Gold g = new Gold(modifyGrade, modifyName, modifyPoint);
				members.add(searchNum, g);
				break;
			case "silver" :
				Silver s = new Silver(modifyGrade, modifyName, modifyPoint);
				members.add(searchNum, s);
				break;
			case "vip" :
				Vip v = new Vip(modifyGrade, modifyName, modifyPoint);
				members.add(searchNum, v);
				break;
			default :
				System.out.println("잘못 입력 했습니다.");
				return;
			}//switch 종료
			System.out.println("수정 완료!");
		}
	}
	
	public void deletMember() {
		System.out.println("-------- 회원 삭제 ---------");
		System.out.print("삭제할 회원 이름 : ");
		String name = sc.next();
		int searchNum = searchIndex(name);
		
		if(searchNum == -1) {
			System.out.println("등록되지 않은 회원습니다.");
		}else {
			members.remove(searchNum);
			System.out.println("회원 삭제 완료!");
		}
		
	}
	
	public int searchIndex(String name) {
		for(int i = 0; i < members.size(); i++) {
			Grade g = members.get(i);
			if(name.equals(g.getName())){
				return i;
			}
		}
		return -1;
	}//searchIndex();
	
}
