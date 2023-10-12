public class Exercise4
{
    public static void windowPosSum(int[] a, int n)
    {
        int i = 0;
        int length = a.length;
        while (i < length)
        {
            if (a[i] < 0)
            {
                i++;
                continue;
            }
            if (i + n >= length)
            {
                for (int j = i; j < length; j++)
                {
                    if (j == i)
                    {
                        continue;
                    }
                    a[i] += a[j];
                }
            }
            else
            {
                for (int j = i; j <= (i + n); j++)
                {
                    if (j == i)
                    {
                        continue;
                    }
                    a[i] += a[j];
                }
            }
            i++;
        }
    }

    public static void  main(String[] args)
    {
        int[] a = {1, -1, -1, 10, 5, -1};
        int n = 2;
        windowPosSum(a, n);

        System.out.println(java.util.Arrays.toString(a));
    }
}