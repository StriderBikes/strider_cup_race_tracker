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
	private JTextField textField;
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
		frame.getContentPane().setLayout(new MigLayout("", "[883px,grow]", "[20px][][][][][][][][163.00,grow][][]"));
		
		JLabel lblStriderCupRace = new JLabel("Strider Cup Race Tracker");
		frame.getContentPane().add(lblStriderCupRace, "cell 0 0,growx,aligny top");
		
		JLabel lblEnterTheAge = new JLabel("Enter the Age Group Title");
		frame.getContentPane().add(lblEnterTheAge, "cell 0 1");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 0 2,growx");
		textField_1.setColumns(10);


		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Race Groups");
		
		JLabel lblNumberOfRacers = new JLabel("Number of Racers");
		frame.getContentPane().add(lblNumberOfRacers, "cell 0 3");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 0 4,growx");
		textField.setColumns(10);
		
		JLabel lblNumberOfStarting = new JLabel("Number of Starting Gates");
		frame.getContentPane().add(lblNumberOfStarting, "cell 0 5");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "cell 0 6,growx");
		textField_2.setColumns(10);
		
		JButton btnAddAgeGroup = new JButton("Add Age Group");
		frame.getContentPane().add(btnAddAgeGroup, "cell 0 7");
		btnAddAgeGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("adding age group");
				add_age_group(e);
			}
		});
		this.groupTree = new JTree(root);
		frame.getContentPane().add(groupTree, "cell 0 8,grow");

		JButton btnCreateEvent = new JButton("Create Event");
		frame.getContentPane().add(btnCreateEvent, "flowx,cell 0 9");
		
		JButton btnSaveGroupConfige = new JButton("Save Group Config");
		btnSaveGroupConfige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("filesavetriggered");
				save_config(arg0);
			}
		});
		frame.getContentPane().add(btnSaveGroupConfige, "cell 0 9");
		btnCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("create cup clicked");
				set_up_races_and_goto_postsetup();
			}
		});
	}

	// called by add age group action event
	public void add_age_group(ActionEvent e) {
		System.out.println("add group clicked");
		String groupTitle = this.textField_1.getText();
		int num_gates = Integer.valueOf(this.textField_2.getText());
		int new_id = this.cm.get_num_groups()+1;
		int num_racers = Integer.valueOf(this.textField.getText());
		System.out.println(String.format("adding group id = %d to cup manager", new_id));
		AgeGroup new_AG = new AgeGroup(groupTitle, new_id, num_gates, num_racers); //new age group object
		this.cm.add_new_group(new_AG);
		this.add_age_group_to_tree(groupTitle, new_id, num_gates, num_racers);
	}
	public void add_age_group_to_tree(String gTitle, int gID, int gates, int racers) {
		DefaultMutableTreeNode new_group = new DefaultMutableTreeNode(gTitle);
		DefaultMutableTreeNode id_node = new DefaultMutableTreeNode(String.format("group id: %d", gID));
		DefaultMutableTreeNode gate_node = new DefaultMutableTreeNode(String.format("gates: %d", gates));
		DefaultMutableTreeNode racers_node = new DefaultMutableTreeNode(String.format("number of racers: %d", racers));
		new_group.add(id_node);
		new_group.add(gate_node);
		new_group.add(racers_node);
		DefaultMutableTreeNode root_node = (DefaultMutableTreeNode)this.groupTree.getModel().getRoot();
		root_node.add(new_group);
		DefaultTreeModel new_model = (DefaultTreeModel)this.groupTree.getModel();
		new_model.reload();
	}
	
	public void set_up_races_and_goto_postsetup() {
		System.out.println("still being implemented");
		for(int ix = 0; ix < this.cm.get_num_groups(); ix++) {
			AgeGroup c_ag = this.cm.get_age_group(ix);
			c_ag.set_races();
		}
	}
	public void save_config(ActionEvent e) {
		this.cm.save_as_groups_csv();
	}
}
