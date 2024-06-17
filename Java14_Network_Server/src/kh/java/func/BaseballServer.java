package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BaseballServer {
	public void baseballSever() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int serverPort = 9880;

		ServerSocket server = null;

		DataOutputStream dos = null;
		DataInputStream dis = null;

		try {
			server = new ServerSocket(serverPort);
			System.out.println(" < < < < < BaseBall Game > > > > >");
			// while문 만들 자리
			while(true) {
				
				ArrayList<Integer> serverNum = new ArrayList<Integer>();
				serverNum.clear();
		
				System.out.println("클라이언트의 접속을 기다립니다.....");
				Socket socket = server.accept();//클라이언트의 socket 객체를 같이 공유
				System.out.println("클라이언트가 접속했습니다.");
				InputStream in = socket.getInputStream();
				dis = new DataInputStream(in);
				OutputStream out = socket.getOutputStream();
				dos = new DataOutputStream(out);
				System.out.println();
				System.out.println(" < < < < < Game Start > > > > >");
				
				// 서버 값도 배열로 받을지?
				while(serverNum.size() < 3) {
					int num = r.nextInt(10);
					//if(serverNum.indexOf(num) == -1) {//찾는 문자열이 없다면 -1 을 리턴한다, 배열만에 문자가 없다면 배열에 수를 넣자.
					if(!serverNum.contains(num)) {//이미 배열에 숫자가 있다. 중복되지 않을 경우에 배열에 수를 넣자.
						serverNum.add(num);
					}
				}
				
				/*
				굳이.. 배열로.. 리스트 이용해서 하면 더 간단하다. 
				for (int i = 0; i < 3; i++) {
					int randomNum = r.nextInt(10) + 1;
					serverNum.add(randomNum);
					for (int j = 0; j < i; j++) {
						if (serverNum.get(j) == randomNum) {
							serverNum.remove(i);
							--i;
							break;
						}
					}
				}
				*/
				
				//System.out.println("서버 숫자 : " + serverNum.get(0) + " " + serverNum.get(1) + " " + serverNum.get(2));
				System.out.print("서버 숫자 : ");
				for(Integer num : serverNum) {
					System.out.print(num + " ");
				}
				//서버의 게임준비가 끝 -> 게임시작 -> 클라이언트에게 게임시작을 알림 
				dos.writeInt(1);
				
				while (true) {
					int ball = 0;
					int strike = 0;
					int select = 0;
					int count = 0;
					ArrayList<Integer> clientNum = new ArrayList<Integer>();
					
					for(int i = 0; i < 3; i++) {
						clientNum.add(dis.readInt());
					}
					serverNum.add(100);
					// 넘을 받아서 실행 여부를 while 문을 빠지게 한다.
					System.out.print("클라이언트가 입력한 수 - > ");
					
					for(Integer num : clientNum) {
						System.out.print(num + " ");
					}
					System.out.println();
					
					/*
					for (int i = 0; i < 3; i++) {
						int num = clientNum.get(i);
						System.out.print(num + " ");
					}
					*/
					
					for(int i = 0; i < clientNum.size(); i++) {
						int num = clientNum.get(i);
						if(serverNum.contains(num)) {
							if(num == serverNum.get(i)) {
								strike++;
							}else {
								ball++;
							}
						}
					}
					String str = null;
					if(strike == 3) {
						str = "3스크라이크";
						System.out.println("3 스트라이크. 현재 클라이언트와 접속을 종료합니다.");
						dos.writeUTF(str);
						break;
					}else {
						str = strike+"스트라이크"+ball+"볼";
						if(count == 10) {
							str += "기회를 모두 사용하셨습니다. 정답은 ";
							for(Integer num : serverNum) {
								System.out.print(num + " ");
							}
							str += "입니다.";
							dos.writeUTF(str);
							System.out.println("시도 횟수 10회로 클라이언트 접속 종료합니다.");
							break;
						}
						dos.writeUTF(str);
					}
					
					/*
					Arraylist에 있는걸 사용하는게 편하다. 
					if (clientNum.get(0) == serverNum.get(0) && clientNum.get(1) == serverNum.get(1)
							&& clientNum.get(2) == serverNum.get(2)) {
						dos.writeInt(select+100);
						
						System.out.println("정답 현재 클라이언트와의 접속을 종료합니다.");
						break;
					}
					
					for (int i = 0; i < clientNum.size(); i++) {
						if (clientNum.get(i) == serverNum.get(i)) {
							strike++;
						}
						if (clientNum.get(i) == serverNum.get(i + 1)) {
							ball++;
						}
					}
					
					dos.writeInt(select);
					dos.writeInt(strike);
					dos.writeInt(ball);
					
					//String sendMsg = strike + "스트라이크" + ball + "볼";
					//System.out.println(sendMsg);
					//dos.writeUTF(sendMsg);
					 */
				}
			}

			// while 문 사용해서 반복문으로 만들고, 10회 가 되면 클라이언트 쪽에서 종료가 되고 종료가 되는걸 받아온다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				server.close();
				dos.close();
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
