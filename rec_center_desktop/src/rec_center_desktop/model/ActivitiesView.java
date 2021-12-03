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
	private JTextField txtEnterActivityName;
	private JTextField historyActivityField;

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
		
		txtEnterActivityName = new JTextField();
		txtEnterActivityName.setText("Enter activity name");
		txtEnterActivityName.setBounds(297, 260, 135, 20);
		add(txtEnterActivityName);
		txtEnterActivityName.setColumns(10);
		
		JButton btnChangePrice = new JButton("Change Price: ");
		btnChangePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String activity = txtEnterActivityName.getText();
				ChangePrice ca = new ChangePrice(contentFrame, userName, activity);
				ca.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(ca);
			}
		});
		btnChangePrice.setBounds(166, 259, 121, 23);
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
		
		JButton btnPriceHistory = new JButton("Price History: ");
		btnPriceHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 1) {
					String s = table.getValueAt(table.getSelectedRow(), 0).toString();
					System.out.println(s);
				}
				String activity = txtEnterActivityName.getText();
				ActivityPriceHistory ca = new ActivityPriceHistory(contentFrame, userName, activity);
				ca.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(ca);
			}
		});
		btnPriceHistory.setBounds(166, 225, 121, 23);
		add(btnPriceHistory);
		
		historyActivityField = new JTextField();
		historyActivityField.setText("Enter activity name");
		historyActivityField.setColumns(10);
		historyActivityField.setBounds(297, 226, 135, 20);
		add(historyActivityField);
		
	}
}
