package models;
import java.util.ArrayList;

public class CupManager {
	//class variables
	private int racer_id_last = 101; //start our racer Ids at 101 so that they can be used as jersey nums too
	private ArrayList<AgeGroup> age_groups = new ArrayList<AgeGroup>();
	private ArrayList<Racer> racer_list = new ArrayList<Racer>();
	int gates;
	// this signifies the top n racers that will move on from each heat
	int heat_cutoff = 2;
	//constructors
	public void CupManager() {
		System.out.println("created new CupManager instance");
	}
	
	/*
	public CupManager(int num_participants) {
		// TODO Auto-generated constructor stub
		this.participants = new Racer[num_participants];	
		for(int i = 0; i < num_participants; i++) {
			Racer newbie = new Racer(i);
			this.participants[i] = newbie;
		}
	}
	
	public CupManager(AgeGroup[] groups) {
		//this.age_groups = new AgeGroups[groups.length];
		this.age_groups = groups;
	}
	 */
	
	// getters and setters
	public int get_num_groups() {
		return this.age_groups.size();
	}
	
	public AgeGroup get_age_group(int idx) {
		return this.age_groups.get(idx);
	}
	
	// handles logic associated with adding a new race group
	public void add_new_group(AgeGroup a) {
		for(int i = 0; i < a.num_racers; i++) {
			this.racer_id_last = this.racer_id_last + 1;
			Racer newest = new Racer(this.racer_id_last);
			a.racer_ids.add(this.racer_id_last);
			this.racer_list.add(newest);
		}
	}
	
	public void set_up_cup() {
		for(int ix = 0; ix < this.age_groups.size(); ix ++) {
			this.age_groups.get(ix).set_races();
		}
	}
}
