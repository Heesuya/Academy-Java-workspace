package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//tcp 아이피와 포트번호를 알아야 한다. 
public class TcpServer {
	public void tcpSever() {
		Scanner sc = new Scanner(System.in);
		//1. 서버에서 사용할 포트번호 지정   //얘가 몇번 포트로 시작하지? 프로그램을 구분하기 위한 포트번호
		//사용할 수 있는 포트번호 범위 : 0 ~ 65535 중 1개를 사용
		//0~1000 사이의 번호는 잘 알려진 포트로 일반적으로 사용하지 않음  //예약이 되어있다고 생각하면 된다. well knowing port
		int port = 7777;
		//반환 할 객체 미리 선언 
		//서버에서 포트를 열고 접속을 기다리는 객체 
		ServerSocket server = null;  //서버소켓 객체 
		//서버와 클라이언트 사이에 데이터를 주고받을 보조스트림
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			//2. 서버 소켓 객체 생성
			//생성자로 전달한 포트번호로 서비스를 운영할 객체가 생성 
			server = new ServerSocket(port);
			System.out.println("[서버 준비 완료]");
			System.out.println("클라이언트 접속 대기 중.....");
			//3. server.accept() : 클라이언트 접속을 기다리는 코드 
			//4. 클라이언트 접속 요청이 들어오면 수락해서 통신을 하기위한 소켓객체를 받음
			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");
			//5. 데이터를 주고받기위한 스트림을 추출(소켓안에 양방향 스트림이 이미 존재)
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			//6. 보조스트림으로 성능 개선
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			//데이터 송/수신 준비 끝 
			System.out.println("종료 시 : exit");
			while(true) {
				System.out.print("클라이언트로 보낼 메세지 입력  : ");
				String str = sc.nextLine();
				dos.writeUTF(str);//클라이언트쪽으로 데이터 전송
				if(str.equals("exit")) {
					break;
				}
				
				String clientMsg = dis.readUTF();
				if(clientMsg.equals("exit")) {
					break;
				}
				System.out.println("클라이언트 : "+clientMsg);
			}
			System.out.println("대화가 종료 되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//자원반환
			try {
				server.close();		
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}
