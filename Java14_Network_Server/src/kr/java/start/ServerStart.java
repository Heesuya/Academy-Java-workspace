package kr.java.start;

import kh.java.func.BaseballServer;
import kh.java.func.DNSServer;
import kh.java.func.FileServer;
import kh.java.func.TcpServer;
import kh.java.func.ThreadChatServer;
import kh.java.func.UdpServer;

public class ServerStart {

	public static void main(String[] args) {
		TcpServer tcpServer = new TcpServer();
		//server.tcpSever();
		UdpServer us = new UdpServer();
		//us.udpServerTest(); 
		DNSServer ds = new DNSServer();
		//ds.dnsServer();
		FileServer fs = new FileServer();
		//fs.server1();
		//fs.server2();
		BaseballServer bs = new BaseballServer();
		//bs.baseballSever();
		ThreadChatServer server = new ThreadChatServer();
		//server.start();//dis 는 현재 null이다. 
		server.main();
	}
}
