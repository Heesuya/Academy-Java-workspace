package kh.java.test3;

public class Tiger extends Animal {
	public void hunt() {
		System.out.println("사냥");
	}
	
	//동적바이딩이 순위가 더 높다.
	@Override
	public void talk() {
		System.out.println("어흥!");
	}
	
}


//공통적인 부분은 주고 따로 관리하는건 따로 한다. 