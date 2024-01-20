import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private void unDisable()
	{
		this.setVisible(false);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,135,960,540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainClassTitle = new JLabel("RESTORAN YONETIM SISTEMI");
		mainClassTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainClassTitle.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		mainClassTitle.setBounds(153, 10, 671, 59);
		contentPane.add(mainClassTitle);
		
		JButton btn1 = new JButton("Problem1");
		btn1.setToolTipText("Problem 1\r\n");
		btn1.setBackground(new Color(224, 255, 255));
		btn1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btn1.setFocusPainted(false);
	    btn1.setBorderPainted(false);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			        Problem1Page p1Page = new Problem1Page();
			        unDisable();   			
			}
			
		});
		btn1.setBounds(254, 252, 168, 59);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Problem2");
		btn2.setToolTipText("Problem 2\r\n");
		btn2.setBackground(new Color(224, 255, 255));
		btn2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(false);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 Problem2Page p2Page = new Problem2Page();
			        unDisable();  
			}
			
		});
		btn2.setBounds(574, 252, 168, 59);
		contentPane.add(btn2);
		this.setVisible(true);
	}
}
