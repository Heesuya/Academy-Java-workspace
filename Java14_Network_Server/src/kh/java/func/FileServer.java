package kh.java.func;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//카카오톡는 다르다.카톡은 서버에 올리고 주는거 
public class FileServer {
	public void server1() {
		//1. 서버 포트 지정
		int serverPort = 5678;
		//반환할 객체 미리 선언
		ServerSocket server = null;
		//주고받을 데이터가 파일형태이므로 파일을 주고받기 좋은 보조스트림을 사용
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		//DataI/OputStream == 글자 형태 주고받을때 쓰는 보조스트림 
		try {
			server = new ServerSocket(serverPort);
			System.out.println("서버 준비 완료");
			System.out.println("클라이언트 요청 대기 중 .....");
			Socket socket = server.accept();
			System.out.println("클라이언트 접속!!");
			//크라이언트쪽으로 파일을 전송하기우한 스트림을 추출 
			OutputStream out = socket.getOutputStream();
			//파일을 읽어오기위한 input스트림 
			FileInputStream fis = new FileInputStream("quiz.gif");
			//보조스트림으로 성능 개선 
			bos = new BufferedOutputStream(out);
			bis = new BufferedInputStream(fis);
			while(true) {
				int data = bis.read();
				bos.write(data);
				if(data == -1) {
					break;
				}
			}
			System.out.println("파일 전송 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				server.close();
				bos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void server2() {
		int serverPort = 9876;
		ServerSocket server = null;
		
		BufferedInputStream bis = null;//클라이언트에게 파일을 전송할 보조스트림
		BufferedOutputStream bos = null;//파일을 읽어올 보조스트림
		DataInputStream dis = null;//클라이언트에게 메세지를 받을 보조스트림
		DataOutputStream dos = null;//클라이언트에게 메세지를 보낼 보조스트림
		try {
			server = new ServerSocket(serverPort);
			System.out.println("클라이언트 접속 대기 중....");
			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");
			
			OutputStream out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			InputStream in = socket.getInputStream();
			dis = new DataInputStream(in);
			
			File fileFolder = new File("files");
			File[] fileArr = fileFolder.listFiles();//폴더에 있는 모든 파일을 파일 배열형태로 리턴 
			//fileFolder.isDirectory() : 폴더면 true 아니면 false 
			//폴더는 압축해서 파일로 만들어서 보낸다. 
			
			//클라이언트 측에서 파일 갯수를 알아야 파일명 수신 반복횟수가 지정 가능하므로 파일갯수 먼저 전달
			int fileCount = fileArr.length;
			dos.writeInt(fileCount);
			/*
			String fileCountStr = String.valueOf(fileCount);
			dos.writeUTF(fileCountStr);
			*/
			
			for(int i = 0; i < fileArr.length; i ++) {
				File file = fileArr[i];
				String filename = file.getName();
				dos.writeUTF(filename);
			}
			
			String filename = dis.readUTF();
			File file = new File("files\\"+filename);//files파일과 찾는 파일 이름을 결합시킨다.
			if(file.exists()) {
				dos.writeInt(1);
				//FileInputStream fis = new FileInputStream("files/"+filename);
				FileInputStream fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				bos = new BufferedOutputStream(out);
				//bos = new BufferedOutputStream(bos); 가능
				while(true) {
					int data = bis.read();
					bos.write(data);
					if(data == -1) {
						break;
					}
				}
				System.out.println("파일 전송 완료");
			}else {
				dos.writeInt(0);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				server.close();
				if(bis != null) {
					bis.close();
				}else {
					dis.close();
				}
				if(bos != null ) {
					bos.close();
				}else {
					dos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
