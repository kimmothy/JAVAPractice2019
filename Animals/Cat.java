package Animals;

public class Cat extends Feiline implements Pet{
    @Override
    public void makeNoise(){
        System.out.println("cat makes a noise. 'miyao' ");
    }
    @Override
    public void eat(){
        System.out.println("cat eats a fish");
    }

    @Override
    public void beFriendly(){
        System.out.println("cat punches your face");
    }
    @Override
    public void play(){
        System.out.println("cat punches your leg");
    }
}
