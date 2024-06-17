package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//ArrayList 배열을 이용한 InputOutput
//기능을 구현할때 프로그램-파일 내보내기,불러내기를 할때 애초에 파일에 저장하면 됨. 
public class UserMgr2 {
	private ArrayList<User> list;
	private Scanner sc;
	public UserMgr2() {
		super();
		list = new ArrayList<User>();
		sc = new Scanner(System.in);
	}
	
	public void main() {
		while(true) {
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 출력");
			System.out.println("3. 회원 정보 내보내기");
			System.out.println("4. 회원 정보 불러오기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select){
			case 1:
				insertUser();
				break;
			case 2:
				printUser();
				break;
			case 3:
				exportUser();
				break;
			case 4:
				importUser();
				break;
				
			}
		}
	}
	
	public void insertUser() {
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		User u = new User(id, pw, name, age);
		list.add(u);
		System.out.println("회원 정보 등록 완료");
	}
	public void printUser() {
		System.out.println("아아디\t비밀번호\t이름\t나이");
		for(User u : list) {
			System.out.println(u.getId()+"\t"+u.getPw()+"\t"+u.getName()+"\t"+u.getAge());
		}
	}
	
	public void exportUser() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream("backup2.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("내보내기 완료!");
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
	
	public void importUser() {
		ObjectInputStream ois = null; 
		try {
			FileInputStream fis = new FileInputStream("backup2.txt");
			//ois 객체를 만들어서 리드 해야하지만, 보조스트림 만들고, 트라이캐치, 라이널 만 하면 끝~
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			ArrayList<User> readList = (ArrayList<User>)obj;
			list = readList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
