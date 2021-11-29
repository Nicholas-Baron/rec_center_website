package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActivitiesView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ActivitiesView(JFrame contentFrame, String userName) {
		setLayout(null);
		
		JPanel thisPanel = this;
		
		

		String[] columnNames = {"Activity", "Price"};
		
		Object[][] data = {
			    {"Weightlifting", 5},
			    {"Treadmill", 3},
			    {"Pool", (2)},
			    {"Hydro Massage", (20)},
			    {"Yoga", (4)}
			};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		add(table);
		table.setBounds(56, 89, 322, 80);
		
		JButton btnNewButton = new JButton("Create Activity");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateActivity ca = new CreateActivity(contentFrame, userName);
				ca.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(ca);
			}
		});
		btnNewButton.setBounds(36, 259, 135, 23);
		add(btnNewButton);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String activity = "Weightlifting";
				ChangePrice ca = new ChangePrice(contentFrame, userName, activity);
				ca.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(ca);
			}
		});
		btnChangePrice.setBounds(249, 259, 148, 23);
		add(btnChangePrice);
		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home homePage = new Home(contentFrame, userName);
				homePage.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(homePage);
			}
		});
		btnReturnHome.setBounds(271, 11, 148, 23);
		add(btnReturnHome);

	}
}
