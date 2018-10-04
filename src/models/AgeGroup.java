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
	//list properties
	ArrayList<Race> heat_race_list = new ArrayList<Race>();
	ArrayList<Race> main_race_list = new ArrayList<Race>();
	ArrayList<Racer> racers = new ArrayList<Racer>();
	ArrayList<Integer> race_cutoffs = new ArrayList<Integer>();
	// non-list properties
	String group_title;
	private Integer num_gates;
	private Integer group_id;
	private Integer num_racers;
	private Integer heat_cutoff = 1;
	
	
	/**
	 * methods
	 */
	//constructor
	public AgeGroup(String gt, int gID, int gates, int num_racers) {
		this.group_id = gID;
		this.group_title = gt;
		this.num_gates = gates;
		this.num_racers = num_racers;
	}
	
	//getters and setters
	
	// get heat race list
	public ArrayList<Race> get_heats() {
		return this.heat_race_list;
	}
	
	//get the ids for each heat as an array of strings
	public String[] get_heat_ids() {
		String[] id_strings = new String[this.heat_race_list.size()];
		for(int x = 0; x < this.heat_race_list.size(); x++) {
			id_strings[x] = this.heat_race_list.get(x).get_race_id();
		}
		return id_strings;
	}
	//get the title of this group
	public String get_title() {
		return this.group_title;
	}
	//get the list of main races
	public ArrayList<Race> get_main_list(){
		return this.main_race_list;
	}
	//get the ids for the main races as an array of strings
	public String[] get_main_ids() {
		String[] id_strings = new String[this.main_race_list.size()];
		for(int ix = 0; ix < this.main_race_list.size(); ix++) {
			id_strings[ix] = this.main_race_list.get(ix).get_race_id();
		}
		return id_strings;
	}
	/**
	 * set race sizes for our mains
	 * should be noted that all races n except n-1
	 * will be set to +1 the number of racers 
	 * it is initially filled with to accomodate the
	 * first place winner from the prior main to be 
	 * included
	 */
	public void set_main_cutoffs() {
		this.main_race_list.add(new Race(this.group_id, "main_1"));
		Integer less_mains = this.heat_race_list.size() / (this.heat_race_list.size()/3);
		Integer sub_size = this.racers.size() / less_mains;
		Integer sub_remain = this.racers.size() % less_mains;
		for(int idx = 0; idx < less_mains; idx++) {
			this.main_race_list.add(new Race(this.group_id, String.format("main_%d", idx +2), sub_size));
		}
		Integer current = this.main_race_list.get(this.main_race_list.size()-1).get_num_racers();
		this.main_race_list.get(this.main_race_list.size()-1).set_num_racers(current+sub_remain);
		System.out.println("created mains: " + this.main_race_list.toString());
	}
	/**
	 * this is our logic for breaking down number of racers
	 * into a number of heats for any given race gate size,
	 * makes a call to fill these newly created races in an unopinionated way
	 * at the end of the function
	 */
	public void set_races() {
		int g = this.num_gates;
		int num_races = this.num_racers / g;
		int leftovers = this.num_racers % g;
		if(num_races < this.num_gates/4) {
			g = this.num_gates/2;
			if(this.num_racers % g == 0) {
				num_races = this.num_racers / g;
			} else {
				num_races = (this.num_racers / g) + 1;
			}
		} else if (num_races > 10) {
			g = this.num_gates * 2;
			num_races = this.num_racers / g;
			if(this.num_racers % g != 0) {
				num_races++; 
			} 
		}else {
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
		this.fill_heats_with_racers();
	}
	
	// this will take the number of racers we have and systemitically 
	// add them to heat races
	private void fill_heats_with_racers() {
		int ix = 0;
		for(int x = 0; x < this.racers.size(); x++) {
			this.heat_race_list.get(ix).add_racer(this.racers.get(x));
			if (ix < this.heat_race_list.size()-1) {
				ix++;
			} else {
				ix = 0;
			}
		}
		for(int s = 0; s < this.heat_race_list.size(); s++) {
			Race current = this.heat_race_list.get(s);
			System.out.println(String.format("race %s created with %d racers",current.get_race_id(), current.get_racer_list().size()));
		}
		this.set_main_cutoffs();
	}
	// needed to display list of racer ids on main Race Group Page
	public String[] get_racer_ids_as_strings() {
		String[] out = new String[this.racers.size()];
		for(int x = 0; x < this.racers.size(); x++) {
			out[x] = Integer.toString(this.racers.get(x).get_jersey_number());
		}
		return out;
	}
	/**
	 * get list of all racers in this age group
	 * @return
	 */
	public ArrayList<Racer> get_full_racer_list(){
		return this.racers;
	}
	
	/**
	 * given the jersey number of a racer in this age group
	 * this method returns the racer object
	 * @param jerseyNum
	 * @return
	 */
	public Racer get_racer_by_jersey(Integer jerseyNum) {
		for(Racer nr: this.racers) {
			if (nr.get_jersey_number() == jerseyNum) {
				return nr;
			}
		} 
		Racer new_r = new Racer(jerseyNum);
		return new_r;
	}
	
	
	/**
	 * given the race id string, and a boolean as
	 * to whether it is a main race or a heat race
	 * this method returns the race object with the 
	 * specified race_id 
	 * @param race_id
	 * @param is_main
	 * @return
	 */
	public Race get_race_by_id(String race_id, boolean is_main) {
		if(!is_main) {
			for (Race r: this.heat_race_list) {
				if(r.get_race_id() == race_id) {
					return r;
				}
			}
		} else {
			for (Race mR: this.main_race_list) {
				if(mR.get_race_id() == race_id) {
					return mR;
				}
			}
		}
		return new Race(this.group_id, race_id);
	}
	
	
	// get this groups id
	public int get_gid() {
		return this.group_id;
	}
	// get the number of total racers in this group
	public int get_num_racers() {
		return this.num_racers;
	}
	// get the number of gates for this group
	public int get_num_gates() {
		return this.num_gates;
	}
}
