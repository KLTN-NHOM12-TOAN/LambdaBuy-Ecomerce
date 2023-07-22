package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProfileDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.UserDesktopService;

public class UserController {
	private JButton btnSubmit;
	private JTextField jtfId;
	private JTextField jtfUsername;
	private JTextField jtfEmail;
	private JTextField jtfFirstName;
	private JTextField jtfLastName;
	private JTextField jtfPhoneNumber;
	private JLabel jlbAvatar;
	private MultipartFile avatarFile;
	private JTextArea jtaAddress;
	
	private JLabel jlbMessage;
	private UserResponseDto user = null;
	private CreateUserProfileDto createUserProfileDto = null;
	private UpdateProfileDto updateProfile = null;
	private ProfileResponseDto returnProfile = null;
	private UserDesktopService userWebService;
	private ProfileDesktopService profileWebService;
	private String token;
	
	public UserController(String token, JButton btnSubmit, JTextField jtfId, JTextField jtfUsename, JTextField jtfEmail, JTextField jtfFirstName, JTextField jtfLastName, JTextField jtfPhoneNumber, JLabel jlbAvatar, MultipartFile avatarFile, JTextArea jtaAddress, JLabel jlbMessage) {
		this.token = token;
		this.btnSubmit = btnSubmit;
		this.jtfId = jtfId;
		this.jtfUsername = jtfUsename;
		this.jtfEmail = jtfEmail;
		this.jtfFirstName = jtfFirstName;
		this.jtfLastName = jtfLastName;
		this.jtfPhoneNumber = jtfPhoneNumber;
		this.jlbAvatar = jlbAvatar;
		this.avatarFile = avatarFile;
		this.jtaAddress = jtaAddress;
		
		this.jlbMessage = jlbMessage;
		this.userWebService = new UserDesktopService();
		this.profileWebService = new ProfileDesktopService();
	}
	
	public void setView(UserResponseDto userResponseDto) {
		try {
			this.user = userResponseDto;
			if(user.getId() == null) {
				jtfId.disable();
			} else {
				this.returnProfile = userResponseDto.getProfile();
				jtfId.setText(user.getId());
				jtfId.disable();
				jtfUsername.setText(user.getUsername());
				jtfUsername.disable();
				jtfEmail.setText(user.getEmail());
				jtfEmail.disable();
				jtfFirstName.setText(returnProfile.getFirstName());
				jtfLastName.setText(returnProfile.getLastName());
				jtfPhoneNumber.setText(returnProfile.getPhoneNumber());
				jlbAvatar.setText(returnProfile.getAvatar());
				jtaAddress.setText(returnProfile.getAddress());
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void setEvent() {
		btnSubmit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubmit.setBackground(new Color(100,221,23));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setBackground(new Color(0,200,83));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtfUsername.getText().length() == 0 || jtfEmail.getText().length() == 0 || jtfFirstName.getText().length() == 0 || jtfLastName.getText().length() == 0 || jtfPhoneNumber.getText().length() == 0 || jlbAvatar.getText() == null || jtaAddress.getText().length() == 0) {
					jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
					btnSubmit.setEnabled(false);
				} else {
					if(user.getId() != null) {
						updateProfile = new UpdateProfileDto();
						updateProfile.setId(user.getProfile().getId());
						updateProfile.setFirstName(jtfFirstName.getText());
						updateProfile.setLastName(jtfLastName.getText());
						updateProfile.setPhoneNumber(jtfPhoneNumber.getText());
						
						String avatarImage = StringUtils.cleanPath(avatarFile.getOriginalFilename());
						if(avatarImage.contains(".."))
						{
							System.out.println("not a a valid file");
						}
						try {
							updateProfile.setAvatar(Base64.getEncoder().encodeToString(avatarFile.getBytes()));
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						updateProfile.setAddress(jtaAddress.getText());
						profileWebService.updateProfile(updateProfile, token);
						
						jlbMessage.setText("Cập nhật dữ liệu thành công!");
						
					} else {
						createUserProfileDto = new CreateUserProfileDto();
						createUserProfileDto.setUsername(jtfUsername.getText());
						createUserProfileDto.setEmail(jtfEmail.getText());
						createUserProfileDto.setFirstName(jtfFirstName.getText());
						createUserProfileDto.setLastName(jtfLastName.getText());
						createUserProfileDto.setPhoneNumber(jtfPhoneNumber.getText());
						createUserProfileDto.setAvatar(jlbAvatar.getText());
						createUserProfileDto.setAddress(jtaAddress.getText());
						userWebService.createUserProfile(createUserProfileDto, token);
						
						jlbMessage.setText("Tạo người dùng thành công!");
					}
				}
			}
		});
	}
}
