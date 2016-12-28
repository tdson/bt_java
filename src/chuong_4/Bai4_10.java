package chuong_4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class Bai4_10 extends Frame implements ActionListener {

	private Panel p1, p2, p4;
	private JLabel lb1, lbn, lbkq;
	private TextField tfn, tfkq;
	private Button bts, btExit, btRest;

	public Bai4_10(String title) {
		super(title);
		lb1 = new JLabel("Kiểm tra số a có thuộc dãy Fibonaci không");
		lbn = new JLabel("Nhập a: ");
		lbn.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
		lbkq = new JLabel("Kết quả: ");
		lbkq.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);

		tfn = new TextField();
		tfkq = new TextField();

		bts = new Button("OK");
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

		setBounds(500, 300, 480, 180);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(bts)) {
			try {
				int n = Integer.parseInt(tfn.getText());
				tfkq.setText(ktFibonacci(n));
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

	// 
	private String ktFibonacci(int n) {
		String result = "";
		// SIZE là kích cỡ của dãy fibonacci.
		int SIZE = 0;
		/*
		 * Để tối ưu tốc độ thuật toán. Nếu số nhập vào nhỏ thì chỉ cần tìm kiếm
		 * trong một size nhỏ thôi nhằm tiết kiệm thời gian
		 */
		if (n < 10000)
			SIZE = 20;
		else
			// Kích thước tối đa mà kiểu double cho phép là 46
			SIZE = 46;
		// Bắt đầu vòng lặp và so sánh
		double f;
		// Làm tròn đến hàng đơn vị vì f kiểu double nên có dấu chấm thập
		// phân.
		boolean isFibonacci = false;
		DecimalFormat df = new DecimalFormat("0");
		for (int i = 1; i <= SIZE; i++) {
			f = (1 / Math.sqrt(5) * (Math.pow(((1 + Math.sqrt(5)) / 2), i) - Math
					.pow(((1 - Math.sqrt(5)) / 2), i)));
			Integer fibonacci = new Integer(df.format(f));
			if (fibonacci == n) {
				// Nếu n là số fibonacci thì in kết quả, dừng vòng lặp

				result += (n + " nằm trong dãy Fibonacci.");
				isFibonacci = true;
				break;
			} else
				continue;
		}
		// In ra kết quả không phải số fibonacci sau khi dừng vòng lặp và không
		// tìm thấy
		if (!isFibonacci)
			result += (n + " không nằm trong dãy Fibonacci.");
		return result;
	}

	public static void main(String[] args) {
		new Bai4_10("Kiểm tra số Fibonaci");
	}
}
