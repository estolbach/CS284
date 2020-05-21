import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This class uses iterative quicksort to sort an array I pledge my honor that I
 * have abided by the Stevens Code of Honor
 * 
 * @author Esther Stolbach
 *
 */
public class Sort<T extends Comparable<T>> {

	/**
	 * This is an inner class to create Intervals
	 * 
	 * @author Esther Stolbach
	 *
	 */
	private static class Interval {
		private int lower;
		private int upper;

		public Interval(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;
		}

		/**
		 * This method returns the lower bound
		 * 
		 * @return lower
		 */
		public int getLower() {
			return lower;
		}

		/**
		 * this method returns the upper bound
		 * 
		 * @return upper
		 */
		public int getUpper() {
			return upper;
		}

		/**
		 * this method returns true if this interval and the given interval have
		 * the same lower and upper bounds
		 */
		public boolean equals(Object o) {
			Interval interval = (Interval) o;
			if (this.getLower() == interval.getLower()
					&& this.getUpper() == interval.getUpper()) {
				return true;
			}
			return false;
		}

		/**
		 * return lower * lower + upper
		 */
		public int hashCode() {
			return lower * lower + upper;
		}

		@Override
		/**
		 * this method creates a tosString
		 */
		public String toString() {
			return "Interval [lower=" + lower + ", upper=" + upper + "]";
		}
	}

	/**
	 * this method sort the array by using iterative quicksort
	 * 
	 * @param array
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		if (array == null || array.length == 1) {
			return;
		}
		if (array.length == 2) {
			if (array[0].compareTo(array[1]) > 0) {
				swap(array, 0, 1);
			}
			return;
		}
		Set<Interval> setIntervals = new HashSet<Interval>();
		Interval interval = new Interval(0, array.length - 1);
		setIntervals.add(interval);

		while (!setIntervals.isEmpty()) {
			Iterator<Interval> iteration = setIntervals.iterator();
			Interval temp = iteration.next();
			setIntervals.remove(temp);
			int up = temp.getLower();
			int down = temp.getUpper();
			if (up < down) {
				int part = partition(array, up, down);
				Interval half = new Interval(up, part - 1);
				Interval half2 = new Interval(part + 1, down);
				setIntervals.add(half);
				setIntervals.add(half2);
			}

		}
	}

	public static int max(int a, int b) {
		return (a < b) ? b : a;
	}

	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	/**
	 * this method swaps elements in an array
	 * 
	 * @param array
	 * @param x
	 * @param y
	 */
	protected static <T extends Comparable<T>> void swap(T[] array, int first,
			int last) {
		T temp = array[first];
		array[first] = array[last];
		array[last] = temp;
	}

	/**
	 * this method uses bubble sort to sort the first, last and middle item in
	 * the array
	 * 
	 * @param array
	 * @param first
	 * @param last
	 */
	protected static <T extends Comparable<T>> void bubbleSort3(T[] array,
			int first, int last) {
		int middle = first + (last - first) / 2;
		if (array[middle].compareTo(array[first]) < 0) {
			swap(array, first, middle);
		}
		if (array[last].compareTo(array[middle]) < 0) {
			swap(array, middle, last);
		}
		if (array[middle].compareTo(array[first]) < 0) {
			swap(array, first, middle);
		}
	}

	/**
	 * This is a method to partition the array using the median-of-three
	 * partition
	 * 
	 * @param array
	 * @param first
	 * @param last
	 * @return
	 */
	private static <T extends Comparable<T>> int partition(T[] array,
			int first, int last) {
		int middle = first + (last - first) / 2;
		bubbleSort3(array, first, last);
		swap(array, first, middle);
		T pivot = array[first];
		int up = first;
		int down = last;
		do {
			while ((up < last) && (pivot.compareTo(array[up]) >= 0)) {
				up++;
			}
			// assert: up equals last or array[up] > pivot.
			while (pivot.compareTo(array[down]) < 0) {
				down--;
			}
			if (up < down) {
				swap(array, up, down);
			}
		} while (up < down);
		swap(array, first, down);
		return down;
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[] { 6, 5, 7, 2, 9, 3, 12, 4 };
		sort(a);
		String out = "[ ";
		for (Integer i : a) {
			out += i.toString() + " ";
		}
		out += "]";
		System.out.println(out);
	}
}
