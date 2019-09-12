/**
 * By using <T> we indicate that this class is generic class,
 * but it the < > we specify Parameter type
 * @param <T>
 */
public class GenericObject<T>
{
    private T obj = null;

    public GenericObject(T obj)
    {
        this.obj = obj;
    }

    public T getObject()
    {
        return this.obj;
    }
}
