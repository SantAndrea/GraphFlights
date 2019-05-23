package util;

import java.util.HashMap;
import java.util.Map.Entry;

public class Node {

	private String nodeName;
	private String nameTable;
	private HashMap<String,String> values;
	
	public Node(){
		
	}
	
	public Node(String nodeName,String nameTable){
		this.nameTable = nameTable;
		this.nodeName = nodeName;
	}
	
	
	public Node(String nodeName,String nameTable, HashMap<String,String> values){
		this.nameTable = nameTable;
		this.nodeName = nodeName;
		this.values = values;
	}
	
	
	public void addParam(String name, String value){
		values.put(name, value);
	}
	
	public void addParams(HashMap<String,String> values){
		values.putAll(values);
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNameTable() {
		return nameTable;
	}

	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}

	public HashMap<String, String> getValues() {
		return values;
	}

	public void setValues(HashMap<String, String> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "Node [nodeName=" + nodeName + ", nameTable=" + nameTable + ", values=" + values + "]";
	}
	
	public Node clone(){
		
		Node clone = new Node();
		clone.nameTable = this.nameTable;
		clone.nodeName = this.nodeName;
		
		HashMap<String,String> clonedValues = new HashMap<String,String>();
		
		for(Entry<String, String> mapElement: values.entrySet()){
			
			String clonedParam = mapElement.getKey();
			String clonedValue = mapElement.getValue();
			clonedValues.put(clonedParam, clonedValue);	
		}
		
		return clone;
	}
	
	
	
}
