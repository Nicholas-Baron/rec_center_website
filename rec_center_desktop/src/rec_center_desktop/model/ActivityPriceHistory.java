package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ActivityPriceHistory extends JPanel {

	/**
	 * Create the panel.
	 */
	public ActivityPriceHistory() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Activity Price History");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(35, 11, 220, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Activity Name: ");
		lblNewLabel_1.setBounds(35, 69, 98, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date: ");
		lblNewLabel_2.setBounds(140, 137, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price: ");
		lblNewLabel_2_1.setBounds(221, 137, 46, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Current Price:");
		lblNewLabel_1_1.setBounds(191, 69, 98, 14);
		add(lblNewLabel_1_1);
		
	}

}
