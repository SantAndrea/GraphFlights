package graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

public class MainFrame extends JFrame{
	
	public MainFrame (String title){
		super(title);
		
		setLayout(new BorderLayout());	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500,500);
		setLayout(new BorderLayout());	
		
		GridLayout grid = new GridLayout(3, 2);
		JPanel panel =new JPanel(grid);
		JPanel panelEmpty = new JPanel();
		
		JButton b1 = new JButton("query 1");
		JButton b2 = new JButton("query 2");
		JButton b3 = new JButton("query 3");
		JButton b4 = new JButton("query 4");
		
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(panelEmpty);
		panel.add(panelEmpty);
		
		Container c = getContentPane();
		
		
		//------SETTING TABLE PROP
		
		String[] columnNames = {"Proprietà",
                "Proprietà",
                "Proprietà",
                "Proprietà",
                "Proprietà"};
		
		/*
		 * Its data is initialized and stored in a two-dimensional Object array:
		 */
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)},    
			};
		
		JTable table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		JPanel panelForTable = new JPanel();
		
	//	panelForTable.add(table.getTableHeader());
		panelForTable.add(scrollPane);
		
		//-----------------------------------------------------
		
		c.add(panelForTable, BorderLayout.CENTER);
		c.add(panel, BorderLayout.SOUTH);
				
	}

}
