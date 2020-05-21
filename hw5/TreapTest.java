import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods in Treap
 * @author Esther Stolbach
 *
 */

public class TreapTest {

	@Test
	/**
	 * tests add method
	 */
	public void test() {
		Treap<Integer> testTree = new Treap<>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);

		assertEquals(false, testTree.add(2, 31));
		assertEquals(true, testTree.add(8, 15));
		assertEquals(false, testTree.add(4, 19));
		assertEquals(true, testTree.add(32, 35));
		assertEquals(true, testTree.add(12, 19));
		assertEquals(true, testTree.add(66, 11));
	}

	/**
	 * tests delete method
	 */
	public void test1() {
		Treap<Integer> testTree = new Treap<>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);

		assertEquals(true, testTree.delete(1));
		assertEquals(true, testTree.delete(2));
		assertEquals(true, testTree.delete(7));
		assertEquals(true, testTree.delete(4));
		assertEquals(false, testTree.delete(25));
		assertEquals(false, testTree.delete(55));

	}

	public void test2() {
		Treap<Character> testTree = new Treap<>();
		testTree.add('a', 19);
		testTree.add('b', 31);
		testTree.add('c', 70);
		testTree.add('d', 84);
		testTree.add('e', 12);
		testTree.add('f', 83);
		testTree.add('g', 26);

		assertEquals(false, testTree.add('b', 31));
		assertEquals(true, testTree.add('h', 15));
		assertEquals(false, testTree.add('a', 19));
		assertEquals(true, testTree.add('i', 35));
		assertEquals(true, testTree.add('j', 19));
		assertEquals(true, testTree.add('k', 11));

	}

	public void test3() {
		Treap<Character> testTree = new Treap<>();
		testTree.add('a', 19);
		testTree.add('b', 31);
		testTree.add('c', 70);
		testTree.add('d', 84);
		testTree.add('e', 12);
		testTree.add('f', 83);
		testTree.add('g', 26);
		
		assertEquals(true, testTree.delete('d'));
		assertEquals(true, testTree.delete('a'));
		assertEquals(true, testTree.delete('b'));
		assertEquals(true, testTree.delete('e'));
		assertEquals(false, testTree.delete('j'));
		assertEquals(false, testTree.delete('k'));
		
	}

}
