package kr.co.iei.point.run;

import kr.co.iei.point.controller.PointMgr;
import kr.co.iei.point.controller.PointMgrInterface;

public class Start {

	public static void main(String[] args) {
		PointMgrInterface pm = new PointMgr();
		pm.main();
		
	}

}
