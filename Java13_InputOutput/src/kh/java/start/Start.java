package kh.java.start;

import kh.java.func.ByteStreamTest;
import kh.java.func.CharStreamTest;
import kh.java.func.FileTest;
import kh.java.func.StreamTest;
import kh.java.func.UserMgr;
import kh.java.func.UserMgr2;

public class Start {

	public static void main(String[] args) {
		ByteStreamTest bst = new ByteStreamTest();
		//bst.primaryStream();
		CharStreamTest cst = new CharStreamTest();
		//cst.primaryStream();
		//cst.subStream();
		//cst.readerTest();
		StreamTest st = new StreamTest();
		//st.test1();
		//st.test2();
		FileTest ft = new FileTest();
		//ft.test();
		UserMgr um = new UserMgr();
		//um.main();
		UserMgr2 um2 = new UserMgr2();
		um2.main();
	}

}
