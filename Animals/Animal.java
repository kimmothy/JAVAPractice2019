package Animals;

public abstract class Animal {
    private boolean hunger = true;
    private String food;

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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
