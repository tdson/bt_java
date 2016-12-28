package chuong_4;

import java.awt.*;
import java.awt.event.*;

public class Bai4_7 extends Frame {
	private Label lb1, lba, lbb, lbkq;
	private TextField tfa, tfb, tfkq;
	private Button btTinh, btReset, btThoat;
	private Panel p1, p2, p3;

	public Bai4_7(String title) {
		super(title);
		lb1 = new Label("Giải Phương Trình Bậc Nhất");
		lba = new Label("Nhập a:");
		lbb = new Label("Nhập b:");
		lbkq = new Label("Kết quả:");
		tfa = new TextField();
		tfb = new TextField();
		tfkq = new TextField();
		btTinh = new Button("Tính");
		btReset = new Button("Đặt lại");
		btThoat = new Button("Thoát");

		p1 = new Panel();
		p1.add(lb1, BorderLayout.WEST);
		p1.add(lb1, BorderLayout.CENTER);
		p1.add(lb1, BorderLayout.EAST);

		p2 = new Panel(new GridLayout(3, 2));
		p2.add(lba);
		p2.add(tfa);
		p2.add(lbb);
		p2.add(tfb);
		p2.add(lbkq);
		p2.add(tfkq);

		p3 = new Panel(new GridLayout(1, 3));
		p3.add(btTinh);
		p3.add(btReset);
		p3.add(btThoat);

		// Bắt các sự kiện nhấn nút
		btTinh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Double a = Double.parseDouble(tfa.getText());
					Double b = Double.parseDouble(tfb.getText());
					if (a == 0) {
						if (b == 0) {
							tfkq.setText("Có vô số nghiệm.");
						} else {
							tfkq.setText("Vô nghiệm.");
						}
					} else {
						double kq = -b / a;
						tfkq.setText(Double.toString(kq));
					}
					// System.out.println(a + "" + b);
				} catch (NumberFormatException mfe) {
					tfkq.setText("Số không đúng.");
					mfe.printStackTrace();
				}
			}
		});
		btReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfa.setText(null);
				tfb.setText(null);
				tfkq.setText(null);
			}
		});
		btThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		this.setBounds(500, 300, 400, 180);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Bai4_7("Giải phương trình bậc nhất");
	}
}

