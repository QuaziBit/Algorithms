/**
 * Stacks are dynamic data structures that follow the Last In First Out (LIFO) principle.
 */

public class MyStack
{
    private int[] array = null;
    private int size = 0;
    private int index = -1;

    // Constructor to initialize stack
    public MyStack(int size)
    {
        this.size = size;
        array = new int[this.size];
        index = 0;
    }

    // Function to add an element 'n' in the stack
    public void push(int n)
    {
        array[index] = n;
        index++;
    }

    // Function to pop top element from the stack
    public int pop()
    {
        --index;
        return array[index];
    }

    // Function to return top element in a stack
    public int peek()
    {
        int i = index;
        --i;
        return array[i];
    }

    // Function to return bottom element in a stack
    public int bottom()
    {
        int i = 0;
        return array[i];
    }

    // Function to return the size of the stack
    public int size()
    {
        return array.length;
    }

    // Function to check if the stack is empty or not
    public Boolean isEmpty()
    {
        return index == -1;	// or return size() == 0;
    }

    // Utility function to check if the stack is full or not
    public Boolean isFull()
    {
        return index == array.length;	// or return size() == capacity;
    }


}
