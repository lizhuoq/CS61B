package deque;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;

public class MaxArrayDequeTest
{
    private class Dog implements Comparable<Dog>
    {
        private String name;
        private int size;

        public Dog(String n, int s)
        {
            name = n;
            size = s;
        }

        public static class NameComparator implements Comparator<Dog>
        {
            public int compare(Dog d1, Dog d2)
            {
                return d1.name.compareTo(d2.name);
            }
        }

        public static class SizeComparator implements Comparator<Dog>
        {
            public int compare(Dog d1, Dog d2)
            {
                return d1.compareTo(d2);
            }
        }

        @Override
        public int compareTo(Dog otherDog)
        {
            return size - otherDog.size;
        }
    }

    @Test
    public void maxNoArgumentSizeTest()
    {
        Comparator<Dog> sizeComparator = new Dog.SizeComparator();
        MaxArrayDeque<Dog> dogs = new MaxArrayDeque<>(sizeComparator);
        dogs.addLast(new Dog("Bary", 10));
        dogs.addFirst(new Dog("Charly", 100));
        dogs.addLast(new Dog("Lily", 200));
        dogs.addLast(new Dog("Windows", 20));
        dogs.addLast(new Dog("Tom", 150));
        Dog maxDog = dogs.max();
        assertEquals("Lily", maxDog.name);
    }

    @Test
    public void maxNoArgumentNameTest()
    {
        Comparator<Dog> nameComparator = new Dog.NameComparator();
        MaxArrayDeque<Dog> dogs = new MaxArrayDeque<>(nameComparator);
        dogs.addLast(new Dog("Bary", 10));
        dogs.addFirst(new Dog("Charly", 100));
        dogs.addLast(new Dog("Lily", 200));
        dogs.addLast(new Dog("Windows", 20));
        dogs.addLast(new Dog("Tom", 150));
        Dog maxDog = dogs.max();
        assertEquals("Windows", maxDog.name);
    }

    @Test
    public void maxSizeTest()
    {
        Comparator<Dog> sizeComparator = new Dog.SizeComparator();
        Comparator<Dog> nameComparator = new Dog.NameComparator();
        MaxArrayDeque<Dog> dogs = new MaxArrayDeque<>(nameComparator);
        dogs.addLast(new Dog("Bary", 10));
        dogs.addFirst(new Dog("Charly", 100));
        dogs.addLast(new Dog("Lily", 200));
        dogs.addLast(new Dog("Windows", 20));
        dogs.addLast(new Dog("Tom", 150));
        Dog maxDog = dogs.max(sizeComparator);
        assertEquals("Lily", maxDog.name);
    }

    @Test
    public void maxNameTest()
    {
        Comparator<Dog> sizeComparator = new Dog.SizeComparator();
        Comparator<Dog> nameComparator = new Dog.NameComparator();
        MaxArrayDeque<Dog> dogs = new MaxArrayDeque<>(sizeComparator);
        dogs.addLast(new Dog("Bary", 10));
        dogs.addFirst(new Dog("Charly", 100));
        dogs.addLast(new Dog("Lily", 200));
        dogs.addLast(new Dog("Windows", 20));
        dogs.addLast(new Dog("Tom", 150));
        Dog maxDog = dogs.max(nameComparator);
        assertEquals("Windows", maxDog.name);
    }
}
