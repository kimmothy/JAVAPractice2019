package Animals;

public class Dog  extends Canine {
    @Override
    public void makeNoise(){
        System.out.println("dog makes a noise. 'Wang Wang!' ");
    }
    @Override
    public void eat(){
        System.out.println("dog eats a bone");
    }
}
