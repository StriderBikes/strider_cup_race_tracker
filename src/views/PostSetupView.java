package views;
import models.*;
import controllers.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class PostSetupView {
	CupManager cm;
	private JFrame frame;
	private JTabbedPane tab_pane;
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
	}
	
	private void setup_race_group_tabs() {
		for (int ix = 0; ix < this.cm.get_num_groups(); ix++) {
			AgeGroup current_group = this.cm.get_age_group(ix);
			JPanel group_panel = new JPanel();
			JList racer_list = new JList(current_group.get_racer_ids());
			JList race_list = new JList(current_group.get_heat_ids());
			JButton edit_race = new JButton("edit/view race");
			JButton edit_racer = new JButton("edit/view racer");
			group_panel.add(new JLabel("race list:"));
			group_panel.add(edit_race);
			group_panel.add(new JScrollPane(race_list));
			group_panel.add(edit_racer);
			group_panel.add(new JLabel("racer list"));
			group_panel.add(new JScrollPane(racer_list));
			this.tab_pane.addTab(current_group.get_title(), null, group_panel, null);
		}
	}
}
