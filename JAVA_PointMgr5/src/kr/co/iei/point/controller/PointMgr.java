package kr.co.iei.point.controller;

import java.util.ArrayList;

import kr.co.iei.point.view.PointView;
import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointMgr {
	private ArrayList<Grade> members;
	private PointView view;

	public PointMgr() {
		super();
		members = new ArrayList<Grade>();
		view = new PointView();
		members.add(new Gold("회원1", "gold", 100));
		members.add(new Silver("회원2", "silver", 100));
		members.add(new Vip("회원3", "vip", 100));
		

	}
	
	public void main() {
		while(true) {
			int selcet = view.main();
			switch(selcet){
			case 1:
				//회원 정보 등록 
				insertMember();
				break;
			case 2:
				//회원 전체 출력
				printAllMember();
				break;
			case 3:
				//회원 1명 조회
				printOneMember();
				break;
			case 4:
				//회원 정보 수정
				updateMember();
				break;
			case 5:
				//회원 삭제 
				deleteMember();
				break;
			case 0:
				return;
			default :
				view.fail();
				break;
			}
		}
	}//main();
	
	public void insertMember() {
		Grade g = view.intsertMember("등록");
		members.add(g);
		view.completeMessage("등록");
	}
	
	public void printAllMember() {
		view.getPrintAllmember(members);
	}
	
	public void printOneMember() {
		String name = view.getName("검색");
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			Grade g = members.get(searchIndex);
			view.printOneMeber(g);
		}
	}
	
	public void updateMember() {
		String name = view.getName("수정");
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			members.set(searchIndex, view.intsertMember("수정"));
			view.completeMessage("수정");
		}
	}
	
	public void deleteMember() {
		String name = view.getName("삭제");
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			members.remove(searchIndex);
		}
		view.completeMessage("삭제");
	}

	public int searchMember(String name) {
		for(int i = 0; i < members.size(); i++) {
			Grade g = members.get(i);
			if(name.equals(g.getName())) {
				return i;
			}
		}
		return -1;
	}

}
