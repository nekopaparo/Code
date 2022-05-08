package data0609;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestJFrame extends JFrame {
	TestJFrame(){
		super("Hello");
		Container cp = getContentPane();
		JButton btn = new JButton("按鈕");
		cp.add(btn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
