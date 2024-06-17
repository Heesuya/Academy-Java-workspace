package kh.java.func;

//1. Thread클래스 상속 
public class ThreadTest extends Thread {
	private int num;

	public ThreadTest() {
		super();
		num = 30;
	}
	//2. run() 메소드 오버라이딩
	@Override
	public void run() {
		//다른 쓰레드로 실행할 소스코드 작성
		test1();
	}
	
	public void test1() {
		while(true) {
			System.out.println("num : "+num);
			num--;
			sleep(1000);  //1000 = 1초 , 100 = 0.1초
			if(num == 0) {
				return;
			}
		}
	}
	
	public void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
