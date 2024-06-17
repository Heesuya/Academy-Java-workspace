package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UserMgr {
//회원정보등록
	private User user;
	private Scanner sc;

	public UserMgr() {
		super();
		sc = new Scanner(System.in);
		user = null;
	}

	public void main() {
		while (true) {
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 회원 정보 출력");
			System.out.println("3. 회원 정보 내보내기");
			System.out.println("4. 회원 정보 불러오기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				insertUser();
				break;
			case 2:
				printUser();
				break;
			case 3:
				exportUser2();
				break;
			case 4:
				importUser2();
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
		user = new User(id, pw, name, age);
		System.out.println("등록 완료!");
	}

	public void printUser() {
		if (user == null) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.println("아이디 : " + user.getId());
			System.out.println("비밀번호 : " + user.getPw());
			System.out.println("이름 : " + user.getName());
			System.out.println("나이 : " + user.getAge());
		}
	}

	// 직렬화로 내보내는 메소드
	public void exportUser2() {
		if (user == null) {
			System.out.println("내보낼 정보가 없습니다.");
		} else {
			// 직렬화 한 객체를 내보내는 보조스트림 선언
			ObjectOutputStream oos = null;

			try {
				// 주스트림 생성
				FileOutputStream fos = new FileOutputStream("backup1.txt");
				// 주스트림 이용해서 보조스트림 생성
				oos = new ObjectOutputStream(fos);

				oos.writeObject(user);// 객체내보내기
				System.out.println("객체 내보내기 완료!");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void importUser2() {
		// backup1.txt파일에 있는 데이터를 가져옴
		// 직렬화되어 내보내진 객체를 다시 가져오는 보조스트림
		ObjectInputStream ois = null;

		try {
			// 주 스트림 생성
			FileInputStream fis = new FileInputStream("backup1.txt");
			// 주스트림을 이용해서 보조스트림 생성
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			User u = (User) obj;
			user = u;
			System.out.println("가져오기 완료!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void exportUser() {
		// uwer에 있는 정보를 id/pw/name/age 형태로 문자열로 만들어서 파일에 저장
		if (user == null) {
			System.out.println("내보낼 정보가 없습니다.");
		} else {
			String exportString = user.getId() + "/" + user.getPw() + "/" + user.getName() + "/" + user.getAge();
			// 내보낼 정보가 문자열 데이터 -> Writer
			BufferedWriter bw = null;
			try {
				// 데이터를 내보낼 주 스트림 생성
				FileWriter fw = new FileWriter("backup.txt");
				// 주스트림을 이용해서 보조스트림 생성(기능 강화)
				bw = new BufferedWriter(fw);
				// 데이터 내보내기
				bw.write(exportString);
				System.out.println("내보내기 완료!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void importUser() {
		// badkup.txt파일에서 데이터를 읽어와서 User객체로 만들어서 전역변수에 저장
		BufferedReader br = null;

		try {
			// 파일을 읽어올 주 스트림 생성
			FileReader fr = new FileReader("backup.txt");
			// 주스트림이용해서 보조스트림 생성
			br = new BufferedReader(fr);
			String str = br.readLine();
			// id/pw/name/age
			String[] arr = str.split("/");
			String id = arr[0];
			String pw = arr[1];
			String name = arr[2];
			int age = Integer.parseInt(arr[3]);
			User u = new User(id, pw, name, age);
			user = u;
			System.out.println("정보 불러오기 완료!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
