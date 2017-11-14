package com.lidiabazhenova;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

class DataModel extends DefaultTableModel{
	  List<String[]> data = new ArrayList<String[]>();

//	 �����������
	public DataModel(){
	for ( int i = 0; i < data.size(); i++) {
	  data.add(new String[getColumnCount()]);
	}
	};

	// ��������� ��������
	public Object getValueAt(int rowIndex, int columnIndex){
	    String[] row = data.get(rowIndex);
	    return row[columnIndex];
	};
	// ���������� ��������
	public void setValueAt(String[] value){
	    String[] row = new String[getColumnCount()];
	    row = value;
	    data.add(row);
	};
	// ��������� ��������
	public void updateValue(String newValue, int rowIndex, int columnIndex){
	    String[] row = data.get(rowIndex);
	    row[columnIndex] = newValue;
	};
	// ���������� �����
	public int getRowCount()
	{
	    return data.size();
	};
	// ���������� ��������
	public int getColumnCount()
	{
	    return 10;
	};
	}
