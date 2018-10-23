package controllers;
import factories.*;
import views.*;
import models.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.*;

/**
 * this is the main controller for the race group view
 * it handles to calling of our tab panel factory and storing those objects
 * as well as the methods to be called by our button action listeners
 * @author nick.williams
 *
 */

public class RaceGroupController {
	//PROPERTIES
	RaceByGroupView rbgv;
	PostSetupView root_view;
	RaceController new_rc;
	RacerController rc;
	CupManager cm;
	// the following map property is used to store goupID's and 
	//map them to the index of there group panel
	Map<Integer, Integer> group_to_panel_map = new HashMap<Integer, Integer>(); 
	ArrayList<RaceGroupView> jPanels = new ArrayList<RaceGroupView>();

	//METHODS
	//constructor
	public RaceGroupController(CupManager cm) {
		this.cm = cm;
		this.setup_views();
	}
	
	//initializes our view and calls the
	//method that uses our factory to create and 
	//add tab panels
	private void setup_views() {
		this.root_view = new PostSetupView(this.cm);
		this.setup_race_group_tabs();
	}
	private void setup_race_group_tabs() {
		RaceGroupTabFactory rgtf = new RaceGroupTabFactory(this.root_view.get_tab_pane());
		for (int ix = 0; ix < this.cm.get_num_groups(); ix++) {
			AgeGroup current_group = this.cm.get_age_group(ix);
			RaceGroupView rgv = rgtf.new_jpanel(current_group);
			rgv.edit_racer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("user trying to edit racer lol");
					trigger_dialog(current_group.get_racer_by_jersey(Integer.parseInt(rgv.racer_list.getSelectedValue().toString())));
				}
			});
			rgv.edit_race.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("user clicked edit race");
					edit_race_dialog_init(current_group.get_race_by_id(rgv.race_list.getSelectedValue().toString(), false));
				}
			});
			rgv.goto_race_view.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					goto_full_race_view(current_group);
				}
			});
			rgv.add_racer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("user clicked add racer");
					add_racer(current_group.get_gid(), current_group.get_num_racers());
				}
			});
			this.jPanels.add(rgv);
			this.group_to_panel_map.put(current_group.get_gid(), this.jPanels.indexOf(rgv));
		}
	}
	public void add_racer(Integer racegroupID, Integer num_racers) {
		this.rc = new RacerController(racegroupID, num_racers + 102); // add 102 since we start at 101 and only add one racer at time
		this.cm.get_age_group(racegroupID).get_full_racer_list().add(this.rc.return_racer());
		this.jPanels.get(this.group_to_panel_map.get(racegroupID));
	}
	
	//instantiates race controller
	public void edit_race_dialog_init(Race edit_race) {
		System.out.println("editing race : " + edit_race.get_race_id());
		this.new_rc = new RaceController(edit_race);
	}
	//instantiates racer controller
	public void trigger_dialog(Racer r) {
		System.out.println("trigger called");
		RacerController rc = new RacerController(r);
	}
	//instantiates full view controller
	public void goto_full_race_view(AgeGroup ag) {
		System.out.println("nice try big boi");
		this.rbgv = new RaceByGroupView(ag);
	}
	
}
