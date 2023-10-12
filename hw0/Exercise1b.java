public class Exercise1b
{
    public static void main(String[] args)
    {
        int N = 10;
        drawTriangle(N);
    }

    public static void drawTriangle(int N)
    {
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