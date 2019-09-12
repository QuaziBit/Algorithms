public class Main
{
    public static void main(String[] args)
    {
        LL list = new LL();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //list.remove(1);

        if (!list.isEmpty())
        {
            System.out.printf("linked-list size: %d\n\n", list.getSize());
            for (int i = 0; i < list.traverse().length; i++)
            {
                if (list.traverse()[i] != null)
                {
                    Node node = list.traverse()[i];
                    System.out.printf("[%d]: %d\n", node.getIndex(), node.getData());
                }
            }

            System.out.printf("\nGet by index %d: %d\n", 3, list.get(3).getData());
        }
        else
        {
            System.out.printf("Linked List is empty.\n");
        }
    }
}
