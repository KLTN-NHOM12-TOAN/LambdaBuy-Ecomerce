package com.kltn.nhom12.LambdaBuyDesktop.action;

import java.awt.BorderLayout;
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

import com.example.kltn.SpringAPILambdaBuy.common.response.ProductResponseDto;
import com.kltn.nhom12.LambdaBuyDesktop.gui.ProductFrm;
import com.kltn.nhom12.LambdaBuyDesktop.service.ProductDesktopService;
import com.kltn.nhom12.LambdaBuyDesktop.utility.ClassTableProductModel;

public class HomeManagementController {
	private JPanel jpnView;
	
	public HomeManagementController(JPanel jpnView) {
		this.jpnView = jpnView;
	}
	
}
