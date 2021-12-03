package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JTable;
import model.dataccess.ActivityBusiness;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ActivitiesView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ActivitiesView(JFrame contentFrame, String userName) {
		setLayout(null);
		
		JPanel thisPanel = this;

		String[] columnNames = { "Activity", "Price" };

		List<Object[]> dataStrings = ActivityBusiness.getInstance().getActivities().stream()
						.map(a -> new Object[] { a.getName(), a.getPrice().toPlainString() })
						.collect(Collectors.toList());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);
		
		table = new JTable(Arrays.copyOf(dataStrings.toArray(), dataStrings.size(), Object[][].class), columnNames);
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
		btnNewButton.setBounds(21, 259, 135, 23);
		add(btnNewButton);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String activity = "";
				String price = "";
				if (table.getSelectedRowCount() == 1) {
					activity = table.getValueAt(table.getSelectedRow(), 0).toString();
					price = table.getValueAt(table.getSelectedRow(), 1).toString();
					ChangePrice ca = new ChangePrice(contentFrame, userName, activity, price);
					ca.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(ca);
				}
				
			}
		});
		btnChangePrice.setBounds(271, 259, 121, 23);
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
		
		JButton btnPriceHistory = new JButton("Price History");
		btnPriceHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String activity = "";
				String price = "";
				if (table.getSelectedRowCount() == 1) {
					activity = table.getValueAt(table.getSelectedRow(), 0).toString();
					ActivityPriceHistory ca = new ActivityPriceHistory(contentFrame, userName, activity);
					ca.setVisible(true);
					thisPanel.setVisible(false);
					contentFrame.remove(thisPanel);
					contentFrame.setContentPane(ca);
				}
				
			}
		});
		btnPriceHistory.setBounds(271, 225, 121, 23);
		add(btnPriceHistory);
		
	}
}
