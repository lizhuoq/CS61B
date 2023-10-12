public class Exercise2
{
    public static int max(int[] m)
    {
        int max_number = 0;
        int i = 0;
        int length = m.length;
        while (i < length)
        {
            if (m[i] > max_number)
            {
                max_number = m[i];
            }
            i++;
        }
        return max_number;
    }

    public static void main(String[] args)
    {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}