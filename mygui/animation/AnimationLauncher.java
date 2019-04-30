package mygui.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationLauncher {
    int x = 70;
    int y = 70;
    Color[] colors = {Color.CYAN,Color.MAGENTA,Color.YELLOW};
    int timePoint = 0;

    public void go(){
        JFrame frame = new JFrame();
        frame.setTitle("Box is free");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
        for (;;){
            x++;
            if (x>=240){
                x = 0;
            }
            y+=2;
            if (y>=260){
                y = 0;
            }
            timePoint++;
            drawPanel.repaint();
            try{
                Thread.sleep(50);
            } catch (Exception ex){}
        }
    }
    public static void main(String[] arg){
        AnimationLauncher launcher = new AnimationLauncher();
        launcher.go();
    }
    class MyDrawPanel extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            int i = timePoint/10%3;
            g.setColor(colors[i]);
            g.fillRect(x,y,60,40);
        }
    }

}
