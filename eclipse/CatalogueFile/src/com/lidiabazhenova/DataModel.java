package com.lidiabazhenova;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

class DataModel extends DefaultTableModel{
	  List<String[]> data = new ArrayList<String[]>();

//	 Конструктор
	public DataModel(){
	for ( int i = 0; i < data.size(); i++) {
	  data.add(new String[getColumnCount()]);
	}
	};

	// Получение элемента
	public Object getValueAt(int rowIndex, int columnIndex){
	    String[] row = data.get(rowIndex);
	    return row[columnIndex];
	};
	// Добавление элемента
	public void setValueAt(String[] value){
	    String[] row = new String[getColumnCount()];
	    row = value;
	    data.add(row);
	};
	// Изменение элемента
	public void updateValue(String newValue, int rowIndex, int columnIndex){
	    String[] row = data.get(rowIndex);
	    row[columnIndex] = newValue;
	};
	// количество строк
	public int getRowCount()
	{
	    return data.size();
	};
	// количество столбцов
	public int getColumnCount()
	{
	    return 10;
	};
	}
