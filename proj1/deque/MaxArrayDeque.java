package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>
{
    private Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> c)
    {
        super();
        cmp = c;
    }

    public T max(Comparator<T> c)
    {
        int size = size();
        if (size == 0)
        {
            return null;
        }

        T maxVal = get(0);
        for (int i = 1; i < size; i++)
        {
            T currentVal = get(i);
            if (c.compare(maxVal, currentVal) < 0)
            {
                maxVal = currentVal;
            }
        }
        return maxVal;
    }

    public T max()
    {
        return max(cmp);
    }
}
