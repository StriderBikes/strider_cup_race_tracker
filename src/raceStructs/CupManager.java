package raceStructs;

public class CupManager {
	AgeGroup[] age_groups;
	Racer[] participants;
	int gates;
	// this signifies the top n racers that will move on from each heat
	int heat_cutoff = 2;
	
	
	CupManager(int num_participants){
		this.participants = new Racer[num_participants];	
		for(int i = 0; i < num_participants; i++) {
			Racer newbie = new Racer(i);
			this.participants[i] = newbie;
		}
	}

}
