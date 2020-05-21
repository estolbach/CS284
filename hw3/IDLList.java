import java.util.*;

/**
 * This class implements a double linked list with fast accessing
 *
 * @author Esther Stolbach
 *
 * @param <E>
 */
public class IDLList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;

	public IDLList() {
		size = 0;
		indices = new ArrayList<>();
	}

	/**
	 * this method adds elem at position index
	 * 
	 * @param index
	 * @param elem
	 * @return true
	 */
	public boolean add(int index, E elem) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		// if index empty call add
		if (head == null) {
			add(elem);
			return true;
		}
		// if index+1 == size then call append
		if (index == size) {
			append(elem);
			return true;
		}
		Node<E> new1 = new Node<E>(elem);
		Node<E> temp = indices.get(index - 1);
		Node<E> temp2 = indices.get(index);
		temp.next = new1;
		new1.prev = temp;
		temp2.prev = new1;
		new1.next = temp2;
		indices.add(index, new1);
		size++;
		return true;
	}

	/**
	 * this method adds elem at the head
	 * 
	 * @param elem
	 * @return true
	 */
	public boolean add(E elem) {
		Node<E> new1 = new Node<E>(elem);
		if (head == null) {
			head = new1;
			tail = new1;
			indices.add(0, new1);
			size++;
			return true;
		}
		// check this part that follows
		else {
			head.prev = new1;
			new1.next = head;
			head = new1;
			indices.add(0, head);
			size++;
			return true;
		}
	}

	/**
	 * this method adds elem as the new last element of the list (tail)
	 * 
	 * @param elem
	 * @return true
	 */
	public boolean append(E elem) {
		Node<E> new1 = new Node<E>(elem);
		if (size == 0) {
			add(elem);
		}
		tail.next = new1;
		new1.prev = tail;
		tail = new1;
		indices.add(size, new1);
		size++;
		return true;
	}

	/**
	 * This method returns the object at position index
	 * 
	 * @param index
	 * @return temp1
	 */
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		Node<E> temp = indices.get(index);
		E temp1 = temp.data;
		return temp1;
	}

	/**
	 * This method returns the object at the head
	 * 
	 * @return head.data
	 */
	public E getHead() {
		if (head == null) {
			throw new NullPointerException("List is empty");
		}
		return head.data;
	}

	/**
	 * This method returns the object at the tail
	 * 
	 * @return
	 */
	public E getLast() {
		if (size == 0) {
			throw new NullPointerException("List is empty");
		}
		return tail.data;
	}

	/**
	 * This method returns the list size
	 * 
	 * @return size
	 */
	public int size() {
		return size;
	}

	/**
	 * This method removes and returns the element at the head
	 * 
	 * @param elem
	 * @return
	 */
	public E remove() {
		if (size == 0) {
			throw new NullPointerException("List is empty");
		}

		if (size == 1) {
			E temp = head.data;
			head = null;
			tail = null;
			size = 0;
			indices.remove(0);
			return temp;
		}
		Node<E> tempHead = head.next;
		E result = head.data;
		tempHead.prev = null;
		head = tempHead;
		size--;
		indices.remove(0);
		return result; 
	}

	/**
	 * This method removes and returns the last element at the tail
	 * 
	 * @return
	 */
	public E removeLast() {
		if (size == 1 || size == 0) {
			remove();
		}
		Node<E> tempTail = tail.prev;
		E result = tail.data;
		tempTail.next = null;
		tail = tempTail;
		size--;
		indices.remove(size - 1);
		return result;
	}

	/**
	 * This method removes and returns the element at the index, index.
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (index < 0 || index > indices.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		if (size == 1) {
			remove();
		}
		if (index == 0) {
			Node<E> tempHead = head.next;
			tempHead.prev = null;
			head = tempHead;
			size--;
			indices.remove(0);
			return head.data;
		}
		Node<E> temp = indices.get(index - 1);
		Node<E> temp2 = indices.get(index);
		temp.next = temp2.next;
		temp2.next.prev = temp2.prev;
		indices.remove(index);
		size--;
		return temp2.data;
	}

	/**
	 * This method removes the first occurrence of elem in the list and returns
	 * true. Return false if elem was not in the list
	 * 
	 * @param elem
	 * @return
	 */
	public boolean remove(E elem) {
		Node<E> curr = head;
		int counter = 0;
		if (size == 1 && head.data == elem) {
			remove();
			return true;
		}
		if (curr.data.equals(elem)) {
			remove();
			return true;
		}
		while (curr.next != null) {
			curr = curr.next;
			if (curr.data.equals(elem)) {
				if (curr == tail) {
					removeLast();
					return true;
				} else {
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
					size--;
					indices.remove(counter);
					return true;
				}
			}
			counter++;
		}
		return false;
	}

	/**
	 * This method creates a string representation of the list
	 */
	public String toString() {
		Node<E> current = head;
		StringBuilder res = new StringBuilder();

		while (current != null) {
			res.append(current.data + "\n");
			current = current.next;
		}

		return res.toString();
	}

	/**
	 * This inner class creates Node of type E
	 * 
	 * @author Esther Stolbach
	 *
	 * @param <E>
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;

		/**
		 * Constructor
		 * 
		 * @param elem
		 */
		private Node(E elem) {
			data = elem;
			next = null;
			prev = null;
		}

		/**
		 * Constructor
		 * 
		 * @param elem
		 * @param prev
		 * @param next
		 */
		private Node(E elem, Node<E> prev, Node<E> next) {
			data = elem;
			this.next = next;
			this.prev = prev;
		}
	}

	// main method
	public static void main(String[] args) {
		IDLList<String> l = new IDLList<>();
		l.add("Esti");
		l.add("Rivka");
		l.add("Reuven");
		l.add("Benny");
		l.add("Sara");
		System.out.println("Head: " + l.getHead());
		System.out.println(l);
		System.out.println(l.indices.size());
		System.out.println(l.remove(2));
		System.out.println(l.indices.size());
		System.out.println(l);
		System.out.println();
		System.out.println("Head: " + l.getHead());
		System.out.println(l.get(0));
		System.out.println(l);
		l.removeLast();
		System.out.println(l);
		System.out.println(l.indices.size());

	}
}
