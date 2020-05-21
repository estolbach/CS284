/**
 * This class is to create methods with different time complexities
 * 
 * @author Esther Stolbach
 *
 */

public class Complexity {

	/**
	 * this method has a time complexity O(n^2)
	 * 
	 * @param n
	 */
	public void method1(int n) {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	/**
	 * this method has a time complexity O(n^3)
	 * 
	 * @param n
	 */
	public void method4(int n) {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.println("Operation " + counter);
					counter++;
				}
			}
		}
	}

	/**
	 * This method has a time complexity O(logn)
	 * 
	 * @param n
	 */
	public void method2(int n) {
		int counter = 0;
		for (int i = 1; i < n; i *= 2) {
			System.out.println("Operation " + counter);
			counter++;
		}
	}

	/**
	 * This method has a time complexity O(nlogn)
	 * 
	 * @param n
	 */
	public void method3(int n) {
		int counter = 0;
		for (int i = 1; i < n; i*=2) {
			for (int j = 0; j < n; j++) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	/**
	 * This method has a time complexity O(log(log(n)))
	 * 
	 * @param args
	 */
	public void method5(int n) {
		int counter = 0;
		for (int i = 1; i < n; i *= 2) {
			for (int j =1; j < n; j *=2) {
				System.out.println("Operation " + counter);
				counter++;
			}
		}
	}

	/**
	 * This method has a time complexity O(2^n)
	 * it uses the fibonacci numbers, which is most commonly known for recursion 
	 * 
	 * @param n
	 * @return
	 */
	
	public int method6(int n){

		if(n==1 || n==0){
			return n;
		}else{
			int x = method6(n-2);  
			int y = method6(n-1);
			System.out.println(x+y);
			return x+y;
		}
	}

	public static void main(String args[]) {
		Complexity o = new Complexity();
		o.method1(2);
		o.method4(2);
		o.method2(5);
		o.method3(5);
		o.method5(16);
		o.method6(5);
	}
}