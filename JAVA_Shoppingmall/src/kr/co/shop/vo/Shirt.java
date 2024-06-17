package kr.co.shop.vo;

public class Shirt extends Product{
	private String size;
	private String color;
	
	public Shirt() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Shirt(String name, int price, int amount, int type) {
		super(name, price, amount, type);
		// TODO Auto-generated constructor stub
	}

	public Shirt(String name, int price, int amount, int type, String size, String color) {
		super(name, price, amount, type);
		this.size = size;
		this.color = color;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
