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
public class RacerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Racer racer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
			textField_2 = new JTextField(this.racer.get_racer_gaurdian());
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
			textField_4 = new JTextField(this.racer.get_heat_id());
			contentPanel.add(textField_4, "cell 1 4,growx");
			textField_4.setColumns(10);
		}
		{
			JLabel lblHeatFinish = new JLabel("Heat Finish");
			contentPanel.add(lblHeatFinish, "cell 0 5,alignx trailing");
		}
		{
			textField_5 = new JTextField(this.racer.get_heat_finish());
			contentPanel.add(textField_5, "cell 1 5,growx");
			textField_5.setColumns(10);
		}
		{
			JLabel lblMainId = new JLabel("Main ID");
			contentPanel.add(lblMainId, "cell 0 6,alignx trailing");
		}
		{
			textField_7 = new JTextField(this.racer.get_finals_id());
			contentPanel.add(textField_7, "cell 1 6,growx");
			textField_7.setColumns(10);
		}
		{
			JLabel lblMainFinish = new JLabel("Main Finish");
			contentPanel.add(lblMainFinish, "cell 0 7,alignx trailing");
		}
		{
			textField_6 = new JTextField(this.racer.get_finals_finish());
			contentPanel.add(textField_6, "cell 1 7,growx");
			textField_6.setColumns(10);
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
	
	public void save_race() {
		if(this.textField.getText() != "") {
			this.racer.set_racer_name(this.textField.getText());
		}
		if(this.textField_1.getText() != "") {
			
		}
		if(this.textField_2.getText() != "") {
			
		}
		if(this.textField_3.getText() != "") {
			
		}
		if(this.textField_4.getText() != "") {
			
		}
		if(this.textField_5.getText() != "") {
			
		}
		if(this.textField_6.getText() != "") {
			
		}
		if(this.textField_7.getText() != "") {
			
		}
	}
}
