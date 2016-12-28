package chuong_7;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Bai7_1 extends JFrame {

	private Connection conn = null;
	private JTable dataTable = new JTable();
	private DefaultTableModel tableModel = new DefaultTableModel();

	JLabel lb1, lb2;
	JTextField tfSearch;
	JButton btSearch, btReset, btExit;
	Checkbox ms, ht, ns, dc, gt;
	CheckboxGroup cbGroup;

	public Bai7_1() {
		String[] colsName = { "Mã số", "Họ và tên", "Ngày sinh", "Địa chỉ",
				"Giới tính" };
		// Đặt tiêu đề cột cho tableModel
		tableModel.setColumnIdentifiers(colsName);
		// kết nối jtable với tableModel
		dataTable.setModel(tableModel);
		// Khởi tạo các components trên JFrame
		initComponent();
		// kết nối cơ sở dữ liệu
		connectDatabase();
		// gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để
		// đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
		updateData(view("SELECT * FROM tbl_sinhvien"));

	}

	public void updateData(ResultSet result) {
		String[] colsName = { "Ma So", "Ho Ten", "Ngay Sinh", "Dia Chi",
				"Gioi Tinh" };
		// Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
		tableModel.setColumnIdentifiers(colsName);

		try {
			// nếu còn đọc tiếp được một dòng dữ liệu
			while (result.next()) {
				String[] rows = new String[5];
				// lấy dữ liệu tại cột số 1
				rows[0] = result.getString(1);
				// lấy dữ liệu tai cột số 2
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);
				// đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
				tableModel.addRow(rows);
				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự
				// động update lại trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void connectDatabase() {

			String url = new String("jdbc:mysql://localhost:3306/mytest?autoReconnect=true&useSSL=false");
			try {
				conn = DriverManager.getConnection(url);
				// System.out.println("Kết nối thành công");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public ResultSet view(String sql) {
		ResultSet result = null;
		// String sql = "SELECT * FROM tbl_sinhvien";
		try {
			Statement statement = (Statement) conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void initComponent() {
		setLayout(new GridLayout(2, 1));
		setTitle("Select");
		setBounds(300, 300, 600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1));
		Panel pt = new Panel();
		lb1 = new JLabel("Nhap noi dung");
		tfSearch = new JTextField("Nhap thong tin muon tim");
		btSearch = new JButton("Tim Kiem");
		btReset = new JButton("Reset");
		btExit = new JButton("Exit");
		pt.add(lb1);
		pt.add(tfSearch);
		pt.add(btSearch);
		pt.add(btReset);
		pt.add(btExit);
		Panel pm = new Panel();
		lb2 = new JLabel("Tim kiem theo");
		cbGroup = new CheckboxGroup();
		ms = new Checkbox("MaSo", cbGroup, false);
		ht = new Checkbox("HoTen", cbGroup, false);
		ns = new Checkbox("NgaySinh", cbGroup, false);
		dc = new Checkbox("DiaChi", cbGroup, false);
		gt = new Checkbox("GioiTinh", cbGroup, false);
		pm.add(lb2);
		pm.add(ms);
		pm.add(ht);
		pm.add(ns);
		pm.add(dc);
		pm.add(gt);
		p1.add(pt);
		p1.add(pm);
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout());
		JScrollPane sTable = new JScrollPane(dataTable);
		p2.add(sTable);

		add(p1);
		add(p2);
		setVisible(true);
		
		btSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String str = "SELECT * FROM tbl_sinhvien WHERE "
						+ cbGroup.getSelectedCheckbox().getLabel() + "='"
						+ tfSearch.getText() + "'";
				// Xoá bảng
				tableModel.setRowCount(0);
				// Cập nhật lại
				updateData(view(str));
			}
		});
		btReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				tfSearch.setText("");
				tableModel.setRowCount(0);
				updateData(view("SELECT * FROM tbl_sinhvien"));
			}
		});
		btExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Bai7_1();
	}
}

