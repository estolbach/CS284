import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

	@Test
	public void test() {
		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 5, 2, 3 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		assertEquals("[ 2 3 5 ]", out);
	}
	
	@Test
	public void test1() {

		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 2, 3 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		assertEquals("[ 2 3 ]", out);
	}
	
	@Test
	public void test2() {

		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 3, 2 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		assertEquals("[ 2 3 ]", out);
	}
	
	@Test
	public void test3() {

		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 5, 3, 43, 4, 77, 2 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		assertEquals("[ 2 3 4 5 43 77 ]", out);
	}

	@Test
	public void test4() {

		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 3 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		assertEquals("[ 3 ]", out);
	}
	
	@Test
	public void test5() {
		
		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";	
		assertEquals("[ ]", out);
	}
	
	@Test
	public void test6() {
		
		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 1, 2, 3, 4 ,5 , 6 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";	
		assertEquals("[ 1 2 3 4 5 6 ]", out);
	}
	
	@Test
	public void test7() {
		
		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 6, 5, 4, 3, 2, 1 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		assertEquals("[ 1 2 3 4 5 6 ]", out);
	}
	
	@Test	
	public void test8() {
		
		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 6, 5, 4, 3, 2, 6 };
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";		
		assertEquals("[ 2 3 4 5 6 6 ]", out);
	}
	
	@Test
	public void test9() {
		
		Sort<Integer> s = new Sort<>();
		Integer[] a = new Integer[] { 6, 5, 2, 3, 10, 3, 41, 9, 8, 1, 4};
		s.sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";		
		assertEquals("[ 1 2 3 3 4 5 6 8 9 10 41 ]", out);
	}
	
	
}
