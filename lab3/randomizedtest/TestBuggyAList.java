package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove()
    {
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        L1.addLast(4);
        L1.addLast(5);
        L1.addLast(6);

        L2.addLast(4);
        L2.addLast(5);
        L2.addLast(6);

        assertEquals(L1.size(), L2.size());

        assertEquals(L1.removeLast(), L2.removeLast());
        assertEquals(L1.removeLast(), L2.removeLast());
        assertEquals(L1.removeLast(), L2.removeLast());
    }

    @Test
    public void randomizedTest()
    {
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                assertEquals(L1.size(), L2.size());
            }
            else if (operationNumber == 2)
            {
                int size = L1.size();
                // getLast
                if (size <= 0)
                {
                    continue;
                }
                else
                {
                    assertEquals(L1.getLast(), L2.getLast());
                }
            }
            else if (operationNumber == 3)
            {
                int size = L1.size();
                // removeLast
                if (size <= 0)
                {
                    continue;
                }
                else
                {
                    assertEquals(L1.removeLast(), L2.removeLast());
                }
            }
        }
    }
}
