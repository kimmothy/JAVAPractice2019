package Animals;

import java.util.Iterator;

public class Dog  extends Canine implements Comparable,Iterable{
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void makeNoise(){
        System.out.println("dog makes a noise. 'Wang Wang!' ");
    }
    @Override
    public void eat(){
        System.out.println("dog eats a bone");
    }

    public void bark(){
        System.out.println("bark like a dog");
    }
}
