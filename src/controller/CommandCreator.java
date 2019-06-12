package controller;
import java.util.Map.Entry;

import util.Node;

/**Questa classe permette di creare comando per Neo4j*/
public class CommandCreator {

	/**Crea il comando per generare un nodo a partire da un oggetto Node.
	 * Example: CREATE (p:TableName{attr1:value1,attr2:value2});
	 * @param node un oggetto di tipo nodo
	 * @return La stringa contente il comando.*/
	public String createNode(Node node){
		String command = "CREATE("+node.getNodeName()+":"+node.getNameTable()+"{ ";
		
		int counter = 0;
		
		for(Entry<String, String> mapElement: node.getValues().entrySet()){
			command = command+mapElement.getKey()+" : "+mapElement.getValue();
			
			if(counter>=1){
				command = command+", ";
			}
			counter ++;
			
		}
		command = command+"});";

		return command;
	}
	
	
	public String matchAll(){
		String command = "match (n) return n";
		return command;
	}
	
	public String flightsFromWhere(){
		String command = "MATCH (p:Pilota {eta: \"41\"})-[:Pilota_Viaggio]->(v:Volo)<-[:Aereo_Volo]-(a:Aereo {anno_acquisto: \"2013\"}), "
				+ "(v)<-[:Arrivo]-(ap)-[:Partenza]->(others) "
				+ "RETURN p, a, ap, others AS Volo";
		return command;
	}
	
	public String pilotFlightWithModel() {
		String command = "match (v:Volo)<-[:Pilota_Viaggio]-(p:Pilota), (v)<-[:Aereo_Volo]-(a:Aereo), (ap:Aeroporto {comune :\"NAPOLI\"})"
				+ ", (app:Aeroporto {comune : \"CIAMPINO\"})"
				+ " where a.modello = \"Boeing 777-300\" and v.id_pilota = p.matricola and (v)<-[:Partenza]-(app)"
				+ "and not (v)<-[:Arrivo]-(ap) return a, p";
		return command;
	}
	
	public String aereoByVoloDateAndDeparture(){
		String command = "match (a:Aereo)<-[:Aereo_Volo]-(v:Volo)"
				+ " where v.data=\"5\06\2018\" and v.aeroporto_partenza=\"NAP\""
				+ " return a;";
		return command;
	}
	
	public String voloByAeroporto(){
		String command = "match(v:Volo)<-[r:Arrivo]-(ar:Aeroporto)"
				+ " where v.aeroporto_partenza = \"NAP\" "
				+ " return v";
				
		return command;
	}
	
	

}
