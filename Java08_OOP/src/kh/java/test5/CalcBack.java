package kh.java.test5;

public class CalcBack implements Calc{
	@Override
	public int sum(int[] arr) {
		int sum = 0;
		for(int i = 0; i <arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
