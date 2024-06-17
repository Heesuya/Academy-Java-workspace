package kh.java.run;


import kh.java.mytest.My;
import kh.java.test2.NewTV;
import kh.java.test2.TV;
import kh.java.test3.Aclass;
import kh.java.test3.Bclass;
import kh.java.test3.LgTV;
import kh.java.test3.Rabbit;
import kh.java.test3.SamsungTV;
import kh.java.test3.Tiger;
import kh.java.test4.TestClass1;
import kh.java.test4.TestClass2;
import kh.java.test5.CalcFront;
import kh.java.test5.TestInterface;
import kh.java.test5.TestInterfaceImpl;

public class Start {

	public static void main(String[] args) {
		
		//객체 5월 첫째주 
//		String str1 = "hi";
//		String str2 = "hi";
//		
//		str1 = "hello";
		
		//TV tv1 = new TV();//new 라는 연산자를 통해서 메모리를 만드는것 //stack 에 tv1이라는 참조형 변수(인스턴스)에 만들어짐, 주소를 따라가면 heap 에 
		//TV tv2 = new TV();//모양틀을 class 
		//My my = new My();
		//my.start();
		//mt.test12();//호출 ; 내가 부르는거다 
		
//	System.out.println(tv1.volume);
		//tv1의 주소를 따라가~ heap 에 가서 
		//변수인가 메소드(매개변수가 있어서 소괄호가 있다.)인가 
		//tv1.volumeUp();
//		System.out.println(tv1.volume);
		//이게 우리의 의도이다. 개발자의 의도. 꺼낼올수 있다면 집어넣을수도 있다. 
//		tv1.volume = -1; //직접적으로 값을 넣는건 private 로 막음
//		System.out.println(tv1.volume);
		//0~30 인데 원하는 데이터 관리가 힘들다. private 로 바꿔서 접근을 막을것이다. 
		
		//외부에서 메소드를 이용해서 전역변수의 데이터를 수정하기위한 메소드
		//inch  수정
		//외부에서 메소드를 이용해서 전역변수의 데이터를 수정하기위한 메소드

		//NewTV tv1 = new NewTV();
		//NewTV tv2 = new NewTV(100, false, 0, 0);
		//System.out.println(tv1.getInch());
	//	System.out.println(tv2.getInch());		
		
		/*
		//클래스이름() : 생성자 (객체를 만들어주는 친구이다)
		TV(=클래스) tv2 = new TV();  
		tv2.power();//메소드 = 이름(매개변수);
		System.out.println(tv2.power);//변수
		*/
  
		/*
		//상속  5.13
		Aclass aaa = new Aclass();
		Bclass bbb = new Bclass();
		System.out.println("a-num : "+aaa.getNum());
		aaa.setNum(100);
		System.out.println("a-num : "+aaa.getNum());
		
		System.out.println("b-num : "+bbb.getNum());
		bbb.setNum(100);
		System.out.println("b-num : "+bbb.getNum());
		System.out.println("b-str : "+bbb.getStr());
		bbb.setStr("안녕!");
		System.out.println("b-str : "+bbb.getStr());
		
		aaa.test1();//마우스 test1 + F3
		bbb.test1();
		
		
		Tiger t = new Tiger();
		Rabbit r = new Rabbit();
		t.talk();
		t.hunt();
		r.talk();
		r.jump();
		*/
		
		
		/*
		//5.14
		SamsungTV sTV = new SamsungTV();
		LgTV lTV = new LgTV();
		//다형성 -TV라는 것을 상속해서 만든것
		//부모타입NewTV 에 객체가 들어갈수 있는것이 다형성이다. 
		NewTV tv1 = new SamsungTV(); //삼성이 더 범위가 크다(func 을 더 포함) 다 포함하고 있기에 대체할수 있다.
		NewTV tv2 = new LgTV();
		NewTV tv3 = new NewTV();
	
		//자식타입 변수에 부모타입 객체를 저장하는것은 불가능
		//SamsungTV tv4 = new NewTV();  //error 삼성의 또다른 기능이 있기에 반대로는 안된다. 
		//형제관계에서도 다형성은 적용할 수 없음
		//SamsungTV tv5 = new LgTV(); //error 형제 관계도 메소드가 없어서 변환이 안된다. 
		sTV.getChannel();
		sTV.getvolume();
		sTV.samsungFunc();
		
		tv1.getChannel();
		tv1.getvolume();
		//다형성이 적용되면 부모타입에 존재하는 멤버들만 사용이 가능 
		//tv1.samsungFunc(); //error 쓸수 없다. 
		//tv3.lgFunc();
		
		//다형성이 적용된 상태에서 자식객체만 가지고 있는 고유기능을 사용하고 싶으면?
		//형변환
		SamsungTV tv5 = (SamsungTV)tv1;
		tv5.samsungFunc(); 
		LgTV tv6 = (LgTV)tv2;
		tv6.lgFunc();
		//tv1은 SamsungTV 객체를 NewTV타입으로 저장한 변수
		//원래는 SamsungTV 객체 -> NewTV인척하고있음
		//NewTV는 SamsungTV, LgTV 두가지 다 가능성이 있어서
		//LgTV는 변환했을때 에러는 없음 -> 실행하면 실제로는 SamsungTV는 서로 변환 불가능
		LgTV tv7 = (LgTV)tv1;
		tv7.lgFunc(); //코드상에 문제는 없어보이지만 실행하면 error
		
		//down casting 형변환 // 자료형을 마음대로 붙인다고 형변환이 되는건 아니다.
		//상속관계에서만 가능하다. 
		//Animal aaa = (LgTV)tv1;
		//상속과 다향성 활용의 여지가 많다. 
		 */
		
		/*
		//5.14 추상메소드
		//TestClass1 tc = new TestClass1();//추상클래스는 객체를 생성할 수 없음
		TestClass2 tc2 = new TestClass2();//추상클래스를 상속한 클래스는 완성된 클래스로 객체생성이 가능
		TestClass1 tc3 = new TestClass2();//추상클래스는 객체생성은 불가능하지만 부모타입 자료형으로는 사용이 가능
		tc3.testMethod2();//다운캐스팅을 안해도 되는 장점이 있다. 구연을 강제화한다. 
		*/
		
		//5.14 인터페이스
		TestInterfaceImpl ti1 = new TestInterfaceImpl();
		//TestInterface ti = new TestInterface(); //인터페이스는 객체를 생성할 수 없음
		TestInterface ti2 = new TestInterfaceImpl(); //인터페이스는 객체생성은 불가능하지만 부모타입 자료형으로는 사용 가능
		ti2.test1();
		ti2.test2();//똑같이 메소드는 가지고 있다. 
		//소통의 도구로도 사용
		
		CalcFront cf = new CalcFront();
		cf.view();
	}

}
