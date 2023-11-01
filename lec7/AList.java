public class AList
{
    private int[] items;
    private int size;

    public AList()
    {
        items = new int[100];
        size = 0;
    }

    public void addLast(int x)
    {
        if (size == items.length)
        {
            // resize
            int[] a = new int[size + 1];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        items[size] = x;
        size += 1;
    }
}
