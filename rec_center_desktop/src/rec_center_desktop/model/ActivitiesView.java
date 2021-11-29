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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 259, 341, -197);
		add(scrollPane);
		

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
		
		table = new JTable(data, columnNames);
		table.setBounds(67, 249, 310, -183);
		add(table);
	}
}
