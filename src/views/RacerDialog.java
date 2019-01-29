package views;
import models.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;

/**
 * this is the dialog that pops up
 * upon clicking the edit race button.
 * this view allows you to set the results of the
 * race and gives a checkbox to "finish" the race and thereby disable 
 * any future tampering with the results
 * @author nick.williams
 *
 */
public class RacerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Racer racer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Racer con_racer) {
		try {
			System.out.println("creating the dialog box");
			RacerDialog dialog = new RacerDialog(con_racer);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RacerDialog(Racer con_racer) {
		this.racer = con_racer;
		setBounds(100, 100, 607, 473);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		{
			JLabel lblRacerName = new JLabel("Racer Name:");
			contentPanel.add(lblRacerName, "cell 0 0,alignx trailing");
		}
		{
			textField = new JTextField(this.racer.get_racer_name());
			contentPanel.add(textField, "cell 1 0,growx");
			textField.setColumns(10);
		}
		{
			JLabel lblJersey = new JLabel("Jersey # / ID");
			contentPanel.add(lblJersey, "cell 0 1,alignx trailing");
		}
		{
			textField_1 = new JTextField(String.format("%d",this.racer.get_jersey_number()));
			contentPanel.add(textField_1, "cell 1 1,growx");
			textField_1.setColumns(10);
		}
		{
			JLabel lblGaurdianName = new JLabel("Gaurdian Name");
			contentPanel.add(lblGaurdianName, "cell 0 2,alignx trailing");
		}
		{
			textField_2 = new JTextField(this.racer.get_racer_guardian());
			contentPanel.add(textField_2, "cell 1 2,growx");
			textField_2.setColumns(10);
		}
		{
			JLabel lblGroupId = new JLabel("Group ID");
			contentPanel.add(lblGroupId, "cell 0 3,alignx trailing");
		}
		{
			textField_3 = new JTextField(String.format("%d",this.racer.get_racer_group_id()));
			contentPanel.add(textField_3, "cell 1 3,growx");
			textField_3.setColumns(10);
		}
		{
			JLabel lblHeatId = new JLabel("Heat ID");
			contentPanel.add(lblHeatId, "cell 0 4,alignx trailing");
		}
		{
			JLabel lblNewLabel = new JLabel("");
			contentPanel.add(lblNewLabel, "cell 1 4");
		}
		{
			JLabel lblHeatFinish = new JLabel("Heat Finish");
			contentPanel.add(lblHeatFinish, "cell 0 5,alignx trailing");			
		}
		{
			JLabel lblHeatVal = new JLabel(String.format("%d", this.racer.get_finish_dict().get("heat")));
			contentPanel.add(lblHeatVal, "cell 1 5, alignx trailing");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			contentPanel.add(lblNewLabel_1, "cell 1 5");
		}
		{
			JLabel lblMainId = new JLabel("Main ID");
			contentPanel.add(lblMainId, "cell 0 6,alignx trailing");
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label, "cell 1 6");
		}
		{
			JLabel lblMainFinish = new JLabel("Main Finish");
			contentPanel.add(lblMainFinish, "cell 0 7,alignx trailing");
		}
		{
			JLabel label = new JLabel("");
			contentPanel.add(label, "cell 1 7");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						save_racer();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancel_edit();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}

	public void cancel_edit() {
		this.dispose();
	}
	
	public void save_racer() {
		if(this.textField.getText() != "") {
			this.racer.set_racer_name(this.textField.getText());
		}
		if(this.textField_1.getText() != "") {
			this.racer.set_jersey_number(Integer.parseInt(this.textField_1.getText()));
		}
		if(this.textField_2.getText() != "") {
			this.racer.set_guardian(this.textField_2.getText());
		}
		/*
		if(this.textField_3.getText() != "" && Integer.parseInt(this.textField_3.getText()) != this.racer.get_racer_group_id()) {
			this.racer.set_age_group(Integer.parseInt(this.textField_3.getText()));
		}
		*/
		this.dispose();
	}
}
