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
	public ChangePrice(JFrame contentFrame, String currentUser, String activity, String price) {

		JPanel thisPanel = this;
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(226, 119, 128, 20);
		textField.setText(price);
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
				try {
					ActivityBusiness ab = ActivityBusiness.getInstance();
					System.out.println(activity + " " + textField.getText());
					ab.updateActivityPrice(activity, textField.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				PriceChangeSuccess pc = new PriceChangeSuccess(contentFrame, currentUser);
				pc.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(pc);
			}
		});
		activityLabel.setText(activity);
		btnNewButton.setBounds(171, 209, 89, 23);
		add(btnNewButton);
		
		JButton button = new JButton("Return to Activites View");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActivitiesView av = new ActivitiesView(contentFrame, currentUser);
				av.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(av);
			}
		});
		button.setBounds(249, 11, 191, 23);
		add(button);
	}

}
