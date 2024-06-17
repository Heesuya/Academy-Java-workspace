package kr.oc.shop.controller;

import java.util.Scanner;

import kr.co.shop.vo.Outer;
import kr.co.shop.vo.Pants;
import kr.co.shop.vo.Product;
import kr.co.shop.vo.Shirt;

public class ShoppingController {
	private Scanner sc;
	private Product[] productList;	//전체 판매 상품을 저장하는 배열
	private int productIndex;		//상품배열의 인덱스를 관리하는 변수
	private Product[] cart; 		//구매상품을 저장하는 배열
	private int cartIndex;			//구매상품배열의 인덱스를 관리하는 변수
	
	public ShoppingController() {
		super();
		sc = new Scanner(System.in);
		productList = new Product[30];
		productIndex = 0;
		cart = new Product[10];
		cartIndex = 0;
		
		//Shirt(String name, int price, int amount, int type, String size, String color) 
		Shirt s1 = new Shirt("셔츠", 10000, 10, 1, "L", "흰색");
		Product p1 = (Product)s1; //부모타입으로 형변환(업캐스팅)
		productList[productIndex] = p1;//업캐스팅된 객체를 상품배열에 저장
		productIndex++;//배열에 상품이 들어갔으므로 관리번호 1 증가
		
		Shirt s2 = new Shirt("티셔츠", 5000, 13, 1, "M", "검정");//셔츠객체 생성
		Product p2 = s2;//부모타입으로 형변환(업캐스팅) -> 업캐스팅은 자동형변환 가능 
		productList[productIndex] = p2;
		productIndex++;
		
		//아우터 객체 생성해서 자동으로 업캐스팅해서 Product타입으로 저장
		Product p3 = new Outer("구스다운", 100000, 5, 2, "XL");
		productList[productIndex] = p3;
		productIndex++;
		
		//아우터 객체 생성해서 자동으로 업캐스팅해서 상품배열에 저장
		productList[productIndex] = new Outer("덕다운", 90000, 4, 2, "L");
		productIndex++;
		
		//팬츠 객체 생성해서 자동으로 업캐스팅해서 상품배열에 저장하고 관리용 인덱스번호 증가
		productList[productIndex++] = new Pants("청바지", 60000, 20, 3, 28);
		productList[productIndex++] = new Pants("면바지", 50000, 12, 3, 30);
	}
	
	public void main() {
		while(true) {
			System.out.println("\n---------- 쇼핑몰 ----------\n");
			System.out.println("1. 직원");
			System.out.println("2. 손님");
			System.out.println("0. 종료");
			System.out.print("선택 >> ");
			int selcet = sc.nextInt();
			switch(selcet) {
			case 1:
				empMenu();
				break;
			case 2:
				clientMenu();
				break;
			case 0:
				return;				
			}//switch 종료
		}//while 종료
	}//main 종료
	///////////////////////////////////직원/////////////////////////////////
	public void empMenu() {
		while(true) {
			System.out.println("\n---------- 잠은 죽어서 자라 노예야 ----------\n");
			System.out.println("1. 신규 상품 등록");
			System.out.println("2. 재고 변경");
			System.out.println("3. 상품 삭제");
			System.out.println("4. 현재 상품 목록 조회");
			System.out.println("0. 이전 메뉴로");
			System.out.print("선택 >> ");
			int selcet = sc.nextInt();
			switch(selcet) {
			case 1:
				insertProduct();
				break;
			case 2:
				changeAmount();
				break;
			case 3:
				deleteProduct();
				break;
			case 4:
				showProduct();
				break;
			case 0:
				return;
			}//switch 종료
		}//while 종료
	}//empMenu();
	
