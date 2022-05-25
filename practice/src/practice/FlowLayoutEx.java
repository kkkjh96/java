package practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 
public class FlowLayoutEx extends JFrame {
 
    public FlowLayoutEx() {
        setTitle("FlowLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.yellow);
        
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 50));
        
        contentPane.add(new JButton("버튼 1"));
        contentPane.add(new JLabel("Hello World"));
        contentPane.add(new JTextField(20));
        contentPane.add(new JCheckBox("체크"));
        contentPane.add(new JRadioButton("Radio"));
        contentPane.add(new JComboBox());
        contentPane.add(new JPasswordField(10));
        
        setSize(600, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FlowLayoutEx();
 
    }
}
 