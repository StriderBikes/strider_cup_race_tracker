package factories;
import models.*;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.*;

public class RaceGroupTabFactory {
	JTabbedPane p;
	CupManager cm;
	public RaceGroupTabFactory(JTabbedPane parent, CupManager cm) {
		this.cm = cm;
		this.p = parent;
	}
	
	public JPanel new_jpanel(AgeGroup current_group) {
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
		return group_panel;
	}
}
