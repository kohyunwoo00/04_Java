package condition.run;

// 다른 패키지에 있는 클래스 가져오기
import condition.service.conditionService;

/**
 * 실행용 클래스
 */
public class ConditionRun {
	public static void main(String[] args) {
		// ConditionService 객체 생성
		conditionService service = new conditionService();
		
		// service.메서드명();
		//service.method1();
		//service.method2();
		//service.method3();
		//service.displaymenu();
		service.method4();
	}
}

