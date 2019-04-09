package SwingGUI;

import javax.swing.*;
import java.awt.event.*;

public class GUILauncher{
    private static String labelPrefixA = "Number of buttonA clicks: ";
    private static String labelPrefixB = "Number of buttonB clicks: ";
    private int numClicksA = 0;
    private int numClicksB = 0;
    JLabel labelA = new JLabel(labelPrefixA + "0");
    JLabel labelB = new JLabel(labelPrefixB + "0");

    public void go(String title){
        JFrame frame = new JFrame(title);
        JButton buttonA = new JButton("Button A");
        JButton buttonB = new JButton("Button B");
        buttonA.addActionListener(e->{numClicksA+=1; labelA.setText(labelPrefixA+numClicksA);});
        buttonB.addActionListener(e->{numClicksB+=1; labelB.setText(labelPrefixB+numClicksB);});

        JPanel panel = new JPanel();
        panel.add(buttonA);
        panel.add(buttonB);
        panel.add(labelA);
        panel.add(labelB);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public static void main(String[] arg){
        GUILauncher button2 = new GUILauncher();
        button2.go("Event handling");

    }
}
