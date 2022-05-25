package practice;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
 
public class BorderLayoutEx extends JFrame {
 
    public BorderLayoutEx() {
        setTitle("FlowLayout ����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        
        contentPane.setLayout(new BorderLayout(30, 20));
        
        contentPane.add(new JButton("��ư 1"), BorderLayout.CENTER);
        contentPane.add(new JButton("��ư 2"), BorderLayout.NORTH);
        contentPane.add(new JButton("��ư 3"), BorderLayout.SOUTH);
        contentPane.add(new JButton("��ư 4"), BorderLayout.EAST);
        contentPane.add(new JButton("��ư 5"), BorderLayout.WEST);
        
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BorderLayoutEx();
 
    }
}
