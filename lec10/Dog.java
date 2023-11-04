public class Dog implements Comparable<Dog>
{
    public String name;
    public int size;

    public Dog(String n, int s)
    {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog otherDog)
    {
        return size - otherDog.size;
    }

    public void bark()
    {
        System.out.println(name + " says: bark");
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
            return d1.size - d2.size;
        }
    }
}
