package src.rec_center_desktop.model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PriceChangeSuccess extends JPanel {

	/**
	 * Create the panel.
	 */
	public PriceChangeSuccess(JFrame contentFrame, String currentUser) {
		
		JPanel thisPanel = this;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Return to Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homePage = new Home(contentFrame, currentUser);
				homePage.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(homePage);
			}
		});
		btnNewButton.setBounds(99, 241, 245, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Price has been changed!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 11, 334, 76);
		add(lblNewLabel);
		
	}

}
