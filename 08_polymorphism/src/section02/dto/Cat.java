package section02.dto;

// 추상 클래스인 Animal 상속 받기
// -> 상속 받은 추상 메서드를 사용하고 싶으면 재정의(오버라이딩)하라고 강제됨
public class Cat extends Animal {

	// 필드
	private String fur; // 털
	
	public Cat() {
		super();
	}
	
	// 매개 변수
	public Cat(String type, String fur) {
		super();
		this.fur = fur;
	}
	
	public String getFur() {
		return fur;
	}

	public void setFur(String fur) {
		this.fur = fur;
	}

	@Override
	public String toString() {
		return super.toString() + "털색 : " + fur;
	}
	@Override
	public void move() {
		System.out.println("고양이 : 4족 보행, 사뿐 사뿐 움직임");
	}
	
	@Override
	public void sleep() {
		System.out.println("고양이 : 엎드려서 잠");
	}
	
	@Override
	public void eat() {
		System.out.println("고양이 : 깨작 깨작 먹음");
	}
	
	
	
}
