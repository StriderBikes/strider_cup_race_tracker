package models;

public class Racer {
	String name;
	private Integer age;
	String gaurdName;
	Integer racerID;
	private Integer jerseyNumber;
	Integer ageGroupId;
	Integer lastRaceID = 0;
	Integer lastRacePlace = 0;
	String age_group_title;
	
	// constructors
	public Racer(String newName, Integer newAge, String gName, Integer rID, Integer jersey) {
		this.name = newName;
		this.set_age(newAge);
		this.gaurdName = gName;
		this.racerID = rID;
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
		this.jerseyNumber = num + 101;
	}
	
	public int get_jersey_number() {
		return this.jerseyNumber;
	}
	
	public void add_to_age_group(Integer gID) {
		this.ageGroupId = gID;
	};
}
