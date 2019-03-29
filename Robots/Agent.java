package Robots;

public class Agent extends Robot {
    private int serialNo;
    public Agent(int voltage, int serialNo){
        super(voltage);
        this.serialNo=serialNo;
    }
    @Override
    public void initiate(){
        System.out.println(this.getClass().getSimpleName()+this.serialNo+"started operation");
        System.out.println("The agent robot start protecting human");
    }
}
