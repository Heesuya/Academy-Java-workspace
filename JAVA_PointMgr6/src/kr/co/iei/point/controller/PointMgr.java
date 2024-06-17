package kr.co.iei.point.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import kr.co.iei.point.view.PointView;
import kr.co.iei.point.vo.Grade;

public class PointMgr {
	//기존 ArrayList 전역 변수 만들어서 저장 했지만 아예 저장을 안하겠다. 
	//필요하면 파일을 통해서 불러오겠다. 
	//사실 효율적인 방식은 아님.   //데이터를 효율적으로 관리할 문제는 DBMS(데이터 매니지먼트 시스템).
	//여러명이 한 데이터를 공유해야할때의 한계가 있다. 
	//버전 로직이 바꼈어 하면 뒤쪽이 바뀌고, 플랫폼이 바꼈어 하면 앞쪽이 바뀐다.
	private PointView view;

	public PointMgr() {
		super();
		view = new PointView();
	}
	
	public void main() {
		while(true) {
			int select = view.main();
			switch(select){
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
					deleteMember();
					break;
				case 0:
					return;
			}
		}
	}
	


	public void insertMember() {
		Grade g = view.insertMember();
		ArrayList<Grade> list = loadAllMembers();
		list.add(g);
		saveMembers(list);
		view.completeMessage("등록");
	}
	
	public void printAllMember() {
		ArrayList<Grade> list = loadAllMembers();
		view.printAllMember(list);
	}
	
	public void printOneMember() {
		String name = view.getName("조회");
		ArrayList<Grade> list = loadAllMembers();
		int searchMember = searchMember(name, list);
		if(searchMember == -1) {
			view.noSearchMember();
		}else {
			Grade g = list.get(searchMember);
			view.printOneMember(g);
			view.completeMessage("조회");
		}
	}
	
	private void updateMember() {
		String name = view.getName("수정");
		ArrayList<Grade> list = loadAllMembers();
		int searchIndex = searchMember(name, list);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			Grade g = view.updateMember();
			list.set(searchIndex, g);
			saveMembers(list);
			view.completeMessage("수정");
		}
	}
	
	public int searchMember(String name, ArrayList<Grade> list) {
		for(int i = 0; i < list.size(); i++) {
			Grade g = list.get(i);
			String searchName = g.getName();
			if(name.equals(searchName)) {
				return i;
			}
		}
		return -1;
	}
	private void deleteMember() {
		String name = view.getName("삭제");
		ArrayList<Grade> list = loadAllMembers();
		int searchIndex = searchMember(name, list);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			list.remove(searchIndex);
			saveMembers(list);
			view.completeMessage("삭제");
		}
	}
	
	//list 불러오기
	public ArrayList<Grade> loadAllMembers() {
		ArrayList<Grade> list = null;
		ObjectInputStream ois = null;
		try {
			//backup.txt 파일에 인풋 해줘~ 했는데 파일이 없다. 
			FileInputStream fis = new FileInputStream("backup.txt");
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			list = (ArrayList<Grade>)obj;
		} catch (FileNotFoundException e) {
			//에러 난 내용 알려줘서 메세지 없애고
			//길이가 0짜리 리스트를 받아 빈 리스트를 내보낸다. 
			//회원 한명도 없는 상태로 만들어~ 
			list = new ArrayList<Grade>();
			saveMembers(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) {					
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//똑같이 빈 리스트를 넣어놓아서 리턴이 된다. 
		return list;
	}
	
	public void saveMembers(ArrayList<Grade> list) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("backup.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
