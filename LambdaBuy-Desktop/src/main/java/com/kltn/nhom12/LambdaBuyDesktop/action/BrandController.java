package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.service.BrandDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProfileDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.UserDesktopService;

public class BrandController {
	private JButton btnSubmit;
	private JTextField jtfId;
	private JTextField jtfName;
	private JTextField jtfFullName;
	private JTextArea jtaAddress;
	
	private JLabel jlbMessage;
	private BrandResponseDto brand = null;
	private CreateBrandDto createBrandDto = null;
	private UpdateBrandDto updateBrandDto = null;
	private String token;
	
	private BrandDesktopService brandDesktopService;
	
	public BrandController(String token, JButton btnSubmit, JTextField jtfId, JTextField jtfName, JTextField jtfFullName, JTextArea jtaAddress, JLabel jlbMessage) {
		this.token = token;
		this.btnSubmit = btnSubmit;
		this.jtfId = jtfId;
		this.jtfName = jtfName;
		this.jtfFullName = jtfFullName;
		this.jtaAddress = jtaAddress;
		
		this.jlbMessage = jlbMessage;
		brandDesktopService = new BrandDesktopService();
	}
	
	public void setView(BrandResponseDto brandResponseDto) {
		try {
			this.brand = brandResponseDto;
			if(brand.getId() == null) {
				jtfId.disable();
			} else {
				jtfId.setText(brand.getId());
				jtfId.disable();
				jtfName.setText(brand.getName());
				jtfFullName.setText(brand.getFullName());
				jtaAddress.setText(brand.getAddress());
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
				if(jtfName.getText().length() == 0 || jtfFullName.getText().length() == 0 || jtaAddress.getText().length() == 0) {
					jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
					btnSubmit.setEnabled(false);
				} else {
					if(brand.getId() != null) {
//						BrandResponseDto brand = brandDesktopService.getById(jtfId.getText(), token);
						updateBrandDto = new UpdateBrandDto();
						updateBrandDto.setId(jtfId.getText());
						updateBrandDto.setName(jtfName.getText());
						updateBrandDto.setFullName(jtfFullName.getText());
						updateBrandDto.setAddress(jtaAddress.getText());
						updateBrandDto.setIsDeleted(brand.getIsDeleted());
						brandDesktopService.update(updateBrandDto, token);
						
						jlbMessage.setText("Cập nhật dữ liệu thành công!");
						
//						
//						updateProfile = new UpdateProfileDto();
//						updateProfile.setId(user.getProfile().getId());
//						updateProfile.setFirstName(jtfFirstName.getText());
//						updateProfile.setLastName(jtfLastName.getText());
//						updateProfile.setPhoneNumber(jtfPhoneNumber.getText());
//						updateProfile.setAvatar(jlbAvatar.getText());
//						updateProfile.setAddress(jtaAddress.getText());
//						profileWebService.updateProfile(updateProfile, token);
//						
//						jlbMessage.setText("Cập nhật dữ liệu thành công!");
					} else {
						createBrandDto = new CreateBrandDto();
						createBrandDto.setName(jtfName.getText());
						createBrandDto.setFullName(jtfFullName.getText());
						createBrandDto.setAddress(jtaAddress.getText());
						brandDesktopService.create(createBrandDto, token);
						
						jlbMessage.setText("Tạo thương hiệu mới thành công!");
					}
				}
			}
		});
	}
}
