package views;
import models.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;


public class RaceByGroupView {

	private JFrame frame;
	private JTable table;
	public AgeGroup raceGroup;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaceByGroupView window = new RaceByGroupView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * overloading the only constructor method that
	 * will be used for the time being, passing in 
	 * our age group so that we can build a table 
	 * of our race objects, FUN
	 * Create the application.
	 */
	public RaceByGroupView(AgeGroup ag) {
		initialize();
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

}
