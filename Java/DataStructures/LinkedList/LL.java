/**
 * @author Implememnted by: Olexandr Matveyev
 * Linked-List is linear and recursive data structure, it has links to itself.
 */

public class LL
{
    // Head Node is first Node
    private Node head;

    // Size of the linked list
    private int size;

    // Init Linked List
    public LL()
    {
        head = null;
        size = 0;
    }

    /**
     * Add element to a Linked List
     * @param data
     */
    public void add(int data)
    {
        if (head == null)
        {
            head = new Node(data, size, null);
            head.setNext(null);
        }
        else if (head != null)
        {
            // If head node is not null
            // we have to loop over the recursive stack of a list's nodes
            // in other words wer have to traverse a list in a backward order

            Node last = head;
            while (last.getNext() != null)
            {
                last = last.getNext();
            }

            last.setNext(new Node(data, size, last));
        }
        size++;
    }

    /**
     * Get Linked List element by data value
     * @param data
     * @return
     */
    public int find(int data)
    {
        Node next = head;
        while (next.getNext() != null)
        {
            next = next.getNext();
            if (data == next.getData())
            {
                break;
            }
        }

        return next.getData();
    }

    /**
     * Get Linked List element by index
     * @param index
     * @return
     */
    public Node get(int index)
    {
        Node tmp = head;
        while (tmp.getNext() != null)
        {
            tmp = tmp.getNext();
            if (tmp.getIndex() == index)
            {
                break;
            }
        }

        return tmp;
    }

    /**
     * Return all Nodes on a Linked List
     * @return
     */
    public Node[] traverse()
    {
        int i = 0;
        Node[] tmp = null;

        if (size != -1)
        {
            Node next = head;
            tmp = new Node[size];

            tmp[i] = next;
            while (next.getNext() != null)
            {
                next = next.getNext();
                i++;
                tmp[i] = next;
            }
        }

        // ----------------------------------------------------------------------- //
        Node[] tmp2 = null;
        // Extra loop over nodes to remove unlinked node
        int j = 0;
        for (i = 0; i < tmp.length; i++)
        {
            if (tmp[i] != null)
            {
                j++;
            }
        }
        i = 0;

        tmp2 = new Node[j];
        j = 0;

        for (i = 0; i < tmp.length; i++)
        {
            if (tmp[i] != null)
            {
                tmp2[j] = tmp[i];
                j++;
            }
        }

        this.size = tmp2.length;
        // ----------------------------------------------------------------------- //

        return tmp2;
    }

    /**
     * Remove element from a Linked lIst
     * @param data
     */
    public void remove(int data)
    {

        Node last = null;
        Node current = head;
        Node next = null;

        while (current.getNext() != null)
        {
            if (data == current.getData())
            {
                break;
            }
            current = current.getNext();
        }

        last = current.getLast();
        next = current.getNext();

        // Remove first node
        // ------------------------------------------------------------ //
        if (last == null && next != null)
        {
            next.setLast(null);
            head = next;
        }
        if (last == null && next == null)
        {
            head = null;
            size = -1;
        }
        // ------------------------------------------------------------ //

        // Remove middle node
        if (last != null && next != null)
        {
            last.setNext(next);
            next.setLast(last);
        }

        // Remove last node
        if (last != null && next == null)
        {
            last.setNext(null);
        }

        // updating indexes
        indexUpdate();
    }

    /**
     * Updating Nodes indexes after Node removal
     */
    private void indexUpdate()
    {
        int i = 0;

        if (size != -1)
        {
            // Updating indexes
            head.setIndex(i);

            Node next = head;

            while (next.getNext() != null)
            {
                next = next.getNext();

                i++;

                // Updating indexes
                next.setIndex(i);
            }
        }
    }

    /**
     * Get Linked List size
     * @return
     */
    public int getSize()
    {
        traverse();
        return this.size;
    }

    /**
     * Returns 'true' if Linked List is empty
     * @return
     */
    public boolean isEmpty()
    {
        boolean tmp = true;
        if (head != null)
        {
            tmp = false;
        }

        return tmp;
    }
}
