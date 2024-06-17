package kh.java.function;

import java.util.Scanner;

public class IfTest {
	
	//제어문 입력한 값이 어디서부터 ~ 어디까지 실행하게 하는것이다. 
	public void test1() {                       //scan 입력 => ctrl+space
		Scanner sc = new Scanner(System.in);    // 자동완성 shift+ctrl+O
		System.out.print("정수 10을 입력하세요 : ");
		int num = sc.nextInt();
		/*
		 if(논리형데이터){            //논리형 데이터 자리에 조건식이 들어간다. 
		 	논리형데이터가 true이면 실행될 코드(false이면 실행되지 않음)
		 }
		 */
		boolean result = (num == 10);  //비교하는 연산자. 
		if(result) {
			System.out.println("참 잘했어요!");  //조건이 성립해서 안쪽으로 들어가면 if문을 잊는게 코드치기 편하다. {} 안에 들어가는가, 안들어가는가. 
		}
		if(num == 10) {
			System.out.println("참 잘했어요@@");
		}
		System.out.println("끝!");
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 숫자 구별 프로그램 =====");
		System.out.print("임의의 정수를 입력 하세요 : ");
		int num = sc.nextInt();
		if(num > 0) {
			System.out.print("당신이 입력한 수는 "+num+"은(는) 양수입니다.");
		}		
		if(num == 0) {
			System.out.print("당신이 입력한 수는 "+num+"은(는) 0입니다.");
		}		
		if(num < 0) {
			System.out.print("당신이 입력한 수는 "+num+"은(는) 음수입니다.");
		}	
		//독립 시행 : 모든 if문을 검사(실행)해보고 끝나는것이다. 모든 실행문 끝까지 돌아간다. 
		//현재는 if문이 서로 아무런 영향을 주지 않음. 
		//if문의 순서는 무의미하다.   뒤쪽에 가면 순서의 의미가 있음. 배울 예정
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 두수 비교 프로그램 ======");
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
		if(num1 < num2) {
			System.out.println(num1+"<"+num2);
			System.out.println("두번째 수가 더 큽니다.");
		}
		if(num1 == num2) {   //  = : 대입 , == : 비교
			System.out.println(num1+"="+num2);
			System.out.println("두 수가 같습니다.");
		}
		if(num1 > num2) {
			System.out.println(num1+">"+num2);
			System.out.println("첫번째 수가 더 큽니다.");   
		}
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 계산기 프로그램 ======");
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");  //sum(+), sub(-), mul(*), div(/)
		char oper = sc.next().charAt(0);   //문자 타입
		/* 기본자료형 - 공간에 값을 직접 대입
		 * 참조자료형 - 주소값을 대입 
		 
		 * 문자열로 간다면  // 참조형 oper1(+) <=다르다=>oper2(2)
		 String oper = sc.next();   -> 비교는 "문자열"
		 if(oper.equals("+")) => 문자열1.equals("비교문자열") = ("비교문자열").equals(문자열1)
		 
		 *문자열은 같은지만 찾을수 있음. 비교 불가능.
		 */
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
	
		if(oper == '+') {  //  '문자'  "문자열"
			//int sum = num1 + num2;
			System.out.println(num1+"+"+num2+"="+(num1 + num2));
			System.out.printf("%d%c%d=%d",num1,oper,num2,num1+num2); //가능 예제
		}
		if(oper == '-') {
			//int sub = num1 - num2;  
			System.out.println(num1+"-"+num2+"="+(num1 - num2));
		}
		if(oper == '*') {
			System.out.println(num1+"*"+num2+"="+num1 * num2);
		}
		if(oper == '/') {
			double div = (double)num1/num2;   //필요한 순간에 연산해라. 컴퓨터에게 불필요한 계산x. //이 이유로 많이 씀 
			System.out.printf("%d+%d+=%.6f",num1,num2,div);
		}
		//삼항연산자 : 실행될 코드가 간단하게 1개를 택할때
		//if 조건문 : 실행될 코드가 여러개일 때 //처리할수 있는 범위가 더 크다. 
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		//입력받은 정수가 홀수인지/짝수인지 구분하는 프로그램 제작 
		//홀수/짝수 구분하는 기준 -> 입력받은 숫자를 2로 나눴을때 나머지가 0(짝수)인지 1(홀수)인지로 구분
		int data;
		if(num%2 == 0) {  
			data =0;
			System.out.println("짝수!");
		}
		else {
			data = 1;
			System.out.println("홀수!");
		}
		System.out.println(data);
		
		/*
		if(num%2 == 0) {  
			data = 0;    //0으로 리셋하는게 아니라 지운다. 애매한 수가 들어가잇다. 
			System.out.println("짝수!");
		}
		if(num%2 == 1) {
			data = 1;
			System.out.println("홀수!");
		}
		System.out.println(data); 
		//error //데이터에서는 쓰레기가 들어가 있는 상황이다. 그래서 에러가 뜬다.
		최종 data = > 둘다 안돌아가면 어쩔껀데
		*/    
		
		/*
		if(num%2 == 0) {  //실행후 true 이면 else까지 가지 않고 끝이 난다. //가장 유사한게 삼항연사자이다. 
			System.out.println("짝수!");
		}
		else {
			System.out.println("홀수!");
		}
		*/
		
		/*  위의 코드와 아래 코드 실행 방식은 다르다. 
		if(num%2 == 0) {  //앞의 결과가 true 이든 false 이든 두번 움직인다. 
			System.out.println("짝수");
		}
		if(num%2 == 1) {
			System.out.println("홀수");
		}
		*/
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		int adultPrice = 15000;
		int childPrice = 5000;
		System.out.println("=======놀이공원 프로그램=======");
		System.out.print("입장하실 총 인원은 몇명입니까? : ");
		int total  = sc.nextInt();
		System.out.print("어른은 몇명입니까?(1인당 adultPrice원) : ");
		int adult = sc.nextInt();
		System.out.print("아이는 몇명입니까?(1인당 childPrice원) : ");
		int child = sc.nextInt();
		
		//int sum = adult+child;
		if(adult + child == total) {  //if(adult + child == total)  //따로 변수 설정 안해도 된다. 
			int money = adult*adultPrice+child*childPrice;
			System.out.println("지불하실 총 금액은 "+(adult*adultPrice+child*childPrice)+"원 입니다.");
		}
		else {
			System.out.println("인원수가 맞지 않습니다.");
		}
	}
	//변수로 데이터를 처리해야하는 이유 : 변경이 될수 있는 값을 미리 만들어 둔다. 
	//값은 미리 변수를 위쪽에 만들어주면 좋다. // 변할수 있는 데이터를 수정하기 좋다. 
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		System.out.println("===== 퀴즈 프로그램 =====");
		System.out.println("첫번째 퀴즈");
		System.out.print("사과는 영어로 무엇일까요(1.apple,2.스티브 잡스)? : ");
		int apple = sc.nextInt();
		
