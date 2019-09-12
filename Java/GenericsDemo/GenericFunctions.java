public class GenericFunctions
{
    public GenericFunctions()
    {

    }

    public <T> void genericDisplay(T element)
    {
        System.out.println(element.getClass().getName() + " = " + element);
    }
}
