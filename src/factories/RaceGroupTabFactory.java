package factories;
import models.*;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.*;

public class RaceGroupTabFactory {
	JTabbedPane p;
	CupManager cm;
	public RaceGroupTabFactory(JTabbedPane parent, CupManager cm) {
		this.cm = cm;
		this.p = parent;
	}
	
	
}
