package Animals;

public class Wolf extends Canine {
    @Override
    public void makeNoise(){
        System.out.println("wolf makes a noise. 'awooo!' ");
    }
    @Override
    public void eat(){
        System.out.println("wolf eats a fresh meat");
    }
}

