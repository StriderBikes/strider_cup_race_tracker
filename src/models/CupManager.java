package models;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class CupManager {
	//class variables
	private int racer_id_last = 101; //start our racer Ids at 101 so that they can be used as jersey nums too
	private ArrayList<AgeGroup> age_groups = new ArrayList<AgeGroup>();
	private ArrayList<Racer> racer_list = new ArrayList<Racer>();
	int gates;
	// this signifies the top n racers that will move on from each heat
	int heat_cutoff = 2;
	//constructors
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
	
	// getters and setters
	public int get_num_groups() {
		return this.age_groups.size();
	}
	
	public AgeGroup get_age_group(int idx) {
		return this.age_groups.get(idx);
	}
	
	// handles logic associated with adding a new race group
	public void add_new_group(AgeGroup a) {
		for(int i = 0; i < a.get_num_racers(); i++) {
			Integer g_id = a.get_gid();
			this.racer_id_last = this.racer_id_last + 1;
			Racer newest = new Racer(g_id, this.racer_id_last);
			a.racer_ids.add(this.racer_id_last);
			this.racer_list.add(newest);
			newest.set_age_group(a.get_gid());
		}
		this.age_groups.add(a);
	}
	// this calls a method determines the amount of races that need to be done for the each age group
	public void set_up_cup() {
		for(int ix = 0; ix < this.age_groups.size(); ix ++) {
			this.age_groups.get(ix).set_races();
		}
	}
	public void save_as_groups_csv() {
		try {
			PrintWriter pw = new PrintWriter("race_group_config.csv");
			String first_line = "GroupName, number_of_racers, number_of_starting_gates";
			pw.println(first_line);
			System.out.println(this.age_groups.size());
			for(int l = 0; l < this.age_groups.size(); l++) {
				AgeGroup current = this.age_groups.get(l);
				String current_line = current.group_title + "," + Integer.toString(current.get_num_racers()) + "," + Integer.toString(current.get_num_gates())+",";
				System.out.println(current_line);
				if(l + 1 == this.age_groups.size()) {
					current_line = current_line.substring(0, current_line.length() - 1);
				}
				pw.println(current_line);
			}
			System.out.println("successfully saved config");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Racer> get_racer_list(){
		return this.racer_list;
	}
	public Racer get_racer_by_jersey(Integer jerseyNum) {
		for(Racer nr: this.racer_list) {
			if (nr.get_jersey_number() == jerseyNum) {
				return nr;
			}
		} 
		Racer new_r = new Racer(jerseyNum);
		return new_r;
	}
}
