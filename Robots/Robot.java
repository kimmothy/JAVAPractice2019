package Robots;

public abstract class Robot {
    private int voltage;

    public Robot(int voltage){
        this.voltage = voltage;
    }
    public int getVoltage() {
        return voltage;
    }
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    public abstract void initiate();

}
