public class Exercise1a
{
    public static void main(String[] args)
    {
        int N = 5;
        int row = 0;
        while (row < N)
        {
            for (int col = 0; col < row + 1; col++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
            row++;
        }
    }
}