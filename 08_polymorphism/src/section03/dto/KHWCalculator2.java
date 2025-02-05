package section03.dto;

/** Calculator 인터페이스 구현체
 * - 모든 인터페이스 구현체는 같은 형태를 띄고 있다
 */
public class KHWCalculator2 implements Calculator{

	@Override
	public int plus(int a, int b) {
		int result = checkNum(a+b);
		return result;
	 
	}

	@Override
	public int minus(int a, int b) {
		int result = checkNum(a-b);
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = checkNum(a * b);
		return result;
	}

	@Override
	public int div(int a, int b) {
		int result = checkNum(a/b);
		if(result > MAX_NUM) return MAX_NUM;
		if(result < MIN_NUM) return MIN_NUM;
		return result;

	}

	@Override
	public int mod(int a, int b) {
		int result = checkNum(a%b);
		return result;
	
	}

	@Override
	public int pow(int a, int x) {
		int result =1;
		for(int i=0; i<x; i++) {
			result *= a;
		}
		return checkNum(result);
	
	}

	@Override
	public double areaOfCircle(double r) {
		double result = r*r*PI;
		if(result > MAX_NUM) return MAX_NUM;
		if(result < MIN_NUM) return MIN_NUM;
		return result;
	
	}

}
