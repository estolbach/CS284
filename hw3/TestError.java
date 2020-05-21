import org.junit.Test;
/**
 * This class tests the exceptions in IDLList
 * @author Esther Stolbach
 *
 */

public class TestError {

	@Test(expected=IndexOutOfBoundsException.class)
	/**
	 * tests when index is out of bounds
	 */
	public void test() {
		IDLList<String> l = new IDLList<>();
		l.add("coke");
		l.add("pizza");
		l.append("fries");
		l.add("sushi");
		l.add("snapple");
		l.get(2);
		l.remove("slurpee");
		l.remove(8);
		l.size();
	}
	
	/**
	 * tests when list is empty
	 */
	public void test2() {
		IDLList<String> l = new IDLList<>();
		l.getHead();
		l.getLast();
		l.remove();
		l.removeLast();
		l.remove();
		
		
	}

}
