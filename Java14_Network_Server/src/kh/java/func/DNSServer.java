package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class DNSServer {
	public void dnsServer() {
		Scanner sc = new Scanner(System.in);
		int port = 8888;

		ServerSocket server = null;
		// 보조스트림 생성
		DataOutputStream dos = null;
		DataInputStream dis = null;

		HashMap<String, String> address = new HashMap<String, String>();
		address.put("www.naver.com", "125.209.222.142");
		address.put("www.google.com", "172.217.175.4");
		address.put("www.iei.or.kr", "99.83.248.72");
		try {
			server = new ServerSocket(port);
			System.out.println("DNS 서버 준비 완료");
			while (true) {
				System.out.println("클라이언트 요청 대기......");
				Socket socket = server.accept();
				// 스트림 추출
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();
				// 보조스트림 성능개선
				dos = new DataOutputStream(out);
				dis = new DataInputStream(in);

				String str = "알고 싶은 도메인 주소를 입력하세요 : ";
				dos.writeUTF(str);
				String clientMsg = dis.readUTF();
				if (address.get(clientMsg) == null) {
					dos.writeUTF("주소가 없습니다.");
				} else {
					String clientSendMsg = "[" + clientMsg + "]의 주소는 " + address.get(clientMsg) + "입니다.";
					dos.writeUTF(clientSendMsg);
				}

				System.out.print("시스템을 종료하시겠습니까[y/n]?");
				String sendMsg = sc.next();
				if (sendMsg.equals("y")) {
					break;
				} 

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	//선생님 풀이
	public void server() {
		Scanner sc = new Scanner(System.in);
		int port = 8888;

		ServerSocket server = null;
		// 보조스트림 생성
		DataOutputStream dos = null;
		DataInputStream dis = null;

		HashMap<String, String> dns = new HashMap<String, String>();
		dns.put("www.naver.com", "125.209.222.142");
		dns.put("www.google.com", "172.217.175.4");
		dns.put("www.iei.or.kr", "99.83.248.72");
		try {
			server = new ServerSocket(port);
			System.out.println("DNS 서버 준비 완료");
			while (true) {
				System.out.println("클라이언트 요청 대기......");
				Socket socket = server.accept();
				// 스트림 추출
				OutputStream out = socket.getOutputStream();
				dos = new DataOutputStream(out);
				InputStream in = socket.getInputStream();
				dis = new DataInputStream(in);
				// 보조스트림 성능개선

				String domain = dis.readUTF();
				System.out.println(domain);

				String ipAddress = dns.get(domain);
				
				if (ipAddress != null) {
					dos.writeUTF("[" + domain + "]의 주소는 " + ipAddress + "입니다.");
				} else {
					dos.writeUTF("주소가 없습니다.");
				}
				//클라이언트는 반복이 아니기때문에 스트림을 닫아줘야한다. 
				dis.close();
				dos.close();
				
				System.out.print("시스템을 종료하시겠습니까[y/n]?");
				String select = sc.next();
				if (select.equals("y")) {
					break;
				} 

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
