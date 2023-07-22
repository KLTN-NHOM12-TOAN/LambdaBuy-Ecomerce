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
import com.example.kltn.SpringAPILambdaBuy.common.request.category.CreateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.category.UpdateCategoryDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.service.BrandDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.CategoryDesktopService;

public class CategoryController {
	private JButton btnSubmit;
	private JTextField jtfId;
	private JTextField jtfName;
	
	private JLabel jlbMessage;
	private CategoryResponseDto category = null;
	private CreateCategoryDto createCategoryDto = null;
	private UpdateCategoryDto updateCategoryDto = null;
	private String token;
	
	private CategoryDesktopService categoryDesktopService;
	
	public CategoryController(String token, JButton btnSubmit, JTextField jtfId, JTextField jtfName, JLabel jlbMessage) {
		this.token = token;
		this.btnSubmit = btnSubmit;
		this.jtfId = jtfId;
		this.jtfName = jtfName;
		
		this.jlbMessage = jlbMessage;
		categoryDesktopService = new CategoryDesktopService();
	}
	
	public void setView(CategoryResponseDto categoryResponseDto) {
		try {
			this.category = categoryResponseDto;
			if(category.getId() == null) {
				jtfId.disable();
			} else {
				jtfId.setText(category.getId());
				jtfId.disable();
				jtfName.setText(category.getName());
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
				if(jtfName.getText().length() == 0) {
					jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
					btnSubmit.setEnabled(false);
				} else {
					if(category.getId() != null) {
						updateCategoryDto = new UpdateCategoryDto();
						updateCategoryDto.setId(jtfId.getText());
						updateCategoryDto.setName(jtfName.getText());
						categoryDesktopService.update(updateCategoryDto, token);
						
						jlbMessage.setText("Cập nhật dữ liệu thành công!");
					} else {
						createCategoryDto = new CreateCategoryDto();
						createCategoryDto.setName(jtfName.getText());
						categoryDesktopService.create(createCategoryDto, token);
						
						jlbMessage.setText("Tạo loại sản phẩm mới thành công!");
					}
				}
			}
		});
	}
}
