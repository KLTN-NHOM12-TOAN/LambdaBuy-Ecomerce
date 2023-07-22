package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.kltn.SpringAPILambdaBuy.common.request.brand.CreateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.brand.UpdateBrandDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.CreateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.supplier.UpdateSupplierDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.service.BrandDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.SupplierDesktopService;

public class SupplierController {
	private JButton btnSubmit;
	private JTextField jtfId;
	private JTextField jtfName;
	private JTextArea jtaDescription;
	private JTextArea jtaAddress;
	
	private JLabel jlbMessage;
	private SupplierResponseDto supplier = null;
	private CreateSupplierDto createSupplierDto = null;
	private UpdateSupplierDto updateSupplierDto = null;
	private String token;
	
	private SupplierDesktopService supplierDesktopService;
	
	public SupplierController(String token, JButton btnSubmit, JTextField jtfId, JTextField jtfName, JTextArea jtfDescription, JTextArea jtaAddress, JLabel jlbMessage) {
		this.token = token;
		this.btnSubmit = btnSubmit;
		this.jtfId = jtfId;
		this.jtfName = jtfName;
		this.jtaDescription = jtaDescription;
		this.jtaAddress = jtaAddress;
		
		this.jlbMessage = jlbMessage;
		supplierDesktopService = new SupplierDesktopService();
	}
	
	public void setView(SupplierResponseDto supplierResponseDto) {
		try {
			this.supplier = supplierResponseDto;
			if(supplier.getId() == null) {
				jtfId.disable();
			} else {
				jtfId.setText(supplier.getId());
				jtfId.disable();
				jtfName.setText(supplier.getName());
				jtaDescription.setText(supplier.getDescription());
				jtaAddress.setText(supplier.getAddress());
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
				if(jtfName.getText().length() == 0 || jtaDescription.getText().length() == 0 || jtaAddress.getText().length() == 0) {
					jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
					btnSubmit.setEnabled(false);
				} else {
					if(supplier.getId() != null) {
//						BrandResponseDto brand = brandDesktopService.getById(jtfId.getText(), token);
						updateSupplierDto = new UpdateSupplierDto();
						updateSupplierDto.setId(jtfId.getText());
						updateSupplierDto.setName(jtfName.getText());
						updateSupplierDto.setDescription(jtaDescription.getText());
						updateSupplierDto.setAddress(jtaAddress.getText());
						
						supplierDesktopService.update(updateSupplierDto, token);
						
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
						createSupplierDto = new CreateSupplierDto();
						createSupplierDto.setName(jtfName.getText());
						createSupplierDto.setDescription(jtaDescription.getText());
						createSupplierDto.setAddress(jtaAddress.getText());
						supplierDesktopService.create(createSupplierDto, token);
						
						jlbMessage.setText("Tạo nhà phân phối mới thành công!");
					}
				}
			}
		});
	}
}
