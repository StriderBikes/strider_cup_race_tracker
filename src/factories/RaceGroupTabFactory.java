package factories;
import models.*;
import views.RaceGroupView;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class RaceGroupTabFactory {
	JTabbedPane p;
	public RaceGroupTabFactory(JTabbedPane parent) {
		this.p = parent;
	}
	
	public RaceGroupView new_jpanel(AgeGroup current_group) {
		RaceGroupView rgv = new RaceGroupView(current_group.get_heat_ids(), current_group.get_racer_ids_as_strings(), current_group.get_main_ids());
		//rgv.racer_list = new JList();
		//rgv.race_list = new JList();
		rgv.build_panel();
		this.p.addTab(current_group.get_title(), null, rgv.panel, null);
		return rgv;
	}
}
