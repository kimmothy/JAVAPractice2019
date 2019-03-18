package Animals;

public abstract class Animal {
    public abstract void makeNoise();
    public abstract void eat();
    public abstract void roam();
    public void sleep(){
        System.out.println("Your pet sleeps quietly");
    };
}
