package mygui;

import javax.swing.*;
//계산기에서 숫자를 담당하는 10개의 버튼을 따로 정의하기 위한 클래스이다. 생성시 int값을 받으며 텍스트는 해당 int대로 설정된다.
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
