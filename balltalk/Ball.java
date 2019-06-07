package balltalk;


import java.io.Serializable;
import java.util.Random;

public class Ball implements Serializable {
    private int color;
    private int position_x;
    private int position_y;
    private int weight;
    private int move_x;
    private int move_y;
    private int leftOver;
    private int interval;
    private int time;

    public Ball(int c, int maxHeight, int mx, int weight){
        this.color = c;
        this.position_x = new Random().nextInt(500);
        this.position_y = maxHeight;
        this.move_x = mx;
        this.move_y=0;
        this.weight =weight;
        this.time = 0;
        int num1 = 1;
        int num2 = maxHeight;
        while(true){
            num2 = num2 - num1*weight;
            num1++;
            if (num2 < num1*weight){
                this.leftOver = num2;
                this.interval = (num1-1)*2;
                break;
            }
        }
    }

    public int getColor() {
        return color;
    }

    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    private void changeAcceleration(){
        time += 1;
        if(time < interval/2){
            move_y = -time*weight;
        } else if (time == interval/2){
            move_y = -(time*weight + leftOver);
        } else if (time == interval/2 + 1){
            move_y = (time-1)*weight + leftOver;
        } else if (time > interval/2 + 1){
            move_y = (interval - time + 1)*weight;
        }
        if (time == interval){
            time = 0;
        }
    }
    public void move(){
        this.position_x = position_x + move_x;
        this.position_y = position_y + move_y;
        if (this.position_x >= 500) {
            this.position_x = 0;
        } else if (this.position_x <= 0){
            this.position_x = 500;
        }
        this.changeAcceleration();
    }
}