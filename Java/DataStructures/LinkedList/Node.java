public class Node
{
    private Node last;
    private Node nextNode;
    private int data;
    private int index = 0;

    public Node(int data, int index, Node last)
    {
        this.data = data;
        this.last = last;
        this.index = index;
    }

    public void setNext(Node node)
    {
        nextNode = node;
    }

    public int getData()
    {
        return this.data;
    }

    public Node getNext()
    {
        return this.nextNode;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }

    public void setLast(Node last)
    {
        this.last = last;
    }

    public Node getLast()
    {
        return this.last;
    }

}
