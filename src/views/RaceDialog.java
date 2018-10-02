package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;

public class RaceDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RaceDialog dialog = new RaceDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RaceDialog() {
		setBounds(100, 100, 642, 594);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow][][][][][][][][][][][][][][][grow]", "[][grow]"));
		{
			JLabel lblFinishPositions = new JLabel("Finish Positions");
			contentPanel.add(lblFinishPositions, "cell 2 0");
		}
		{
			JLabel lblRaceId = new JLabel("Race ID: ");
			contentPanel.add(lblRaceId, "cell 6 0");
		}
		{
			JLabel lblOfRacers = new JLabel("# of Racers:");
			contentPanel.add(lblOfRacers, "cell 10 0");
		}
		{
			JButton btnEditRaceList = new JButton("Edit Race List");
			contentPanel.add(btnEditRaceList, "cell 16 0");
		}
		{
			JList list = new JList();
			contentPanel.add(list, "cell 1 1 3 1,grow");
		}
		{
			JList list = new JList();
			contentPanel.add(list, "cell 16 1,grow");
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