		if (apple == 1) {
			count++;    //count = 1; 이 되면 if 문이 많아지면 쓰기가 어렵다. 
			System.out.println("정답!!");        
		}
		else {
			System.out.println("땡!!");    
			}
		
		System.out.println("두번째 퀴즈");
		System.out.print("바나나는 길어 길으면 기차 기차는 (1.비싸,2.빨라)");
		int banana = sc.nextInt();
		if (banana == 2) {
			count++;
			System.out.println("정답!!");        
		}
		else {
			System.out.println("땡!!");    
			} 
		
		System.out.println("총 "+count+"문제를 맞췄습니다.");
		//count 의 수를 바로 받아 출력하면 된다. 
		//계산하는 용도, 검증하는 용도 등등.. 변수는 무궁무진하게 사용이 된다. 
		if (count == 2) {
			System.out.println("총 2문제를 맞췄습니다. ");
		}
		if (count == 1) {
			System.out.println("총 1문제를 맞췄습니다. ");
		}
		else {
			System.out.println("총 0문제를 맞췄습니다. ");
		}
		/* if - else  경우의 수가 2개 이상밖에 없어서 가능. 
		 * 경우의 수가 많다면 아래와 같이 입력을 할수가 없다. 
		 if((apple == 1 && banana == 1) || (apple == 2 && banana == 2)) {
			System.out.println("총 1문제를 맞췄습니다. ");
			}
		 if(apple == 1 && banana == 2) {
		 	System.out.println("총 2문제를 맞췄습니다. ");
		 	}
		 if(apple == 2 && banana == 1) {
			System.out.println("총 0문제를 맞췄습니다. ");
		}
		
		 */
	}
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==========심리테스트==========");
		System.out.print("당신은 술을 좋아합니까 (1.yes, 2.no)? : ");
		int an1 = sc.nextInt();
		if(an1 == 1) {   //if 안에 if문이 몇백개 들어가도 상관없다. 
			System.out.print("당신는 담배를 피웁니까 (1.yes, 2.no)? : ");
			int an2 = sc.nextInt();	
			if(an2 == 1){
				System.out.println("담배는 건강에 좋지 않습니다.");
			}else {
				System.out.println("술은 간에 좋지 않습니다.");
			}  //중괄호가 닫히면 자동으로 메모리를 정리한다. 싹다 사라진다. 
		}else {
			System.out.print("당신은 이성친구가 있습니까 (1.yes. 2.no)? : ");
			int an3 = sc.nextInt();  //(범위사용)int an2  가능하다. 변수 기준 가까운 중괄호만 사용 가능하다.
			if(an3 == 1) {
				System.out.println("올..ㅋ");
			}
			else {
				System.out.println("힘내요 ㅠㅠ");
			}	
		}
		
		//System.out.println(an2);
		int num1 = 100;
		int num2 = 200;
		//int num1 = 300;   //자료형이 붙으면 이름이 겹쳐서 쓸수가 없다. 
		num1 = 300; //재사용하겠다 . 100 -> 300으로 바꾼다. 
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 1000) {
			System.out.println("1000 보다 큰 수 입니다.");
		}else if(num > 100) {
			System.out.println("100 보다 큰 수 입니다.");
		}else if(num > 10) {
			System.out.println("10 보다 큰 수 입니다.");
		}else {
		//위 else if 조건에 해당되는게 없으면 그 외 나머지   //위 상위가 false 일때만 검사한다. 
			System.out.println("10 이하의 수 입니다.");
		}
		//if문 독립적으로 쓰는게 아니라, 하나로 묶은것이다. //순서가 중요하다. 조건의 영역이 겹치면 범위가 작은것부터 적어야 함. 
		
		/*
		if(num > 1000) {
			System.out.println("1000 보다 큰 수 입니다.");
			}
		if(num > 100) {
			System.out.println("100 보다 큰 수 입니다.");
		}
		if(num > 10) {
			System.out.println("10 보다 큰 수 입니다.");
		}  //if문과 if-else if문 차이    //조건 검사를 각각 따로 하기에 두개가 나온다. 
		*/ 
	}
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 대/소문자 변환 프로그램 =====");
		System.out.print("문자입력 : ");
		char word = sc.next().charAt(0);
		//int chInt = (int)word;
		System.out.println("=====결과=====");  //중복될 필요 없음. 
		//if('a' <= word && ch <= 'z')    // 숫자로 굳이 변환하지 않아도 변환 가능하다. 
		if(97 <= word && word <= 122) {  
			//1)char changeCh = (char)(word-32);
			/*2)word += 32;   <= 복합대입연산자는 자동으로 자동형변환 진행된다. 위의 char타입 과 일치한다 자동 인식한다. 
			word = ch +32;  <= error  // int 에 들어갈지 char 에 들어갈지 인식못한다. */
			//3) ch ^= 32; X OR 연산자 손쉽게 연산이 가능하다. 자동으로 대소문자 연산이 가능. 
			System.out.println("소문자로 입력 하였습니다.");
			System.out.print("대문자로 변환 : "+(char)(word-32));
		}
		//else if('A' <= word && word <== 'Z')
		else if(65 <= word && word <= 90) {
			//char changeCh = (char)(word+32);
			System.out.println("대문자를 입력 하였습니다.");
			System.out.println("소문자 변환 : "+(char)(word+32));
		}
		else {
			System.out.println("잘못입력하셨습니다. 영문자를 입력해주세요.");
		}
		//if(65 <= chInt M=122) 로 하게 되면 연산이 앞에서부터 일어나기 때문에 자바에서는 읽지 못한다.
		//내가 입력한 코드는 재사용하는 코드.
	}		
	public void exam8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		
		if(num == 0) {   //(num == || num%3 != 0 && num%4 != 0)    //코드 줄이기 가능하다. 
			//범위가 겹치면 코드를 줄이는게 좋다. 
			System.out.println("===== 결과 =====");
			System.out.println("["+num+"]은(는) 3의 배수도 4의 배수도 아닙니다.");
		}else if(num%12 == 0) {
			System.out.println("===== 결과 =====");
			System.out.println("["+num+"]은(는) 3의 배수면서 4의 배수입니다.");
		}else if(num%3 == 0) {
			System.out.println("===== 결과 =====");
			System.out.println("["+num+"]은(는) 3의 배수입니다.");		
		}else if(num%4 == 0) {
			System.out.println("===== 결과 =====");
			System.out.println("["+num+"]은(는) 4의 배수입니다.");	
		}else {   //(num%3 != 0 && num%4 != 0)  <도 가능
			System.out.println("===== 결과 =====");
			System.out.println("["+num+"]은(는) 3의 배수도 4의 배수도 아닙니다.");			
		}
	}
}


