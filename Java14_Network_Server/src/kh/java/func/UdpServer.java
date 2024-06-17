package kh.java.func;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//동영상, 음악 등 데이터를 전송할때 
public class UdpServer {
	public void udpServerTest() {
		//1. 서버에서 사용할 포트번호 지정 
		//UDP 사용 가능 포트번호 : 0 ~ 65535   //DCP 65535와 UDP 65535 별개이다~
		int port = 8888;
		//자원반환할 객체 미리 선언
		DatagramSocket socket = null;
		
		try {
			//2. DatagramSocket 객체 생성(UDP 서시스 준비 완료)
			socket = new DatagramSocket(port);
			System.out.println("서버 소켓 생성 완료");
			byte[] inMsg = new byte[1024];//클라이언트에서 들어오는 메세지를 저장할 공강(여유있게 1025byte)
			DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length); //사용자가 이거줘 ~ 
			socket.receive(inPacket);//클라이언트의 메세지를 받기위해서 기다리는 코드
			//클라이언트가 메세지를 보내면 배열을 통해서 받음 
			//배열을 통해서 받은 메세지 중 사용하지 않는 부분을 잘라내고 문자열로 변환
			//String생성자에 byte을 배열을 넣으면 byte배열을 문자열 형태로 변환
			//trim() : 사용하지 않는 부분을 잘라내는 메소드 
			String clientMsg = new String(inMsg).trim();  // .trim 불필요한 부분 자르는 메소드 
			System.out.println(clientMsg);
			//UDP는 연결하고 통신하는 구조가 아님 
			//응답을 주기위해서는 클라이언트로부터 받은 패킷에서 클라이언트의 아이피/포트정보를 추출
			//클라이언트 아이피를 저장할 InetAddress 객체 생성
			InetAddress clientIp = inPacket.getAddress();
			int clientPort = inPacket.getPort();
			
			String msg = "난 UDP server다!";
			byte[] outMsg = msg.getBytes();
			
			DatagramPacket outPacket = new DatagramPacket(outMsg, outMsg.length, clientIp, clientPort);
			socket.send(outPacket);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			socket.close();
		}
	}
}
