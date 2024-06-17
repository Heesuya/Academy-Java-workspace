package kh.java.func;

import java.io.File;
import java.util.Scanner;

public class FileTest {
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력 : ");
		String filename = sc.nextLine();
		//파일객체 생성
		File file = new File(filename);
		//exists() : 해당파일이 존재하면 true / 존재하지 않으면 false
		if(file.exists()) {
			System.out.println("파일이 이름 : "+file.getName());
			System.out.println("파일 상대경로 : "+file.getPath());
			System.out.println("파일 절대경로 : "+file.getAbsolutePath());
			System.out.println("파일 크기 : "+file.length()+"Byte");
			//    /1024 Kb  > 한번더 /1024 Mb
			System.out.print("해당 파일을 삭제하시겠습니까(1.yes)?");
			int num = sc.nextInt();
			if(num == 1) {
				//delete() : 파일을 삭제하고, 삭제 결과를 리턴(지웠으면 true / 못지웠으면 false)
				boolean bool = file.delete();
				System.out.println(bool);
			}
		}else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}
}
