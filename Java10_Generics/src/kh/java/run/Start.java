package kh.java.run;

import kh.java.func.AmimalMgr3;
import kh.java.func.Animal;
import kh.java.func.AnimalMgr1;
import kh.java.func.AnimalMgr2;
import kh.java.func.GenericEx1;
import kh.java.func.GenericEx3;
import kh.java.func.GenericEx4;
import kh.java.func.Rabbit;
import kh.java.func.Tiger;

public class Start {

	public static void main(String[] args) {
		//모든상황에서 generic 이 편한건 아니지만, 특정한 상황에서 효과적일수도 있다. 
		//silver, gold, vip 같은 경우 grade 타입을 만들어서 쓰는게 편하다. 
		Tiger t1 = new Tiger(200);
		Rabbit r1 = new Rabbit(100);
		
		AmimalMgr3<Tiger> am1 = new AmimalMgr3<Tiger>(t1);
		AmimalMgr3<Rabbit> am2 = new AmimalMgr3<Rabbit>(r1);
		
		Tiger t2 = am1.getData();
		t2.getHp();
		t2.tigerFunction();
		
		Rabbit r2 = am2.getData();
		r2.getHp();
		r2.rabbitRunction();
		
		/*
		//상속으로 할 경우 
		Tiger t1 = new Tiger(200);
		Rabbit r1 = new Rabbit(100);
		
		AnimalMgr2 am1 = new AnimalMgr2(t1);//Animal 타입으로 업캐스팅
		AnimalMgr2 am2 = new AnimalMgr2(r1);
		
		//.....
		
		Animal a1 = am1.getData();
		a1.getHp();
		Tiger t2 = (Tiger)a1;
		t2.tigerFunction();
		
		Animal a2 = am2.getData();
		a2.getHp();
		Rabbit r2 = (Rabbit)a2;
		r2.rabbitRunction();
		*/
		
		/*
		//Object 로 할 경우 
		Tiger t1 = new Tiger(200);
		Rabbit r1 = new Rabbit(100);
		
		AnimalMgr1 am1 = new AnimalMgr1(t1);//Object 업캐스팅 
		AnimalMgr1 am2 = new AnimalMgr1(r1);
		
		//.......
		
		Object o1 = am1.getData();
		Tiger t2 = (Tiger)o1;
		int hp1 = t2.getHp();
		t2.tigerFunction();
		
		Object o2 = am2.getData();
		Rabbit r2 = (Rabbit)o2;
		r2.getHp();
		r2.rabbitRunction();
		*/
		
		/*
		GenericEx1 ge1 = new GenericEx1();
		ge1.setData1(100);
		
		GenericEx3<String> ge3 = new GenericEx3<String>();
		ge3.setData1("data");
		//제네릭으로 지정되는 자료형은 반드시 참조형
		GenericEx3<Integer> ge4 = new GenericEx3<Integer>();
		ge4.setData1(100);
		
		GenericEx4<Double, String> ge5 = new GenericEx4<Double, String>();
		*/
	}

}
