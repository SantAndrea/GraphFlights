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
}
