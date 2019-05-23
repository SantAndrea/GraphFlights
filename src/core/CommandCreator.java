package core;

import java.util.List;
import java.util.Map.Entry;

import util.Node;

/**Questa classe permette di creare comando per Neo4j*/
public class CommandCreator {

	/**Crea il comando per generare un nodo a partire da un oggetto Node.
	 * @param node un oggetto di tipo nodo
	 * @return La stringa contente il comando.*/
	public String createNode(Node node){
		String command = "CREATE("+node.getNodeName()+":"+node.getNameTable()+"{ ";
		
		int counter = 0;
		
		for(Entry<String, String> mapElement: node.getValues().entrySet()){
			command = command+mapElement.getKey()+" : "+mapElement.getKey();
			
			if(counter>=1){
				command = command+", ";
			}
			counter ++;
			
		}
		command = command+"});";

		return command;
	}

	/**Crea la stringa di comando per generare un nodo a partire da un CSV precaricato sul database.
	 * Nel caso in cui la lista dei parametri non ha la stesa dimensione della lista degli attributi del csv
	 * viene scelto la dimensione più bassa, creando parzialmente il nodo.
	 * @param nodeName il nome del nodo
	 * @param tableName il nome della tabella
	 * @param csvVariable il nome della variabile del csv
	 * @param paramNode i nomi degli attributi del futuro nodo
	 * @param paramsCSV i nomi degli attributi del csv
	 * @return La stringa contente il comando.*/
	public String createNodeCSV(String nodeName, String tableName, String csvVariable,
			List<String>paramsNode, List<String>paramsCSV){
		
		int maxSize = 0;
		
		if(paramsCSV.size()<=paramsNode.size()){
			maxSize = paramsCSV.size();
		}else{
			maxSize = paramsNode.size();
		}
			String command = "MERGE("+nodeName+":"+tableName+"{";

			for(int i=0; i<maxSize;i++){
				
				command = command+paramsNode.get(i)+" : "+csvVariable+"."+paramsCSV.get(i);
				
				if(maxSize>1){
					command = command+", ";
				}

			}
		
		command = command+"});";
		
		return command;

		
	}
	
	/**Crea la stringa di comando per caricare un file csv con headers all'interno del database Neo4j.
	 * @param path il percorso in cui è presente il file.
	 * @param csvVariable il nome della variabile csv
	 * @return La stringa contente il comando.*/
/**	public String loadCSVH(String path,String csvVariable){
		return "LOAD CSV WITH HEADERS FROM "+path+" AS "+csvVariable;
	}
**/	
	
	/**Crea la stringa di comando per caricare un file csv all'interno del database Neo4j.
	 * @param path il percorso in cui è presente il file.
	 * @param csvVariable il nome della variabile csv
	 * @return La stringa contente il comando.*/
/**	public String loadCSV(String path,String csvVariable){
		return "LOAD CSV FROM "+path+" AS "+csvVariable;
	}
**/	



}
