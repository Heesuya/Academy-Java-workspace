package kr.co.shop.vo;

public class Pants extends Product{
	private int size;

	public Pants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pants(String name, int price, int amount, int type) {
		super(name, price, amount, type);
		// TODO Auto-generated constructor stub
	}

	public Pants(String name, int price, int amount, int type, int size) {
		super(name, price, amount, type);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
