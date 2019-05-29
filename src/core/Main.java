package core;
import jdbc.Neo4jConnectionPool;

import org.neo4j.driver.v1.Driver;

import controller.CommandCreator;

public class Main {

	public static String DB_NAME = "line"; 
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Neo4jConnectionPool ncp = new Neo4jConnectionPool();
		CommandCreator cc = new CommandCreator();
		Driver driver = ncp.connection();
		
		String matcher = cc.matchAll();
		
		ncp.query(matcher, driver);
		ncp.close();
	}

}
