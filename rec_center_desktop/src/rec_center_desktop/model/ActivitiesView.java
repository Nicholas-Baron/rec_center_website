package rec_center_desktop.model;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ActivitiesView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ActivitiesView() {
		setLayout(null);
		
		
		

		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", 5},
			    {"John", "Doe",
			     "Rowing", 3},
			    {"Sue", "Black",
			     "Knitting", (2)},
			    {"Jane", "White",
			     "Speed reading", (20)},
			    {"Joe", "Brown",
			     "Pool", (10)}
			};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);
		
		table = new JTable(data, columnNames);
		add(table);
		table.setBounds(75, 90, 322, 80);

	}
}
