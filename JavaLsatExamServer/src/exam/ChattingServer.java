package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChattingServer {

	public void chattingServer() {
		//포트 번호는 서버와 클라이언트와 같은 번호를 사용해야 연결이 된다. 
		int port = 8888;

		ServerSocket serverSocket = null;

		DataInputStream dis = null;

		DataOutputStream dos = null;

		try {

			serverSocket = new ServerSocket(port);

			Socket clientSocket = serverSocket.accept();
			//InputStream 은 소켓에서 가져와서 사용하기 때문에 생성자를 이용해서 객체를 만드는게 아니라, 소켓에서 get해야함. 
			InputStream in = clientSocket.getInputStream();
			//OutputStream은 소켓에서 가져와서 사용하기 때문에 생성자를 이용해서 객체를 만드는게 아니라, 소켓에서 get해야함. 
			OutputStream out = clientSocket.getOutputStream();

			dis = new DataInputStream(in);

			dos = new DataOutputStream(out);

			dos.writeUTF("[서버 연결 성공]");

			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

			String now = sdf.format(date);

			dos.writeUTF("[현재시간] : " + now);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				dis.close();

				dos.close();

				serverSocket.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}