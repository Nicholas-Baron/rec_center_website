package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuccessActivitiesView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SuccessActivitiesView(JFrame contentFrame, String currentUser) {
		setLayout(null);
		
		JPanel thisPanel = this;
		
		JLabel lblNewLabel = new JLabel("Success! Activity Created.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 21, 414, 97);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Return to View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActivitiesView av = new ActivitiesView(contentFrame, currentUser);
				av.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(av);
			}
		});
		btnNewButton.setBounds(102, 236, 231, 23);
		add(btnNewButton);

	}

}
