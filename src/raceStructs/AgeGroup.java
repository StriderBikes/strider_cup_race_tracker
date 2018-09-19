package raceStructs;

public class AgeGroup {
	/**
	 * we store an array or racer ids
	 * so that we can know how they are finishing
	 * and then we can use the length of the array
	 * to derive number of participants in this age 
	 * group
	 */
	
	int[] racer_ids;
	//empty races list, will be packed with method FillRaces()
	Race[] race_list;
	String group_title;
	int num_gates;
	
	public AgeGroup(String gt, int[] r_ids, int gates) {
		this.racer_ids = r_ids;
		this.group_title = gt;
		this.num_gates = gates;
	}
}
