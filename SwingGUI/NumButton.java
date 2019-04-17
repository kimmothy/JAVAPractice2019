package SwingGUI;

import javax.swing.*;

public class NumButton extends JButton {
    private final int num;
    public NumButton(int n){
        super(""+n);
        this.num = n;
    }
    int getNum(){
        return num;
    }
}
