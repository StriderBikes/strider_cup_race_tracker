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
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
public class MainView {

	private JFrame frame;

	CupManager cm;
	private JTextField textField_1;
	private JTextField textField_2;
	JTree groupTree;
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
		this.cm = new CupManager();
		frame.setBounds(100, 100, 888, 632);
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
		frame.getContentPane().setLayout(new MigLayout("", "[883px,grow]", "[20px][][][][][][][][][163.00,grow][]"));
		
		JLabel lblStriderCupRace = new JLabel("Strider Cup Race Tracker");
		frame.getContentPane().add(lblStriderCupRace, "cell 0 0,growx,aligny top");
		
		JLabel lblEnterTheAge = new JLabel("Enter the Age Group Title");
		frame.getContentPane().add(lblEnterTheAge, "cell 0 2");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 0 3,growx");
		textField_1.setColumns(10);
		
		JLabel lblNumberOfStarting = new JLabel("Number of Starting Gates");
		frame.getContentPane().add(lblNumberOfStarting, "cell 0 4");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "cell 0 5,growx");
		textField_2.setColumns(10);


		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Race Groups");
		
		JButton btnAddAgeGroup = new JButton("Add Age Group");
		frame.getContentPane().add(btnAddAgeGroup, "cell 0 6");
		btnAddAgeGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("adding age group");
				add_age_group(e);
			}
		});
		this.groupTree = new JTree(root);
		frame.getContentPane().add(groupTree, "cell 0 9,grow");

		JButton btnCreateEvent = new JButton("Create Event");
		frame.getContentPane().add(btnCreateEvent, "cell 0 10");
	}

	// called by add age group action event
	public void add_age_group(ActionEvent e) {
		System.out.println("add group clicked");
		String groupTitle = this.textField_1.getText();
		int num_gates = Integer.valueOf(this.textField_2.getText());
		int new_id = this.cm.age_groups.size() + 1;
		this.cm.age_groups.add(new AgeGroup(groupTitle, new_id, num_gates));
		DefaultMutableTreeNode new_group = new DefaultMutableTreeNode(groupTitle);
		
	}

	
}
