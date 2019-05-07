package mygui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorLauncher {
    /*
    enum OperType은 계산기가 계산할 예정인 수식을 알 수 있게 하기 위한 열거형이다.
    currentNum은 사용자가 입력하는 수
    previousNum은 입력되어있는 수
    memoryNum은 따로 저장되어 사용자가 원할 때 활용할 수 있는 수
    operator는 열거형인 OperType의 변수로 수행에 필요한 변수이다.
    afterDot은 소수점 아래로 내려갈때 몇번째 자리인지 담당한다.
    아래의 세개의 ~Print는 위 변수들의 정보를 사용자에게 출력한다.
     */
    public enum OperType {PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), NONE(" ");
        private final String mark;
        OperType(String mark){
            this.mark = mark;
        }
        public String getMark() {
            return mark;
        }
    }
    private double memoryNum = 0;
    private double previousNum = 0;
    private double currentNum = 0;
    private CalculatorLauncher.OperType operator = CalculatorLauncher.OperType.NONE;
    private int afterDot = 0;
    private JLabel memoryPrint = new JLabel("Memory:   " + memoryNum + "                              ");
    private JLabel previousPrint = new JLabel(previousNum + "          "+this.operator.getMark());
    private JLabel currentPrint = new JLabel(""+currentNum);

    //변경된 수치에 맞춰 라벨을 수정하는 함수
    private void updateLabels(){
        memoryPrint.setText("Memory:   " + memoryNum + "                              ");
        previousPrint.setText(previousNum + "          "+this.operator.getMark());
        currentPrint.setText(""+currentNum);
    }
    //기초적인 계산을 담당하는 함수
    private double calculate(){
        double tmp = 4;
        if (this.operator == CalculatorLauncher.OperType.NONE & currentNum == 0){
            tmp = previousNum;
        } else if (this.operator == CalculatorLauncher.OperType.NONE & currentNum != 0){
            tmp = currentNum;
        } else if (this.operator == CalculatorLauncher.OperType.PLUS){
            tmp = previousNum + currentNum;
        } else if (this.operator == CalculatorLauncher.OperType.MINUS){
            tmp = previousNum - currentNum;
        } else if (this.operator == CalculatorLauncher.OperType.MULTIPLY){
            tmp = previousNum * currentNum;
        } else if (this.operator == CalculatorLauncher.OperType.DIVIDE){
            tmp = previousNum / currentNum;
        }
        currentNum = 0;
        this.operator = CalculatorLauncher.OperType.NONE;
        afterDot = 0;

        return tmp;
    }

    private void go(String title) {
        /*계산기의 기본적인 설정과 배치
        프레임의 큰 판은 보더 레이아웃으로 위에는 라벨 패널 아래는 버튼 패널을 둔다.
         */
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,350);
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        JPanel labelPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        pane.add(labelPanel, "North");
        pane.add(buttonPanel, "South");
        labelPanel.setSize(300, 50);
        buttonPanel.setSize(300, 300);
        labelPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridBagLayout());

        /*라벨의 위치와 크기를 정한다.
        라벨 패널은 보더레이아웃으로 작동한다
         */
        memoryPrint.setSize(100, 50);
        previousPrint.setSize(100, 50);
        currentPrint.setSize(100,50);
        labelPanel.add(memoryPrint, "West");
        labelPanel.add(previousPrint, "Center");
        labelPanel.add(currentPrint, "East");

        /*
        +,-,*,/ 네가지 계산식의 리스너. 이전 계산의 결과에 이어서 계산할 경우, 연속해서 계산 명령을 내릴 경우를 고려한다.

        첫번째 조건은 이미 계산된 값이 previdousNum에 저장되어있고 그 수에 이어서 계산할 경우를 위한 것
        두번째 경우는 기존 계산의 결과와 상관없이 새로운 계산을 할 경우이다. 기존 계산이 없어도 이 부분이 수행된다.
        세번쨰 경우는 5+4*2/6 이런 식으로 계속해서 계산하려고 하는 경우이다. 계산 유형에 상관 없이 입력 순서대로 계산 된다.
        */


        /*
        각 버튼을 만들고 자리를 설정핸다.
        버튼 패널은 GridBackLayout을 사용하며 이에따라 GridBackConstraint를 통해 자리를 배치한다.
        먼저 버튼의 배열과 GridBackConstraint의 배열을 같은 크기로 정의하여 순서에 맞게 버튼과 GBC를 채워넣는다.
        각 버튼이 정의되면 뒤에서 각 배열 번호대로 패널에 넣는다.
         */
        JButton[] buttons = new JButton[23];
        GridBagConstraints[] gbc = new GridBagConstraints[23];
        //모든 버튼에 적용되야할 설정이다.
        for (int i = 0; i<=22; i++){
            gbc[i] = new GridBagConstraints();
            gbc[i].weightx = 1;
            gbc[i].weighty = 1;
            gbc[i].fill = GridBagConstraints.BOTH;
        }
        buttons[0] = new NumButton(0);
        gbc[0].gridx = 2;
        gbc[0].gridy = 5;
        //0을 제외한 NumButton은 각자의 숫자와 위치에 규칙이 있어서 반복문을 통해 짧게 생성한다.
        for (int i = 1; i <= 9; i++) {
            buttons[i] = new NumButton(i);
            gbc[i].gridx = (i - 1) % 3 + 2;
            gbc[i].gridy = 4 - ((i - 1) / 3);
        }
        //CalButton은 따로 생성하되 자리 배치는 반복문으로 간결하게 한다.
        buttons[10] = new OperButton(CalculatorLauncher.OperType.PLUS);
        buttons[11] = new OperButton(CalculatorLauncher.OperType.MINUS);
        buttons[12] = new OperButton(CalculatorLauncher.OperType.MULTIPLY);
        buttons[13] = new OperButton(CalculatorLauncher.OperType.DIVIDE);
        for (int i = 1; i <= 4; i++) {
            gbc[9 + i].gridx = 5;
            gbc[9 + i].gridy = i;
        }
        //소수점이하 수를 입력하기 위한 버튼이다. afterDot 변수는 NumButton의 리스너에서 활용된다.
        //만약 이미 소수점 이하일 떄 이 버튼을 누르면 아무 일도 일어나지 않는다.
        buttons[14] = new JButton(". ");
        gbc[14].gridx = 3;
        gbc[14].gridy = 5;
        buttons[14].addActionListener(e -> {
            if (afterDot == 0) {
                afterDot = 1;
            }
        });
        //다른 작업을 하지 않고 계산을 수행하는 equal 버튼이다.
        buttons[15] = new JButton("=");
        buttons[15].addActionListener(e -> {
            previousNum = calculate();
            updateLabels();
        });
        gbc[15].gridx = 4;
        gbc[15].gridy = 5;
        gbc[15].gridwidth = 2;
        gbc[15].fill = GridBagConstraints.BOTH;
        //모든 값을 제거하는 clear 버튼
        buttons[16] = new JButton("clear");
        buttons[16].addActionListener(e -> {
            previousNum = 0;
            currentNum = 0;
            memoryNum = 0;
            this.operator = CalculatorLauncher.OperType.NONE;
            updateLabels();
        });
        gbc[16].gridx = 2;
        gbc[16].gridy = 1;
        gbc[16].gridwidth = 2;
        //sqrt는 squar root 제곱근을 말한다. 계산을 수행하고 그 값의 제곱근을 구해준다.
        buttons[17] = new JButton("sqrt");
        buttons[17].addActionListener(e -> {
            previousNum = Math.sqrt(calculate());
            updateLabels();
        });
        gbc[17].gridx = 4;
        gbc[17].gridy = 1;

        /*이 이하 다섯개의 버튼은 메모리 관리를 위한 버튼이다.
        MS: Memory save 현재 계산을 수행해 메모리에 저장한다
        M+: Memory plus 현재 계산을 수행하여 메모리에 저장된 값에 더한다
        M-: Memory minus 현재 계산을 수행하여 메모리에 저장된 값에 뺀다.
        MR: Memory read 메모리에 저장된 값을 읽어온다.
        MC: Memory clear 메모리에 저장된 값을 삭제한다.
        각각 설정하고 리스너를 붙인 다음 위치 조정은 반복문으로 한번에 한다.
         */
        buttons[18] = new JButton("MS");
        buttons[18].addActionListener(e -> {
            memoryNum = calculate();
            previousNum = 0;
            updateLabels();
        });
        buttons[19] = new JButton("M+");
        buttons[19].addActionListener(e -> {
            memoryNum += calculate();
            previousNum = 0;
            updateLabels();
        });
        buttons[20] = new JButton("M-");
        buttons[20].addActionListener(e -> {
            memoryNum -= calculate();
            previousNum = 0;
            updateLabels();
        });
        buttons[21] = new JButton("MR");
        buttons[21].addActionListener(e -> {
            previousNum = memoryNum;
            currentNum = 0;
            updateLabels();
        });
        buttons[22] = new JButton("MC");
        buttons[22].addActionListener(e -> {
            memoryNum = 0;
            updateLabels();
        });

        for (int i = 1; i <= 5; i++) {
            gbc[17 + i].gridx = 1;
            gbc[17 + i].gridy = i;
        }
        //설정된 버튼과 GridBackConstraint의 배열에서 하나씩 값을 불러와, 패널에 채워 넣는다.
        for (int i = 0; i <= 22; i++) {
            buttonPanel.add(buttons[i], gbc[i]);
        }
        frame.setVisible(true);
    }
    public static void main(String[] arg){
        CalculatorLauncher button2 = new CalculatorLauncher();
        button2.go("Calculator");
    }

    public class OperButton extends JButton{
        private final OperType operType;
        ActionListener opListner = e -> {
            OperButton b = (OperButton) e.getSource();
            if ((operator == CalculatorLauncher.OperType.NONE) & (currentNum == 0)) {
                //여기선 아무것도 하지 않는다. 뒤에 다른 두 조건의 동작을 발동시키지 않기 위해 둔 조건
                //
            } else if ((operator == CalculatorLauncher.OperType.NONE) & (currentNum != 0)) {
                previousNum = calculate();
                System.out.println(previousNum);
            } else if (operator != CalculatorLauncher.OperType.NONE) {
                previousNum = calculate();
                System.out.println(operator.getMark());
            }
            operator = b.getOperType();
            updateLabels();


        };

        public OperButton(OperType operType){
            super(operType.mark);
            this.operType = operType;
            this.addActionListener(opListner);
        }

        public OperType getOperType() {
            return operType;
        }
    }



    public class NumButton extends JButton {
        private final int num;
        /*숫자 버튼과 계산 버튼의 리스너를 미리 람다로 정의한다.
        숫자버튼의 경우 버튼에서 수를 불러오고 소수이하 여부에 따라 다르게 적용한다.
        소수점 이하 자리수(afterDot)가 0이라면 기존의 수에 10을 곱하고 새 수를 더한다.('.'버튼을 눌러야 이 변수가 1이 된다.)
        afterDot이 1 이상이면 그 수만큼 10을 제곱한다. 해당 수에 새로 입력한 수를 곱해 기존의 수에 더한다.
        */
        ActionListener numListener = e -> {

            NumButton b = (NumButton) e.getSource();
            int num = b.getNum();
            if (afterDot == 0) {
                currentNum = currentNum * 10 + num;
            } else {
                double dividingNum = Math.pow(10,afterDot);
                currentNum += num/dividingNum;
                afterDot += 1;
            }

            System.out.println(num^2);
            updateLabels();
        };
        public NumButton(int n){
            super(""+n);
            this.num = n;
            this.addActionListener(numListener);
        }
        int getNum(){
            return num;
        }
    }
}
