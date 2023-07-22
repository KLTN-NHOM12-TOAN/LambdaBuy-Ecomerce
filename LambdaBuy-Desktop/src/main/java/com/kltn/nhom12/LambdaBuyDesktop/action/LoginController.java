package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.AuthResponse;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;
import com.kltn.nhom12.LambdaBuyDesktop.gui.MainFrm;
import com.kltn.nhom12.LambdaBuyDesktop.service.AuthenticationDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.UserDesktopService;

public class LoginController {
	private Dialog dialog;
    private JButton btnDangnhap;
    private JTextField jtfTendangnhap;
    private JTextField jtfMatkhau;
    private JLabel jlbMessage;
//    private List<UserEntity> listUser;
    private AuthenticationDesktopService authenticationWebService;
    private UserDesktopService userDesktopService;
    
//    private NguoiDungDAO nguoidungDAO = null;
    
    public LoginController(JButton btnDangnhap, JTextField jtfTendangnhap, JTextField jtfMatkhau, JLabel jlbMessage) throws IOException {
    	this.btnDangnhap = btnDangnhap;
    	this.jtfTendangnhap = jtfTendangnhap;
    	this.jtfMatkhau = jtfMatkhau;
    	this.jlbMessage = jlbMessage;
    	
    	authenticationWebService = new AuthenticationDesktopService();
    	userDesktopService = new UserDesktopService();
//    	this.api = APIClient.getClient().create(UserAPI.class);
//    	this.listUser = 
//    	this.nguoidungDAO = new NguoidungImpl();
    }
    
    public void setEvent() {
    	btnDangnhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(jtfTendangnhap.getText().length() == 0 || jtfMatkhau.getText().length() == 0) {
						jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
					}else {
						LoginDto loginDto = new LoginDto();
						loginDto.setUsername(jtfTendangnhap.getText());
						loginDto.setEmail(jtfTendangnhap.getText());
						loginDto.setPassword(jtfMatkhau.getText());
						AuthResponse auth = (AuthResponse) authenticationWebService.login(loginDto);
						UserResponseDto user = userDesktopService.getCurrentUser(auth.getAccessToken());
						if(user == null) {
							jlbMessage.setText("Tên đăng nhập và mật khẩu không đúng!");
						}else {
//							dialog.dispose();
							if(user.getRole() == UserRole.ADMIN) {
								jlbMessage.setText("Success");
								MainFrm frame = new MainFrm(user, "Bearer " + auth.getAccessToken());
								frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
								frame.setResizable(true);
								frame.setVisible(true);
							}else {
								jlbMessage.setText("Tài khoản không đúng!");
							}
						}
					}
				} catch (Exception e2) {
					jlbMessage.setText(e2.toString());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				 btnDangnhap.setBackground(new Color(0, 200, 83));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDangnhap.setBackground(new Color(100, 221, 23));
			}
    		
    	});
    	
    }
}
