package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Race {
	private static int avg_race_time = 5;
	protected Boolean timeOptimized = false;
	protected Integer ageGroupId;
	private Map<Integer,Integer> finishPositions = new HashMap<Integer, Integer>();
	private ArrayList<Racer> racerList = new ArrayList<Racer>();
	private String unique_race_id;
	//constructor
	public Race(Integer ageGroup, String r_id) {
		this.ageGroupId = ageGroup;
		this.unique_race_id = r_id;
	}
	
	//getter & setters
	
	public void add_racer(Racer new_racer) {
		this.racerList.add(new_racer);
		return;
	}
	
	public Racer get_racer_at_index(int ix) {
		return this.racerList.get(ix);
	}
	
	public Boolean is_time_optimized() {
		return this.timeOptimized;
	}
	public String get_race_id() {
		return this.unique_race_id;
	}
	public void update_finish_map(Integer finish_position, Racer racer_object) {
		this.finishPositions.put(finish_position, racer_object.get_jersey_number());
		racer_object.set_finsish_postion(this.get_race_id(), finish_position);
	}
}
