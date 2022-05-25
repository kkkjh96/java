package practice;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerEx extends JFrame {
 
    
    public NullContainerEx() {
        setTitle("��ġ������ ���� ���� ��ġ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        
        JLabel la = new JLabel("Yoon's Dev!");
        la.setLocation(500, 350);
        la.setSize(200, 50);
        
        this.add(la);
        
        // 9���� ��ư ������Ʈ �����ϰ� ������ ũ��� ����, ��ġ�� ��ġ��
        for(int i=0; i<10; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setLocation(i*30, i*30);
            btn.setSize(100, 50);
            this.add(btn);
        }
        
        setSize(1000, 700);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new NullContainerEx();
    }
}