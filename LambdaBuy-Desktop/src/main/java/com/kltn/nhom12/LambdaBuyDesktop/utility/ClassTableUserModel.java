package com.kltn.nhom12.LambdaBuyDesktop.utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;

public class ClassTableUserModel {
	public DefaultTableModel setTableModel(List<UserResponseDto> listItem, String[] listColumn) {
		DefaultTableModel dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		try {
			dtm.setColumnIdentifiers(listColumn);
			int columns = listColumn.length;
			Object[] obj = null;
			int rows = listItem.size();
			if(rows > 0) {
				for(int i=0; i<rows; i++) {
					UserResponseDto user = listItem.get(i);
					obj = new Object[columns];
					obj[0] = (i+1);
					obj[1] = user.getId();
					obj[2] = user.getUsername();
					obj[3] = user.getEmail();
					obj[4] = user.getProfile().getFirstName();
					obj[5] = user.getProfile().getLastName();
					obj[6] = user.getProfile().getAvatar();
					obj[7] = user.getProfile().getPhoneNumber();
					obj[8] = user.getProfile().getAddress();
					
					dtm.addRow(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;
	}
}
