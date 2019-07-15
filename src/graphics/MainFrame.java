package graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.v1.Driver;

import controller.CommandCreator;
import jdbc.Neo4jConnectionPool;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public Container c;
	
	public MainFrame (String title){
		super(title);
		
		Neo4jConnectionPool ncp = new Neo4jConnectionPool();
		CommandCreator cc = new CommandCreator();
		Driver driver = ncp.connection();
		
		setLayout(new BorderLayout());	
		
		c = getContentPane();


		
		GridLayout grid = new GridLayout(3, 2);
		JPanel panelExample =new JPanel(grid);
		JPanel panelEmpty = new JPanel();
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JButton b1 = new JButton("Voli che sono partiti da un aeroporto in cui sono arrivati voli con piloti di 41 anni e aereo immatricolato nel 2003");
		JButton b2 = new JButton("Piloti che hanno viaggiato con un Boing 777-300 che sono partiti da Napoli e non sono arrivati a Roma");
		JButton b3 = new JButton("Aereo di un volo partito nella data 5/06/2018 ed aeroporto di partenza Napoli");
		JButton b4 = new JButton("Volo da aeroporto di Partenza Napoli");

		//Parte parametrica
		JPanel paramSearch = new JPanel();
		
		JLabel cercaVoloLabel = new JLabel("Cerca Volo                     ");
		JLabel partenzaDaLabel = new JLabel("Partenza da:");
		JComboBox<String> partenzaVolo = new JComboBox<>();
		partenzaVolo.addItem("NAP");
		partenzaVolo.addItem("CIA");
		partenzaVolo.addItem("LIN");
		partenzaVolo.addItem("MXP");
		JLabel arrivoALabel = new JLabel("Arrivo a:");
		JComboBox<String> arrivoVolo = new JComboBox<>();
		arrivoVolo.addItem("NAP");
		arrivoVolo.addItem("CIA");
		arrivoVolo.addItem("LIN");
		arrivoVolo.addItem("MXP");
		JButton search = new JButton("Ricerca Volo");
		JLabel inDataLabel = new JLabel("In Data:");
		JTextArea ricercaData = new JTextArea("gg/mm/yy",1,6);
		
		paramSearch.add(cercaVoloLabel);
		paramSearch.add(partenzaDaLabel);
		paramSearch.add(partenzaVolo);
		paramSearch.add(arrivoALabel);
		paramSearch.add(arrivoVolo);
		paramSearch.add(inDataLabel);
		paramSearch.add(ricercaData);
		paramSearch.add(search);
		
		panelExample.add(b1);
		panelExample.add(b2);
		panelExample.add(b3);
		panelExample.add(b4);
	
		mainPanel.add(panelExample, BorderLayout.NORTH);
		mainPanel.add(paramSearch, BorderLayout.SOUTH);
		
		ActionListener l1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String matcher = cc.flightsFromWhere();
				System.out.println("q1");
				
				List<NodeValue> listQuery = ncp.query(matcher, driver);
				String[] columnNames = {"Età pilota", "Aeromobile anno acquisto", "Nome aeroporto", "Volo id"};
				Object[][] data = new Object[listQuery.size()/4][listQuery.size()];
				for(int i=0; i<listQuery.size(); i++){
					int index = 0;
					for(int j=0; j<listQuery.size(); j++){
						
						if(i==0 && listQuery.get(j).get("eta").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("eta");
							index++;
						}
						if(i==1 && listQuery.get(j).get("anno_acquisto").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("anno_acquisto");
							index++;
						}
						if(i==2 && listQuery.get(j).get("codice_iata").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("codice_iata");
							index++;
						}
						if(i==3 && listQuery.get(j).get("id_volo").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("id_volo");
							index++;
						}
					}
				}
				setTable(columnNames, data);
			}
		};
		
		b1.addActionListener(l1);
		
		
		ActionListener l2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String matcher = cc.pilotFlightWithModel();
				System.out.println("q2");
				
				List<NodeValue> listQuery = ncp.query(matcher, driver);
				String[] columnNames = {"Modello aereo", "Nome Pilota"};
				Object[][] data = new Object[listQuery.size()/2][listQuery.size()];
				for(int i=0; i<listQuery.size(); i++){
					int index = 0;
					for(int j=0; j<listQuery.size(); j++){
						
						if(i==0 && listQuery.get(j).get("modello").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("modello");
							index++;
						}
						if(i==1 && listQuery.get(j).get("nome").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("nome");
							index++;
						}
					}
				}
				setTable(columnNames, data);
			}
		};
		
		b2.addActionListener(l2);
		
		
		ActionListener l3 = new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String matcher = cc.aereoByVoloDateAndDeparture();
				System.out.println("q3");
				
				List<NodeValue> listQuery = ncp.query(matcher, driver);
				String[] columnNames = {"Anno acquisto","Modello","Matricola"};
				Object[][] data = new Object[listQuery.size()][listQuery.size()];
				for(int i=0; i<listQuery.size(); i++){
					int index = 0;
					for(int j=0; j<listQuery.size(); j++){
						
						if(i==0 && listQuery.get(j).get("anno_acquisto").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("anno_acquisto");
							index++;
						}
						
						if(i==1 && listQuery.get(j).get("modello").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("modello");
							index++;
						}
						
						if(i==2 && listQuery.get(j).get("matricola_aereo").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("matricola_aereo");
							index++;
						}
						
					}
				}
				setTable(columnNames, data);
				
			}};
		b3.addActionListener(l3);
		
		
		ActionListener l4 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String matcher = cc.voloByAeroporto();
				System.out.println("q3");
				
				List<NodeValue> listQuery = ncp.query(matcher, driver);
				String[] columnNames = {"Data","Id volo","Aeroporto arrivo","Orario partenza","Aeroporto partenza",
						"Orario arrivo","Id pilota","Modello aereo"};
				Object[][] data = new Object[listQuery.size()][listQuery.size()];
				
				for(int i=0; i<listQuery.size(); i++){
					int index = 0;
					for(int j=0; j<listQuery.size(); j++){
						
						if(i==0 && listQuery.get(j).get("data").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("data");
							index++;
						}
						
						if(i==1 && listQuery.get(j).get("id_volo").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("id_volo");
							index++;
						}
						
						if(i==2 && listQuery.get(j).get("aeroporto_arrivo").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("aeroporto_arrivo");
							index++;
						}
						
						if(i==3 && listQuery.get(j).get("orario_partenza").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("orario_partenza");
							index++;
						}

						if(i==4 && listQuery.get(j).get("aeroporto_partenza").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("aeroporto_partenza");
							index++;
						}
						
						if(i==5 && listQuery.get(j).get("orario_arrivo").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("orario_arrivo");
							index++;
						}
						
						if(i==6 && listQuery.get(j).get("id_pilota").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("id_pilota");
							index++;
						}
						
						if(i==7 && listQuery.get(j).get("aeromobile_volo").toString() != "NULL"){
							data[i][index] = listQuery.get(j).get("aeromobile_volo");
							index++;
						}
						
						
					}
				}
				setTable(columnNames, data);
				
			}};
		b4.addActionListener(l4);
		//------SETTING TABLE PROP
		
		ActionListener searchButtonListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedPartenza = (String)partenzaVolo.getSelectedItem();
				String selectedArrivo = (String)arrivoVolo.getSelectedItem();
				String dataVolo = ricercaData.getText();
				
				String command = cc.searchVolo(selectedPartenza, selectedArrivo, dataVolo);
				System.out.println(command);
				try{
					List<NodeValue> listQuery = ncp.query(command, driver);
					
					if(listQuery.isEmpty()){
						JOptionPane.showMessageDialog(null,"La query non ha prodotto risultati.");
					}else{
						String[] columnNames = {"Data","Id volo","Aeroporto arrivo","Orario partenza","Aeroporto partenza",
								"Orario arrivo","Id pilota","Modello aereo"};
						Object[][] data = new Object[listQuery.size()][listQuery.size()];
						
						for(int i=0; i<listQuery.size(); i++){
							int index = 0;
							for(int j=0; j<listQuery.size(); j++){
								
								if(i==0 && listQuery.get(j).get("data").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("data");
									index++;
								}
								
								if(i==1 && listQuery.get(j).get("id_volo").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("id_volo");
									index++;
								}
								
								if(i==2 && listQuery.get(j).get("aeroporto_arrivo").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("aeroporto_arrivo");
									index++;
								}
								
								if(i==3 && listQuery.get(j).get("orario_partenza").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("orario_partenza");
									index++;
								}

								if(i==4 && listQuery.get(j).get("aeroporto_partenza").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("aeroporto_partenza");
									index++;
								}
								
								if(i==5 && listQuery.get(j).get("orario_arrivo").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("orario_arrivo");
									index++;
								}
								
								if(i==6 && listQuery.get(j).get("id_pilota").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("id_pilota");
									index++;
								}
								
								if(i==7 && listQuery.get(j).get("aeromobile_volo").toString() != "NULL"){
									data[i][index] = listQuery.get(j).get("aeromobile_volo");
									index++;
								}
								
								
							}
						}
						setTable(columnNames, data);
					}
					
				}catch(Exception e1){
					
						JOptionPane.showMessageDialog(null,"Non ci sono nodi nel database con questi parametri.");
						
				}
				
			}};
		search.addActionListener(searchButtonListener);
		
		
		String[] columnNames = {"---",
                "---",
                "---",
                "---",
                "---"};
		
		/*
		 * Its data is initialized and stored in a two-dimensional Object array:
		 */
		
		Object[][] data = {
			    {"---", "---",
			     "---", "---", "---"},
			    {"---", "---",
				     "---", "---", "---"},
			    {"---", "---",
					     "---", "---", "---"},
			    {"---", "---",
						     "---", "---", "---"},
			    {"---", "---",
							 "---", "---", "---"},    
			};
		

		
		this.table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		JPanel panelForTable = new JPanel();
		
		panelForTable.add(table.getTableHeader());
		panelForTable.add(scrollPane);
		
		//-----------------------------------------------------
		
		c.add(panelForTable, BorderLayout.CENTER);
		c.add(mainPanel, BorderLayout.SOUTH);
				
	}
	
	public void setTable(String[] columns, Object[][] data){
		table.setModel(new DefaultTableModel(data.length, columns.length));
		JTableHeader th = table.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		for(int i=0; i<columns.length; i++){
			TableColumn tc = tcm.getColumn(i);
			tc.setHeaderValue( columns[i] );
			for(int j=0; j<data.length; j++){
				table.setValueAt(data[i][j], j, i);
				th.repaint();
			}
			
		}
	}

}
