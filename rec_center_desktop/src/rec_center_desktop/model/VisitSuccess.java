package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitSuccess extends JPanel {

	/**
	 * Create the panel.
	 */
	public VisitSuccess(JFrame contentFrame, String currentUser) {
		setLayout(null);
		
		JPanel thisPanel = this;
		JLabel lblNewLabel = new JLabel("Visit reservation has been saved.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 11, 334, 117);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Return to Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homePage = new Home(contentFrame, currentUser);
				homePage.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(homePage);
			}
		});
		btnNewButton.setBounds(105, 235, 256, 23);
		add(btnNewButton);

	}

}
