package deque;

public class LinkedListDeque<T>
{
    private class StuffNode
    {
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(StuffNode p, T i, StuffNode n)
        {
            item = i;
            next = n;
            prev = p;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque()
    {
        sentinel = new StuffNode(null, null , null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T x)
    {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T x)
    {
        sentinel.prev = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public T removeFirst()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            T x = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return x;
        }
    }

    public T removeLast()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            T x = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return x;
        }
    }

    public T get(int index)
    {
        if (index >= size)
        {
            return null;
        }
        StuffNode p = sentinel.next;
        for (int i = 0; i < index; i++)
        {
            p = p.next;
        }
        return p.item;
    }

    public int size()
    {
        return size;
    }

    private T getRecursive(int pos, int index, StuffNode x)
    {
        if (pos == index)
        {
            return x.item;
        }
        return getRecursive(pos + 1, index, x.next);
    }

    public T getRecursive(int index)
    {
        if (index >= size)
        {
            return null;
        }
        return getRecursive(0, index, sentinel.next);
    }

    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        return false;
    }
}
