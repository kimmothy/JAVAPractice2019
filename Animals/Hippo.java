package Animals;

public class Hippo extends Animal {
    @Override
    public void makeNoise(){
        System.out.println("Hippo makes a noise. 'hipo hipo!");
    }
    @Override
    public void eat(){
        System.out.println("cat eats plants");
    }
    @Override
    public void roam(){
        System.out.println("Hippo roams around the river");
    }
}
