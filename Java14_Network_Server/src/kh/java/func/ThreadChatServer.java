package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadChatServer extends Thread{	
	private DataInputStream dis = null;
	
	@Override
	public void run() {
		//클라이언트가 보낸 값을 받아서 출력
		try {
			while(true) {
				String receiveMsg = dis.readUTF();
				System.out.println("[client] : "+receiveMsg);				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		int serverPort = 4567;
		
		ServerSocket server = null;

		DataOutputStream dos = null;
		
		try {
			server = new ServerSocket(serverPort);
			System.out.println("클라이언트 접속 대기중.....");
			Socket socket = server.accept();
			
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			//연결이 되고나서 진행 
			this.start();  //기호로 하지 않고 헷갈리지 않게 this.start(); 로 적는다. 
			System.out.println("채팅이 시작되었습니다.");
			//키보드값을 입력받아서 클라이언트에게 전송 
			while(true) {
				String sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
