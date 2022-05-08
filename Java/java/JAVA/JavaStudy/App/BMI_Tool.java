package Data;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BMI_Tool extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFrame frmBmi;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					BMI_Tool window = new BMI_Tool();
					window.frmBmi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMI_Tool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBmi = new JFrame();
		frmBmi.setTitle("BMI");
		frmBmi.setType(Type.UTILITY);
		frmBmi.setAutoRequestFocus(false);
		frmBmi.setBounds(100, 100, 648, 436);
		frmBmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBmi.getContentPane().setLayout(null);
		
		JLabel lblBmi = new JLabel("\u0042\u004d\u0049\u8a08\u7b97");
		lblBmi.setFont(new Font("新細明體", Font.PLAIN, 44));
		lblBmi.setHorizontalAlignment(SwingConstants.CENTER);
		lblBmi.setBounds(60, 58, 513, 64);
		frmBmi.getContentPane().add(lblBmi);
		
		JTextPane textHeight = new JTextPane();
		textHeight.setFont(new Font("新細明體", Font.PLAIN, 30));
		textHeight.setText("456");
		textHeight.setBounds(154, 173, 407, 50);
		textHeight.setToolTipText("");
		frmBmi.getContentPane().add(textHeight);
		
		JTextPane textWeight = new JTextPane();
		textWeight.setFont(new Font("新細明體", Font.PLAIN, 30));
		textWeight.setText("123");
		textWeight.setBounds(154, 247, 407, 50);
		textWeight.setToolTipText("");
		frmBmi.getContentPane().add(textWeight);
		
		JButton buttonSubmit = new JButton("送出");
		buttonSubmit.setFont(new Font("新細明體", Font.PLAIN, 20));
		buttonSubmit.setBounds(471, 325, 102, 36);
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frmBmi.getContentPane().add(buttonSubmit);
		
		JLabel lblNewLabel = new JLabel("身高:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 30));
		lblNewLabel.setBounds(60, 173, 84, 50);
		frmBmi.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("體重:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 247, 84, 50);
		frmBmi.getContentPane().add(lblNewLabel_1);
	}
}
