package chuong_4;

import java.awt.*;
import java.awt.event.*;

import javax.script.*;
import javax.swing.*;

/* Bài calculator*/

public class Bai4_11 extends JFrame implements ActionListener {
	private JTextField display, bBlank;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDot, bMC, bMR,
			bMS, bMPlus, bBack, bCE, bC, bMsign, bPlus, bMinus, bMul, bDiv,
			bSqrt, bPercent, b1Per, bEqual;
	private JMenuBar m;
	private JMenu mEdit, mView, mHelp;
	private JMenuItem hAbout;
	private JPanel pButton;
	private final String INFO = "Simple Caculator\nVersion 1.2 by SonTD\nE-mail: sontd.it@gmail.com";

	public Bai4_11(String t) {
		super(t);

		// Put on the menubar and menu
		m = new JMenuBar();
		mEdit = new JMenu("Edit");
		m.add(mEdit);
		mView = new JMenu("View");
		m.add(mView);
		mHelp = new JMenu("Help");
		m.add(mHelp);
		hAbout = new JMenuItem("About");
		mHelp.add(hAbout);
		setJMenuBar(m);
		
		hAbout.addActionListener(this);

		// Dùng GridBag
		GridBagLayout layout = new GridBagLayout();
		pButton = new JPanel(layout);
		GridBagConstraints c = new GridBagConstraints();
		// buttons change size by both
		c.fill = GridBagConstraints.BOTH;

		// Ràng buộc khoảng cách quanh display
		c.insets = new Insets(3, 3, 10, 3);

		// Put on the display
		display = new JTextField();
		display.setFont(new Font("Tahoma", Font.BOLD, 20));
		display.setHorizontalAlignment(JTextField.RIGHT);
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 6;
		pButton.add(display, c);

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bDot = new JButton(".");
		bMC = new JButton("MC");
		bMR = new JButton("MR");
		bMS = new JButton("MS");
		bMPlus = new JButton("M+");
		bBack = new JButton("←"); // backspace
		bCE = new JButton("CE");
		bC = new JButton("C");
		bMsign = new JButton("-"); // negative numbers
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		bMul = new JButton("*");
		bDiv = new JButton("/");
		bSqrt = new JButton("√");
		bPercent = new JButton("%");
		b1Per = new JButton("1/x");
		bEqual = new JButton("=");
		bBlank = new JTextField();
		bBlank.setEditable(false);

		// Gắng ống nghe các button
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bDot.addActionListener(this);
		bMC.addActionListener(this);
		bMR.addActionListener(this);
		bMPlus.addActionListener(this);
		bBack.addActionListener(this);
		bCE.addActionListener(this);
		bC.addActionListener(this);
		bMsign.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bMul.addActionListener(this);
		bDiv.addActionListener(this);
		bSqrt.addActionListener(this);
		bPercent.addActionListener(this);
		b1Per.addActionListener(this);
		bEqual.addActionListener(this);

		// Ràng buộc khoảng cách xung quanh của bBlank
		c.insets = new Insets(3, 3, 7, 10);
		// Nút trắng
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bBlank, c);

		// 3 nút còn lại của hàng 1
		c.insets = new Insets(3, 3, 7, 3);

		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 2;
		pButton.add(bBack, c);

		c.gridx = 4;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 2;
		pButton.add(bCE, c);

