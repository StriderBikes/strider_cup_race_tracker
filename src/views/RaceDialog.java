package views;
import models.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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
import java.awt.event.*;


public class RaceDialog extends JDialog {
	Race di_race;
	public ArrayList<JLabel> position_labels = new ArrayList<JLabel>();
	public ArrayList<JTextField> position_inputs = new ArrayList<JTextField>();
	private JTextField textField;

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
		setBounds(100, 100, 1067, 530);
		getContentPane().setLayout(new MigLayout("", "[900px]", "[39px][][][][]"));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 0 0,growx,aligny top");
			{
				JButton okButton = new JButton("OK");
				//okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						save_result();
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						cancel_edit();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblPleaseEnterThe = new JLabel("Please enter the Jersey Number into the Corresponding Finish Postion text box");
			getContentPane().add(lblPleaseEnterThe, "cell 0 1");
		}

		for(int idx = 0; idx < this.di_race.get_racer_list().size(); idx++){
			String jersey = "";
			{
				JLabel lblst = new JLabel(String.format("%d : ", idx+1));
				this.position_labels.add(lblst);
				getContentPane().add(lblst, "flowx,cell 0 2");
			}
			{
				//jersey = String.format("%d", this.di_race.get_finish_map().get(idx));
				if(this.di_race.get_finish_map().get(idx) != null) {
					jersey = String.format("%d", this.di_race.get_finish_map().get(idx));
					System.out.println(jersey);
					textField = new JTextField(jersey);
					textField.setColumns(50);
					getContentPane().add(textField, "cell 0 2");
					this.position_inputs.add(textField);
				} else {
					System.out.println("no result saved");
					textField = new JTextField();
					textField.setColumns(50);
					getContentPane().add(textField, "cell 0 2");
					this.position_inputs.add(textField);
				}
			}	
		}
		{
			JLabel lblPleaseEnterThe = new JLabel("Racer Jersey Number List");
			getContentPane().add(lblPleaseEnterThe, "cell 0 3");
		}
		{
			JList racer_list = new JList(this.di_race.get_jersey_nums());
			getContentPane().add(racer_list, "cell 0 4");
		}
	}
	
	public void cancel_edit() {
		this.dispose();
	}
	
	public void save_result() {
		for(int ix=0; ix < this.position_inputs.size(); ix++) {
			try {
				Integer jNum = Integer.parseInt(this.position_inputs.get(ix).getText());
				Racer u_racer = this.di_race.get_racer_by_id(jNum);
				u_racer.set_finish_postion("heat", ix);
				Integer position = ix;
				this.di_race.update_finish_map(position, u_racer);
			} catch (java.lang.NumberFormatException er)
			{
				System.out.println(er.toString());
			}
		}
		System.out.println(this.di_race.get_finish_map().toString());
	}

}
