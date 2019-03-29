package Robots;

import Animals.Pet;

public class RobotDog extends Robot implements Pet{
    private String name;
    public RobotDog(int voltage, String name){
        super(voltage);
        this.name = name;

    }
    @Override
    public void beFriendly(){
        System.out.println("Robot dog sing a sweet song. It's lyrics are 'bow wow'");
    }
    @Override
    public void play(){
        System.out.println("Robot dog runs. It makes electronic sounds");
    }
    @Override
    public void initiate(){
        System.out.println(this.getClass().getSimpleName()+" "+this.name+"started operation");
        System.out.println("This robot dog is your friend now");
    }
}
