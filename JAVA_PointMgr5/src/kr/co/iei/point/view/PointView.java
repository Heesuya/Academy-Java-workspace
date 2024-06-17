package kr.co.iei.point.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointView {
	private Scanner sc;
	private ArrayList<Grade> members;
	
	public PointView() {
		super();
		sc = new Scanner(System.in);
		members = new ArrayList<Grade>();
	}
	
	public int main() {
		System.out.println("\n----- 회원 관리 프로그램v5 -----\n");
		System.out.println("1. 회원 정보 등록");
		System.out.println("2. 전체 회원 조회");
		System.out.println("3. 회원 1명 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		return select;
	}
	
	public Grade intsertMember(String str) {
		System.out.println("\n-------- 회원 정보 "+str+" --------\n");
		System.out.print(str+"할 회원 이름 입력 : ");
		String name = sc.next();
		System.out.print(str+"할 회원 등급[gold/silver/vip] : ");
		String grade = sc.next();
		System.out.print(str+"할 회원 포인트 입력 : ");
		int point = sc.nextInt();
		
		switch(grade) {
		case "gold" :
			Gold g = new Gold(name, grade, point);
			return g;
		case "silver" :
			Silver s = new Silver(name, grade, point);
			return s;
		case "vip" :
			Vip v = new Vip(name, grade, point);
			return v;
		default:
			fail();
			break;
		}
		return null;
	}
	
	public void fail() {
		System.out.println("잘 못 입력했습니다.");
	}
	
	public void getPrintAllmember(ArrayList<Grade> members) {
		System.out.println("\n-------- 전체 회원 출력 --------");
		System.out.println("이름\t등급\t포인트\t보너스");
		System.out.println("--------------------------------");
		for(Grade g : members) {
			System.out.println(g.getName()+"\t"+g.getGrade()+"\t"+g.getPoint()+"\t"+g.getBonus());
		}
		System.out.println("--------------------------------");
	}
	
	public String getName(String str) {
		System.out.println("\n-------- 회원 정보 "+str+" --------\n");
		System.out.print(str+" 할 회원 이름 : ");
		String name = sc.next();
		return name;
	}
	
	public void printOneMeber(Grade g) {
			System.out.println("이름 : "+g.getName());
			System.out.println("등급 : "+g.getGrade());
			System.out.println("포인트 : "+g.getPoint());
			System.out.println("보너스 : "+g.getBonus());
		
	}
	
	/*
	public Grade getUpdateMember() {
			System.out.println("수정할 이름 입력 : ");
			String modifyName = sc.next();
			System.out.println("수정할 등급 입력[gold/silver/vip] : ");
			String modifyGrade = sc.next();
			System.out.println("수정할 포인트 입력 : ");
			int modifyPoint = sc.nextInt();
			Grade g = new Grade(m)
			
			switch(modifyGrade){
			case "gold" :
				Gold g = new Gold(modifyName, modifyGrade, modifyPoint);
				return g;
			case "silver" :
				Silver s = new Silver(modifyName, modifyGrade, modifyPoint);
				return s;
			case "vip" :
				Vip v = new Vip(modifyName, modifyGrade, modifyPoint);
				return v;
			default:
				System.out.println("잘 못 입력했습니다.");
				break;
			}
			return null;
		}
		*/
	public void noSearchMember() {
		System.out.println("회원 정보를 찾을 수 없습니다.");
	}
	public void completeMessage(String str) {
		System.out.println(str+" 완료!");
	}
}
