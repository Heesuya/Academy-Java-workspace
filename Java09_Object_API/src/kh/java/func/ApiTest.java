package kh.java.func;

import java.awt.PrintGraphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.spi.CalendarNameProvider;

public class ApiTest {
	public void math() {
		// 다른 클래스에 작성된 메소드를 사용하려면?
		// 1. 객체생성
		// TestClass3 tc = new TestClass3();
		// 2. 생성된 객체를 이용해서 메소드 호출
		// tc.test1();

		// static 메소드를 쓰는법
		// 클래스이름.메소드명();
		// TestClass3.test1();//싱글톤이라는 용어를 쓴다. 프로그램이 돌아가는 동안 1번만 사용할것이다.
		// 따로 쓰지 말고 그냥 나를써~ 객체를 여러개 만들지 말고 한번만 사용할때 쓰는 static 정적이다.
		// TestClass2 tc = new TestClass2();
		// tc.test1();

		// Math 객체는 모든 메소드가 static 으로 만들어져 있음
		// -> 객체를 만들지않고 바로 사용

		// Math.abs(숫자) : 절대값 엡솔루트~~
		System.out.println(Math.abs(10));
		System.out.println(Math.abs(-10));

		// 올림,버림,반올림
		System.out.println(Math.ceil(10.1));// 소수 첫째자리에서 올림 //모든 수 올려버린다
		System.out.println(Math.floor(10.9));// 소수 첫째자리에서 버림 //모든 수 내려버린다
		System.out.println(Math.round(10.5));// 소수 첫째자리에서 반올림

		// 1.3456 -> 소수 2째자리까지 반올림해서 표현 <<개발자가 만들어서 사용해라.
		// 1.3456 -> 134.56 -> 135 -> 1.35
		System.out.println(Math.round(1.3456 * 100) / (double) 100);

		// max : 매개변수로 준 2개숫자 중 큰수를 리턴
		System.out.println(Math.max(100, 200));
		System.out.println(Math.max(200, 100));
		// min : 매개변수로 준 2개숫자 중 작은수를 리턴
		System.out.println(Math.min(200, 100));

		// random() : 0.0 ~ 1.0 사이의 임의의 실수 1개를 리턴
		System.out.println(Math.random());

		// java math 검색하면 static 으로 되어있어서 생성자를 안만들고 바로 사용할수 있다.
	}

	public void test1() {
		// 컴퓨터의 날짜 계산방법 -> 1970년 1월 1일 0시부터 몇 ms가 흘렀는지를 저장하고
		// 저장된 데이터를 환산해서 날짜로 표기 -> 저장된 데이터 타입이 long
		Date date1 = new Date();// 객체가 만들어지는 시점의 시스템의 시간
		System.out.println(date1);
		// Date객체 생성 시 생정자의 파라미터로 정수를 주면
		// 해당 정수시간만큼 흐른 날짜를 계산해서 Date객체 생성
		Date date2 = new Date(0); // 사선 deplicate : 예전에는 사용했는데 지금은 안써.
		System.out.println(date2);
		Date date3 = new Date(24 * 60 * 60 * 1000);
		System.out.println(date3);

		// SimpleDateFormat : date타입을 주면 원하는 형식의 문자열로 리턴해주는 객체
		// 객체 생성 시 생정자에 원하는 패턴을 문자열로 전달
		// y(Y) : 년도, M : 월, d(D) : 일, h(H) : 시간, m : 분, s(S) : 초
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = sdf1.format(date1);// 지정한 대로 스트링 타입으로 받아서 사용한다.
		System.out.println(str1);
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String str2 = sdf2.format(date1);
		System.out.println(str2);

		SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss EEE");
		String str3 = sdf3.format(date1);
		System.out.println(str3);
	}

