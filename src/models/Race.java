package models;

import java.util.ArrayList;

public class Race {
	private static int avg_race_time = 5;
	protected Boolean timeOptimized = false;
	protected Integer ageGroupId;
	private ArrayList<Racer> racerList = new ArrayList<Racer>();
	private String unique_race_id;
	//constructor
	public Race(Integer ageGroup, String r_id) {
		this.ageGroupId = ageGroup;
		this.unique_race_id = r_id;
	}
	
	//getter & setters
	
	public void add_racer(Racer r) {
		this.racerList.add(r);
		return;
	}
	
	public Racer get_racer_at_index(int ix) {
		return this.racerList.get(ix);
	}
	
	public Boolean is_time_optimized() {
		return this.timeOptimized;
	}
}
