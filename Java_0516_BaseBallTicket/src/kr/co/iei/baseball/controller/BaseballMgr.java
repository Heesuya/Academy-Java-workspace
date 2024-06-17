package kr.co.iei.baseball.controller;

import java.util.Scanner;

import kr.co.iei.baseball.vo.General;
import kr.co.iei.baseball.vo.Grade;
import kr.co.iei.baseball.vo.Guest;
import kr.co.iei.baseball.vo.Seat;
import kr.co.iei.baseball.vo.Vip;

public class BaseballMgr implements BaseballMgrInterface {

	private Scanner sc;
	private Grade[] members;
	private Seat[] seats;
	private int memberIndex;
	private int seatIndex;
	private int total;

	public BaseballMgr() {
		super();
		sc = new Scanner(System.in);
		members = new Grade[30];
		seats = new Seat[30];
		memberIndex = 0;
		seatIndex = 0;
		total = 0;

		members[memberIndex++] = new General("회원1", "010-1234-5678", "general");
		members[memberIndex++] = new General("회원2", "010-1234-5679", "general");
		members[memberIndex++] = new Vip("회원3", "010-1235-5679", "vip");
		members[memberIndex++] = new Vip("회원4", "010-1235-5680", "vip");
	}

	@Override
	public void main() {
		while (true) {
			sc = new Scanner(System.in);
			System.out.println("1.직원용");
			System.out.println("2.손님용");
			System.out.println("0.종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				empMenu();
				break;
			case 2:
				clientMenu();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	@Override
	public void empMenu() {
		while (true) {
			sc = new Scanner(System.in);
			System.out.println("1.좌석구역판매량 설정");
			System.out.println("2.예약자 확인");
			System.out.println("3.남은좌석");
			System.out.println("0.종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				sellTicket();
				break;
			case 2:
				showBooking();
				break;
			case 3:
				showSeat();
				break;
			case 0:
				return;
			}
		}
	}

	@Override
	public void sellTicket() {
		System.out.println("\n----------- 좌석 설정 ------------\n");
		System.out.print("좌석명 입력 : ");
		String name = sc.next();
		System.out.print("좌석 가격 입력 : ");
		int price = sc.nextInt();
		System.out.print("좌석 수 입력 : ");
		int num = sc.nextInt();
		seats[seatIndex++] = new Seat(name, price, num);
	}

	@Override
	public void showBooking() {
		System.out.println("----------예약자 확인----------");
		if (total == 0) {
			System.out.println("예약 내역이 없습니다.");
		} else {
			System.out.println("이름\t전화번호\t등급\t인원수\t결제 금액");
			for (int i = 0; i < memberIndex; i++) {
				Grade grade = members[i];
				if(grade.getPrice() > 0) {
					System.out.println(grade.getName() + "\t" + grade.getPhoneNum() + "\t" + grade.getGrade() + "\t" + grade.getPrice());
				}
			}
		}
	}

	@Override
	public void clientMenu() {
		while (true) {
			sc = new Scanner(System.in);
			System.out.println("1.좌석확인");
			System.out.println("2.티켓예약");
			System.out.println("3.티켓환불");
			System.out.println("4.예매내역확인");
			System.out.println("0.종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				showSeat();
				break;
			case 2:
				insertTicket();
				break;
			case 3:
				deleteTicket();
				break;
			case 4:
				checkTicket();
				break;
			case 0:
				return;
			}
		}
	}

	@Override
	public void showSeat() {
		System.out.println("\n------- 전체 좌석 확인 -------\n");
		System.out.println("번호\t이름\t가격\t좌석개수");
		System.out.println("-------------------------------");

		for (int i = 0; i < seatIndex; i++) {
			Seat s = seats[i];
			System.out.println(i + 1 + "\t" + s.getName() + "\t" + s.getPrice() + "\t" + s.getNum());
		}
		System.out.println("-------------------------------");

	}

	@Override
	public void insertTicket() {
		System.out.println("\n-----------티켓 예약하기-----------\n");
		showSeat(); // 좌석 확인
		
		if(seats[0] == null) {
			System.out.println("아직 경기가 열리지 않았습니다.");
		}else{
			System.out.print("예약자의 이름을 입력하세요 : "); // 이름과 비교해서 등급을 불러올 예정
			String userName = sc.next();
			System.out.print("구매할 좌석명을 입력하세요 : ");
			String seatName = sc.next();
			System.out.print("예약할 인원수 입력 하세요 : ");
			int amount = sc.nextInt();
			
			if (searchSeat(seatName) == -1) {
				System.out.println("좌석명이 올바르지 않습니다.");
				return;
			}
			//예약하는 좌석과 배열에 있는 좌석 이름 비교 //해당되는 좌석명 찾기 
			Seat seat = seats[searchSeat(seatName)]; // 예약 좌석 불러오기
			
			// 좌석이 없으면 예약 불가. return
			int stock = seat.getNum() - amount;
			if (stock < 0) {
				System.out.println("남는 좌석이 없습니다.");
				return;
			}
			seat.setNum(stock); // 좌석이 남아있으면 좌석을 stock으로 저장
			
			// 내가 예약한 좌석명
			String mySeatName = seat.getName();
			// 내가 예약한 인원수
			
			if (searchMember(userName) == -1) {
				// searchMember가 -1일때, 즉 회원이 없을때 게스트 가입.
				System.out.println("회원이 아닙니다. 게스트로 예약을 진행합니다.");
				System.out.print("전화번호를 입력하세요(010-xxxx-xxxx) : ");
				String Gtel = sc.next();
				
				members[memberIndex++] = new Guest(userName, Gtel, "guest");
				Grade member = members[searchMember(userName)];
				
				member.setSeatName(mySeatName);
				member.setSeatNum(amount);
				
				// 총 드는 비용
				int myPrice = amount * seat.getPrice();
				member.setPrice(myPrice); // 비용을 member배열에 저장하기
				int userPrice = (int) member.getDiscount(); // 할인 포함 총 드는 비용
				member.setPrice(userPrice);
				
				// 예약 내역 출력
				System.out.println("예약자 성함 : "+member.getName());
				System.out.println("예약한 좌석명 : " + member.getSeatName());
				System.out.println("예약한 인원수 : " + member.getSeatNum());
				System.out.println("총 드는 비용 : " + member.getPrice());
				total += userPrice;
			} else {
				Grade member = members[searchMember(userName)]; // 유저 member불러오기
				
				member.setSeatName(mySeatName);
				member.setSeatNum(amount);
				
				// 총 드는 비용
				int myPrice = amount * seat.getPrice();
				member.setPrice(myPrice); // 비용을 member배열에 저장하기
				int userPrice = (int) member.getDiscount(); // 할인 포함 총 드는 비용
				member.setPrice(userPrice);
				
				// 예약 내역 출력
				System.out.println("예약자 성함 : "+member.getName());
				System.out.println("내가 예약한 좌석명 : " + member.getSeatName());
				System.out.println("내가 예약한 인원수 : " + member.getSeatNum());
				System.out.println("총 드는 비용 : " + member.getPrice());
				total += userPrice;
				System.out.println("-------------------------------");
			}
			System.out.println("구매 완료!");
		}
	}

	@Override
	public void deleteTicket() {
		System.out.println("-----티켓 환불-----");
		System.out.print("환불하실 고객님의 이름을 입력하세요. : ");
		String userName = sc.next();
		int searchIndex = searchMember(userName);
		if (searchIndex == -1) {
			System.out.println("예약 내역을 확인할 수 없습니다");
		} else { // member 배열에 있을 때만 환불 진행
			int price = members[searchIndex].getPrice();
			if (price == 0) {
				System.out.println("환불할 예매 내역이 없습니다.");

			} else {
				int num = members[searchIndex].getSeatNum();
				String seatName = members[searchIndex].getSeatName();
				String grade = members[searchIndex].getGrade();

				if (grade == "guest") {
					// System.out.println("작동테스트");
					// members 배열에서 삭제
					for (int i = searchIndex; i < memberIndex - 1; i++) {
						members[i] = members[i + 1];
					}
					members[--memberIndex] = null;
				} else {
					// 회원인 경우 member 배열에서 삭제하지 않고 값만 변경
					Grade gr = members[searchMember(userName)];
					gr.setPrice(0);
					gr.setSeatNum(0);
				}
				System.out.println(price + "원 환불 완료");
				for (int i = 0; i < seatIndex; i++) {
					Seat s = seats[i];
					if (s.getName().equals(seatName)) {
						seats[i].setNum(seats[i].getNum() + num); // 좌석 재고에 추가
						break;
					}
				}
			}
		}
	}

	@Override
	public void checkTicket() {
		System.out.println("----------예매 내역 확인----------");
		System.out.print("예약자 이름을 입력하세요 : ");
		String userName = sc.next();
		int searchIndex = searchMember(userName);
		int price = members[searchIndex].getPrice();
		if (searchIndex == -1 || price == 0) {
			System.out.println("예약 내역이 없습니다.");
		} else {
			System.out.println("이름\t전화번호\t\t인원수\t결제 금액");
			System.out.println(userName + "\t" + members[searchIndex].getPhoneNum() + "\t" + members[searchIndex].getSeatNum() + "\t" + members[searchIndex].getPrice());
		}
		System.out.println("-------------------------------");

	}

	// 멤버 인덱스 번호 불러오기
	public int searchMember(String name) {
		for (int i = 0; i < memberIndex; i++) {
			if (members[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	// 좌석 인덱스 번호 불러오기
	public int searchSeat(String name) {
		for (int i = 0; i < seatIndex; i++) {
			if (seats[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}