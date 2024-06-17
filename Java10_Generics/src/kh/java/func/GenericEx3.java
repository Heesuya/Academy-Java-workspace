package kh.java.func;

public class GenericEx3<T> {
	private T data1;
	private String data2;
	public GenericEx3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenericEx3(T data1, String data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}
	public T getData1() {
		return data1;
	}
	public void setData1(T data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	@Override
	public String toString() {
		return "GenericEx3 [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
}
