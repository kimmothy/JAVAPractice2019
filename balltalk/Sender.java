package balltalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import balltalk.Ball;
import balltalk.ClientMain;

public class Sender {
    JTextField[] textFields = new JTextField[4];
    JLabel[] labels = new JLabel[4];
    ClientMain client;
    public Sender(ClientMain cm){
        this.client=cm;
    }
    void go(){
        JFrame frame = new JFrame("Insert Ball Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,350);
        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());

        for (int i = 0; i < 4; i++){
            textFields[i] = new JTextField();
        }
        textFields[0].setText("1");
        textFields[1].setText("100");
        textFields[2].setText("0");
        textFields[3].setText("1");
        labels[0] = new JLabel("Color");
        labels[1] = new JLabel("Height");
        labels[2] = new JLabel("Move_x");
        labels[3] = new JLabel("Weight");
        GridBagConstraints[] gbc = new GridBagConstraints[15];
        for (int i = 0; i < 15; i++){
            gbc[i] = new GridBagConstraints();
            gbc[i].fill = GridBagConstraints.BOTH;
        }
        String[] howTo = new String[6];
        howTo[0] = "외계의 어느 행성에서는 공이 튀기는 모양으로 의사소통을 한다고 합니다." ;
        howTo[1] = "아래 값들을 통해 공 메시지를 보내보세요 각 값은 정수로 입력하셔야 합니다.";
        howTo[2] = "Color는 1: 시안, 2: 마젠타, 3: 노란색, 4: 까만색, 5: 초록색, 6: 빨간색, 7: 파랑색 입니다.";
        howTo[3] = "Height는 공의 최대 높이를 나타냅니다. 400 이하의 자연수를 입력해주십시오.";
        howTo[4] = "Move_x는 공이 x축으로 이동하는 속도입니다. -10과 10 사이의 정수가 적합합니다.";
        howTo[5] = "Weight는 공이 떨어지는 속도 입니다. 5 이하의 자연수가 적합합니다.";
        for (int i = 0; i < 6; i++){
            gbc[i].gridx=0;
            gbc[i].gridy=i;
            gbc[i].gridwidth=5;
            gbc[i].weighty = 1;
            pane.add(new JLabel(howTo[i]), gbc[i]);
        }
        for (int i = 0; i < 4; i++){
            gbc[i+6].gridx = i;
            gbc[i+6].gridy = 6;
            gbc[i+6].weightx = 1;
            gbc[i+6].weighty = 3;
            pane.add(labels[i], gbc[i+6]);
        }
        for (int i = 0; i < 4; i++){
            gbc[i+10].gridx = i;
            gbc[i+10].gridy = 7;
            gbc[i+10].weightx = 1;
            gbc[i+10].weighty = 3;
            pane.add(textFields[i], gbc[i+10]);
        }
        gbc[14].gridx = 4;
        gbc[14].gridy = 6;
        gbc[14].gridheight = 2;
        gbc[14].weightx = 1;
        pane.add(new SendButton(), gbc[14]);
        frame.setVisible(true);
    }

    public class SendButton extends JButton {
        private ActionListener al = e -> {
            int color = Integer.parseInt(textFields[0].getText());
            int maxHeight = Integer.parseInt(textFields[1].getText());
            int movex = Integer.parseInt(textFields[2].getText());
            int weight = Integer.parseInt(textFields[3].getText());
            textFields[0].setText("1");
            textFields[1].setText("100");
            textFields[2].setText("0");
            textFields[3].setText("1");
            Ball b = new Ball(color, maxHeight, movex, weight);
            client.sendBall(b);
        };
        public SendButton(){
            super("Send");
            this.addActionListener(al);
        }
    }
}
