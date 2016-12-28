package chuong_4;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Bai4_13 extends JFrame implements ActionListener, ItemListener {
	private ButtonGroup gt;
	private JRadioButton male, female;
	private List os;
	private Choice type;
	private JLabel mes;
	private JPanel p, p1, p2;
	private JButton btExit;

	public Bai4_13(String title) {
		super(title);
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p.setLayout(new FlowLayout());
		p2.setLayout(new GridLayout(1, 2));
		gt = new ButtonGroup();
		male = new JRadioButton("Male", true);
		female = new JRadioButton("Female", false);
		gt.add(male);
		gt.add(female);

		os = new List(3);
		os.add("MS DOS");
		os.add("WINDOWS");
		os.add("LINUX");
		os.add("UNIX");

		type = new Choice();
		type.addItem("Tiger");
		type.addItem("Lion");
		type.addItem("Monkey");

		mes = new JLabel("The item is displayed here...");
		// mes.setBounds(0, 0, 200, 20);

		btExit = new JButton("Exit");
		//btExit.setBounds(0, 202, 28, 20);
		btExit.addActionListener(this);
		male.addItemListener(this);
		female.addItemListener(this);
		os.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				mes.setText(os.getSelectedItem() + " is selected.");

			}
		});
		type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				mes.setText(type.getSelectedItem() + " is selected.");
			}
		});

		p2.add(male);
		p2.add(female);
		p.add(p2);
		p.add(os);
		p.add(type);
		p.add(mes);
		p.add(btExit);
		p.add(p1);
		add(p);
		setVisible(true);
		setBounds(200, 100, 230, 220);
		// setResizable(false);
	}

	public static void main(String[] args) {
		new Bai4_13("Item Event");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (male.isSelected())
			mes.setText("Male is selected.");
		if (female.isSelected())
			mes.setText("Female is selected.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}

	}
}