	//현재 판매중인 상품 목록을 출력
	public void showProduct() {
		System.out.println("\n------------------ 상품 목록 ------------------\n");
		System.out.println("번호\t상품이름\t가격\t재고\t옵션");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < productIndex; i++) {
			Product p = productList[i]; 
			//배열에서 꺼낸 객체는 실제로는 (셔츠/아우터/팬츠) 객체지만 현재 업캐스팅을 통해서 Product 타입인 상태
			//Product타입으로 업캐스팅이 된 상태면 사용가능한 메소드는 Product클래스에 있는 메소드만 가능(name/price/amount/type)
			//그 외 size, coler 데이터를 사용하고 싶으면 다시 원본객체타입으로 다운캐스팅
			//다운캐스팅 시 주의할점은 부모/자식간의 업/다운캐스팅은 문제가 없지만, 형제관계끼리는 캐스팅이 불가능
			if(p.getType() == 1) {
				Shirt s = (Shirt)p;
				System.out.println((i+1)+"\t"+s.getName()+"\t"+s.getPrice()+"\t"+s.getAmount()
										+"\t"+s.getSize()+"/"+s.getColor());
			}else if(p.getType() == 2) {
				Outer o = (Outer)p;	
				System.out.println((i+1)+"\t"+o.getName()+"\t"+o.getPrice()+"\t"+o.getAmount()
										+"\t"+o.getSize());
			}else if(p.getType() == 3) {
				Pants pants = (Pants)p;
				System.out.println((i+1)+"\t"+pants.getName()+"\t"+pants.getPrice()
										+"\t"+pants.getAmount()+"\t"+pants.getSize());
			}
		}
	}//showProduct();
	
	//신규상품을 등록하는 메소드
	public void insertProduct() {
		System.out.println("\n--------------- 신규 상품 등록 ---------------\n");
		System.out.print("상품 종류를 입력하세요[1.셔츠 / 2.아우터 / 3. 팬츠] : ");
		int type = sc.nextInt();
		System.out.print("상품 이름 입력 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("상품 가격 입력 : ");
		int price = sc.nextInt();
		System.out.print("상품 수량 입력 : ");
		int amount = sc.nextInt();
		switch(type) {
		case 1:
			System.out.print("셔츠 사이즈를 입력하세요 : ");
			String shirtSize = sc.next();
			System.out.print("셔츠 색상을 입력하세요 : ");
			String shirtColo = sc.next();
			Shirt s = new Shirt(name, price, amount, type, shirtSize, shirtColo);
			productList[productIndex++] = s; 
			break;
		case 2:
			System.out.print("아우터 사이즈를 입력하세요 : ");
			String outerSize = sc.next();
			productList[productIndex++] = new Outer(name, price, amount, type, outerSize);
			break;
		case 3:			
			System.out.print("팬츠 사이즈를 입력하세요 : ");
		int pantsSize = sc.nextInt();
			productList[productIndex++] = new Pants(name, price, amount, type, amount);
			break;
		}//switch 종료
	}//insertProduct();
	
	//상품 재고를 변경하는 메소드
	public void changeAmount() {
		showProduct();
		System.out.print("재고를 수정할 상품의 번호를 입력하세요 : ");
		int productNo = sc.nextInt();
		System.out.print("수정할 재고 수량을 입력하세요 : ");
		int modifyAmount = sc.nextInt();
		Product product = productList[productNo-1];
		product.setAmount(modifyAmount);
		System.out.println("재고 변경 완료");
	}//changeAmount();
	
	
	//판매상품을 삭제하는 메소드
	public void deleteProduct() {
		showProduct();
		System.out.print("삭제 할 상품 번호를 입력하세요 : ");
		int productNo = sc.nextInt();
		for(int i = productNo-1; i <productIndex-1; i ++) {
			productList[i] = productList[i+1];
		}
		productList[--productIndex] = null;
		System.out.println("상품 삭제 완료");
	}//deleteProduct();
	
	/////////////////////////////손님기능///////////////////////////////
	public void clientMenu() {
		while(true) {
			System.out.println("\n---------- 어서오세요 ----------\n");
			System.out.println("1. 판매상품 보기");
			System.out.println("2. 상품 구매하기");
			System.out.println("3. 내 구매목록 보기");
			System.out.println("4. 상품 교환하기");
			System.out.println("5. 환불하기");
			System.out.println("0. 이전메뉴로");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				showProduct();
				break;
			case 2:
				buyProduct();
				break;
			case 3:
				showCart();
				break;
			case 4:
				updateCart();
				break;
			case 5:
				deleteCart();
				break;
			case 0:
				return;
			}//switch 종료
		}//while 종료
	}//cilentMenu();
	
	//상품을 구매하는 메소드 : 판매 상품 중 선택한 상품의 정보를 cart배열에 추가
	public void buyProduct() {
		System.out.println("\n---------- 상품 구매하기 ---------\n");
		showProduct();
		System.out.print("구매할 상품의 번호를 입력하세요 : ");
		int productNo = sc.nextInt();
		System.out.print("구매 수량을 입력 하세요 : ");
		int amount = sc.nextInt();
		//상품을 구매하면 구매 수량만큼 재고가 수정 
		
		
		
		//구매상품정보를 가져오기위해서 상품목록배열에서 해당 상품정보를 꺼내옴
		Product product = productList[productNo-1];
		
		int stock = product.getAmount() - amount;
		if(stock < 0 ) {
			System.out.println("상품 재고가 없습니다.");
			//재고가 없는경우 구매로직이 동작하지않고 메소드 종료
			return;
		}
		
		product.setAmount(stock);
		
		String name = product.getName();
		int price = product.getPrice();
		int type = product.getType();
		switch(type) {
		case 1:
			Shirt s1 = (Shirt)product;
			String size = s1.getSize();
			String color = s1.getColor();
			cart[cartIndex++] = new Shirt(name, price, amount, type, size, color);
			break;
		case 2:
			Outer o1 = (Outer)product;
			cart[cartIndex++] = new Outer(name, price, amount, type, o1.getSize());
			break;
		case 3:
			Pants p1 = (Pants)product;
			cart[cartIndex++] = new Pants(name, price, amount, type, p1.getSize());
			break;
		}
		System.out.println("구매완료!");
	}//buyProduct();
	
	//내 구매목록보기, cart에 있는 모든 상품정보를 출력 
	public void showCart() {
		int totalPrice = 0;
		System.out.println("\n---------- 내 구매 목록 ---------\n");
		System.out.println("번호\t상품이름\t가격\t수량\t옵션");
		System.out.println("-----------------------------------------");
		for(int i = 0; i < cartIndex; i++) {
			Product product = cart[i];
			totalPrice += product.getPrice() * product.getAmount();
			System.out.print("\n"+(i+1)+"\t"+product.getName()+"\t"+product.getPrice()+"\t"+product.getAmount());;
			switch(product.getType()) {
			case 1:
				Shirt s = (Shirt)product;
				System.out.println("\t"+s.getSize()+"/"+s.getColor());
				break;
			case 2:
				Outer o = (Outer)product;
				System.out.println("\t"+o.getSize());
				break;
			case 3:
				Pants p = (Pants)product;
				System.out.println("\t"+p.getSize());
				break;
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println("구매한 총 금액은 : "+totalPrice);
	}//showCart();
	
	//구매상품 삭제 -> 장바구니에서 제거
	public void deleteCart() {
		showCart();
		System.out.print("몇번 상품을 환불할까요?");
		int cartNo = sc.nextInt();
		//환불하려는 상품정보를 삭제 전에 복사해둠
		Product product = cart[cartNo-1];
		
		//환불을 한다는건 해당상품을 cart에서 지우고, 
		for(int i = cartNo-1; i < cartIndex-1; i ++) {
			cart[i] = cart[i+1];
		}
		cart[--cartIndex] = null;
		
		//해당상품의 재고를 다시 증가 -> 지워진상품이 productList의 몇번째에 있는지 조회
		String name = product.getName();
		int searchIndex = searchProduct(name);
		
		//현재 재고량에 환불하는 수량을 더해서 재고량을 수정
		int stock = productList[searchIndex].getAmount() + product.getAmount();
		productList[searchIndex].setAmount(stock);
		
		//환불상품이 productList의 몇번째에 있는지 조회
		System.out.println("환불 완료");
	}//deleteCart();
	
	//구매한상품을 다른상품으로 교환
	public void updateCart() {
		showCart();
		System.out.print("반품 할 상품 번호를 입력하세요 : ");
		int cartNo = sc.nextInt();
		showProduct();
		System.out.println("교환 할 상품 번호를 입력하세요 : ");
		int productNo = sc.nextInt();
		System.out.print("구매 수량을 입력하세요 : ");
		int amount = sc.nextInt();
		
		//반품할상품 재고처리
		Product product = cart[cartNo-1];
		String name = product.getName();
		int searchIndex = searchProduct(name);
		int stock = productList[searchIndex].getAmount() + product.getAmount();
		productList[searchIndex].setAmount(stock);
		//
		Product p = productList[productNo-1];
		int newStock = p.getAmount() - amount;
		p.setAmount(newStock);
		String modifyName = p.getName();
		int modifyPrice = p.getPrice();
		switch(p.getType()) {
		case 1:
			Shirt s = (Shirt)p;
			String modifySize = s.getSize();
			String modifyColor = s.getColor();
			cart[cartNo-1] = new Shirt(modifyName, modifyPrice, amount, p.getType(), modifySize, modifyColor);
			break;
		case 2:
			Outer o = (Outer)p;
			cart[cartNo-1] = new Outer(modifyName, modifyPrice, amount, p.getType(), o.getSize());
			break;
		case 3:
			Pants pants = (Pants)p;
			cart[cartNo-1] = new Pants(modifyName, modifyPrice, amount, p.getType(), pants.getSize());
			break;
		}
		System.out.println("교환완료");
	}//updateCart();
	
	
	//사용조건 -> 상품이름이 같은것은 없음
	public int searchProduct(String name) {
		for(int i = 0; i < productIndex; i++) {
			if(productList[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
