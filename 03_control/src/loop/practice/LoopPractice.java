package loop.practice;

import java.util.Scanner;

/**
 * 기능 제공용 크랠스
 */
public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	/**
	 * 사용자로부터한개의값을입력받아1부터그숫자까지의숫자들을모두출력하세요.
	 * 단, 입력한수는1보다크거나같아야합니다.
	 * 만일1 미만의숫자가입력됐다면“1 이상의숫자를입력해주세요“를출력하세요.
	 * [실행화면]
	 *  1이상의숫자를입력하세요: 4
	 *  1 2 3 4 
	 */
	public void practice1(){
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num >=1) {
			for(int i=1; i<=num; i++) {
				System.out.print(i + " ");
			}
			}else {
				System.out.print("1 이상의 숫자를 입력해주세요");
			}
	}
	/**
	 * 사용자로부터한개의값을입력받아1부터그숫자까지의모든숫자를거꾸로출력하세요.
	 * 단, 입력한수는1보다크거나같아야합니다
	 * [실행화면]
	 * 1이상의숫자를입력하세요: 4 
   * 4 3 2 1
	 */
	public void practice2(){
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num >=1) {
			for(int i=num; i>=1; i--) {
				System.out.print(i + " ");
			}
			}else {
				System.out.print("1 이상의 숫자를 입력해주세요");
			}
	}
