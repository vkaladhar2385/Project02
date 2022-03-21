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
  public LinkedStack<Integer> convertToPostfix(String exp)
    {
        LinkedStack<Integer> valueStack = new LinkedStack<Integer>();    // Create postfix stack
        int n = exp.length();

        for(int i=0;i<n;i++)
        {
            if(isOperator(exp.charAt(i)))
            {
                // pop top 2 operands.
                int operatorOne =  valueStack.pop();
                int operatorTwo = valueStack.pop();

                // evaluate in reverse order i.e. op2 operator op1.
                switch (exp.charAt(i)) {
                    case '+' -> valueStack.push(operatorTwo + operatorOne);
                    case '-' -> valueStack.push(operatorTwo - operatorOne);
                    case '*' -> valueStack.push(operatorTwo * operatorOne);
                    case '/' -> valueStack.push(operatorTwo / operatorOne);
                }

            }
            // Current Char is Operand simple push into stack
            else
            {
                // convert to integer
                int result = exp.charAt(i) - '0';
                valueStack.push(result);
            }
        }

        // Stack at End will contain result.
        System.out.println(valueStack.pop());
        return valueStack;
        //correction2
        //return valueStack.pop();
    } //end evaluatePostfix
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exceeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    } // end checkCapacity
    private void checkIntegrity()
    {
        if (!integrityOK)   //Method to check integrity and use for every other method. Means of sanitizing data.
        {
            throw new SecurityException("Uninitialized object used to call an arrayBag method");
        }
    }  //end checkInitialization
    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    }
    public boolean isOperator(char ch) //this method will be used in evaluatePostfix to check and make sure what it being used in the stack is correct
    {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }

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
