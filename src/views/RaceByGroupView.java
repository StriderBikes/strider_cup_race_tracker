package views;
import models.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class RaceByGroupView {
	
	
	//property declarations
	
	private JFrame frame;
	private JTable table;
	public AgeGroup raceGroup;
	public Object[] col_names;
	public Object[][] row_values;
	
	
	/**
	 * overloading the only constructor method that
	 * will be used for the time being, passing in 
	 * our age group so that we can build a table 
	 * of our race objects, FUN
	 * Create the application.
	 */
	public RaceByGroupView(AgeGroup ag) {
		this.raceGroup = ag;
		initialize_with_ag();
		this.frame.setVisible(true);
	}
	//not overloaded, no age group provided
	public RaceByGroupView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1970, 799);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		frame.getContentPane().add(table);
	}
	private void initialize_with_ag() {
		/**
		 * here we will set our frame, create our Object[] 
		 * for column headers and collect our row values into a 
		 * Object[][], after this we can create the table and set the frame
		 * to visible -> true
		 */
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1970, 799);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		/*
		for(int race_idx = 0; race_idx < this.raceGroup.get_heats().size(); race_idx++) {
			Race loop_race = this.raceGroup.get_heats().get(race_idx);
			Object[] col_names = new String[loop_race.get_num_racers()];
			Object[][] row_vals = new Object[1][loop_race.get_num_racers()];
			for(int l_racer = 0; l_racer < loop_race.get_num_racers(); l_racer++) {
				col_names[l_racer] = loop_race.get_race_id() + String.format("_%d", l_racer+1);
				row_vals[0][l_racer] = loop_race.get_racer_list().get(l_racer);
				JTable table = new JTable(row_vals, col_names);
				frame.getContentPane().add(table);
			}
		}
		*/
		/**
		 * gonna loop through our object setting up our table with a model
		 */
		this.col_names = new Object[this.raceGroup.get_heats().get(0).get_num_racers() + 1];
		this.row_values = new Object[this.raceGroup.get_heats().size()][this.raceGroup.get_heats().get(0).get_num_racers() + 1];
		this.col_names[0] = "Race Name/ID";
		Integer max_row_length = 0;
		for(int x = 0; x < this.raceGroup.get_heats().get(0).get_num_racers(); x++) {
			this.col_names[x+1] = String.format("%d pos", x+1);
		}
		DefaultTableModel tm = new DefaultTableModel(this.col_names, 0);
		for(int ix = 0; ix < this.raceGroup.get_heats().size(); ix++) {
			Race row_race = this.raceGroup.get_heats().get(ix);
			//this.row_values[ix][0] = row_race.get_race_id();
			tm.addRow(row_race.get_race_table_vals(ix, false, this.col_names.length));
		}
		//System.out.println(String.format("%d columns %d max row length", this.col_names.length, max_row_length));
		JTable table = new JTable(tm);
		table.setFont(new Font("Serif", Font.PLAIN, 21));
		table.setBackground(Color.CYAN);
		this.frame.add(new JScrollPane(table), "cell 1 2");
	}

}
