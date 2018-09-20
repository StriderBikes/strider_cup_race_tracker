package models;
import java.util.ArrayList;

public class CupManager {
	
	public ArrayList<AgeGroup> age_groups = new ArrayList<AgeGroup>();
	public ArrayList<Racer> racer_list = new ArrayList<Racer>();
	int gates;
	// this signifies the top n racers that will move on from each heat
	int heat_cutoff = 2;
	
	
	public void CupManager() {
		System.out.println("created new CupManager instance");
	}
	
	/*
	public CupManager(int num_participants) {
		// TODO Auto-generated constructor stub
		this.participants = new Racer[num_participants];	
		for(int i = 0; i < num_participants; i++) {
			Racer newbie = new Racer(i);
			this.participants[i] = newbie;
		}
	}
	
	public CupManager(AgeGroup[] groups) {
		//this.age_groups = new AgeGroups[groups.length];
		this.age_groups = groups;
	}
	 */
}
