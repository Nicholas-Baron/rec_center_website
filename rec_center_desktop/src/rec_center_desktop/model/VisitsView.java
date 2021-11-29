package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitsView extends JPanel {

	/**
	 * Create the panel.
	 */
	public VisitsView(JFrame contentFrame, String currentUser) {
		setLayout(null);
		JPanel thisPanel = this;
		JLabel lblNewLabel = new JLabel("My Visits");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(35, 11, 373, 43);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(35, 54, 373, 181);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Reservation 1");
		lblNewLabel_1.setBounds(10, 11, 106, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date: 12/05/2021");
		lblNewLabel_1_1.setBounds(93, 36, 106, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Time: 11:30");
		lblNewLabel_1_1_1.setBounds(93, 60, 106, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Status: Online Pending");
		lblNewLabel_1_1_1_1.setBounds(93, 85, 183, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("Return Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homePage = new Home(contentFrame, currentUser);
				homePage.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(homePage);
			}
		});
		btnNewButton.setBounds(93, 256, 259, 23);
		add(btnNewButton);
		
	}

}
