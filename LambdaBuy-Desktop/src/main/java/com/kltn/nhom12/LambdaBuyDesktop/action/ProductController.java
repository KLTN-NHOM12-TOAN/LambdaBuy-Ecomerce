package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.kltn.SpringAPILambdaBuy.common.request.product.CreateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.product.UpdateProductDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProductDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProfileDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.UserDesktopService;

public class ProductController {
	private JButton btnSubmit;
	private JTextField jtfId;
	private JTextField jtfName;
	private JTextArea jtaDescription;
	private JTextField jtfUnitPrice;
	private JTextField jtfDiscount;
	private JLabel jlbImageName;
	private JTextField jtfInStock;
	private JTextField jtfCountry;
	private JTextField jtfManufactureDate;
	private JRadioButton jrdSpecialTrue;
	private JRadioButton jrdSpecialFalse;
	private JTextField jtfCategory;
	private JTextField jtfBrand;
	private JTextField jtfSupplier;
	
	private JLabel jlbMessage;
	private ProductResponseDto product = null;
	private CreateProductDto createProductDto = null;
	private UpdateProductDto updateProductDto = null;
	private ProductDesktopService productDesktopService;
	private String token;
	
	public ProductController(String token, JButton btnSubmit, JTextField jtfId, JTextField jtfName, JTextArea jtaDescription, JTextField jtfUnitPrice, JTextField jtfDiscount, JLabel jlbImageName, JTextField jtfInStock, JTextField jtfCountry, JTextField jtfManufactureDate, JRadioButton jrdSpecialTrue, JRadioButton jrdSpecialFalse, JTextField jtfCategory, JTextField jtfBrand, JTextField jtfSupplier, JLabel jlbMessage) {
		this.token = token;
		this.btnSubmit = btnSubmit;
		this.jtfId = jtfId;
		this.jtfName = jtfName;
		this.jtaDescription = jtaDescription;
		this.jtfUnitPrice = jtfUnitPrice;
		this.jtfDiscount = jtfDiscount;
		this.jlbImageName = jlbImageName;
		this.jtfInStock = jtfInStock;
		this.jtfCountry = jtfCountry;
		this.jtfManufactureDate = jtfManufactureDate;
		this.jrdSpecialTrue = jrdSpecialTrue;
		this.jrdSpecialFalse = jrdSpecialFalse;
		this.jtfCategory = jtfCategory;
		this.jtfBrand = jtfBrand;
		this.jtfSupplier = jtfSupplier;
		
		this.jlbMessage = jlbMessage;
		this.productDesktopService = new ProductDesktopService();
	}
	
	public void setView(ProductResponseDto productResponseDto) {
		try {
			this.product = productResponseDto;
			if(product.getId() == null) {
				jtfId.disable();
			} else {
				jtfId.setText(product.getId());
				jtfId.disable();
				jtfName.setText(product.getName());
				jtaDescription.setText(product.getDescription());;
				jtfUnitPrice.setText(String.valueOf(product.getUnitPrice()));
				jtfDiscount.setText(String.valueOf(product.getDiscount()));
				jlbImageName.setText(product.getImage());
				jtfInStock.setText(String.valueOf(product.getInStock()));
				jtfCountry.setText(product.getCountry());
				jtfManufactureDate.setText(String .valueOf(product.getManufacturedDate()));
				if(String.valueOf(product.isSpecial()).equalsIgnoreCase("Yes")) {
					jrdSpecialTrue.setSelected(true);
					jrdSpecialFalse.setSelected(false);
				}else {
					jrdSpecialTrue.setSelected(false);
					jrdSpecialFalse.setSelected(true);
				}
				jtfCategory.setText(product.getCategory());
				jtfBrand.setText(product.getBrand());
				jtfSupplier.setText(product.getSupplier());
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
				if(jtfName.getText().length() == 0 || jtaDescription.getText().length() == 0 || jtfUnitPrice.getText().length() == 0 || jtfDiscount.getText().length() == 0 || jlbImageName.getText().length() == 0 || jtfInStock.getText() == null || jtfCountry.getText().length() == 0 || jtfManufactureDate.getText().length() == 0) {
					jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
					btnSubmit.setEnabled(false);
				} else {
					if(product.getId() != null) {
						updateProductDto = new UpdateProductDto();
						updateProductDto.setId(jtfId.getText());
						updateProductDto.setName(jtfName.getText());
						updateProductDto.setDescription(jtaDescription.getText());
						updateProductDto.setUnitPrice(Double.parseDouble(jtfUnitPrice.getText()));
						updateProductDto.setDiscount(Double.parseDouble(jtfDiscount.getText()));
						updateProductDto.setImage(jlbImageName.getText());
						updateProductDto.setInStock(Integer.parseInt(jtfInStock.getText()));
						updateProductDto.setCountry(jtfCountry.getText());
						updateProductDto.setManufacturedDate(Integer.parseInt(jtfManufactureDate.getText()));
						updateProductDto.setIsSpecial(jrdSpecialTrue.isSelected()? true : false);
						updateProductDto.setCategory(jtfCategory.getText());
						updateProductDto.setBrand(jtfBrand.getText());
						updateProductDto.setSupplier(jtfSupplier.getText());
						productDesktopService.update(updateProductDto, token);
						
						jlbMessage.setText("Cập nhật dữ liệu thành công!");
						
					} else {
						createProductDto = new CreateProductDto();
						createProductDto.setName(jtfName.getText());
						createProductDto.setDescription(jtaDescription.getText());
						createProductDto.setUnitPrice(Double.parseDouble(jtfUnitPrice.getText()));
						createProductDto.setDiscount(Double.parseDouble(jtfDiscount.getText()));
						createProductDto.setImage(jlbImageName.getText());
						createProductDto.setInStock(Integer.parseInt(jtfInStock.getText()));
						createProductDto.setCountry(jtfCountry.getText());
						createProductDto.setManufacturedDate(Integer.parseInt(jtfManufactureDate.getText()));
						createProductDto.setIsSpecial(jrdSpecialTrue.isSelected()? true : false);
						createProductDto.setCategory(jtfCategory.getText());
						createProductDto.setBrand(jtfBrand.getText());
						createProductDto.setSupplier(jtfSupplier.getText());
						
						productDesktopService.create(createProductDto, token);
						
						jlbMessage.setText("Tạo sản phẩm mới thành công!");
					}
				}
			}
		});
	}
}
