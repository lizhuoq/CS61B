public class SLList
{
    private static class IntNode
    {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n)
        {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList()
    {
        size = 0;
        sentinel = new IntNode(63, null);
    }

    public SLList(int x)
    {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x)
    {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst()
    {
        return sentinel.next.item;
    }

    public void addLast(int x)
    {
        size += 1;
        IntNode p = sentinel;
        while (p.next != null)
        {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int size()
    {
        return size;
    }

    public static void main(String[] args)
    {
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
    }
}