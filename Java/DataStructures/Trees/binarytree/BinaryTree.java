/**
 * @author Data-Structure author:
 * @author Implememnted by: Olexandr Matveyev
 * BST: 'Binary Search Tree' is a non-linear and recursive data structure,
 * such data structure is broken into nodes which are linked to each other.
 */

package binarytree;

/**
 * Link: https://stackoverflow.com/questions/2130416/what-are-the-applications-of-binary-trees
 * What are the applications of binary trees?
    To squabble about the performance of binary-trees is meaningless - they are not a data structure,
    but a family of data structures, all with different performance characteristics. While it is true that
    unbalanced binary trees perform much worse than self-balancing binary trees for searching, there are many
    binary trees (such as binary tries) for which "balancing" has no meaning.

    Applications of binary trees
        Binary Search Tree - Used in many search applications where data is constantly entering/leaving,
        such as the map and set objects in many languages' libraries.
		Binary Space Partition - Used in almost every 3D video game to determine what objects need to be rendered.
		Binary Tries - Used in almost every high-bandwidth router for storing router-tables.
		Hash Trees - used in p2p programs and specialized image-signatures in which a hash needs to be verified,
        but the whole file is not available.
		Heaps - Used in implementing efficient priority-queues, which in turn are used for scheduling processes
        in many operating systems, Quality-of-Service in routers, and A* (path-finding algorithm used in AI applications,
        including robotics and video games). Also used in heap-sort.
		Huffman Coding Tree (Chip Uni) - used in compression algorithms, such as those used by
        the .jpeg and .mp3 file-formats.
		GGM Trees - Used in cryptographic applications to generate a tree of pseudo-random numbers.
		Syntax Tree - Constructed by compilers and (implicitly) calculators to parse expressions.
		Treap - Randomized data structure used in wireless networking and memory allocation.
		T-tree - Though most databases use some form of B-tree to store data on the drive, databases which keep all (most) their
        data in memory often use T-trees to do so.
 */

/**
 * Binary Search Tree
 */

public class BinaryTree
{
    private Node root;

    /**
     * Creating empty Binary Search Tree.
     */
    public BinaryTree()
    {
        this.root = null;
    }

    /**
     * Adding new node, in this method we adding a root node
     * or utilizing {insert} method to add nodes into existing tree.
     * @param node
     */
    public void addNode(Node node)
    {
        if (root == null)
        {
            root = node;
        }
        else
        {
            Node parent = insert(root, node);

            if (parent != null)
            {
                if (node.getKey() < parent.getKey())
                {
                    parent.setLeft(node);
                }
                else if (node.getKey() > parent.getKey())
                {
                    parent.setRight(node);
                }
            }
        }
    }

