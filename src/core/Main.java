package core;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.*;

public class Main {

	public static String DB_NAME = "line";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Neo4jConnectionPool ncp = new Neo4jConnectionPool();
		CommandCreator cc = new CommandCreator();
		
		Driver d = ncp.connection();
		List<String> params = new ArrayList<String>();
		params.add("Scadenza");
		String matcher = cc.createNodeCSV("l", "lol", DB_NAME, params, params);
		ncp.executeTransaction(d,matcher);

	}

}
