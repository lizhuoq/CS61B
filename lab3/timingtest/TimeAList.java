package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAddLast(int N)
    {
        AList<Integer> L = new AList<>();
        for (int i = 0; i < N; i++)
        {
            L.addLast(i);
        }
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int N = 1000;
        AList<Integer> NColumn = new AList<>();
        AList<Double> timeColumn = new AList<>();
        AList<Integer> opsColumns = new AList<>();
        while (N <= 128000)
        {
            Stopwatch sw = new Stopwatch();
            // addLast
            timeAddLast(N);
            double timeInSeconds = sw.elapsedTime();
            NColumn.addLast(N);
            opsColumns.addLast(N);
            timeColumn.addLast(timeInSeconds);
            N *= 2;
        }

        printTimingTable(NColumn, timeColumn, opsColumns);
    }
}
