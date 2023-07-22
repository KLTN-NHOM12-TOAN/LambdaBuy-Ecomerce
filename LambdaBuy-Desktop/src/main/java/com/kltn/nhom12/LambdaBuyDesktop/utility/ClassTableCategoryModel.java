package com.kltn.nhom12.LambdaBuyDesktop.utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.example.kltn.SpringAPILambdaBuy.common.response.BrandResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.CategoryResponseDto;

public class ClassTableCategoryModel {
	public DefaultTableModel setTableModel(List<CategoryResponseDto> listItem, String[] listColumn) {
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
					CategoryResponseDto category = listItem.get(i);
					obj = new Object[columns];
					obj[0] = (i+1);
					obj[1] = category.getId();
					obj[2] = category.getName();
					
					dtm.addRow(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;
	}
}
