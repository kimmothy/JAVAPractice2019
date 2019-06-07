package balltalk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Receiver implements Runnable {
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    Color[] colors = {Color.CYAN,Color.MAGENTA,Color.YELLOW, Color.BLACK, Color.GREEN, Color.RED, Color.BLUE};
    public void add(Ball b){
        balls.add(b);
        if (balls.size() > 5){
            balls.remove(0);
        }
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("Ball Messages");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Receiver.MyDrawPanel drawPanel = new Receiver.MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(500, 400);
        frame.setVisible(true);
        while (true) {
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    class MyDrawPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            for (Ball b: balls){
                b.move();
                int position_x =b.getPosition_x();
                int position_y =b.getPosition_y();
                int color = b.getColor();
                g.setColor(colors[color-1]);
                g.fillOval(position_x,(330-position_y),30,30);
            }

        }
    }
}