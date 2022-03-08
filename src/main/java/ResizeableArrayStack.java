//I vow to make a ton of comments on my code and make it all readable

import java.util.EmptyStackException;
import java.util.*;

public final class ResizeableArrayStack<T> implements StackInterface<T>
    {
        private T[] stack; //Array of stack entries we will be using
        private int topIndex; //top of the the stack is measured with this integer
        private boolean integrityOK = false;
        private static final int DEFAULT_CAPACITY = 50;
        private static final int MAX_CAPACITY = 10000;  //stack cannot be greater than this integer

public ResizeableArrayStack()
        {
            this(DEFAULT_CAPACITY);
        } //end default constructor

public ResizeableArrayStack( int initialCapacity )
        {
            integrityOK = false; //check integrity
            checkCapacity(initialCapacity); //sanitize user data
            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[])new Object[initialCapacity];
            stack = tempStack;
            topIndex = -1;
            integrityOK = true;
        } // end constructor

    @Override
public void push(T newEntry)
        {
            checkIntegrity(); //taken from notes, pushes a new entry to the top of the stack
            ensureCapacity();
            stack[topIndex + 1] = newEntry;
            topIndex++; //then adds one to the top counter so that the peek method works
        } //end push

    @Override
public T pop()
        {
            checkIntegrity();
            if (isEmpty())
            {
                throw new EmptyStackException();
            } else
            {
                T top = stack[topIndex];
                stack[topIndex] = null;
                topIndex--;
                return top;
            } // end if

        } //end pop

    @Override
public T peek()
        {
        checkIntegrity();
        if (isEmpty())
        {
            throw new EmptyStackException(); //sanitize user input
        } else
        {
            return stack[topIndex]; //will return whatever is at the top of the stack
        }
        } //end peek

    @Override
public boolean isEmpty()
        {
        return topIndex < 0;
        }

    @Override
public void clear()
        {
        checkIntegrity();
        while (topIndex > -1)
            {
                stack[topIndex] = null;
                topIndex--;
            } // end while
            //Assertion: topIndex is -1
        } //end clear

/*
public T evaluatePostfix(postfix)
        {
// Evaluates a postfix expression.
        T[] valueStack = (T[])new Object[];
        while (!valueStack.isEmpty())
        {
        nextCharacter = next nonblank character of postfix
        switch (nextCharacter)
        {
            case variable:
                valueStack.push(value of the variable nextCharacter) break
            case '+' : case '-' : case '*' : case '/' : case '^' :
            operandTwo = valueStack.pop()
            operandOne = valueStack.pop()
            result = the result of the operation in nextCharacter and its operands
            operandOne and operandTwo valueStack.push(result)
            break
            default: break // Ignore unexpected characters
        } }
return valueStack.peek()
        } //end evaluatePostfix
 */

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
} //end ResizeableArrayStack
