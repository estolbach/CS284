import static org.junit.Assert.*;

/**
 * This class tests the methods in IDLList
 * 
 * @author Esther Stolbach
 *
 */
public class Test {

	@org.junit.Test
	/**
	 * tests get methods
	 */
	public void test() {
		IDLList<String> l = new IDLList<>();
		l.add("coke");
		l.add("pizza");
		l.add("fries");
		l.add("sushi");
		l.add("snapple");
		l.add(3, "donut");

		assertEquals("snapple", l.getHead());
		assertEquals("snapple", l.get(0));
		assertEquals("fries", l.get(2));
		assertEquals("donut", l.get(3));
		assertEquals("coke", l.getLast());
		assertEquals(6, l.size());
	}

	/**
	 * tests the remove methods
	 */
	public void test2() {
		IDLList<String> l = new IDLList<>();
		l.add("coke");
		l.add("pizza");
		l.add("fries");
		l.add("sushi");
		l.add("snapple");
		assertEquals(5, l.size());
		assertEquals("coke", l.removeLast());
		assertEquals("snapple", l.remove());
		assertEquals(3, l.size());
		assertEquals("sushi", l.remove("sushi"));
		assertEquals(2, l.size());
	}

	/**
	 * tests append
	 */
	public void test3() {
		IDLList<String> l = new IDLList<>();
		l.add("coke");
		l.add("pizza");
		l.append("fries");
		l.add("sushi");
		l.add("snapple");
		assertEquals("fries", l.getLast());
		assertEquals("fries", l.getLast());
	}

	/**
	 * tests list with only one element
	 */
	public void test4() {
		IDLList<String> l = new IDLList<>();
		l.append("fries");
		assertEquals("fries", l.getLast());
		assertEquals("fries", l.getHead());
		assertEquals(1, l.size());
		assertEquals("fries", l.removeLast());
		assertEquals(0, l.size());
	}

	/**
	 * tests list using type Integer 
	 */
	public void test5() {
		IDLList<Integer> l = new IDLList<>();
		l.add(10);
		l.add(2);
		l.append(1);
		l.add(8);
		l.add(1, 3);
		assertEquals("8", l.getLast());
		assertEquals("10", l.getHead());
		assertEquals("3", l.get(1));
	}
}
