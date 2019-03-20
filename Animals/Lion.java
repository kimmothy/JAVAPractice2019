package Animals;

public class Lion extends Canine {
    public int age = 3;
    @Override
    public void makeNoise(){
        System.out.println("lion makes a noise. 'eohung!' ");
    }
    @Override
    public void eat(){
        System.out.println("Lion eats a zebra");
    }
}
