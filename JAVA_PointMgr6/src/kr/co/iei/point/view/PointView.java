package kr.co.iei.point.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointView {
	private Scanner sc;

	public PointView() {
		super();
		sc = new Scanner(System.in);
	}
	
	public int main() {
		System.out.println("\n---------- 포인트 관리 프로그램v6 ----------\n");
		System.out.println("1. 회원 정보 등록");
		System.out.println("2. 전체 회원 출력");
		System.out.println("3. 회원 1명 출력");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	public Grade insertMember() {
		System.out.println("\n-------- 회원 정보 등록 --------\n");
		System.out.print("회원 등급 입력[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("회원 포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade){
			case "silver" :
				Silver s = new Silver(grade, name, point);
				return s;
			case "gold" :
				Gold g = new Gold(grade, name, point);
				return g;
			case "vip" 	:
				Vip v = new Vip(grade, name, point);
				return v;
		}
		return null;
	}

	public void completeMessage(String string) {
		System.out.println("회원 정보 "+string+" 완료!");
	}


	public void printAllMember(ArrayList<Grade> list) {
		System.out.println("\n-------- 전체 회원 출력 --------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("------------------------------");
		for(Grade g : list) {
			System.out.println(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t"+g.getBonus());
		}
	}

	public String getName(String string) {
		System.out.println("\n-------- 회원 정보 "+string+"--------\n");
		System.out.print(string+"할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}

	public void noSearchMember() {
		System.out.println("회원 정보를 조회할 수 없습니다.");
	}

	public void printOneMember(Grade g) {
		System.out.println("등급 : "+g.getGrade());
		System.out.println("이름 : "+g.getName());
		System.out.println("포인트 : "+g.getPoint());
		System.out.println("보너스 : "+g.getBonus());
	}

	public Grade updateMember() {
		System.out.print("수정 등급 입력 : ");
		String grade = sc.next();
		System.out.print("수정 이름 입력 : ");
		String name = sc.next();
		System.out.print("수정 포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade) {
		case "silver" :
			Silver s = new Silver(grade, name, point);
			return s;
		case "gold" :
			Gold g = new Gold(grade, name, point);
			return g;
		case "vip" :
			Vip v = new Vip(grade, name, point);
			return v;
		}
		return null;
	}
	
}
