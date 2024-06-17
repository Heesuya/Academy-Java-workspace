package kr.co.iei.point.controller;


public interface PointMgrInterface {
	public void main();
	public void insertMember();
	public void printAllMember();
	public void printOneMember();
	public void updateMember();
	public void deletMember();
	public int searchMember(String name);
}
