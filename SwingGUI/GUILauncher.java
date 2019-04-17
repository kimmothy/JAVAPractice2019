package SwingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUILauncher{
    private static String labelPrefixA = "Number:";
    private int numInput = 0;
    JLabel cal = new JLabel(labelPrefixA + "0");

    public void go(String title){
        JFrame frame = new JFrame(title);
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(cal,"North");
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(3,3));
        ActionListener AL = e->{
            NumButton b = (NumButton)e.getSource();
            int num = b.getNum();
            numInput = numInput*10+num;
            cal.setText(labelPrefixA + numInput);
        };
        for (int i =1;i<=9;i++){
            NumButton nb = new NumButton(i);
            nb.addActionListener(AL);
            jpanel.add(nb);
        }
        pane.add(jpanel,"Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setVisible(true);
    }

    public static void main(String[] arg){
        GUILauncher button2 = new GUILauncher();
        button2.go("Event handling");

    }
}
