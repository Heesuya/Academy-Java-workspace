package kh.java.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MapTest {
	public void test1() {
		//인덱스번호를 이용해서 순차적으로 문자열을 관리하는 ArrayList
		//정수로 문자열을 관리할게~
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("hi");
		list.add("bye");
		System.out.println(list);
		System.out.println(list.get(1));
		
		//리스트와 유사하게 번호를 통해서 문자열을 관리하는 HashMap
		//너가 관리할 키값 뭘로 할껀데~?   순번이 없고 내가 직접 지정하는거
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "hi");
		map.put(1, "hello");
		map.put(2, "hi");
		map.put(3, "bye");
		System.out.println(map);
		System.out.println(map.get(1));
	}
	
	public void test2() {
		//문자열을 통해서 문자열을 관리하는 맵
		HashMap<String, String> map = new HashMap<String, String>();
		
		//pup(key,value) : map에 데이터를 추가하는 메소드 
		map.put("one", "hi");
		map.put("two", "hello");
		map.put("three", "bye");
		System.out.println(map);
		
		
		//get(key) : map에서 매개변수로 받은 key에 해당하는 value를 리턴
		String data1 = map.get("three");  //데이터를 저장해서 꺼내기.
		System.out.println(data1);
		String data2 = map.get("one");
		System.out.println(data2);
		System.out.println(map.get("two"));  //바로 꺼내도 상관없다. 
		String data3 = map.get("four");//없는 key로 value를 요청하면 null 리턴
		//System.out.println(data3.toLowerCase());
		//null 값이여서 error  => if로 해결한다. 
		System.out.println(data3); 
		
		
		//put을 하는데 이미 사용중인 key인 경우는 나중에 들어가는 데이터로 덮어쓰기 -> 기존 데이터가 사라짐
		map.put("two", "byebye");
		System.out.println(map);
		System.out.println(map.get("two"));
		
		
		//containsKey(param) : 매개변수로 전달한 데이터를 키로 사용중이면 true / 사용중이지 않으면 false
		boolean bool1 = map.containsKey("one");
		boolean bool2 = map.containsKey("four");
		System.out.println("bool1 : "+bool1);
		System.out.println("bool2 : "+bool2);
		
		
		//containsValue(param) : 매개변수로 전달한 데이터가 value에 있으면 true / 없으면 false
		boolean bool3 = map.containsValue("bye");
		boolean bool4 = map.containsValue("byebye");
		System.out.println("bool3 : "+bool3);
		System.out.println("bool4 : "+bool4);
		
		
		//remove(key) : 키값에 해당하는 데이터를 삭제(key와 value 모두 삭제)
		map.remove("two");
		System.out.println(map);
		
		
		//map에 있는 데이터를 가져올때는 get을 사용하면 됨 
		//map에 있는 모든 데이터를 가져오려고 한다면? -> map이 가지고있는 모든 키값
		//keySet() : map에 있는 모든 key값을 Set(HashSet)형태로 반환 
		Set<String> keys = map.keySet();//부모는 interface 로 되어있어서 다형성으로 들어가있다. 
		for(String key : keys) {
			System.out.println(map.get(key));
		}
		
	}
}
