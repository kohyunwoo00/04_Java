package section04.exception;

/* [사용자 정의 예외를 만드는 방법]
 * - 아무 Exception 관련 클래스를 상속 받기
 * 
 * [사용자 정의 Checked/unchecked Exception 만들기]
 * 
 * Checked : Checked Exception 클래스 상속 받기
 * 
 * unchecked Exception : Unchecked Exception 클래스 상속 받기
 */
public class MyTestException 
 // extends Exception{ // CheckedException으로 만들겠다
 extends RuntimeException{ //UncheckedException으로 만들겠다

}
