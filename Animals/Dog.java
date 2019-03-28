package Animals;

import java.util.Iterator;

public class Dog  extends Canine implements Pet{
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

    @Override
    public void beFriendly(){
        System.out.println("dog licks your hair");
    }
    @Override
    public void play(){
        System.out.println("dog catches a ball and throws it again");
    }
}
