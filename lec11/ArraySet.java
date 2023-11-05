public class ArraySet<T>
{
    private int size;
    private T[] items;

    public ArraySet()
    {
        size = 0;
        items = (T[]) new Object[100];
    }

    public void add(T value)
    {
        boolean isContain = contains(value);
        if (isContain)
        {
            return;
        }
        items[size] = value;
        size += 1;
    }

    public boolean contains(T value)
    {
        for (int i = 0; i < size; i++)
        {
            if (value.equals(items[i]))
            {
                return true;
            }
        }
        return false;
    }

    public int size()
    {
        return size;
    }
}
