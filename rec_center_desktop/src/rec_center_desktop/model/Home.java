package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home(JFrame contentFrame, String currentUser) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("My Visits");
		JPanel thisPanel = this;
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitsView vv = new VisitsView(contentFrame, currentUser);
				vv.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(vv);
			}
		});
		btnNewButton.setBounds(63, 206, 135, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBounds(35, 11, 191, 46);
		add(lblNewLabel);
		
		JButton btnNewOrder = new JButton("Schedule Visit");
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisitRegistration visitRegistration = new VisitRegistration(contentFrame, currentUser);
				visitRegistration.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(visitRegistration);
			}
		});
		btnNewOrder.setBounds(250, 206, 135, 23);
		add(btnNewOrder);
		
		JButton btnAcrivitiesList = new JButton("Activities List");
		btnAcrivitiesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActivitiesView av = new ActivitiesView(contentFrame, currentUser);
				av.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(av);
			}
		});
		btnAcrivitiesList.setBounds(63, 242, 135, 23);
		add(btnAcrivitiesList);
		
		JButton btnDignOut = new JButton("Sign Out");
		btnDignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(contentFrame);
				login.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(login);
			}
		});
		btnDignOut.setBounds(250, 242, 135, 23);
		add(btnDignOut);

	}
}
