import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 */
public final class LinkedStack<T> implements StackInterface<T> {
	private Node<T> topNode; // References the first node in the chain

	public LinkedStack() {
		topNode = null;
	} // end default constructor

	public void push(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);

		if (topNode == null) {
			topNode = newNode;
		} else {
			Node<T> temp = topNode;
			topNode = newNode;
			newNode.next = temp;
		}
		System.out.println(newEntry + " pushed to stack");
	}

	public T pop() {
		T retValue = null;
		if (topNode == null) {
			throw new EmptyStackException();
		} else {
			retValue = topNode.data;
			topNode = topNode.next;
		}
		return retValue;
	}

	public T peek() {
		if (topNode == null) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		} else {
			return topNode.data;
		}
	}

	public boolean isEmpty() {
		if (topNode == null) {
			return true;
		} else
			return false;
	}

	public void clear() {
		if (topNode == null) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		} else {
			while (topNode.next != null) {
				topNode.data = null;
			}
		}
	}

//  < Implementations of the stack operations go here. >
//  . . .

	private class Node<T> {
		private T data; // Entry in stack
		private Node<T> next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node<T> linkPortion) {
			data = dataPortion;
			next = linkPortion;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node<T> getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node<T> nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LinkedStack
