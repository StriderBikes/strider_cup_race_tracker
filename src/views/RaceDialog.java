package views;
import models.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class RaceDialog extends JDialog {
	Race di_race;
	public ArrayList<JLabel> position_labels = new ArrayList<JLabel>();
	public ArrayList<JTextField> position_inputs = new ArrayList<JTextField>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Race d_race) {
		try {
			RaceDialog dialog = new RaceDialog(d_race);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RaceDialog(Race d_race) {
		this.di_race = d_race;
		this.CreateRaceDialog();
		this.setVisible(true);
	}
	/**
	 * Create the dialog.
	 */
	public void CreateRaceDialog() {
		setBounds(100, 100, 642, 594);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
		}
	}

}
