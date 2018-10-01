package models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Race {
	private static int avg_race_time = 5;
	protected Boolean timeOptimized = false;
	protected Integer ageGroupId;
	private Map<Integer,Integer> finishPositions = new HashMap<Integer, Integer>();
	private ArrayList<Integer> racerList = new ArrayList<Integer>();
	private String unique_race_id;
	//constructor
	public Race(Integer ageGroup, String r_id) {
		this.ageGroupId = ageGroup;
		this.unique_race_id = r_id;
	}
	
	//getter & setters
	
	public void add_racer(Integer r_id) {
		this.racerList.add(r_id);
		return;
	}
	
	public Integer get_racer_at_index(int ix) {
		return this.racerList.get(ix);
	}
	
	public Boolean is_time_optimized() {
		return this.timeOptimized;
	}
	public String get_race_id() {
		return this.unique_race_id;
	}
}
