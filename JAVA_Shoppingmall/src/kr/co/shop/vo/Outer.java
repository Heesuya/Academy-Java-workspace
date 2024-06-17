package kr.co.shop.vo;

public class Outer extends Product{
	private String size;

	public Outer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Outer(String name, int price, int amount, int type) {
		super(name, price, amount, type);
		// TODO Auto-generated constructor stub
	}

	public Outer(String name, int price, int amount, int type, String size) {
		super(name, price, amount, type);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
}
