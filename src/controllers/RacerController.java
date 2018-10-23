package controllers;
import models.*;
import views.*;


public class RacerController {
	private Racer racer;
	RacerDialog rd;
	
	public RacerController(Racer constructor_racer) {
		this.racer = constructor_racer;
		this.rd = new RacerDialog(this.racer);
		System.out.println("constructed hit");
	}
	
	// jersey num should be the largest jersey number for that group + 1
	public RacerController(Integer rg_id, Integer jersey_num) {
		this.racer = new Racer(rg_id, jersey_num);
		this.rd = new RacerDialog(this.racer);
		System.out.println("new racer initialized");
	}
	
	public Racer return_racer() {
		return this.racer;
	}
}
