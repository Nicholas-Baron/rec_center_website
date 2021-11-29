package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateActivity extends JPanel {
	private JTextField nameField;
	private JTextField priceField;

	/**
	 * Create the panel.
	 */
	public CreateActivity(JFrame contentFrame, String currentUser) {
		setLayout(null);
		
		JPanel thisPanel = this;
		nameField = new JTextField();
		nameField.setBounds(194, 54, 149, 20);
		add(nameField);
		nameField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(194, 109, 149, 20);
		add(priceField);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(108, 57, 46, 14);
		add(lblNewLabel);
		
		JLabel lblPrive = new JLabel("Price:");
		lblPrive.setBounds(108, 112, 46, 14);
		add(lblPrive);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuccessActivitiesView sv = new SuccessActivitiesView(contentFrame, currentUser);
				sv.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(sv);
			}
		});
		btnNewButton.setBounds(174, 211, 89, 23);
		add(btnNewButton);
		
	}
}
