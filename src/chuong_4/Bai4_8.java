package chuong_4;

import java.awt.*;
import java.awt.event.*;

public class Bai4_8 extends Frame implements ActionListener {
	private Panel p1, p2, p3, p4;
	private Label lb1, lba, lbb, lbkq;
	private TextField tfa, tfb, tfkq;
	private Button btc, btt, btn, btch, btExit, btRest;

	public Bai4_8(String title) {
		super(title);
		setLayout(new GridLayout(4, 1));

		lb1 = new Label("Minh họa các phép toán");
		lba = new Label("Nhập a: ");
		lbb = new Label("Nhập b: ");
		lbkq = new Label("Kết quả: ");

		tfa = new TextField();
		tfb = new TextField();
		tfkq = new TextField();

		btc = new Button("Cộng");
		btt = new Button("Trừ");
		btn = new Button("Nhân");
		btch = new Button("Chia");
		btExit = new Button("Thoát");
		btRest = new Button("Đặt lại");

		p1 = new Panel();
		p1.add(lb1, BorderLayout.CENTER);

		p2 = new Panel(new GridLayout(3, 2));
		p2.add(lba);
		p2.add(tfa);
		p2.add(lbb);
		p2.add(tfb);
		p2.add(lbkq);
		p2.add(tfkq);

		p3 = new Panel(new FlowLayout());
		p3.add(btc);
		p3.add(btt);
		p3.add(btn);
		p3.add(btch);

		p4 = new Panel(new FlowLayout());
		p4.add(btRest);
		p4.add(btExit);

		add(p1);
		add(p2);
		add(p3);
		add(p4);

		btc.addActionListener(this);
		btt.addActionListener(this);
		btn.addActionListener(this);
		btch.addActionListener(this);
		btExit.addActionListener(this);
		btRest.addActionListener(this);

		setBounds(500, 300, 400, 320);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Bai4_8("Minh họa các phép toán");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!tfa.getText().equals(null) && !tfb.getText().equals(null)) {
			try {
				Double a = Double.parseDouble(tfa.getText());
				Double b = Double.parseDouble(tfb.getText());
				// Phép cộng
				if (e.getSource().equals(btc)) {
					tfkq.setText(Double.toString((a + b)));
				}
				// Phép trừ
				if (e.getSource().equals(btt)) {
					tfkq.setText(Double.toString((a - b)));
				}
				// Phép nhân
				if (e.getSource().equals(btn)) {
					tfkq.setText(Double.toString((a * b)));
				}
				// Phép chia
				if (e.getSource().equals(btch)) {
					if (b != 0) {
						tfkq.setText(Double.toString((a / b)));
					} else {
						tfkq.setText("Lỗi chia cho 0.");
					}
				}
			} catch (NumberFormatException E) {
				tfkq.setText("Lỗi định dạng số.");
			}
		}
		// Sự kiện exit
		if (e.getSource().equals(btExit)) {
			System.exit(0);
		}
		// Sự kiện reset
		if (e.getSource().equals(btRest)) {
			tfa.setText(null);
			tfb.setText(null);
			tfkq.setText(null);
		}

	}
}
