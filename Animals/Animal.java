package Animals;

public abstract class Animal {
    private boolean hunger = true;

    public abstract void makeNoise();
    public abstract void eat();
    public abstract void roam();
    public void sleep(){
        System.out.println("Your pet sleeps quietly");
    }

    public boolean isHunger() {
        return hunger;
    }
    public void beFull(boolean h){
        this.hunger = h;
    }
}
