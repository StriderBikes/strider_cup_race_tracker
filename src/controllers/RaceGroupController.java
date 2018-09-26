package controllers;
import factories.*;
import views.*;
import models.*;
import java.util.ArrayList;
import java.awt.event.*;

public class RaceGroupController {
	PostSetupView root_view;
	CupManager cm;
	ArrayList<RaceGroupView> jPanels = new ArrayList<RaceGroupView>();
	public RaceGroupController(CupManager cm) {
		this.cm = cm;
		this.setup_views();
	}
	
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
					trigger_dialog(cm.get_racer_by_jersey(Integer.parseInt(rgv.racer_list.getSelectedValue().toString())));
				}
			});
			this.jPanels.add(rgv);
		}
	}
	
	public void trigger_dialog(Racer r) {
		System.out.println("trigger called");
		RacerController rc = new RacerController(r);
	}
	
}
