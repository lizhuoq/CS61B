import java.util.Dictionary;

public class DogLauncher
{
    public static void main(String[] args)
    {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Bejamin", 15);
        Dog[] dogs = new Dog[]{d1, d2, d3};

        Dog d = (Dog) Maximizer.max(dogs);
        System.out.println(d.name);

        Comparator<Dog> nc= new Dog.NameComparator();
        if (nc.compare(d2, d3) > 0)
        {
            d2.bark();
        }
        else
        {
            d3.bark();
        }

        Comparator<Dog> sc = new Dog.SizeComparator();
        if (sc.compare(d2, d3) > 0)
        {
            d2.bark();
        }
        else
        {
            d3.bark();
        }
    }
}
