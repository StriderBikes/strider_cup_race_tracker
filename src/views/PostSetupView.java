package views;
import models.*;
import controllers.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;


public class PostSetupView {
	CupManager cm;
	private JFrame frame;
	private JTabbedPane tab_pane;
	private JButton btnAddGroups;
	//private JButton edit_race;
	//private JButton edit_racer;
	//private JList racer_list;
	//private JList race_list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CupManager cm) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostSetupView window = new PostSetupView(cm);
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
	public PostSetupView(CupManager cm) {
		this.cm = cm;
		initialize();
		this.frame.setVisible(true);
		this.setup_race_group_tabs();
		//this.set_button_actions();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1017, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.tab_pane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(this.tab_pane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		this.tab_pane.addTab("Settings", null, panel, null);
		
		btnAddGroups = new JButton("Add Groups");
		panel.add(btnAddGroups);
		btnAddGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back_to_group_config();
			}
		});
	}
	
	private void setup_race_group_tabs() {
		for (int ix = 0; ix < this.cm.get_num_groups(); ix++) {
			AgeGroup current_group = this.cm.get_age_group(ix);
		}
	}
	
	public void back_to_group_config() {
		System.out.println("going back to group config");
		MainView mv = new MainView(this.cm);
	}
}
