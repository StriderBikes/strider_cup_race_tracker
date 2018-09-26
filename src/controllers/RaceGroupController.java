package controllers;
import factories.*;
import views.*;
import models.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RaceGroupController {
	PostSetupView root_view;
	CupManager cm;
	ArrayList<JPanel> jPanels = new ArrayList<JPanel>();
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
			rgtf.new_jpanel(current_group);
		}
	}
	
}
