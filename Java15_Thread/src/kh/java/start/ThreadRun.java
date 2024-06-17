package kh.java.start;

import kh.java.func.ThreadTest;

public class ThreadRun {

	public static void main(String[] args) {
		ThreadTest tt = new ThreadTest();
		//Thread를 상속한 클래스의 start()메소드를 실행하면
		//해당클래스의 run()메소드에 있는 코드를 새로운 쓰레드로 실행
		tt.start();//사람 한명더 뽑아서 런을 실행하게 하고 사람 한명은 시스아웃을 하러 간다. 
		//run만 쓰면 한명의 직원에게 런 메소드만 실행해. 다른일을 할수가 없다. 
		//tt.test1();//스레드라는 직원이 1명이다. 
		System.out.println("끝!");
	}

}
