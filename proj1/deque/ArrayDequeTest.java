package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest
{
    @Test
    public void randomizedTest()
    {
        LinkedListDeque<Integer> L1 = new LinkedListDeque<>();
        ArrayDeque<Integer> L2 = new ArrayDeque<>();

        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 8);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L1.addFirst(randVal);
                L2.addFirst(randVal);
            }
            else if (operationNumber == 2)
            {
                //size
                assertEquals(L1.size(), L2.size());
            }
            else if (operationNumber == 3)
            {
                //removeFirst
                assertEquals(L1.removeFirst(), L2.removeFirst());
            }
            else if (operationNumber == 4)
            {
                //removeLast
                assertEquals(L1.removeLast(), L2.removeLast());
            }
            else if (operationNumber == 5)
            {
                //isEmpty
                assertEquals(L1.isEmpty(), L2.isEmpty());
            }
            else if (operationNumber == 6)
            {
                //get
                int index = StdRandom.uniform(0, 5);
                assertEquals(L1.get(index), L2.get(index));
            }
            else if (operationNumber == 7)
            {
                //getRecursive
                int index = StdRandom.uniform(0, 5);
                assertEquals(L1.getRecursive(index), L2.get(index));
            }
        }
    }
}
