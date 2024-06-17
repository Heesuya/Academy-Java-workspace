package kr.co.shop.vo;
//변수와 메소드가 똑같은 경우 >> PointMgr
//메소드를 꺼내쓸때 grade 에서 꺼내서 쓰면 되는데, 
//업캐스팅해서 쓰는것. 
//사용할때 업캐스팅 된 상태에서 부모꺼 사용. 
//자식이 가지고 있는 메소드는 다형성때문에 쓸수가 없음. 

public class Product {
	private String name;
	private int price;
	private int amount;
	private int type;		//상품의 종류를 구별할 변수(1 : 셔츠, 2 : 아우터, 3 : 팬츠)
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, int price, int amount, int type) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
