import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @org.junit.jupiter.api.Test
    void testPush() {
        //Arrange
        ResizeableArrayStack<String> arrayStackTest = new ResizeableArrayStack<>();

        //Act
        arrayStackTest.push(String.valueOf('1'));
        Object test = arrayStackTest.peek();

        //Assert
        assertEquals(String.valueOf('1'), test);
    }

    @Test
    void testPop()
    {
        //Arrange
        ResizeableArrayStack<String> arrayStackTest = new ResizeableArrayStack<>();

        //Act
        arrayStackTest.push(String.valueOf('1'));
        arrayStackTest.pop();

        //Assert
        assertTrue(arrayStackTest.isEmpty());
    }

    @Test
    void testPeek()
    {
        //Arrange
        ResizeableArrayStack<String> arrayStackTest = new ResizeableArrayStack<>();

        //Act
        arrayStackTest.push(String.valueOf('a'));
        Object test = arrayStackTest.peek();

        //Assert
        assertEquals(String.valueOf('a'), test);
    }

   /*
    @Test
    void evaluatePostfix() {
        //Arrange
        ResizeableArrayStack<Integer> arrayStackTest = new ResizeableArrayStack<>();
        arrayStackTest.push(2+3-1);

        //Act
        //double testevaluatePostfix(arrayStackTest.peek());

        //Assert
        assertEquals(arrayStackTest.peek(), 33);
    }

    */
}
