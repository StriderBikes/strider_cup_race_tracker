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
	ArrayList<Integer> race_cutoffs = new ArrayList<Integer>();
	
	String group_title;
	private Integer num_gates;
	private Integer group_id;
	private Integer num_racers;
	private Integer heat_cutoff = 1;
	
	
	//constructor
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
		if(num_races < this.num_gates) {
			int g = this.num_gates/2;
			if(this.num_racers % g == 0) {
				num_races = this.num_racers / g;
			} else {
				num_races = (this.num_racers / g) + 1;
			}
		} else {
		if(leftovers > 0) {
			num_races += 1;
			if((leftovers + (num_races*2)) < this.num_gates) {
				num_races += 1;
			} 
		}
		}
		for(int ix = 0; ix < num_races; ix++) {
			Race new_race = new Race(this.group_id, String.format("this.group_title_%d", ix));
			this.heat_race_list.add(new_race);
		}
		System.out.println(String.format("created %d new heat races", num_races));
	}
	
	public int get_gid() {
		return this.group_id;
	}
	public int get_num_racers() {
		return this.num_racers;
	}
	public int get_num_gates() {
		return this.num_gates;
	}
}
