package run;

import service.ArrayService1;
import service.ArrayService2;

public class ArrayRun {
	public static void main(String[] args) {
		
		// ArrayService 객체 생성
		ArrayService1 service1 = new ArrayService1();
		//service1.method5();
		
		// ArrayService2 객체 생성
		ArrayService2 service2 = new ArrayService2();
		service2.method3();
	}
}
