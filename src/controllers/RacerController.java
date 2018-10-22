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
	
	public RacerController() {
		this.racer = new Racer();
		this.rd = new RacerDialog(this.racer);
		System.out.println("new racer initialized");
	}
	
}
