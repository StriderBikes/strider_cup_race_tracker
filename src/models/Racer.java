package models;

public class Racer {
	String racer_name = "";
	private Integer age;
	String gaurdName = "";
	Integer racerID;
	private Integer jerseyNumber;
	Integer ageGroupId;
	private String lastRaceID = "";
	private Integer lastRacePlace = 0;
	String age_group_title = "";
	
	// constructors
	public Racer( String gName, Integer groupID, Integer jersey) {
		this.gaurdName = gName;
		this.racerID = groupID;
		this.jerseyNumber = jersey;
	};
	public Racer(int jersey_num) {
		this.set_jersey_number(jersey_num);
	}
	public Racer() {
		return;
	}
	
	// getters and setters
	public void set_age(int a) {
		this.age = a;
	}
	public int get_age() {
		return this.age;
	}
	
	public void set_jersey_number(int num) {
		this.jerseyNumber = num + 101;
	}
	
	public int get_jersey_number() {
		return this.jerseyNumber;
	}
	
	public void add_to_age_group(Integer gID) {
		this.ageGroupId = gID;
	};
	
	public void set_heat_finish(String unique_race, Integer place) {
		this.lastRaceID = unique_race;
		this.lastRacePlace = place;
	}
	public String get_last_race_id() {
		return this.lastRaceID;
	}
	public int get_last_race_finish_place() {
		return this.lastRacePlace;
	}
	
}
