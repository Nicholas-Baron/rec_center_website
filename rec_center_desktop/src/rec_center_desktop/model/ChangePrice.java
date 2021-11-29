package src.rec_center_desktop.model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.dataccess.ActivityBusiness;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePrice extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ChangePrice(JFrame contentFrame, String currentUser, String activity) {

		JPanel thisPanel = this;
		setLayout(null);
		
		textField = new JTextField();
		textField.setText("5.00");
		textField.setBounds(226, 119, 128, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(128, 122, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Change price for: ");
		lblNewLabel_1.setBounds(20, 11, 112, 39);
		add(lblNewLabel_1);
		
		JLabel activityLabel = new JLabel("");
		activityLabel.setBounds(128, 11, 112, 39);
		add(activityLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ActivityBusiness ab = ActivityBusiness.getInstance();
				PriceChangeSuccess homePage = new PriceChangeSuccess(contentFrame, currentUser);
				homePage.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(homePage);
			}
		});
		btnNewButton.setBounds(171, 209, 89, 23);
		add(btnNewButton);
	}

}