/**
 * 1부터사용자에게입력받은수까지의정수들의합을for문을이용하여출력하세요
 * [실행화면]
 * 정수를하나입력하세요: 8
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
 */
	public void practice3(){
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
			System.out.print(i);
			if(i != num) {
				System.out.print(" + ");
			}
		}
		System.out.printf(" = %d", sum);
	}
	/**
	 * 사용자로부터두개의값을입력받아그사이의숫자를모두출력하세요.
	 * 만일1 미만의숫자가입력됐다면“1 이상의숫자를입력해주세요“를출력하세요.
	 */
	public void practice4(){
		System.out.print("첫 번째 숫자 :");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 :");
		int num2 = sc.nextInt();
		
			if(num1 <1 || num2 <1){
				System.out.print("1 이상의 숫자를 입력해주세요");		
			}else if(num1 >num2) {
				int temp = num1;
				num1 =num2;
				num2 =temp;
			}
				for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
	}
	/**
	 * 사용자로부터입력받은숫자의단을출력하세요.
	 * ex.
숫자: 4
 ===== 4단=====
 4 * 1 = 4
 4 * 2 = 8
 4 * 3 = 12
 4 * 4 = 16
 4 * 5 = 20
 4 * 6 = 24
 4 * 7 = 28
 4 * 8 = 32
 4 * 9 = 36
	 */
	 public void practice5(){
		 System.out.print("숫자 : ");
		 int dan = sc.nextInt();
		 System.out.println("==== " + dan +" 단====");
		 for(int i=1; i<=9; i++) {				 
			 System.out.printf("%2d * %2d = %d\n",dan, i, dan*i);			 
		 }		 
	 }
	/**
	 * 사용자로부터입력받은숫자의단부터9단까지출력하세요.
     단, 2~9를사이가아닌수를입력하면“2~9 사이숫자만입력해주세요”를출력하세요.
	 */
	 public void practice6(){
		 System.out.print("숫자 : ");
		 int dan = sc.nextInt();
		 for(int i=dan; i<=9; i++) {				
			 System.out.println("==== " + i +" 단====");
			 for(int j=1; j<=9; j++) {
					System.out.printf("%2d x %2d = %2d\n",i , j, i*j);
				}		 
		 }	
	 }
	 
	/**
	* 다음과같은실행예제를구현하세요.
	ex.
	정수입력: 4
	 *
	 **
	 ***
	 ****
	 */
	 public void practice7(){
		 System.out.print("정수 입력 :");
		 int num = sc.nextInt();
		 for(int row=1; row<=num; row++) {
				for(int col=1; col<=row; col++) {
					System.out.printf("*", row, col);
				}
				System.out.println(); // 줄 바꿈
			}		
	 }
	 /**
	  * 다음과같은실행예제를구현하세요.
 ex.
정수입력: 4
 ****
 ***
 **
 *
 */
	 public void practice8(){
		 System.out.print("정수 입력 :");
		 int num = sc.nextInt();
		 for(int row=num; row>=1; row--) {
				for(int col=row; col>=1; col--) {
					System.out.printf("*", row, col);
				}
				System.out.println(); // 줄 바꿈
			}		
	 }
	 /**
	  * ex.
		정수입력: 4
		   *
		  **
		 ***
		****
	  */
	 public void practice9(){
		 System.out.print("정수 입력 :");
		 int num = sc.nextInt();
		 for(int col =1; col<=num; col++) {
			 for(int i=num-col; i>0; i--) {
				 System.out.print(" ");
			 }
				for(int j=1; j<=col; j++) {
					System.out.print("*");
				}
				System.out.println();
		   }		 
	 }
	 /**
	 * ex.
	 정수입력: 3
	 *
	 **
	 ***
   **
   *
   */
	 public void practice10(){
		 System.out.print("정수 입력 :");
		 int num = sc.nextInt();
		 for(int row=1; row<=num; row++) {
			 for(int col=1; col<=row; col++) {
					System.out.printf("*", row, col);
				}
				System.out.println();
		 }
		 for(int row=num-1; row>=1; row--) {
				for(int col=row; col>=1; col--) {
					System.out.printf("*", row, col);
				}
				System.out.println(); // 줄 바꿈
			}				 
	 }
	 
	 /**
	  *  ex.
		정수입력: 4
		    *
		   ***
		  *****
		 *******
	  */
	 public void practice11(){
		 System.out.print("정수 입력 :");
		 int num = sc.nextInt();
		 
		 for(int col =1; col<=num; col++) { // 줄 출력
			 for(int i=0; i<num-col; i++) { // 공백 출력
				 System.out.print(" ");
			 }
				for(int j=1; j<=col*2-1; j++) { // 별 출력
					System.out.print("*");
				}
				System.out.println();
		   }		 
	 }
	 
	/**
	 * ex.
	정수입력: 5
	 *****
	 *   *
	 *   *
	 *   *
	 *****
	 */
	 public void practice12(){
		 System.out.print("정수 입력 :");
		 int num = sc.nextInt();
		 
		 for(int row =1; row<=num; row++) {
			 for(int col=1; col<=num; col++) {
			 	 if(row == 1 || row == num || col ==1 || col == num) {
					 System.out.print("*");
				 }else {
					 System.out.print(" ");
			 	 }
			 }
			 System.out.println();
		 }
	 }
	 
	 
	 
	 /**
	  * 2부터사용자가입력한수까지의소수를모두출력하고소수의개수를출력하세요.
		*	단, 입력한수가2보다작은경우“잘못입력하셨습니다.”를출력하세요.
		*	ex.
		*	숫자: 11
		*	2 3 5 7 11 
		*	2부터11까지소수의개수는5개입니다.
	  */	 
	 public void practice16(){
		 System.out.print("숫자 :");
		 int num = sc.nextInt();
		 int count =0; // 소수를 개수 세기 위한 변수
		 
		 // 2부터 입력 받은 수 까지 1개씩 접근하는 for문
		 for(int i=2; i<=num; i++) {
			 boolean flag = true;
			 // true인 경우  : 소수 0
			 // false인 경우 : 소수 x
			 
			 
			 // 1과 자기자신(num)을 뺀 정수를 한개씩 접근
			 for(int x=2; x<i; x++) {
				 if(i % x ==0) { // 1, 자기자신 빼고 나누어 떨어지는 수 존재
					 flag =false;
					 break;
				 }
			 }
			 if(flag) { // 소수라고 판별된 경우 수행
				 System.out.print(i + " ");
				 count++;
			 }
		 }
		 System.out.printf("\n2부터 %d까지 소수의 개수는 %d개입니다", num, count);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
