package kh.java.test3;
//b라는 녀석은 a의 멤버를 그대로 가지고 있다. 
public class Bclass extends Aclass {
	//상속을 해도 변수와 메소드가 필요하면 더 만들어서 사용하면 된다.
	private int data;

	public Bclass() {
		super();//내 부모클래스의 생성자이다. //aclass -> object
		this.data = data;
	}
	//변수
	//접근제어지시자 : 자기 클래스 안까지만
	//상속을 해도 a것만 만들것, 상속되어도 b는 접근을 못한다. 
	//퍼블릭으로 풀면 a꺼를 b에서도 쓸수 있다. 
	//B 안에 A객체를 포함시키는 개념.
//	public void test1() {
//		this.num = 100;
//	}

	public Bclass(int num, String str) {
		super(num, str);
		// TODO Auto-generated constructor stub
	}
	
	public Bclass(int data) {
		super();
		this.data = data;
	}
	
	public Bclass(int num, String str, int data) {
		super(num, str);//super 는 상단으로 나와야 한다. 
		this.data = data;
	}
	
	//메소드 
	//생성자는 다르다. 생성자는 상속이 안된다. 
	//b라는 애한테 a라는 생성자 만들어도 소용없다.
	//생성자는 따로 만들어야 한다. 
	
	//private로 되어있는건 접근이 불가능하다. 
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	//부모의 재산이 돈만 있는게 아니라 고장난 시계가 있음. 고장난 시계 고쳐쓴다. 
	//@ : annotation : 자바 컴파일러에게 알려주는 주석문
	//오버라이딩 조건 
	//1) 메소드의 이름이 동일해야 한다   // 이름이 다르면 메소드 추가
	//2) 매개변수의 개수와 타입이 동일해야 한다
	//3) 리턴 타입이 동일해야 한다.
	//4) private메소드의 오버라이딩이 불가능하다
	//5) 접근제어 지시자는 수정이 가능하지만 부모의 것보다 같거나 
	@Override  //생략해도 잘 되지만, 조건이 있다.
	public void test1() {//동적 바이딩
		System.out.println("난 Bclass의 test1메소드");
	}
	
}
