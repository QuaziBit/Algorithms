package binarytree;

public class Node
{
    private Node left = null;
    private Node right = null;

    private int key;

    public Node()
    {

    }

    public Node(int key)
    {
        this.key = key;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }

    public void setKey(int key)
    {
        this.key = key;
    }


    public Node getLeft()
    {
        return this.left;
    }

    public Node getRight()
    {
        return this.right;
    }

    public int getKey()
    {
        return this.key;
    }

}
