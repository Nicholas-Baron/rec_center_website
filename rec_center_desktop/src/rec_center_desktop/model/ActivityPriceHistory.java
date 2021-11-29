package src.rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.dataccess.ActivityBusiness;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityPriceHistory extends JPanel {

	/**
	 * Create the panel.
	 */
	public ActivityPriceHistory(JFrame contentFrame, String userName, String activity) {
		
		JTable table;
		
		setLayout(null);
		
		JPanel thisPanel = this;

		String[] columnNames = { "Price", "Date" };
		
		List<Object[]> dataStrings = ActivityBusiness.getInstance().getPriceHistory(activity).stream()
						.map(a -> new Object[] { a.getPrice().toPlainString(), a.getDate() })
						.collect(Collectors.toList());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);
		
		table = new JTable(Arrays.copyOf(dataStrings.toArray(), dataStrings.size(), Object[][].class), columnNames);
		add(table);
		table.setBounds(56, 89, 322, 80);
		
		JButton btnReturnHome = new JButton("Return Activities");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActivitiesView av = new ActivitiesView(contentFrame, userName);
				av.setVisible(true);
				thisPanel.setVisible(false);
				contentFrame.remove(thisPanel);
				contentFrame.setContentPane(av);
			}
		});
		btnReturnHome.setBounds(144, 247, 148, 23);
		add(btnReturnHome);

		
	}

}
