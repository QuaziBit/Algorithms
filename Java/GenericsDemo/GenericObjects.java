/**
 * By using <T> we indicate that this class is generic class,
 * but it the < > we specify Parameter type
 * @param <T>
 */
public class GenericObjects<T, U>
{
    private T obj1 = null;
    private U obj2 = null;

    public GenericObjects(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObjectT()
    {
        return this.obj1;
    }

    public U getObjectU()
    {
        return this.obj2;
    }

    public void print()
    {
        System.out.println(this.obj1);
        System.out.println(this.obj2);
    }

    @Override
    public String toString()
    {
        System.out.printf("%s: %d", this.obj1, this.obj2);
        return null;
    }
}