		c.gridx = 6;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bC, c);

		// Cột 1, Nút thứ 2 trở đi
		c.insets = new Insets(3, 3, 3, 10);

		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMC, c);

		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMR, c);

		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMS, c);

		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMPlus, c);

		// Cột 2, Nút thứ 2 trở đi
		c.insets = new Insets(3, 3, 3, 3);

		c.gridx = 2;
		c.gridy = 3;
		//c.gridheight = 1;
		//c.gridwidth = 1;
		pButton.add(b7, c);

		c.gridx = 2;
		c.gridy = 4;
		//c.gridheight = 1;
		//c.gridwidth = 1;
		pButton.add(b4, c);

		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b1, c);

		c.gridx = 2;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b0, c);

		// Cột 3, Nút thứ 2 trở đi
		c.insets = new Insets(3, 3, 3, 3);

		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b8, c);

		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b5, c);

		c.gridx = 3;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b2, c);

		c.gridx = 3;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMsign, c);

		// Cột 4, Nút thứ 2 trở đi
		c.insets = new Insets(3, 3, 3, 3);

		c.gridx = 4;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b9, c);

		c.gridx = 4;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b6, c);

		c.gridx = 4;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b3, c);

		c.gridx = 4;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bDot, c);

		// Cột 5, Nút thứ 2 trở đi
		c.insets = new Insets(3, 3, 3, 3);

		c.gridx = 5;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bDiv, c);

		c.gridx = 5;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMul, c);

		c.gridx = 5;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bMinus, c);

		c.gridx = 5;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bPlus, c);

		// Cột 6, Nút thứ 2 trở đi
		c.insets = new Insets(3, 3, 3, 3);

		c.gridx = 6;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bSqrt, c);

		c.gridx = 6;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bPercent, c);

		c.gridx = 6;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(b1Per, c);

		c.gridx = 6;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		pButton.add(bEqual, c);

		add(pButton, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(330, 280);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch (Integer.parseInt(e.getActionCommand())) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				addLetter(e, display);
				break;
			}

		} catch (NumberFormatException E) {
			System.out.println("Nút này chưa xử lý.");
		}
		if (e.getSource().equals(bPlus) || e.getSource().equals(bMul)
				|| e.getSource().equals(bDiv) || e.getSource().equals(bMinus)
				|| e.getSource().equals(bDot) || e.getSource().equals(bMsign)) {
			addLetter(e, display);
		}

		// Nút =
		if (e.getSource().equals(bEqual)) {
			String result = doCalc(display.getText());
			display.setText(result);
		}

		// Nút 1/x
		if (e.getSource().equals(b1Per)) {
			String result = display.getText();
			try {
				display.setText(String.valueOf(1 / Double.parseDouble(result)));
			} catch (NumberFormatException E) {
				display.setText("#Error");
			}
		}

		// Nút căn bậc hai
		if (e.getSource().equals(bSqrt)) {
			String result = display.getText();
			try {
				display.setText(String.valueOf(Math.sqrt(Double
						.parseDouble(result))));
			} catch (NumberFormatException E) {
				display.setText("#Error");
			}
		}

		// Nút phần trăm
		if (e.getSource().equals(bPercent)) {
			String result = display.getText();
			try {
				display.setText(String.valueOf(Double.parseDouble(result) / 100));
			} catch (NumberFormatException E) {
				display.setText("#Error");
			}
		}

		// Nút C = clear display
		if (e.getSource().equals(bC)) {
			display.setText("");
		}

		// Nút CE = Clear Elemant
		if (e.getSource().equals(bCE)) {
			//String result = display.getText();
			//display.setText(clearElement(result));
			display.setText(clearElement(display.getText()));
		}

		// Nút <-- = backspace
		if (e.getSource().equals(bBack)) {
			String result = display.getText();
			display.setText(backSpace(result));
		}

		if(e.getSource().equals(hAbout)) {
			JOptionPane.showMessageDialog(this, INFO, "About Caculator", 1);
		}
	}

	// Phương thức nối ký tự của phím vào màn hình
	public void addLetter(ActionEvent e, JTextField t) {
		try {
			String _str = t.getText();
			t.setText(_str.concat(e.getActionCommand()));
		} catch (Exception E) {
			System.out.println("Nút này chưa xử lý.");
		}
	}

	// Phương thức tính toán từ xâu vào
	public String doCalc(String str) {
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			return String.valueOf(engine.eval(str));
		} catch (ScriptException e) {
			return "#Error!";
		}
	}

	// Xoa 1 toan hang cuoi bieu thuc vua nhap sai
	public String clearElement(String str) {
		String tmp = "";

		int lastPlus = str.lastIndexOf("+");
		int lastSub = str.lastIndexOf("-");
		int lastMul = str.lastIndexOf("*");
		int lastDiv = str.lastIndexOf("/");

		int lastOperatorIndex = Math.max(Math.max(lastPlus, lastSub),
				Math.max(lastMul, lastDiv));
		if (lastOperatorIndex == -1) {
			tmp = "";
		} else {
			int endPoint = Math.max(Math.max(lastPlus, lastSub),
					Math.max(lastMul, lastDiv)) + 1;
			tmp = str.substring(0, endPoint);
		}
		return tmp;
	}

	// Phương thức backspace
	public String backSpace(String str) {
		try {
			return str.substring(0, str.length() - 1);
		} catch (StringIndexOutOfBoundsException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		new Bai4_11("Calculator");

	}
}
