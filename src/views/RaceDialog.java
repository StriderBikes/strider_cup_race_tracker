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
	public JList positionList;
	public JPanel input_panel;
	public ArrayList<JLabel> position_labels = new ArrayList<JLabel>();
	public ArrayList<JTextField> position_inputs = new ArrayList<JTextField>();
	private final JPanel contentPanel = new JPanel();

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
		for (int num_pos = 0; num_pos < this.di_race.get_racer_list().size(); num_pos++) {
			this.position_labels.add(new JLabel(String.format("%d", num_pos+1)));
			this.input_panel.add(this.position_labels.get(num_pos));
			this.position_inputs.add(new JTextField());
			this.input_panel.add(this.position_inputs.get(num_pos));
		}
		this.setVisible(true);
	}
	/**
	 * Create the dialog.
	 */
	public void CreateRaceDialog() {
		setBounds(100, 100, 642, 594);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow][grow][][][][grow][][][][][][][][][][grow]", "[][grow][]"));
		{
			JLabel lblFinishPositions = new JLabel("Finish Positions");
			contentPanel.add(lblFinishPositions, "cell 2 0");
		}
		{
			JLabel lblRaceId = new JLabel("Race ID: " + this.di_race.get_race_id());
			contentPanel.add(lblRaceId, "cell 6 0");
		}
		{
			JLabel lblOfRacers = new JLabel(String.format("# of Racers: %d" ,this.di_race.get_racer_list().size()));
			contentPanel.add(lblOfRacers, "cell 10 0");
		}
		{
			this.input_panel = new JPanel();
			contentPanel.add(this.input_panel, "cell 2 1,grow");
		}
		{
			this.positionList = new JList();
			contentPanel.add(this.positionList, "cell 6 1,grow");
		}
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
	}

}
