package views;
import models.*;
import controllers.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PostSetupView {
	CupManager cm;
	private JFrame frame;
	private JTabbedPane tab_pane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostSetupView window = new PostSetupView();
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
	public PostSetupView() {
		initialize();
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
		this.tab_pane.addTab("New tab", null, panel, null);
	}
	
	private void setup_race_group_tabs() {
		for (int ix = 0; ix < this.cm.get_num_groups(); ix++) {
			AgeGroup current_group = this.cm.get_age_group(ix);
			JPanel group_panel = new JPanel();
			this.tab_pane.addTab(current_group.get_title(), null, group_panel, null);
		}
	}
	
	private void PostSetupView(CupManager cup_manager) {
		this.cm = cup_manager;
	}

}
