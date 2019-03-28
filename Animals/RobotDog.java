package Animals;

public class RobotDog extends Robot implements Pet{
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
        super.initiate();
        System.out.println("This robot dog is your friend now");
    }
}
