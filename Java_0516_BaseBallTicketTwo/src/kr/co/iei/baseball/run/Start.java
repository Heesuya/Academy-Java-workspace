package kr.co.iei.baseball.run;

import kr.co.iei.baseball.controller.BaseballMgr;
import kr.co.iei.baseball.controller.BaseballMgrInterface;

public class Start {

	public static void main(String[] args) {
		BaseballMgrInterface bm = new BaseballMgr();
		bm.main();
	}

}
