package controllers;
import java.util.*;
import models.*;
import views.*;
public class RaceController {
	Race my_race;
	RaceDialog my_rd;
	Map<String, Integer> new_values = new HashMap<String,Integer>();
	public RaceController(Race race_edit) {
		this.my_race = race_edit;
	}
	public void add_new_value(String key, Integer value) {
		this.new_values.put(key, value);
	}
	public Integer get_new_value(String key) {
		return this.new_values.get(key);
	}
	
	public void init_dialog() {
		this.my_rd = new RaceDialog(this.my_race);
	}
}
