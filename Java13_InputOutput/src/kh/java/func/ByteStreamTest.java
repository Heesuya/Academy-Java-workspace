package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest {
	private Scanner sc;

	public ByteStreamTest() {
		super();
		sc = new Scanner(System.in);
	}

	public void primaryStream() {
		// 1. 스트림생성 -> 2. 메소드를 통한 입력 or 출력 -> 3. 자원반환
		System.out.print("저장할 파일 이름 입력 : ");
		String filename = sc.nextLine();
		// 0. 자원반환할 객체를 미리 선언
		FileOutputStream fos = null;
		try {
			// 객체를 만들면 스트림이 만들어진다.
			// 같은 이름이 있다면 덮어쓴다, 같은 이름이 있어서 새로 만들어라는 개발해야함.
			// 이미지, 동영상 등을 넘기는거
			fos = new FileOutputStream(filename);// exception 강제로 해야함.
			System.out.println("[" + filename + "]에 파일에 저장할 내용을 입력하세요.");
			System.out.println("exit를 입력하면 종료됩니다.");
			while (true) {
				System.out.print("내용입력 : ");
			
				String str = sc.nextLine() + "\r\n";
				if (str.equals("exit\r\n")) {
					break;
				}
				
				// FileOutputStream은 Byte스트림으로 데이터를 내보낼 때 Byte 단위로 내보내야함.
				// 문자열을 바이트스크림으로 내보내기에는 너무 큰 -> byte 단위로 쪼갬
				byte[] arr = str.getBytes();
				fos.write(arr);// 스트림을 통해서 파일에 데이터 내보내기 -> 2. 메소드를 통한 출력
				// error 두번째꺼 하면 추가로 캐치가 붙는다.
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 자원반환 코드르 빼고 실행하는데는 큰 문제가 없다. //스트림을 반환하지 않으면 인계치가 넘어가면 그때부터 안돌아간다.
				// 3. 자원반환
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
