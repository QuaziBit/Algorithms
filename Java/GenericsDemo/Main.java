public class Main
{
    public static void main(String[] args)
    {
        // instance of Integer type
        GenericObject<Integer> iObj = new GenericObject<Integer>(100);

        // instance of String type
        GenericObject<String> sObj = new GenericObject<String>("Hello");

        // instance of Character type
        GenericObject<Character> cObj = new GenericObject<Character>('A');

        System.out.printf("[1]: %d\n", iObj.getObject());
        System.out.printf("[2]: %s\n", sObj.getObject());
        System.out.printf("[3]: %c\n", cObj.getObject());

        System.out.printf("\n");

        // instance of String and Integer types
        GenericObjects<String, Integer> siObj = new GenericObjects<String, Integer>("Answer", 42);
        //siObj.print();
        siObj.toString();

        System.out.printf("\n");

        // Generic functions test
        GenericFunctions gf = new GenericFunctions();
        gf.genericDisplay(new Integer(5));
        gf.genericDisplay(new String("Hello"));

    }
}
