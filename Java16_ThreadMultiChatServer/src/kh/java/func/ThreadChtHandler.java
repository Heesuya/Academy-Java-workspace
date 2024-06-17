package kh.java.func;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

//접속을 받아서 thread를 열어주는 역할만 한다
//오고가는 데이터 핸들러에서 소통한다.
public class ThreadChtHandler {
	//전체 채팅방에 입장한 회원정보(key:닉네임 / value:메세지를 전송한 OutputStream)
	private HashMap<String, DataOutputStream> members;

	public ThreadChtHandler() {
		super();
		members = new HashMap<String, DataOutputStream>();
	}
	
	public void main() {
		int serverPort = 12345;
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(serverPort);
			while(true) {
				Socket socket = server.accept();
				//클라이언트 요청이 들어오면 실제 채팅을 전달할 객체를 멀티쓰레드로 실행
				ThreadMultiChat chat = new ThreadMultiChat(socket, members);
				chat.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
