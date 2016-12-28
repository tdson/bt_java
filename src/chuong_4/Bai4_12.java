package chuong_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Bai4_12 extends JFrame implements ActionListener {
	private JButton btRed, btGreen, btBlue, btExit;
	private JPanel p, p2;
	
	public Bai4_12(String title) {
		p = new JPanel();
		p2 = new JPanel();
		p.setLayout(new BorderLayout());
		p2.setLayout(new FlowLayout());
		
		btRed = new JButton("Red");
		btGreen = new JButton("Green");
		btBlue = new JButton("Blue");
		btExit = new JButton("Exit");
		
		btRed.addActionListener(this);
		btBlue.addActionListener(this);
		btGreen.addActionListener(this);
		btExit.addActionListener(this);
		
		p2.add(btRed);
		p2.add(btBlue);
		p2.add(btGreen);
		p2.add(btExit);

		//p2.setAlignmentX(JPanel.BOTTOM_ALIGNMENT);
		
		
		add(p, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		//add(p2);
		
		setBounds(500, 300, 640, 480);
		//setSize(640, 480);
		setLocationByPlatform(true);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Bai4_12("Đổi màu nền");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btExit))
			System.exit(0);

		if(e.getSource().equals(btRed)){
			p.setBackground(Color.RED);
			p2.setBackground(Color.RED);
		}
		
		if(e.getSource().equals(btBlue)) {
			p.setBackground(Color.BLUE);
			p2.setBackground(Color.BLUE);
		}
		
		if(e.getSource().equals(btGreen)) {
			p.setBackground(Color.GREEN);
			p2.setBackground(Color.GREEN);
		}
	}
}
