package chuong_7;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class Bai7_2 extends JFrame {

	JLabel lb1, lb2;
	JTextField tfInfo, tfSql;
	JButton btSubmit, btReset, btCancel;

	private Connection conn = null;
	private JTable tableData = new JTable();
	private DefaultTableModel tableModel = new DefaultTableModel();

	public Bai7_2() {
		String[] colsName = { "ID", "Ten KH", "DiaChi", "SanPham" };
		// đặt tiêu đề cột cho tableModel
		tableModel.setColumnIdentifiers(colsName);
		// kết nối jtable với tableModel
		tableData.setModel(tableModel);
		// Khởi tạo các components trên JFrame
		initComponent();
		// kết nối cơ sở dữ liệu"
		connectDatabase("jdbc:odbc:mydb");
		// gọi hàm view để truy suất dữ liệu sau đó truyền cho hàm updateData để
		// đưa dữ liệu vào tableModel và hiện lên Jtable trong Frame
		updateData(view("SELECT * FROM khachhang"));
	}

	public void connectDatabase(String db_name) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url = new String(db_name);

			conn = DriverManager.getConnection(url);
			// System.out.println("Kết nối thành công");
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
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

	public void updateData(ResultSet result) {
		String[] colsName = { "ID", "Ten KH", "DiaChi", "SanPham" };
		// Đặt tiêu đề cho bảng theo các giá trị của mảng colsName
		tableModel.setColumnIdentifiers(colsName);

		try {
			// nếu còn đọc tiếp được một dòng dữ liệu
			while (result.next()) {
				String[] rows = new String[4];
				// lấy dữ liệu tại cột số 1
				rows[0] = result.getString(1);
				// lấy dữ liệu tai cột số 2
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				// đưa dòng dữ liệu vào tableModel để hiện thị lên jtable
				tableModel.addRow(rows);
				// mỗi lần có sự thay đổi dữ liệu ở tableModel thì Jtable sẽ tự
				// động update lại trên frame
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initComponent() {
		setLayout(new GridLayout(3, 1));
		setTitle("Select");
		setBounds(300, 300, 600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 2));
		lb1 = new JLabel("Nhap thong tin");
		lb2 = new JLabel("SQL");
		tfInfo = new JTextField("jdbc:odbc:mydb");
		tfSql = new JTextField("select * from khachhang");
		p1.add(lb1);
		p1.add(tfInfo);
		p1.add(lb2);
		p1.add(tfSql);
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout());
		JScrollPane sTable = new JScrollPane(tableData);
		p2.add(sTable);
		Panel p3 = new Panel();
		btSubmit = new JButton("Submit");
		btReset = new JButton("Reset");
		btCancel = new JButton("Cancel");
		p3.add(btSubmit);
		p3.add(btReset);
		p3.add(btCancel);

		btSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// Xoá bảng
				tableModel.setRowCount(0);
				connectDatabase(tfInfo.getText());
				// Cập nhật lại
				updateData(view(tfSql.getText()));
			}
		});
		btReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				tfInfo.setText("jdbc:odbc:mydb");
				tfSql.setText("select * from khachhang");
				tableModel.setRowCount(0);
				updateData(view("SELECT * FROM khachhang"));
			}
		});
		btCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		add(p1);
		add(p2);
		add(p3);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Bai7_2();
	}
}