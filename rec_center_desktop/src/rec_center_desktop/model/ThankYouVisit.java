package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class ThankYouVisit extends JPanel {

	/**
	 * Create the panel.
	 */
	public ThankYouVisit() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thank you for registering your visit!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(35, 11, 394, 54);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setBounds(178, 233, 89, 23);
		add(btnNewButton);

	}

}
