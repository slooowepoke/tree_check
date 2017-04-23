@SuppressWarnings("WeakerAccess")
public interface RBNode<T> {

    T getValue();
    default boolean isRed() {
        return true;
    }

    RBNode<T> getLeft();
    RBNode<T> getRight();

    // Optional
    void setLeft(RBNode<T> left);
    void setRight(RBNode<T> right);
    void setColor(boolean isRed);
}


public class RBTree<T> {


	public class Node<T> implements RBNode<T> {

		private T val;
		private Node<T> left, right;
		private boolean is_red;

		public boolean isRed() {
			return is_red;
		}

		public Node<T> getLeft() {
			return left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public void setColor(boolean isRed) {
			is_red = isRed;
		}
	}

	private Node<T> root;

	public boolean testBlackEqualty() {
		return testBlackEqualty(root, 0);
	}

	private int blackCount = -1;

	private boolean testBlackEqualty(Node<T> node, int localCount) {
		if (node == null) {
			if (blackCount == -1) {
				blackCount = localCount;
			}
			return (localCount == blackCount);
		}
		localCount += (node.isRed() ? 0 : 1);
		return (testBlackEqualty(node.left, localCount) &&
			testBlackEqualty(node.right, localCount));
	}
}