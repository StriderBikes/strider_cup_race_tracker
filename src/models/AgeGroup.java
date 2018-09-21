package models;
import java.util.ArrayList;

public class AgeGroup {
	/**
	 * we store an array or racer ids
	 * so that we can know how they are finishing
	 * and then we can use the length of the array
	 * to derive number of participants in this age 
	 * group
	 */
	//empty races list, will be packed with method FillRaces()
	ArrayList<Race> heat_race_list = new ArrayList<Race>();
	ArrayList<Race> main_race_list = new ArrayList<Race>();
	ArrayList<Integer> racer_ids = new ArrayList<Integer>();
	String group_title;
	Integer num_gates;
	Integer group_id;
	Integer num_racers;
	Integer heat_cutoff = 1;
	
	public AgeGroup(String gt, int gID, int gates, int num_racers) {
		this.group_id = gID;
		this.group_title = gt;
		this.num_gates = gates;
		this.num_racers = num_racers;
	}
	
	public String get_title() {
		return this.group_title;
	}
	public void set_races() {
		int num_races = this.num_racers / this.num_gates;
		int leftovers = this.num_racers % this.num_gates;
		if(leftovers > 0) {
			num_races += 1;
			if((leftovers + (num_races*2)) < this.num_gates) {
				num_races += 1;
			} 
		}
		for(int ix = 0; ix < num_races; ix++) {
			Race new_race = new Race();
		}
	}
	
}
