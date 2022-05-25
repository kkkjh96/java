package practice;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame  {
	//생성자
	public MyFrame() {
		setSize(500, 400);//크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("자바B반 GUI");
		
		setLayout(new FlowLayout());//배치 관리자 설정
		JButton button = new JButton("Hello Java");
		
		//컴포넌트 생성 및 추가
		this.add(button);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
