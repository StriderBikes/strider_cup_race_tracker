package views;

import java.awt.EventQueue;
import models.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.event.*;
public class MainView {

	private JFrame frame;
	private JTextField textField;

	CupManager cm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 905, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);
		
		JMenuItem mntmSave = new JMenuItem("save");
		mnFile.add(mntmSave);
		frame.getContentPane().setLayout(new MigLayout("", "[883px,grow]", "[20px][][][][][][grow][][][]"));
		
		JLabel lblStriderCupRace = new JLabel("Strider Cup Race Tracker");
		frame.getContentPane().add(lblStriderCupRace, "cell 0 0,growx,aligny top");
		
		JLabel lblNumberOfRacers = new JLabel("Number of Racers");
		frame.getContentPane().add(lblNumberOfRacers, "cell 0 2");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 0 3,growx");
		textField.setColumns(10);
		
		JButton btnCreateCup = new JButton("Create Cup");
		frame.getContentPane().add(btnCreateCup, "cell 0 4");
		btnCreateCup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("new cup manager created");
			}
		});
		
		JTree tree = new JTree();
		frame.getContentPane().add(tree, "cell 0 6,grow");
		
		JButton btnAddAgeGroup = new JButton("Add Age Group");
		frame.getContentPane().add(btnAddAgeGroup, "cell 0 7");
	}

	private void create_cup_pressed(ActionEvent e) {
		System.out.println("creating cup manager");
		int new_part_count = Integer.valueOf(this.textField.getText());
		this.cm = new CupManager(new_part_count);
	}
	
}
