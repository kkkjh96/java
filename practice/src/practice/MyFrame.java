package practice;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame  {
	//������
	public MyFrame() {
		setSize(500, 400);//ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ڹ�B�� GUI");
		
		setLayout(new FlowLayout());//��ġ ������ ����
		JButton button = new JButton("Hello Java");
		
		//������Ʈ ���� �� �߰�
		this.add(button);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
