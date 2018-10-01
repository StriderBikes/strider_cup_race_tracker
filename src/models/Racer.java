package models;

public class Racer {
	String racer_name = "";
	private Integer age = -1;
	String gaurdName = "";
	private Integer jerseyNumber;
	Integer ageGroupId =0;
	private String heatID = "";
	private Integer heatFinish = -1;
	private String finalsID = "";
	private Integer finalsFinish = -1;
	String age_group_title = "";
	
	// constructors
	public Racer( Integer groupID, Integer jersey) {
		this.ageGroupId = groupID;
		this.jerseyNumber = jersey;
	};
	public Racer(int jersey_num) {
		this.set_jersey_number(jersey_num);
	}
	
	// getters and setters
	public void set_age(int a) {
		this.age = a;
	}
	public int get_age() {
		return this.age;
	}
	
	public void set_jersey_number(int num) {
		this.jerseyNumber = num;
	}
	
	public int get_jersey_number() {
		return this.jerseyNumber;
	}
	// Group id 
	public void set_age_group(Integer gID) {
		this.ageGroupId = gID;
	};

	public Integer get_racer_group_id() {
		return this.ageGroupId;
	}

	public void set_heat_finish( Integer place) {
		this.heatFinish = place;
	}
	public void set_heat_id(String id) {
		this.heatID = id;
	}
	public String get_heat_id() {
		return this.heatID;
	}
	public int get_heat_finish() {
		return this.heatFinish;
	}
	public void set_finals_id(String id) {
		this.finalsID = id;
	}
	public String get_finals_id() {
		return this.finalsID;
	}
	public void set_finals_finish(Integer place) {
		this.finalsFinish = place;
	}
	public Integer get_finals_finish() {
		return this.finalsFinish;
	}
	public String get_racer_name() {
		return this.racer_name;
	}
	public void set_racer_name(String new_name) {
		this.racer_name = new_name;
	}
	
	public String get_racer_gaurdian() {
		return this.gaurdName;
	}
	public void set_gaurdian(String gaurd) {
		this.gaurdName = gaurd;
	}
}
