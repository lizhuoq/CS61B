package deque;

public class ArrayDeque<T> implements Deque<T>
{
    private T[] items;
    private int size;

    public ArrayDeque()
    {
        items = (T[]) new Object[8];
        size = 0;
    }

    @Override
    public void addFirst(T item)
    {
        if (size == items.length)
        {
            resize((int) (size * 1.5));
        }
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 0, temp, 1, size);
        temp[0] = item;
        items = temp;
        size += 1;
    }

    private void resize(int capacity)
    {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    private boolean shouldResize()
    {
        if ((size < items.length / 4) && (size >= 16))
        {
            return true;
        }
        return false;
    }

    @Override
    public void addLast(T item)
    {
        if (size == items.length)
        {
            resize((int) (size * 1.5));
        }
        items[size] = item;
        size += 1;
    }

    @Override
    public T removeFirst()
    {
        if (isEmpty())
        {
            return null;
        }
        if (shouldResize())
        {
            resize(items.length / 4);
        }
        T firstVal = items[0];
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 1, temp, 0, size - 1);
        items = temp;
        size -= 1;
        return firstVal;
    }

    @Override
    public T removeLast()
    {
        if (isEmpty())
        {
            return null;
        }
        if (shouldResize())
        {
            resize(items.length / 4);
        }
        T lastVal = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return lastVal;
    }

    @Override
    public T get(int index)
    {
        if (index >= size)
        {
            return null;
        }
        return items[index];
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void printDeque()
    {
        for (int i = 0; i < size; i++)
        {
            if (i != (size - 1))
            {
                System.out.print(items[i] + " ");
            }
            else
            {
                System.out.println(items[i]);
            }
        }
    }
}
