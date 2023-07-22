package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.gui.BrandFrm;
import com.kltn.nhom12.LambdaBuyDesktop.gui.ProductFrm;
import com.kltn.nhom12.LambdaBuyDesktop.service.BrandDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProductDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.utility.ClassTableBrandModel;
import com.kltn.nhom12.LambdaBuyDesktop.utility.ClassTableProductModel;

public class ProductManagementController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JButton btnSub;
	private JTextField jtfSearch;
	private String token;
	
	private ProductDesktopService productDesktopService;
	
	private String[] listColumn = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Mô tả", "Đơn giá", "Giảm giá", "Hình ảnh", "Số lượng", "Nơi sản xuất", "Năm sản xuất", "Đặc biệt", "Loại sản phẩm", "Thương hiệu", "Nhà phân phối"};
	private TableRowSorter<TableModel> rowSorter = null;
	
	private JTable table = null;
	private DefaultTableModel model = null;
	
	public ProductManagementController(JPanel jpnView, JButton btnAdd, JButton btnSub, JTextField jtfSearch, String token) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.btnSub = btnSub;
		this.jtfSearch = jtfSearch;
		this.token = token;
		
		productDesktopService = new ProductDesktopService();
	}
	
	public void setDataToTable() {
		try {
			List<ProductResponseDto> listItem = productDesktopService.getAll(token);
			model = new ClassTableProductModel().setTableModel(listItem, listColumn);
			table = new JTable(model);
			
			rowSorter = new TableRowSorter<>(table.getModel());
			table.setRowSorter(rowSorter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = jtfSearch.getText();
				if(text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				}else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		table.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
					
					ProductResponseDto product = new ProductResponseDto();
					product.setId(model.getValueAt(selectedRowIndex, 1).toString());
					product.setName(model.getValueAt(selectedRowIndex, 2).toString());
					product.setDescription(model.getValueAt(selectedRowIndex, 3).toString());
					product.setUnitPrice(Double.parseDouble(model.getValueAt(selectedRowIndex, 4).toString()));
					product.setDiscount(Double.parseDouble(model.getValueAt(selectedRowIndex, 5).toString()));
					product.setImage(model.getValueAt(selectedRowIndex, 6).toString());
					product.setInStock(Integer.parseInt(model.getValueAt(selectedRowIndex, 7).toString()));
					product.setCountry(model.getValueAt(selectedRowIndex, 8).toString());
					product.setManufacturedDate(Integer.parseInt(model.getValueAt(selectedRowIndex, 9).toString()));
					product.setSpecial(Boolean.parseBoolean(model.getValueAt(selectedRowIndex, 10).toString()));
					product.setCategory(model.getValueAt(selectedRowIndex, 11).toString());
					product.setBrand(model.getValueAt(selectedRowIndex, 12).toString());
					product.setSupplier(model.getValueAt(selectedRowIndex, 13).toString());
					
					ProductFrm frame = null;
					frame = new ProductFrm(product, token);

					frame.setTitle("Thông tin sản phẩm");
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
			}
		});
		
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		table.getTableHeader().setPreferredSize(new Dimension(100, 50));
		table.setRowHeight(50);
		table.validate();
		table.repaint();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setPreferredSize(new Dimension(1100,400));
		
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scrollPane);
		jpnView.validate();
		jpnView.repaint();
	}
	
	public void setEvent() {
		btnAdd.addMouseListener(new MouseListener() {
			
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
				btnAdd.setBackground(new Color(100,221,23));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0,200,83));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductFrm frame = null;
				frame = new ProductFrm(new ProductResponseDto(), token);
				frame.setTitle("Thông tin sản phẩm");
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
			}
		});
		
		btnSub.addMouseListener(new MouseListener() {
			
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
				btnSub.setBackground(new Color(204,0,0));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSub.setBackground(new Color(204,0,0));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
				
				String id = (String)model.getValueAt(selectedRowIndex, 1);
//				userWebService.deteleUserById(id);
				
				jtfSearch.setText("Khoá sản phẩm " + id + " thành công!");
				setDataToTable();
			}
		});
	}
}
