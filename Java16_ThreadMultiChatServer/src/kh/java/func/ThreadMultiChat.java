package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

//다같은 해시맵을 모든 쓰레드가 공유를 하고 있다. 
public class ThreadMultiChat extends Thread {
	private Socket socket;
	private HashMap<String, DataOutputStream> members;

	public ThreadMultiChat(Socket socket, HashMap<String, DataOutputStream> members) {
		this.socket = socket;
		this.members = members;
	}

	@Override
	public void run() {
		main();
	}

	public void main() {
		// 여기가 서버구나
		DataInputStream dis = null;
		DataOutputStream dos = null;
		String nickname = null;

		InputStream in;
		try {
			in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			while (true) {
				nickname = dis.readUTF();
				if (members.containsKey(nickname)) {
					dos.writeInt(1);// 사용중이다.
				} else {
					members.put(nickname, dos);
					dos.writeInt(0);
					break;
				}
			}

			while (true) {
				String message = dis.readUTF();
				if (message.equals("exit")) {
					String sendMessge = "[" + nickname + "]님이 퇴장하셨습니다.";
					Set<String> keys = members.keySet();
					for (String key : keys) {
						DataOutputStream sendTarget = members.get(key);
						if(!sendTarget.equals(dos)) {
							sendTarget.writeUTF(sendMessge);							
						}
					}
					break;
				} else {
					String sendMessge = "[" + nickname + "] : " + message;
					Set<String> keys = members.keySet();
					for (String key : keys) {
						DataOutputStream sendTarget = members.get(key);
						sendTarget.writeUTF(sendMessge);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			members.remove(nickname);
			try {
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
