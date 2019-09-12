/**
 * Stacks are dynamic data structures that follow the Last In First Out (LIFO) principle.
 * The last item to be inserted into a stack is the first one to be deleted from it.
 *
 * For example, you have a stack of trays on a table. The tray at the top of the stack is
 * the first item to be moved if you require a tray from that stack.
 */

import java.util.Queue;
import java.util.Stack;

/**
 * Features of stacks
 *     Dynamic data structures
 *     Do not have a fixed size
 *     Do not consume a fixed amount of memory
 *     Size of stack changes with each push() and pop() operation. Each push() and pop()
 *     operation increases and decreases the size of the stack by 1, respectively.
 */

public class Main
{
    public static void main(String[] args)
    {
        MyStack stack = new MyStack(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.printf("[0]: Top element: %d\n", stack.peek());
        System.out.printf("[1]: Bottom element: %d\n", stack.bottom());

        System.out.printf("Pop element: %d\n", stack.pop());

        System.out.printf("[2]: Top element: %d\n", stack.peek());
        System.out.printf("[3]: Bottom element: %d\n", stack.bottom());

        /*
        for (int i = 0; i < 3; i++)
        {

        }
        */
    }
}
