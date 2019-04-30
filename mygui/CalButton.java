package mygui;

import javax.swing.*;
// 계산기에서 계산을 담당하는 네개의 기호를 담당하기 위한 버튼 클래스이다. 열거형을 통해 각자의 계산을 구분한다
// 열거형의 각 상수는 사용자에게 표시돠기 계산식의 표시를 String 타입으로 갖는다.
public class CalButton extends JButton{
    public enum CalType  {PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), NONE(" ");
    private final String mark;
    CalType(String mark){
        this.mark = mark;
    }
        public String getMark() {
            return mark;
        }
    }
    private final CalType calType;

    public CalButton(CalType calType){
        super(calType.mark);
        this.calType = calType;
    }

    public CalType getCalType() {
        return calType;
    }
}