	public void test2() {
		// 시간을 계산할때 사용하는 객체
		// Calendar
		// Calendar 객체 생성하는 방법
		// Calendar는 생성자의 접근제어지시자가 public이 아님
		// 대신 getInstance() 메소드를 public static으로 생성 -> getInstance로 객체를 생성
		Calendar today = Calendar.getInstance();// 객체가 생성되는 순간의 정보가 저장
		// Calendar 객체에서 정보를 가져오는 방법 today.get(알고싶은정보);
		System.out.println(today.get(Calendar.YEAR));// static으로 미리 변수를 만듬
		System.out.println(today.get(Calendar.MONTH) + 1);// 월(0~11로 제공) -> 보정작업 필요
		System.out.println(today.get(Calendar.DATE));// 일
		System.out.println(today.get(Calendar.AM_PM));// AM : 0 / PM : 1
		System.out.println(today.get(Calendar.HOUR));// 시간
		System.out.println(today.get(Calendar.MINUTE));// 분
		System.out.println(today.get(Calendar.SECOND));// 초
		System.out.println(today.get(Calendar.MILLISECOND));// 밀리초
		System.out.println(today.get(Calendar.DAY_OF_WEEK));// 요일(1: 일요일~ 7: 토요일)
		////////////////////////////////////////////////////////////////////////////
		System.out.println("---------------------------------------------------------");
		Calendar day1 = Calendar.getInstance();
		// 캘리더 객체 정보를 변경
		// 2024/10/11
		day1.set(Calendar.MONTH, 9);// 월을 10월로 변경(0~11 이므로 보정해서 적용)
		day1.set(Calendar.DATE, 11);

		day1.set(2014, 9, 11);// 년,월,일 정보를 넣으면 한번에 변환

		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH) + 1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));// 요일까지 잘 바뀐다.
		System.out.println("---------------------------------------------------------");

		Calendar day2 = Calendar.getInstance();
		// 1970년 1월 1일부터 day2의 시간까지 몇 ms가 흘렀는지를 long타입으로 리턴
		long time = day2.getTimeInMillis();
		System.out.println("time : " + time);
		long days = time / (1000 * 60 * 60 * 24);
		System.out.println(days / 365);

		Date date1 = new Date(time - 86400000);
		System.out.println(date1);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년MM월dd일 HH:mm:ss");
		String str = sdf.format(date1);
		System.out.println(str);
	}

	public void exam2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("========== D-DAY 계산기 ==========");
		System.out.print("D-DAY [년도] 입력 : ");
		int insertYear = sc.nextInt();
		System.out.print("D-DAY [월] 입력 : ");
		int insertMonth = sc.nextInt();
		System.out.print("D-DAY [일] 입력 : ");
		int insertDay = sc.nextInt();

		Calendar today = Calendar.getInstance();
		System.out.println("오늘 날짜 : " + today.get(Calendar.YEAR)+"년 "+(today.get(Calendar.MONTH)+1)+"월 "+ today.get(Calendar.DATE)+"일");

		Calendar insert = Calendar.getInstance();
		insert.set(insertYear, insertMonth-1, insertDay);
		System.out.println("dday 날짜 : " + insert.get(Calendar.YEAR) + "년 " + (insert.get(Calendar.MONTH) + 1) + "월 "
				+ insert.get(Calendar.DATE) + "일");
		long timeNow = today.getTimeInMillis();
		long dday = insert.getTimeInMillis();
		
		long sum = (timeNow+dday)/(24 * 60 * 60 * 1000);
		System.out.println(sum/365);
		if(sum < 0 ) {
			System.out.println(sum/365+"일 남았습니다.");
		}else if(sum > 0) {
			System.out.println(sum/365+"일 지났습니다");
		}
	}
	
	public void examsam2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("========== D-DAY 계산기 ==========");
		System.out.print("D-DAY [년도] 입력 : "); 
		int year = sc.nextInt();
		System.out.print("D-DAY [월] 입력 : ");
		int month = sc.nextInt();
		System.out.print("D-DAY [일] 입력 : ");
		int day = sc.nextInt();
		
		Calendar today = Calendar.getInstance();
		long todayMs = today.getTimeInMillis();
		today.set(year, month-1, day);
		//Calendar dday = Calendar.getInstance();//위 아래 시간이 흐른다. //잘못 맞으면 이 사이에 날짜가 바뀐다. 
		long ddayMs = today.getTimeInMillis();
		//System.out.println("today : "+todayMs);
		//System.out.println("dday : "+ddayMs);
		long time = ddayMs - todayMs;
		Date todayDate = new Date(todayMs);
		Date ddayDate = new Date(ddayMs);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String todayStr = sdf.format(todayDate);
		String ddayStr = sdf.format(ddayDate);
		System.out.println("오늘 날짜 : "+todayStr);
		System.out.println("dday 날짜 : "+ddayStr);
		long interDay = time/(60*60*24*1000);
		
		if(time > 0) {
			System.out.println(interDay+"일 남았습니다.");
		}else if(time < 0) {
			System.out.println(Math.abs(interDay)+"일 지났습니다.");
		}else {
			System.out.println("D-Day 입니다.");
		}
	}
	public void wrap() {
		//Wrapper클래스 : 기본자료형을 참조형으로 사용할 수 있도록 포장하는 클래스
		//정수형 변수 선언 후 10 대입
		int num1 = 10;
		System.out.println(num1);
		//Wrapper클래스를 사용(int -> Integer)
		Integer num2 = new Integer(10);//기본형을 참조형으로 포장 -> boxing 
		int num3 = num2.intValue();//wrapper로 감싸진 데이터를 다시 기본형으로 변환 -> unboxing
		System.out.println(num3);
		
		double d1 = 3.14;
		//Wrapper클래스 사용(double -> Double)
		Double d2 = new Double(3.14);
		double d3 = d2.doubleValue();
		
		//auto-boxing, auto-unboxing
		int num11 = 100;
		
		Integer num12 = 100;//auto-boxing
		int num13 = num12;//auto-unboxing
		
		double d11 = 3.14;
		
		Double d12 = 3.14;//auto-boxing
		double d13 = d12;//auto-unboxing
	}
	
	public void wrap2() {
		/*
		//이후 html java oracl error 발생 없애기 위해 문자열로 변환해서 보내준다.
		//int num = 65;
		//char ch = (char)num;
		//String str = (String)ch;//데이터 다루는 방법이 다르기 때문에 error 
		*/
		
		//wrapper 클래스 사용 예			기본형 <-> 문자열 데이터변환
		//1) 문자열 -> 기본자로형
		String str1 = "100";
		System.out.println(str1+1);
		//변경하고싶은 기본자료형의 wrapper클래스를 사용
		int num1 = Integer.parseInt(str1);
		System.out.println(num1);
		System.out.println(num1+1);

		
		String str2 = "3.14";
		double num2 = Double.parseDouble(str2);
		System.out.println(num2+1);
		
		/*
		정상적으로 변환이 불가능한 값은 반환하려고 할 때 에러가 발생 
		String str3 = "100a";   //정수로 바꿀수 있는 방법은 없다. 주의 
		int num3 = Integer.parseInt(str3);
		System.out.println(num3);
		*/
		
		//문자열 -> 문자
		String str4 = "ABDC";
		char ch = str4.charAt(0); //이미 제공하는게 있다. 
		//Character.parse 
	
		
		
		//2) 기본형 -> 문자열로 변환
		int num3 = 100;
		//2-1-1) Integer사용법
		String str5 = Integer.valueOf(num3).toString();
		System.out.println(str5+1);
		
		//2-1-2) String 클래스 사용법
		String str55 = String.valueOf(num3);
		System.out.println(str55+1);
		
		double num4 = 3.14;
		//2-2-1) Double 사용법 
		String str6 = Double.valueOf(num4).toString();
		System.out.println(str6+1);
		//2-2-2) String 클래스 사용법
		String str66 = String.valueOf(num4);//그냥 넣으면 바꿔주는 방법~ 이거 쓰자
		System.out.println(str66+1);
	}
}
