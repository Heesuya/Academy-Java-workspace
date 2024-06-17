package kr.co.iei.baseball.controller;

public interface BaseballMgrInterface  {
	
	//------------------직원------------------------
	public void main();
	public void empMenu(); // 직원이 할일
	public void sellTicket();// 1.좌석구역설정
	public void showBooking();//2. 예약자 확인
	
	//----------------손님---------------------------------
	
	public void clientMenu();
	public void showSeat();//좌석확인
	public void insertTicket();///손님이 사는거
	public void deleteTicket();// 손님 티켓환불
	public void checkTicket();//손님 본인 예약 내역 확인

}
