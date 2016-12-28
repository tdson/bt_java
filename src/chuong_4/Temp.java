package chuong_4;

import java.awt.*;
import javax.swing.*;

public class Temp extends Frame {
	private static final long serialVersionUID = 1L;

	void init() {
		makeUI();
		// addLsn();
	}

	void makeUI() {
		Temp mainFrame = new Temp();
		mainFrame.setBounds(300, 300, 400, 400);
		mainFrame.setTitle("Calculator");
		mainFrame.setLayout(new BorderLayout());

		// Menu bar
		MenuBar thanhMenu = new MenuBar();
		Menu file = new Menu("File");
		// MenuItem exit = new MenuItem("Exit");
		// file.add(exit);
		Menu view = new Menu("View");
		// MenuItem view1 = new MenuItem("Item view");
		// view.add(view1);
		Menu help = new Menu("Help");
		// MenuItem help1 = new MenuItem("Item help");
		// help.add(help1);
		thanhMenu.add(file);
		thanhMenu.add(view);
		thanhMenu.add(help);
		mainFrame.setMenuBar(thanhMenu);

		// Container ctn1
		// TextField
		JPanel tfPanel = new JPanel();
		TextField numberTf = new TextField(30);
		// numberTf.setSize(400, 50);
		tfPanel.setLayout(new BorderLayout());
		tfPanel.add(numberTf);
		mainFrame.add(tfPanel, BorderLayout.NORTH);

		// Buttons
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new BorderLayout());

		// /topPanel
		JPanel tPanel = new JPanel();
		tPanel.setLayout(new GridLayout(1, 4));
		tPanel.add(new JTextField());
		tPanel.add(new JButton("BackSpace"));
		tPanel.add(new JButton("CE"));
		tPanel.add(new JButton("C"));
		btnPanel.add(tPanel, BorderLayout.NORTH);

		// /bottomPanel
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(4, 6));
		bPanel.setSize(400, 320);
		String[] btnItem = { "MC", "7", "8", "9", "/", "sqrt", "MR", "4", "5",
				"6", "*", "%", "MS", "1", "2", "3", "-", "1/x", "M+", "0",
				"+/-", ".", "+", "=" };
		for (int i = 0; i < 24; i++)
			bPanel.add(new JButton(btnItem[i]));
		btnPanel.add(bPanel, BorderLayout.CENTER);
		mainFrame.add(btnPanel);
		mainFrame.setVisible(true);
	}

	public static void main(String[] args) {
		Temp dt = new Temp();
		dt.init();
	}
}
