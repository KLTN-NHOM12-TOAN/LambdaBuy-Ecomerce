package com.kltn.nhom12.LambdaBuyDesktop.utility;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.SupplierResponseDto;

public class ClassTableProductModel {
	public DefaultTableModel setTableModel(List<ProductResponseDto> listItem, String[] listColumn) {
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
					ProductResponseDto product = listItem.get(i);
					obj = new Object[columns];
					obj[0] = (i+1);
					obj[1] = product.getId();
					obj[2] = product.getName();
					obj[3] = product.getDescription();
					obj[4] = product.getUnitPrice();
					obj[5] = product.getDiscount();
					obj[6] = product.getImage();
					obj[7] = product.getInStock();
					obj[8] = product.getCountry();
					obj[9] = product.getManufacturedDate();
					obj[10] = product.isSpecial();
					obj[11] = product.getCategory();
					obj[12] = product.getBrand();
					obj[13] = product.getSupplier();
					
					dtm.addRow(obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtm;
	}
}
