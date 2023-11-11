package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>
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

    @Override
    public void addFirst(T x)
    {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T x)
    {
        sentinel.prev = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void printDeque()
    {
        StuffNode p = sentinel;
        int i = 0;
        while (i < size)
        {
            if (i != (size - 1))
            {
                System.out.print(sentinel.item + " ");
            }
            else
            {
                System.out.println(sentinel.item);
            }
            i += 1;
            p = p.next;
        }
    }

    private class LinkedListDequeIterator implements Iterator<T>
    {
        private int wizPos;

        public LinkedListDequeIterator()
        {
            wizPos = 0;
        }

        @Override
        public boolean hasNext()
        {
            return wizPos < size;
        }

        @Override
        public T next()
        {
            T returnItem = get(wizPos);
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator()
    {
        return new LinkedListDequeIterator();
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Deque))
        {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (this.size() != other.size())
        {
            return false;
        }
        for (int i = 0; i < size; i++)
        {
            if (!(other.get(i).equals(this.get(i))))
            {
                return false;
            }
        }
        return true;
    }
}
