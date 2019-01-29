package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * this class represents our
 * race objects, as such we will use it to store its
 * racer objects as an array and then store the finish
 * results in a hash map following a 
 * finish_position -> racer_id schema
 * 
 * when in doubt i set my class properties to private and 
 * wrote accessesors, this has proved to valuable as 
 * I find myself putting logic that would be tempting to 
 * place in the controller or view in these getters and 
 * setters which helps me stick to fat models/skinny controller/views 
 * design practice
 * @author nick.williams
 *
 */

public class Race {
	private static int avg_race_time = 5;
	protected Boolean timeOptimized = false;
	protected Integer ageGroupId;
	private boolean is_complete = false;
	private int num_racers = 0;
	private Map<Integer,Integer> finishPositions = new HashMap<Integer, Integer>();
	private ArrayList<Racer> racerList = new ArrayList<Racer>();
	private String unique_race_id;
	//constructor
	public Race(Integer ageGroup, String r_id) {
		this.ageGroupId = ageGroup;
		this.unique_race_id = r_id;
	}
	
	public Race(Integer ageGroup, String id, Integer num_racers) {
		this.num_racers = num_racers;
		this.unique_race_id = id;
	}
	
	public void set_num_racers(Integer nr) {
		this.num_racers = nr;
	}
	public Integer get_num_racers() {
		return this.num_racers;
	}
	//getter & setters
	
	public void add_racer(Racer new_racer) {
		this.racerList.add(new_racer);
		this.num_racers++;
		return;
	}
	
	public void complete_race() {
		this.is_complete = true;
	}
	public Racer get_racer_by_id(Integer jNum) {
		for(int ix = 0; ix < this.racerList.size(); ix++) {
			if(this.racerList.get(ix).get_jersey_number() == jNum) {
				return this.racerList.get(ix);
			}
		}
		return new Racer(jNum);
	}
	public Boolean is_time_optimized() {
		return this.timeOptimized;
	}
	public String get_race_id() {
		return this.unique_race_id;
	}
	public ArrayList<Racer> get_racer_list(){
		return this.racerList;
	}
	
	
	public String[] get_jersey_nums() {
		String[] j_nums = new String[this.racerList.size()];
		for(int ix = 0; ix < this.racerList.size(); ix++) {
			j_nums[ix] = Integer.toString(this.racerList.get(ix).get_jersey_number());
		}
		return j_nums;
	}
	public void update_finish_map(Integer finish_position, Racer racer_object) {
		this.finishPositions.put(finish_position, racer_object.get_jersey_number());
		racer_object.set_finish_postion(this.get_race_id(), finish_position);
	}
	public Map get_finish_map() {
		return this.finishPositions;
	}
	
	public Object[] get_race_table_vals(Integer ag_num_id, boolean is_main, Integer required_length) {
		String prefix = is_main ? "MAIN": "HEAT";
		Object[] race_vals = new Object[required_length];
		this.ageGroupId = ag_num_id;
		race_vals[0] = String.format("HEAT_%d", this.ageGroupId);
		int valx = 0;
		for(Racer tr: this.racerList) {
			valx++;
			race_vals[valx] = String.format("%d", tr.get_jersey_number());
		}
		return race_vals;
	}
}
