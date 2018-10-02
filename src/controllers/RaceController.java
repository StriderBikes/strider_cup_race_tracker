package controllers;
import java.util.*;
import models.*;

public class RaceController {
	Race my_race;
	Map<String, Integer> new_values = new HashMap<String,Integer>();
	public void RaceController(Race race_edit) {
		this.my_race = race_edit;
	}
	public void add_new_value(String key, Integer value) {
		this.new_values.put(key, value);
	}
	public Integer get_new_value(String key) {
		return this.new_values.get(key);
	}
	
}
