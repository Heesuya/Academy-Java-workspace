package kh.java.func;

import java.io.Serializable;
//직렬화를 하기 위해서 user 와 arraylist 둘다 직렬화 되어야 한다. 
public class User implements Serializable {
	private String id;
	// transient 가 붙은 변수는 직렬화, 역직렬화에서 제외
	private transient String pw; // transient 를 포함해서 정보를 내보내고 삭제하면 정보 불러오기에 오류가 생긴다.
	private String name;
	private int age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
