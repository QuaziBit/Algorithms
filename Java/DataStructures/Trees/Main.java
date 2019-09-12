import binarytree.BinaryTree;
import binarytree.Node;

public class Main
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        // ----------------------------- //
        /*
                    ....
                   .(50).
                  /      \
              .(25).     .(75).
             /      \   /      \
           (15)   (30)(65)     (85)
        */
        // ----------------------------- //

        tree.addNode(new Node(50));
        tree.addNode(new Node(25));
        tree.addNode(new Node(15));
        tree.addNode(new Node(30));
        tree.addNode(new Node(75));
        tree.addNode(new Node(85));
        tree.addNode(new Node(65));
        tree.addNode(new Node(5));
        tree.addNode(new Node(20));
        tree.addNode(new Node(2));
        tree.addNode(new Node(10));
        tree.addNode(new Node(60));
        tree.addNode(new Node(70));
        tree.addNode(new Node(27));
        tree.addNode(new Node(32));

        /*
        System.out.printf("In Order Traversing\n");
        tree.inOrderTraversing(tree.getRoot());
        System.out.printf("\n");
        System.out.printf("Pre-Order Traversing\n");
        tree.preOrderTraversing(tree.getRoot());
        System.out.printf("\n");
        System.out.printf("Post-Order Traversing\n");
        tree.postOrderTraversing(tree.getRoot());

        System.out.printf("\nFind node with key: %d\n", 30);
        Node tmp = tree.findNode(30);
        if (tmp != null)
        {
            System.out.printf("Node: %d\n", tree.findNode(30).getKey());
        }
        else
        {
            System.out.printf("No such node!\n");
        }
        */


        /*
        System.out.printf("Delete root\n");
        tree.delete(tree.getRoot().getKey());
        */

        /*
        System.out.printf("Delete node\n");
        tree.delete(25);
        */

        System.out.printf("Delete leaf node\n");
        tree.delete(10);

        System.out.printf("In Order Traversing\n");
        tree.inOrderTraversing(tree.getRoot());
        System.out.printf("\n");
        System.out.printf("Pre-Order Traversing\n");
        tree.preOrderTraversing(tree.getRoot());
        System.out.printf("\n");
        System.out.printf("Post-Order Traversing\n");
        tree.postOrderTraversing(tree.getRoot());
    }
}
