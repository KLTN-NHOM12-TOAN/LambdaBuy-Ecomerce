package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.gui.UserFrm;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProfileDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.service.UserDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.utility.ClassTableUserModel;

public class UserManagementController {
	private JPanel jpnView;
	private JButton btnAdd;
	private JButton btnSub;
	private JTextField jtfSearch;
	private String token;
	
	private UserDesktopService userWebService = null;
	private ProfileDesktopService profileWebService = null;
	private String[] listColumn = {"STT", "Mã người dùng", "Tên người dùng", "Email", "Tên", "Họ", "Ảnh đại diện", "Số điện thoại", "Địa chỉ"};
	private TableRowSorter<TableModel> rowSorter = null;
	
	private JTable table = null;
	private DefaultTableModel model = null;
	
	public UserManagementController(JPanel jpnView, JButton btnAdd, JButton btnSub, JTextField jtfSearch, String token) {
		this.jpnView = jpnView;
		this.btnAdd = btnAdd;
		this.btnSub = btnSub;
		this.jtfSearch = jtfSearch;
		this.token = token;
		
		userWebService = new UserDesktopService();
		profileWebService = new ProfileDesktopService();
	}
	
	public void setDataToTable() {
		try {
			List<UserResponseDto> listItem = userWebService.getAllUser(token);
			model = new ClassTableUserModel().setTableModel(listItem, listColumn);
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
					
					UserResponseDto user = new UserResponseDto();
					user.setProfileDto(new ProfileResponseDto());
					user.setId(model.getValueAt(selectedRowIndex, 1).toString());
					user.setUsername(model.getValueAt(selectedRowIndex, 2).toString());
					user.setEmail(model.getValueAt(selectedRowIndex, 3).toString());
					
					UserResponseDto findUser = userWebService.getUserById(UserManagementController.this.model.getValueAt(selectedRowIndex, 1).toString(), token);
					
					ProfileResponseDto profile = user.getProfile();
					profile.setId(findUser.getProfile().getId());
					profile.setFirstName(model.getValueAt(selectedRowIndex, 4).toString());
					profile.setLastName(model.getValueAt(selectedRowIndex, 5).toString());
					if(model.getValueAt(selectedRowIndex, 6) != null) { 
						profile.setAvatar(model.getValueAt(selectedRowIndex, 6).toString());
					} else {
						profile.setAvatar(null);
					}
					if(model.getValueAt(selectedRowIndex, 7) != null) { 
						profile.setPhoneNumber(model.getValueAt(selectedRowIndex, 7).toString());
					} else {
						profile.setPhoneNumber(null);
					}	
					if(model.getValueAt(selectedRowIndex, 8) != null) { 
						profile.setAddress(model.getValueAt(selectedRowIndex, 8).toString());
					} else {
						profile.setAddress(null);
					}
					user.setProfileDto(profile);
					UserFrm frame = null;
					frame = new UserFrm(user, token);

					frame.setTitle("Thông tin người dùng");
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
				UserFrm frame = null;
				frame = new UserFrm(new UserResponseDto(), token);
				frame.setTitle("Thông tin người dùng");
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
				userWebService.deteleUserById(id, token);
				
				jtfSearch.setText("Khoá tài khoản người dùng " + id + " thành công!");
				setDataToTable();
			}
		});
	}
}
