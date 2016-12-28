package chuong_4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bai4_9 extends Frame implements ActionListener {

	private Panel p1, p2, p4;
	private JLabel lb1, lbn, lbkq;
	private TextField tfn, tfkq;
	private Button bts, btExit, btRest;

	public Bai4_9(String title) {
		super(title);
		lb1 = new JLabel("Các số nguyên tố không lớn hơn n");
		lbn = new JLabel("Nhập n: ");
		lbn.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		lbkq = new JLabel("Kết quả: ");
		lbkq.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);

		tfn = new TextField();
		tfkq = new TextField();

		bts = new Button("Tìm...");
		btExit = new Button("Thoát");
		btRest = new Button("Đặt lại");

		p1 = new Panel();
		p1.add(lb1, BorderLayout.CENTER);
		p2 = new Panel(new GridLayout(3, 2));
		p2.add(lbn);
		p2.add(tfn);
		p2.add(lbkq);
		p2.add(tfkq);

		p4 = new Panel(new FlowLayout());
		p4.add(bts);
		p4.add(btRest);
		p4.add(btExit);

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p4, BorderLayout.SOUTH);

		bts.addActionListener(this);
		btExit.addActionListener(this);
		btRest.addActionListener(this);

		setBounds(500, 300, 400, 180);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(bts)) {
			try {
				int n = Integer.parseInt(tfn.getText());
				tfkq.setText(inSoNT(n));
			} catch (Exception E) {
				tfkq.setText("Số không đúng.");
			}
		}

		// Sự kiện exit
		if (e.getSource().equals(btExit)) {
			System.exit(0);
		}
		// Sự kiện reset
		if (e.getSource().equals(btRest)) {
			tfkq.setText(null);
			tfn.setText(null);
		}
	}

	// Hàm trả về các số nguyên tố nhỏ hơn n
	private String inSoNT(int n) {
		String result = "";
		if (n < 2)
			result = ("Không có số nguyên tố nhỏ hơn " + n);
		else {
			for (int i = 2; i <= n; i++) {
				int count = 0;
				for (int j = 2; j < i; j++) {
					if (i % j == 0)
						count++;
				}
				if (count == 0) {
					result += (i + " ");
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new Bai4_9("Tìm số nguyên tố");
	}
}
