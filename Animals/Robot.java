package Animals;

public class Robot {
    private int voltage;
    private String name;

    public int getVoltage() {
        return voltage;
    }
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void initiate(){
        System.out.println(this.getClass().getSimpleName()+this.name+"started operation");
    }
}
