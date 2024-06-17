package kh.java.func;

public class AnimalMgr2 {
	private Animal data; //Tiger or Rabbit 을 저장 할 변수

	public AnimalMgr2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnimalMgr2(Animal data) {
		super();
		this.data = data;
	}

	public Animal getData() {
		return data;
	}

	public void setData(Animal data) {
		this.data = data;
	}
	
}
