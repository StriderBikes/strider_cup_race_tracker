package views;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.*;

/**
 * this is a template layout for our RaceGroupTabFactory to build the 
 * perfect JGroup TabPanel
 * @author nick.williams
 *
 */
public class RaceGroupView {
	
	public RaceGroupView(String[] races, String[] racers, String[] mains) {
		this.panel = new JPanel();
		this.race_list = new JList(races);
		this.racer_list = new JList(racers);
		this.main_list = new JList(mains);
		this.edit_race = new JButton("edit/view race");
		this.edit_racer = new JButton("edit/view racer");
		this.edit_main = new JButton("edit/view finals race");
		return;
	}
	public JButton edit_racer;
	public JButton edit_race;
	public JButton edit_main;
	public JList race_list;
	public JList racer_list;
	public JList main_list;
	public JScrollPane mains_pane;
	public JScrollPane racer_pane;
	public JScrollPane race_pane;
	public JPanel panel;
	
	private void add_racer_scroll_pane() {
		this.racer_pane = new JScrollPane(this.racer_list);
		this.panel.add(this.racer_pane);
	}
	private void add_race_scroll_pane() {
		this.race_pane = new JScrollPane(this.race_list);
		this.panel.add(this.race_pane);
	}
	
	private void add_main_race_scroll_pane() {
		this.mains_pane = new JScrollPane(this.main_list);
		this.panel.add(this.mains_pane);
	}
	
	public void build_panel() {
		this.panel.add(new JLabel("race list:"));
		this.panel.add(this.edit_race);
		this.add_race_scroll_pane();
		this.panel.add(new JLabel("            "));
		this.panel.add(this.edit_racer);
		this.panel.add(new JLabel("racer list"));
		this.add_racer_scroll_pane();
		//this.panel.add(this.edit_main);
		//this.panel.add(new JLabel("Finals race list"));
		//this.add_main_race_scroll_pane();
	}
	
}
