package practice;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
 
public class BorderLayoutEx extends JFrame {
 
    public BorderLayoutEx() {
        setTitle("FlowLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        
        contentPane.setLayout(new BorderLayout(30, 20));
        
        contentPane.add(new JButton("버튼 1"), BorderLayout.CENTER);
        contentPane.add(new JButton("버튼 2"), BorderLayout.NORTH);
        contentPane.add(new JButton("버튼 3"), BorderLayout.SOUTH);
        contentPane.add(new JButton("버튼 4"), BorderLayout.EAST);
        contentPane.add(new JButton("버튼 5"), BorderLayout.WEST);
        
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BorderLayoutEx();
 
    }
}
