package models;

import javax.swing.table.AbstractTableModel;

public class RaceTableModel extends AbstractTableModel{

	private String[] columnNames;
	private Object[][] data;
	
	
	public RaceTableModel(String[] col_names, Object[][] data_vals) {
		this.columnNames = col_names;
		this.data = data_vals;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.length;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.data.length;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return this.data[rowIndex][columnIndex];
	}
	
	
	
	
}
