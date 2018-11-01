package models;

import javax.swing.table.AbstractTableModel;

public class RaceTableModel extends AbstractTableModel{

	private String[] columnNames;
	private Object[][] data;
	
	
	public RaceTableModel(String[] col_names, Object[][] data_vals) {
		this.columnNames = col_names;
		this.data = data_vals;
	}
	
	
	
	
}