    /**
     * Inserting new node into existing tree.
     * @param tmp
     * @param node
     * @return
     */
    private Node insert(Node tmp, Node node)
    {
        if (node.getKey() < tmp.getKey())
        {
            if (tmp.getLeft() == null)
            {
                return tmp;
            }
            else
            {
                return insert(tmp.getLeft(), node);
            }
        }
        else if (node.getKey() > tmp.getKey())
        {
            if (tmp.getRight() == null)
            {
                return tmp;
            }
            else
            {
                return insert(tmp.getRight(), node);
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Finding a node by key value.
     * @param key
     * @return
     */
    public Node findNode(int key)
    {
        Node tmp = root;

        while (tmp.getKey() != key)
        {
            if (key < tmp.getKey())
            {
                tmp = tmp.getLeft();
            }
            else if (key > tmp.getKey())
            {
                tmp = tmp.getRight();
            }

            if (tmp == null)
            {
                return null;
            }
        }

        return tmp;
    }

    /**
     * This method is used to find a parent node.
     * We have to use this method in a situation when we have to remove a leaf node.
     * @param child
     * @return
     */
    private Node findParent(Node child)
    {
        Node tmp = root;
        Node parent = null;

        while (tmp.getKey() != child.getKey())
        {
            if (child.getKey() < tmp.getKey())
            {
                parent = tmp;
                tmp = tmp.getLeft();
            }
            else if (child.getKey() > tmp.getKey())
            {
                parent = tmp;
                tmp = tmp.getRight();
            }

            if (tmp == null)
            {
                return null;
            }
        }

        return parent;
    }

    public void inOrderTraversing(Node node)
    {
        if (node != null)
        {
            inOrderTraversing(node.getLeft());
            System.out.printf("Key: %d\n", node.getKey());
            inOrderTraversing(node.getRight());
        }
    }

    public void preOrderTraversing(Node node)
    {
        if (node != null)
        {
            System.out.printf("Key: %d\n", node.getKey());
            preOrderTraversing(node.getLeft());
            preOrderTraversing(node.getRight());
        }
    }

    public void postOrderTraversing(Node node)
    {
        if (node != null)
        {
            postOrderTraversing(node.getLeft());
            postOrderTraversing(node.getRight());
            System.out.printf("Key: %d\n", node.getKey());
        }
    }

    /**
     * This method is utilizing {deleteRoot}, {deleteNode}, and {deleteLeafNode} methods
     * in order to perform deletion operations.
     * @param key
     * @return
     */
    public boolean delete(int key)
    {
        // ---------------------------------------------------------------------------------------------------- //
        //                                          ....
        //                                         .(50).
        //                             ___________/      \___________
        //                            /                              \
        //                         .(25).                           .(75).
        //                    ____/      \____                     /      \
        //                   /                \                   /        \
        //                .(15).            .(30).             .(65).    .(85).
        //               /      \          /      \           /      \
        //              /        \        /        \         /        \
        //           .(5).     .(20).  .(27).    .(32).   .(60).    .(70).
        //          /     \
        //         /       \
        //      .(2).     .(10).
        // ---------------------------------------------------------------------------------------------------- //

        // ---------------------------------------------------------------------------------------------------- //
        // 0: New node must be greater then the largest node on the left side
        // and be smaller then the largest node on the right side

        // 1: Find node
        // 2: Find the smallest node on the right side or the biggest node on the left side
        // 3; copy value to the node that we have to to delete 'basically we do overwriting on a node'
        // 4: update node-references
        // 5: remove duplicate node
        // ---------------------------------------------------------------------------------------------------- //

        // ---------------------------------------------------------------------------------------------------- //
        // Options to remove a node
        // Option: 1
        // Find max in left
        // copy the value to the targeted node
        // delete duplicate from left-subtree
        // OR
        // Option: 2
        // Find min in right
        // copy the value to the targeted node
        // delete duplicate from right-subtree
        // ---------------------------------------------------------------------------------------------------- //

        boolean isDeleted = false;
        if (key == root.getKey())
        {
            if (deleteRoot(key))
            {
                System.out.printf("Root node deleted: new root [%d]\n", this.root.getKey());
            }
        }
        else
        {
            if (deleteNode(key))
            {
                System.out.printf("Node was deleted\n");
            }
            else
            {
                // The node that we try to remove is leaf node, so we have to use different approach to
                // delete such node

                deleteLeafNode(key);
                System.out.printf("Leaf node was deleted\n");
            }
        }

        return isDeleted;
    }

    /**
     * This method is used to delete root node of the BST 'BST: Binary Search Tree'
     * @param key
     * @return
     */
    private boolean deleteRoot(int key)
    {
        Node tmp = root;
        Node rParent = null;
        Node rChild = null;

        // 1: Find the smallest node on the Right side of the BST
        // 2: Copy value to the targeted node
        // 3: delete duplicate from right-subtree

        // Checking if the right child of the root tree is not ot null
        if (tmp.getRight() != null)
        {
            rChild = tmp.getRight();
        }

        if (rChild != null)
        {
            // Looking for a smallest node on the right side
            while (key < rChild.getLeft().getKey())
            {
                // parent node of a leaf node
                rParent = rChild;

                // leaf node is going to be new root node
                rChild = rChild.getLeft();

                // The last node or the leaf node should not have any nodes on the left or right sides
                if (rChild.getLeft() == null)
                {
                    break;
                }
            }

            /*
            System.out.printf("Smallest node on the right side of the tree: %d\n", rChild.getKey());
            System.out.printf("and its parent is %d\n", rParent.getKey());
            */

            // Overriding root node data and keeping all linked nodes
            this.root.setKey(rChild.getKey());

            // Unlinking the smallest leaf node from its parent node
            rParent.setLeft(null);

            return true;
        }
        else
        {
            System.out.printf("Cannot delete root node.");

            return false;
        }
    }

    /**
     * This method is used to delete any node that is NOT root node and not leaf node from BST 'BST: Binary Search Tree'
     * @param key
     * @return
     */
    private boolean deleteNode(int key)
    {
        Node tmp = null;
        Node lParent = null;
        Node lChild = null;

        // 1: Find the largest node on the Left side of the BST
        // 2: Copy value to the targeted node
        // 3: delete duplicate or just unlink its parent node from its child node

        // Find node that we want to delete
        tmp = findNode(key);

        // If node that we want to remove has no children, than it is leaf node,
        // so we just have to unlink this leaf node from its parent
        if (tmp.getLeft() == null && tmp.getRight() == null)
        {
            return false;
        }

        // Get left node of that node that we want to delete
        lChild = tmp.getLeft();

        // The largest node on the left side of sub-tree must be located on the right side of
        // that node which is a child node of a node that we want to remove
        if (lChild != null)
        {
            // Looking for a largest node on the right side
            while (key > lChild.getRight().getKey())
            {
                // parent node of a leaf node
                lParent = lChild;

                // leaf node is going to be new node or a replacement node
                lChild = lChild.getRight();

                // The last node or the leaf node should not have any nodes on the left or right sides
                if (lChild.getRight() == null)
                {
                    break;
                }
            }

            /*
            System.out.printf("Largest node on the left side of the tree: %d\n", lChild.getKey());
            System.out.printf("and its parent is %d\n", lParent.getKey());
            */

            // Overriding node data to the largest node data in the left-subtree and keeping all linked nodes
            // of that node that we want to remove
            tmp.setKey(lChild.getKey());

            // Unlinking the largest leaf node that we found from its parent node
            lParent.setRight(null);

            return true;
        }
        else
        {
            System.out.printf("Cannot delete node.");

            return false;
        }
    }

    /**
     * This method is used to delete leaf node only from BST 'BST: Binary Search Tree'
     * @param key
     * @return
     */
    private boolean deleteLeafNode(int key)
    {
        Node parent = null;
        Node child = null;

        // We hae to find node with by key value
        child = findNode(key);

        if (child != null)
        {
            // We have to find a parent node
            parent = findParent(child);

            // Basically just looking on what side of a parent leaf node located and unlinking this leaf node
            if (parent != null)
            {
                // Remove left child or right child
                if (parent.getLeft() != null)
                {
                    // Remove left child
                    if (parent.getLeft().getKey() == child.getKey())
                    {
                        parent.setLeft(null);
                    }
                }

                if (parent.getRight() != null)
                {
                    // Remove right child
                    if (parent.getRight().getKey() == child.getKey())
                    {
                        parent.setRight(null);
                    }
                }
                else
                {
                    System.out.printf("[0]: Cannot unlink node: %d from parent: %d\n", child.getKey(), parent.getKey());
                }

                return true;
            }
            else
            {
                System.out.printf("[1]: Cannot remove node: %d in parent: %d\n", child.getKey(), parent.getKey());
                return false;
            }
        }
        else
        {
            System.out.printf("[2]: Cannot remove node: %d\n", child.getKey());
            return false;
        }
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }

    public Node getRoot()
    {
        return this.root;
    }
}
