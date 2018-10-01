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
	
	//getters and setters
	
	public ArrayList<Race> get_heats() {
		return this.heat_race_list;
	}
	
	public String[] get_heat_ids() {
		String[] id_strings = new String[this.heat_race_list.size()];
		for(int x = 0; x < this.heat_race_list.size(); x++) {
			id_strings[x] = this.heat_race_list.get(x).get_race_id();
		}
		return id_strings;
	}
	
	public String get_title() {
		return this.group_title;
	}
	public void set_races() {
		int g = this.num_gates;
		int num_races = this.num_racers / g;
		int leftovers = this.num_racers % g;
		if(num_races < this.num_gates) {
			g = this.num_gates/2;
			if(this.num_racers % g == 0) {
				num_races = this.num_racers / g;
			} else {
				num_races = (this.num_racers / g) + 1;
			}
		} else {
		if(leftovers > 0) {
			num_races += 1;
		}
		if (num_races > 20) {
			g = g *2;
			if(this.num_racers % g == 0) {
				num_races = this.num_racers/g;
			} else {
				num_races = (this.num_racers / g) + 1;
			}
		}
		}
		for(int ix = 0; ix < num_races; ix++) {
			Race new_race = new Race(this.group_id, String.format(this.group_title +"_%d", ix));
			this.heat_race_list.add(new_race);
		}
		System.out.println(String.format("created %d new heat races for race group: %s", num_races, this.group_title));
	}
	
	private void fill_mains_with_racers() {
		
	}
	
	public String[] get_racer_ids() {
		String[] out = new String[this.racer_ids.size()];
		for(int x = 0; x < this.racer_ids.size(); x++) {
			out[x] = Integer.toString(this.racer_ids.get(x));
		}
		return out;
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
