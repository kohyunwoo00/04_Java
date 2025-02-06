package list.run;

import list.service.ListService;

public class ListRun {
	public static void main(String[] args) {
		ListService service = new ListService();
		service.test3();
	}
	/* *** 불편하게 타입 검증, 다운 캐스팅을 하는 이유 ***
	 * - 여러 타입을 저장할 수 있다는 컬렉션의 특징이
	 * 	 오히려 독이됨
	 * -> 제네릭스를 이용해 타입을 제한
	 * -> 한 타입만 있을 테니까 검증, 다운캐스팅 X
	 */

}
