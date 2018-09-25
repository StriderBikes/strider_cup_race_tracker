package controllers;
import models.*;
import views.*;
import javax.swing.widgets.Shell;
import org.eclipse.swt.widgets.Shell;

public class RacerController {
	private Racer racer;
	RacerDialog rd;
	
	public RacerController(Racer constructor_racer, Shell sh) {
		this.racer = constructor_racer;
		this.rd = new RacerDialog(sh, this.racer);
	}
	
}
