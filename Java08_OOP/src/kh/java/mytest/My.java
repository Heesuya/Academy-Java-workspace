package kh.java.mytest;

import java.util.Random;
import java.util.Scanner;

public class My {
	// 광산캐기
	// 메뉴 : 메인메뉴 , 광산메뉴, 상점메뉴
	// 속성(기능) : 체력(움직이면 체력이 떨어진다, 피로회복제를 먹으면 체력이 좋아진다) 곡갱이(광을 캐면 내구성이 떨어진다, 강화하면
	// 내구성이 올라간다)
	// 돈(체력과 곡갱이를 강화할수 있다) 광물(캘수 있다, 팔수 있다)

	boolean power;
	int pickaxe = 10;
	int hp = 10;
	int money = 10000;
	int stone ;
	int iron ;
	int diamond ;
	
	public void homeless() {
		if (stone == 0 && iron == 0 && diamond == 0) {
			System.out.println("광물을 캐서 오세영 ; 날먹 ㄴㄴ");
			return;
		}
	}

	public void moneyNow() {
		if(money > 0) {
			System.out.println("현재 소지금 : " + money);
		}else {
			System.out.println("돈이 없숨돠 ㅠㅠ 광물을 팔던지, 광을 캐던지 돈 벌어오세영");
		}
	}
	public void hpUp() {
		hp += 1;
		System.out.println("체력 +1 되었습니다. 현재 체력 : " + hp);
	}
	public void hpDown() {
		hp -= 1;
		System.out.println("체력 -1 되었습니다. 현재 체력 : " + hp);
	}
	public void pickaxeUp() {
		if (money >= 100) {
			money -= 100;
			pickaxe += 1;
			System.out.println("곡갱이가 내구성 +1 되었습니다. 현재 내구성 : " + pickaxe);

		} else {
			moneyNow();
		}
	}
	public void pickaxeDown() {
		pickaxe -= 1;
		System.out.println("곡갱이의 내구성이 -1이 되었습니다. 현재 내구성 : "+ pickaxe);
	}
	public void phHeal() {
		if (money >= 200) {
			money -= 200;
			hpUp();
			} else {
				moneyNow();
				}
	}
	public void mineralNow() {
		System.out.println("<< 주머니에 있는 광물 갯수 >>");
		System.out.println("돌 : "+stone+"개  철 : "+iron+"개  다이아 : "+diamond+"개");
	}
	public void getting() {
		System.out.println("광을 캐는중~~ ");
		sleep(1000);
		System.out.println("(・ิω・ิ )부자가 되고 말테야!");
		sleep(1000);
		System.out.println("( ・ิω・)ノิ");
		sleep(1000);
		System.out.println("(・ิω・ิ )어기엉차~");
		sleep(1000);
		hpDown();
		sleep(1000);
		System.out.println("( ・ิω・)ノิ");
		sleep(1000);
		System.out.println("(・ิω・ิ )에구 힘들어..");
		sleep(1000);
		pickaxeDown();
		sleep(1000);
		System.out.println("( ・ิω・)ノิ");
		sleep(1000);
		System.out.println("╰ิิ(・ω・)ノิิ 엇!! ");
		sleep(1000);
		}

	public void power() {
		power = !power;
		if (power) {
			System.out.println("===============광산캐기 시작==============");
		} else {
			System.out.println("다시 돌아오길 바래영.");
		}
	}

	public void start() {
		System.out.println("============== My mine =================");
		sleep(700);
		System.out.println("당신은 광산을 캐서 부자가 되고 싶은 가난한 모험가!");
		sleep(700);
		System.out.println("숨겨진 다이아몬드를 캐내서 부자 되시길 바랍니다.");
		sleep(700);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. 게임 on/off   2.광산 입장   3.상점  4.내상태  5.게임 버리기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			if(select >= 2 && select <= 3) {
				if(!power) {
					System.out.println("게임이 꺼져있습니다.");
					continue;
				}
			}
			switch (select) {
			case 1:
				power();
				break;
			case 2:
				mine();
				break;
			case 3:
				store();
				break;
			case 4: 
				System.out.println("체력 : "+hp);
				System.out.println("곡갱이 내구성 : pickaxe "+pickaxe);
				mineralNow();
				moneyNow() ;
				break;
			case 5:
				return;
			}
		}

	}

	public void mine() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("============== mine =================");
		sleep(700);
		System.out.println("광산에 입장을 했습니다.");
		sleep(700);
		while (true) {
			System.out.println("1.광산을 캐겠습니까?");
			System.out.println("2.메뉴로 돌아가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				if (hp > 0 && pickaxe > 0) {
					getting();
					int num = r.nextInt(3) + 1;
					if (num == 1) {
						pickaxeDown();
						System.out.println("돌을 캐냈습니다.");
						stone += 1;
					} else if (num == 2) {
						pickaxeDown();
						System.out.println("아이언을 캤습니다.");
						iron += 1;
					} else {
						pickaxeDown();
						System.out.println("다이아몬드를 캐냈습니다.");
						diamond += 1;
					}
				} else if (hp <= 0) {
					System.out.println("체력이 구립니다 ㅠ 회복하고 오세영");
					} else if (pickaxe <= 0) {
					System.out.println("곡갱이의 내구성이 구려서 광을 못캡니다 ㅠㅠ ");
				}
				break;
			case 2:
				return;
			}

		}

	}

	public void store() {
		System.out.println("============== Store ================");
		sleep(700);
		System.out.println("상점에 온걸 환영하네, ");
		sleep(700);
		System.out.println("없는게 없는 만물상이지");
		sleep(700);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.곡갱이 내구성 강화 --- 100원");
			System.out.println("2.피로회복제 구입 --- 200원");
			System.out.println("3.광물 판매");
			System.out.println("4.메뉴로 돌아가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			System.out.println("=====================================");
			switch (select) {
			case 1:
				pickaxeUp();
				break;
			case 2:
				phHeal();
				break;
			case 3:
				seller();
				break;
			case 4:
				return;
			}
		}
	}
	
	public void seller() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.돌 : 1원\n" + "2.아이언 : 100원\n" + "3.다이아몬드 : 1000원\n"+"4.상점메뉴로 돌아가기");
		System.out.print("어떤 광물을 판매하겠습니까? >> ");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			homeless();
			if (stone > 0) {	
				System.out.println("돌을 1원에 판매 했습니다.");
				stone -= 1;
				moneyNow();
				mineralNow();
			}else {
			
			}
			break;
		case 2:
			homeless();
			if (iron > 0) {
				iron -= 100;
				System.out.println("철을 100원에 판매 했습니다.");
				moneyNow();
				mineralNow();

			}else {
		
			}
			break;
		case 3:
			homeless();
			if (diamond > 0) {
				diamond -= 1;
				System.out.println("다이아를 1000원에 판매 했습니다.");
				moneyNow();
				mineralNow();
			
			}else {
			}
			break;
		case 4:
			return;
		}
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);//F2 버튼 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
