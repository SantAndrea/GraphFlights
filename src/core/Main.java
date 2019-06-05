package core;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import graphics.MainFrame;

public class Main {

	public static String DB_NAME = "line"; 
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new MainFrame ("GraphFlights");
				frame.setSize(1350, 700);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		/*
		Neo4jConnectionPool ncp = new Neo4jConnectionPool();
		CommandCreator cc = new CommandCreator();
		Driver driver = ncp.connection();
		
		
		String matcher = cc.matchAll();
		
		ncp.query(matcher, driver);
		ncp.close();
		*/
	}

}
