package com.kltn.nhom12.LambdaBuyDesktop.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kltn.nhom12.LambdaBuyDesktop.action.LoginController;
import java.awt.Color;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtfTenDangNhap;
	private JTextField jtfMatKhau;
	private JButton btnDangNhap;
	private JLabel jlbMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public LoginDialog() throws IOException {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("LambdaBuy Management");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDangNhap.setBounds(156, 42, 127, 29);
		contentPanel.add(lblDangNhap);
		
		jtfTenDangNhap = new JTextField();
		jtfTenDangNhap.setBounds(168, 93, 223, 30);
		contentPanel.add(jtfTenDangNhap);
		jtfTenDangNhap.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(48, 134, 120, 30);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(48, 90, 120, 30);
		contentPanel.add(lblNewLabel_1);
		
		jtfMatKhau = new JTextField();
		jtfMatKhau.setColumns(10);
		jtfMatKhau.setBounds(168, 137, 223, 30);
		contentPanel.add(jtfMatKhau);
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDangNhap.setBounds(168, 183, 100, 30);
		contentPanel.add(btnDangNhap);
		
		jlbMessage = new JLabel("");
		jlbMessage.setForeground(new Color(255, 0, 0));
		jlbMessage.setBounds(48, 240, 378, 13);
		contentPanel.add(jlbMessage);

		LoginController controller = new LoginController(btnDangNhap, jtfTenDangNhap, jtfMatKhau, jlbMessage);
		controller.setEvent();
	}
}
