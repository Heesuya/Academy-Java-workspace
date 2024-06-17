package kh.java.func;

public class AnimalMgr1 {
	private Object data;//Tiger,Rabbit을 모두 저장하려면 두 클래스의 공통부모타입->Object

	public AnimalMgr1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnimalMgr1(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
