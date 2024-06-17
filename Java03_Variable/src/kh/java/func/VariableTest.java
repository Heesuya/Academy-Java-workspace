package kh.java.func;

public class VariableTest {
	
	public void test1() {
		//변수를 선언하는 방법 : 자료형 변수이름;
		//1. 논리형(boolean) 변수 선언        
		boolean bool;
		
		//2. 문자형(char) 변수 선언 
		char ch;   
		//bool이라는 변수는 선언되었지만 값을 대입한적없음->초기화 안됨
		//-> 초기화가 되지 않는 변수는 사용할 수 없음
		bool = true; //논리형은 true/false 두가지 값만 저장할 수 있음
		System.out.println(bool); 
		ch ='a';
		System.out.println(ch);
		//문자형 변수 testCh를 생성하고 'K'를 대입하고 출력
		char testCh = 'K';
		System.out.println(testCh);
		
		//3. 정수형(int) 변수 선언
		int iNum;
		iNum = 100;
		System.out.println(iNum);
		
		//4. 정수형(long) 변수 선언
		//int로 표현할 수 없는 큰 수를 다룰때 사용
		//단, 값 대입할 때 숫자ㅣ -> ㅣ(L)을붙여서 long타입 정수입을 명시해야 함
		long num;
		num = 10000000000000l;   //0x13
		System.out.println(num);
		
		//5. 실수형(double) 변수 선언
		double dNum;
		dNum = 3.14;
		System.out.println(dNum);
		
		//6. 실수형(float) 변수 선언
		float fNum = 3.14f;
		System.out.println(fNum);
		
		//참조형 변수 선언
		//7. 문자열(String)변수 선언 
		String str = "안녕";
		System.out.println(str);
	}
	public void test2() {
		//정수형 변수 선언
		int num1 = 100;
		System.out.println("num1 : "+num1);
		
		//변수는 변경이 가능  //int num1 = 200; //error(재사용 가능하지만, 변수 한공간에 동시 선언x)
		num1 = 200;
		System.out.println("num1 : "+num1);
		
		//final 키워드를 붙이면 해당 변수는 상수형 변수
		//상수형 변수는 최초 선언시 값을 무조건 초기화 해야함
		//상수형 변수의 표기법은 변수명을 모두 대문자로 작성(구분을 위해서)
		final double PI = 3.14;  
		System.out.println("PI : "+PI);
		//PI = 3.15;  //상수형 변수는 한번 초기화 된 값을 변경할 수 없음
		//System.out.println("pi : "+pi);
		
		final int num2 = 100;
		
		//fianl int num3;
		//num3 = 300;
	}
	public void test3() {
		//형변환
		//1. 자동형변환(작은 자료형을 큰 자료형으로 변경할 때)
		byte num1 = 20;
		int num2 = num1;
		//2. 강제형변환(큰 자료형을 작은 자료형으로 변경할 때)
		byte num3 = (byte)num2;

		int num4 = 2147483647;
		//(long)2147483647 + (int)1 
		//(long)2147483647 + (long)1
		//(long)2147483648
		long num5 = (long)num4+1;
		System.out.println(num5); 
	}
	public void test4() {
		//출력하는 기능을 가진 함수
		//System.out.println() : 괄호 안의 내용을 출력하고 개행
		//System.out.print() : 괄호 안의 내용을 출력
		//System.out.printf() : 괄호 안의 내용을 출력하는데 포맷팅된 데이터 출력
		//안녕하세요 제 이름은 윤희수 입니다.
		System.out.println("안녕하세요 제 이름은 윤희수 입니다.");
		System.out.print("안녕하세요 제 이름은 윤희수 입니다.");
		System.out.println();//아무것도 출력하지 않고 개행 
		System.out.printf("안녕하세요 제 이름은 윤희수 입니다.");
		System.out.println();
		/*
		 자바 자료형
		 논리형(boolean), 문자(char), 정수(int, long), 실수(float,double)
		 문자열
		 */
		//변수를 3개 선언해서 값을 저장(이름(String)/나이(int)/주소(String))
		String name = "윤희수";
		int age = 30;
		String address = "인천";
		System.out.println("안녕하세요 제 이름은 "+name+"이고, 나이는 만 "+age+"살 사는곳은 "+address+"입니다.");
		//System.out.println(10+20+"hi"); 앞에서부터 순서대로 연산한다.
		System.out.printf("안녕하세요 제 이름은 %s이고, 나이는 만 %d살 사는곳은 %s입니다.", name, age, address);
	}
	public void test5() {
		//System.out.printf
		System.out.printf("메세지%d메세지",100);
		System.out.println();
		System.out.printf("제이름은 : %s","윤희수");
		System.out.println();
		System.out.printf("문자 : %c",'k');
		System.out.println();
		System.out.printf("%s%c%d%f", "aaa", 'b', 100, 3.14);
		System.out.println();
		System.out.printf("%.2f", 3.1456);
		System.out.println();
		System.out.printf("오늘 우리반 출석률을 100%%!!");
		System.out.println();
		System.out.println("만약에 쌍따옴표를 출력하고 싶으면 ? \" "); 
		System.out.println("\t안녕하세요\t 저는\n 윤희수 입니다.");
	}
	public void test6() {
		int iNum = 100;
		long lNum = 99990000000l;
		float fNum = 486.520f;
		double dNum = 5697.890123;
		char ch = 'A';
		String hi = "Hello JAVA";		
		boolean bool = true;
		System.out.println("- 정수형 "+iNum+"\n- 정수형 "+lNum+"\n- 실수형 "+ fNum+"(faoat)"
							+"\n- 실수형 "+dNum+"\n- 문자 "+ch+"\n- 문자열 논리 "+hi+"\n- 논리 "+bool);
	}
	public void test7() {
		String studentName1 = "윤희수";
		String studentName2 = "이수빈";
		int age1 = 32;
		int age2 = 21;
		char g1 = '여';
		char g2 = '여';
		String address1 = "인천";
		String address2 = "서울";
		String phonNumber1 = "01035189433";
		String phonNumber2 = "01036218270";
		String mail1 = "goqkddnf@naver.com";
		String mail2 = "lsb98619@gmail.com";
		System.out.println();
		System.out.println("이름\t나이\t성별\t지역\t전화번호\t\t이메일");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(studentName1+"\t"+age1+"\t"+g1+"\t"+address1+"\t"+phonNumber1+"\t"+mail1);
		System.out.println("--------------------------------------------------------------------");
		System.out.println(studentName2+"\t"+age2+"\t"+g2+"\t"+address2+"\t"+phonNumber2+"\t"+mail2);
		//System.out.printf();  <사용가능
	}
}