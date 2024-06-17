package kr.co.iei.point.controller;

import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.SearchResult;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointMgr {
	private Scanner sc;
	private Silver[] sMembers;
	private int sIndex;
	private Gold[] gMembers;
	private int gIndex;
	private Vip[] vMembers;
	private int vIndex;
	//searchMember2()에서 값을 변경, deleteMember()에서 해당 값을 확인
	private String searchGrade;//클래스간 주고받는게 힘들어진다. 

	// int num = "hi" 실버에 골드는 넣은건 다른 타입이기에 못넣는다.

	public PointMgr() {
		super();
		searchGrade = null;
		sc = new Scanner(System.in);
		sMembers = new Silver[10];
		sIndex = 0;
		gMembers = new Gold[10];
		gIndex = 0;
		vMembers = new Vip[10];
		vIndex = 0;
		//샘플데이터 배열에 미리 저장 
		Silver s1 = new Silver("silver","회원1",1000);
		sMembers[sIndex] = s1;
		sIndex++;
		sMembers[sIndex] = new Silver("silver","회원2", 2000);
		sIndex++;
		sMembers[sIndex++] = new Silver("silver", "회원3", 3000);
		gMembers[gIndex++] = new Gold("gold", "회원4", 1000);
		gMembers[gIndex++] = new Gold("gold", "회원5", 2000);
		vMembers[vIndex++] = new Vip("vip", "회원6", 1000);	
	}

	public void main() {
		while (true) {
			System.out.println("\n ----- 회원 관리 프로그랩v2 -----\n");
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
				porintOneMember1();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMeber();
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
	public void insertMember() {
		System.out.println("\n----- 회원 정보 등록 -----\n");
		System.out.print("회원 등급 입력[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		//입력받은 등급이 silver면 Silver객체 생성해서 sMembers 추가
		//입력받은 등급이 gold면 Gold객체 생성해서 gMembers 추가
		//입력받은 등급이 vip면 Vip객체 생성해서 vMembers 추가
		switch(grade) {
		case "silver" :
			Silver s = new Silver(grade, name, point);
			sMembers[sIndex] = s;
			sIndex++;
			break;
		case "gold" ://코드를 줄여보장~
			gMembers[gIndex] = new Gold(grade, name, point); //주소를 가져와서 넣는거기에 바로 넣어도 된다. 
			gIndex++;
			break;
		case "vip" :
			vMembers[vIndex++] = new Vip(grade, name, point);
			break;
		default	:
			System.out.println("등급을 똑바로 입력해");
			return;
		}
		System.out.println("회원 등록 완료!");
	}//insertMember() 종료
	
	public void printAllMember() {
		System.out.println("\n------ 전체 회원 정보 출력 -------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("---------------------------------");
		//실버등급 회원을 출력 -> sMembers 출력
		for(int i = 0; i < sIndex; i ++) {
			Silver s = sMembers[i];
			System.out.println(s.getGrade()+"\t"+s.getName()+"\t"+s.getPoint()+"\t"+s.getBonus());
		}
		//골드등급 회원을 출력 -> gMembers 출력
		for(int i = 0; i < gIndex; i++) {
			System.out.println(gMembers[i].getGrade()+"\t"+gMembers[i].getName()+"\t"+gMembers[i].getPoint()+"\t"+gMembers[i].getBonus());
		}
		for(int i = 0; i < vIndex; i ++) {
			Vip v = vMembers[i];
			System.out.println(v.getGrade()+"\t"+v.getName()+"\t"+v.getPoint()+"\t"+v.getBonus());
		}
	}//printAllMember() 종료
	
	public void porintOneMember1() {
		System.out.println("\n-------- 회원 정보 조회 --------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember1(name);
		
		if(searchIndex == -1) {
			System.out.println("회원 정보를 조회할 수 없습니다.");
		}else {
			if(searchIndex/100 == 1) {
				//vMembers에 있는 경우 
				Vip v = vMembers[searchIndex-100];
				System.out.println("등급 : "+v.getGrade());
				System.out.println("이름 : "+v.getName());
				System.out.println("포인트 : "+v.getPoint());
				System.out.println(("보너스 : "+v.getBonus()));
			}else if(searchIndex/10 == 1) {
				//gMembers
				Gold g = gMembers[searchIndex-10];
				System.out.println("등급 : "+g.getGrade());
				System.out.println("이름 : "+g.getName());
				System.out.println("포인트 : "+g.getPoint());
				System.out.println(("보너스 : "+g.getBonus()));
			}else {
				//sMebers
				Silver s = sMembers[searchIndex-10];
				System.out.println("등급 : "+s.getGrade());
				System.out.println("이름 : "+s.getName());
				System.out.println("포인트 : "+s.getPoint());
				System.out.println(("보너스 : "+s.getBonus()));
			}
		}
	}//porintOneMember1() 종료
	
	public void updateMember() {
		System.out.println("\n------ 회원 정보 수정 ------\n");
		System.out.print("수정 할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember3(name);
		if(result == null) {
			System.out.println("회원 정보를 조회할 수 없습니다");
		}else {
			System.out.println("수정 회원 등급 입력[silver/gold/vip] : ");
			String modifyGrade = sc.next();
			System.out.println("수정 회원 이름 입력 : ");
			String modifyName = sc.next();
			System.out.println("수정 회원 포인트 입력 : ");
			int modifyPoint = sc.nextInt();
			
			//같은 코드를 직장에서 쓰지 않음. 머리속에서 이해가 되고 그려야 함. 
			switch(result.getType()) {
			case "silver" :
				for(int i = result.getSearchIndex(); i < sIndex-1; i++) {
					sMembers[i] = sMembers[i+1];
				}
				sMembers[--sIndex] = null;
				break;
			case "gold" :
				for(int i = result.getSearchIndex(); i < gIndex-1; i++) {
					gMembers[i] = gMembers[i+1];
				}
				gMembers[--gIndex] = null;
				break;
			case "vip" :
				for(int i = result.getSearchIndex(); i < vIndex-1; i++) {
					vMembers[i] = vMembers[i+1];
				}
				vMembers[--vIndex] = null;
				break;
			}
			
			switch(modifyGrade) {
			case "silver" :
				Silver s = new Silver(modifyGrade, modifyName,modifyPoint);
				sMembers[sIndex] = s;
				break;
			case "gold" :
				Gold g = new Gold(modifyGrade, modifyName,modifyPoint);
				gMembers[gIndex] = g;
				break;
			case "vip" :
				Vip v = new Vip(modifyGrade, modifyName,modifyPoint);
				vMembers[vIndex] = v;
				break;
			}
				
			
			
			/* 내가 짠 코드   
			int searchIndex = result.getSearchIndex();
			String searhcGrade = result.getType();
			
			if(searchGrade == modifyGrade) {
				switch(modifyGrade) {
				case "silver" :
					sMembers[searchIndex] = new Silver(modifyGrade, modifyName, modifyPoint);
					break;
				case "gold" :
					gMembers[searchIndex] = new Gold(modifyGrade, modifyName, modifyPoint);
					break;
				case "vip" :
					vMembers[searchIndex] = new Vip(modifyGrade, modifyName, modifyPoint);
					break;
				default :
					System.out.println("잘못 입력했습니다.");
				}	
			}else if(searchGrade != modifyGrade) {
				if(modifyGrade.equals("silver")) {
					if(searchGrade.equals("gold")) {
						gMembers[gIndex--] = null;
						gIndex--;
						sMembers[sIndex++] = new Silver(modifyGrade, modifyName, modifyPoint);
					}else if(searchGrade.equals("vip")) {
						vMembers[vIndex--] = null;
						vIndex--;
						sMembers[sIndex++] = new Silver(modifyGrade, modifyName, modifyPoint);
					}
				}else if(modifyGrade.equals("gold")) {
					if(searchGrade.equals("vip")) {
						vMembers[vIndex--] = null;
						vIndex--;
						gMembers[gIndex++] = new Gold(modifyGrade, modifyName, modifyPoint);
					}
				}
			}*/
		System.out.println("회원 정보 수정 완료!");
		}

	}//updateMember() 종료
	
	public void deleteMeber() {
		//이 코드도 단점이 있다 -> 수정에서 보완 
		System.out.println("\n------ 회원 정보 삭제------\n");
		System.out.print("삭제 할 회원 정보 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember2(name);  
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			switch(searchGrade) {
			case "silver" :
				for(int i = searchIndex; i < sIndex-1; i++) {
					sMembers[i] = sMembers[i+1];
				}
				sMembers[sIndex-1] = null;
				sIndex--;
				break;
			case "gold" :
				for(int i = searchIndex; i < gIndex-1; i ++) {
					gMembers[i] = gMembers[i+1];
				}
				gIndex--;
				gMembers[gIndex] = null;
				break;
			case "vip" :
				for(int i = searchIndex; i < vIndex-1; i++) {
					vMembers[i] = vMembers[i+1];
				}
				vMembers[--vIndex] = null;
				break;
			}
		}
	}//deleteMeber() 종료
	
	
	public int searchMember1(String name) {//무조건 리턴은 1개의 자료 형태로만 가능하다. 
		//현재 배열의 길이가 10짜리이기에 가능 //스케일링이슈 (지금의 회원보다 수가 늘면, 코드를 바꿔야 한다)
		for(int i = 0; i < sIndex; i ++) {
			Silver s = sMembers[i];
			String searchName = s.getName();
			if(searchName.equals(name)) {
				return i ;  // 0 ~ 9  //숫자의 번호를 저장해서 한다. 
			}
		}
		for(int i = 0; i < gIndex; i++) {
			String searchName = gMembers[i].getName();
			if(searchName.equals(name)) {
				return i + 10 ;  // 10 ~ 19
			}
		}
		for(int i = 0; i < vIndex; i ++) {
			if(gMembers[i].getName().equals(name)) {
				return i + 100 ;  // 100 ~ 109
			}
		}
		return -1;
	}//searchMember1() 종료
	
	public int searchMember2(String name) {
		//String searchGrade = null;//사용하기 위해 전역변수로 올려두자.
		for(int i = 0; i < sIndex; i++) {
			String searchName = sMembers[i].getName();
			if(searchName.equals(name)) {
				searchGrade = "silver";//하나의 변수밖에 돌릴수 없어서, 변수를 만들어서 저장 한다. 되돌릴 정보가 2개인게 포인트이다. 
				return i ;
			}
		}
		for(int i = 0; i < gIndex; i++) {
			String searchName = gMembers[i].getName();
			if(searchName.equals(name)) {
				searchGrade = "gold";
				return i ;
			}
		}
		for(int i = 0; i < vIndex; i++) {
			String searchName = vMembers[i].getName();
			if(searchName.equals(name)) {
				searchGrade = "vip";
				return i ;
			}
		}
		return -1;
	}
	
	public SearchResult searchMember3(String name) {//되돌아 갈때 여러개일때 대부분의 상황 유연하게 대처가능 :: 객체를 만들어서 해결한다. 
		for(int i = 0; i < sIndex; i++) {
			String searchName = sMembers[i].getName();
			if(searchName.equals(name)) {
				SearchResult result = new SearchResult();
				result.setType("silver");
				result.setSearchIndex(i);
				return result;
			}
		}
		for(int i = 0; i < gIndex; i ++) {
			String searchName = gMembers[i].getName();
			if(searchName.equals(name)) {
				SearchResult result = new SearchResult("gold", i);
				return result;
			}
		}
		for(int i = 0; i < vIndex; i++) {
			String searchName = vMembers[i].getName();
			if(searchName.equals(name)) {
				SearchResult result = new SearchResult("vip",i);
				return result;
			}
		}
		return null;//2가지 타입을 넣어야 하는데 2가지다 없다면? 조회가 되면 정상적인 객체가 되돌아가고 안되면 null 이 되돌아 간다. 
	}
	
}
