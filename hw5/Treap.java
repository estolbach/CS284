import java.util.Random;
import java.util.Stack;

/**
 * This class creates Treap
 * 
 * @author Esther Stolbach
 *
 * @param <E>
 */
public class Treap<E extends Comparable<E>> {

	private Random priorityGenerator;
	private Node<E> root;

	public Treap() {
		priorityGenerator = new Random();
	}

	public Treap(long seed) {
		priorityGenerator.setSeed(seed);
	}

	/**
	 * This method adds a node to the treap it uses the other add method
	 * 
	 * @param key
	 * @return
	 */
	public boolean add(E key) {
		int priority = priorityGenerator.nextInt();
		return add(key, priority);
	}

	/**
	 * This method adds a node to the treap it reheaps the treap to maintain the
	 * heap and bst functions
	 * 
	 * @param key
	 * @param priority
	 * @return
	 */
	public boolean add(E key, int priority) {
		// check for duplicates
		if (find(root, key) != null) {
			return false;
		}
		Node<E> index = new Node<E>(key, priority);
		if (root == null) {
			root = index;
			return true;
		}
		Stack<Node<E>> s = new Stack<Node<E>>();
		Node<E> curr = root;
		Node<E> lr = null;
		while (curr != null) {
			s.push(curr);
			lr = curr;
			if (curr.data.compareTo(index.data) < 0) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		if (lr.data.compareTo(index.data) < 0) {
			lr.right = index;
			// reheap call with stack of visited nodes and node added
			reHeap(s, index);
			return true;
		} else {
			lr.left = index;
			// reheap call with stack of visited nodes and node added
			reHeap(s, index);
			return true;
		}
	}

	/**
	 * this is a helper method to reheap the treap
	 * 
	 * @param s
	 * @param lr
	 * @return
	 */
	private void reHeap(Stack<Node<E>> s, Node<E> index) {
		while (!s.empty()) {
			Node<E> parent = s.pop();
			if (index.priority > parent.priority) {
				if (index.data.compareTo(parent.data) < 0) {
					parent.rotateRight();
				} else {
					parent.rotateLeft();
				}
				if (!s.isEmpty()) {
					if (s.peek().left == parent) {
						s.peek().left = index;
					} else {
						s.peek().right = index;
					}
				} else {
					this.root = index;
				}
			} else {
				break;
			}
		}
	}

	/**
	 * this method deletes a node given the key
	 * @param key
	 * @return
	 */
	public boolean delete(E key) {
		if (root==null || find(root, key) == null) {
			return false;
		}
		
		if (root.data.compareTo(key)==0) {
			if (root.left==null) {
				root=root.right;
				return true;
			} else if (root.right==null) {
				root=root.left;
				return true;
			} else {
				if (root.left.priority>root.right.priority) {
					root=root.rotateRight();
				} else {
					root=root.rotateLeft();
				}
			}
			
		}
		
		Node<E> curr = root;
		Node<E> parent = null;
		while (curr.data.compareTo(key) != 0) {
			parent = curr;
			if(curr.data.compareTo(key)>0)
				curr = curr.left;
			 else {
				 curr = curr.right;
			 }
		}

		while (!curr.isLeaf()) {
			if (curr.right == null) {
				if (parent.left == curr) {
					parent.left = curr.rotateRight();
					parent = parent.left;
				} else {
					parent.right = curr.rotateRight();
					parent = parent.right;
				}
			} else if (curr.left == null) {
				if (parent.left == curr) {
					parent.left = curr.rotateLeft();
					parent = parent.left;
				} else {
					parent.right = curr.rotateLeft();
					parent = parent.right;
				}
			} else if (curr.right.priority > curr.left.priority) {
				if (parent.left == curr) {
					parent.left = curr.rotateLeft();
					parent = parent.left;
				} else {
					parent.right = curr.rotateLeft();
					parent = parent.right;
				}

			} else if (curr.left.priority > curr.right.priority) {
				if (parent.left == curr) {
					parent.left = curr.rotateRight();
					parent = parent.left;
				} else {
					parent.right = curr.rotateRight();
					parent = parent.right;
				}
			}
		}
		if (curr.right == null && curr.left == null) {
			if (parent.data.compareTo(curr.data) > 0) {
				parent.left = null;
				return true;
			} else if (parent.data.compareTo(curr.data) < 0) {
				parent.right = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * this method finds if the given key is in the treap
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private E find(Node<E> root, E key) {
		if (root == null) {
			return null;
		}
		if (root.data.compareTo(key) == 0) {
			return key;
		} else if (root.data.compareTo(key) < 0) {
			return find(root.right, key);
		} else {
			return find(root.left, key);
		}
	}

	/**
	 * This method creates a toString
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	/**
	 * Perform a preorder traversal.
	 * 
	 * @param node
	 *            The local root
	 * @param depth
	 *            The depth
	 * @param sb
	 *            The string buffer to save the output
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	public static void main(String args[]) {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		System.out.println(testTree);
		testTree.delete(5);
		System.out.println();
		System.out.println(testTree);

	}

	/**
	 * This is an inner class to create nodes
	 * 
	 * @author Esther Stolbach
	 *
	 * @param <E>
	 */
	private static class Node<E> {

		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;

		public Node(E data, int priority) {
			if (data == null) {
				throw new NullPointerException("Data is null");
			}
			this.data = data;
			this.priority = priority;
			left = null;
			right = null;
		}

		/**
		 * This method rotates the tree with right rotation
		 * 
		 * @return
		 */
		public Node<E> rotateRight() {
			Node<E> index = left;
			Node<E> temp = left.right;
			left = temp;
			index.right = this;
			return index;
		}

		/**
		 * this method rotates the tree with left rotation
		 * 
		 * @return
		 */
		public Node<E> rotateLeft() {
			Node<E> index = right;
			Node<E> temp = right.left;
			right = temp;
			index.left = this;
			return index;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		/**
		 * this method creates a toString
		 */
		@Override
		public String toString() {
			return "(key=" + data + ", priority=" + priority + ")";
		}
	}
}
