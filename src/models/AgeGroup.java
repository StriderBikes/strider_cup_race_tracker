package models;
import java.util.ArrayList;

public class AgeGroup {
	/**
	 * we store an array or racer ids
	 * so that we can know how they are finishing
	 * and then we can use the length of the array
	 * to derive number of participants in this age 
	 * group
	 */
	//empty races list, will be packed with method FillRaces()
	ArrayList<Race> race_list = new ArrayList<Race>();
	ArrayList<Integer> racer_ids = new ArrayList<Integer>();
	String group_title;
	Integer num_gates;
	Integer group_id;
	Integer num_racers;
	
	public AgeGroup(String gt, int gID, int gates, int num_racers) {
		this.group_id = gID;
		this.group_title = gt;
		this.num_gates = gates;
		this.num_racers = num_racers;
	}
	
	
}
