package models;

public class AgeGroup {
	/**
	 * we store an array or racer ids
	 * so that we can know how they are finishing
	 * and then we can use the length of the array
	 * to derive number of participants in this age 
	 * group
	 */
	//empty races list, will be packed with method FillRaces()
	Race[] race_list;
	String group_title;
	int num_gates;
	int group_id;
	
	public AgeGroup(String gt, int gID, int gates) {
		this.group_id = gID;
		this.group_title = gt;
		this.num_gates = gates;
	}
}
