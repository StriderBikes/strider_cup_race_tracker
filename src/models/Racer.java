package models;
import java.util.*;
public class Racer {
	String racer_name = "";
	private Integer age = -1;
	String gaurdName = "";
	private Integer jerseyNumber;
	Integer ageGroupId =0;
	private Map<String, Integer> finish_postions = new HashMap<String,Integer>();
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
	
	public void set_finsish_postion(String race_id, Integer fp) {
		this.finish_postions.put(race_id, fp);
	}
	
	public Map<String, Integer> get_finish_dict(){
		return this.finish_postions;
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
