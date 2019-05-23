package core;
import org.neo4j.driver.v1.*;

/** Gestore delle operazioni fondamentali su un database Neo4j.
 * L'interfaccia AutoClosable consente di chiudere automaticamente la connessione quando
 * il servizio richiesto è terminato.*/
public class Neo4jConnectionPool implements AutoCloseable{
	 
	private final static String uri = "bolt://localhost/7687";
	private final static String username = "neo4j";
	private final static String password = "12345";
	
	private Driver driver;
	
	public Neo4jConnectionPool(){}
	
	/**Metodo per la connessione al database
	 * @return Restituisce un oggetto Driver per la connessione al db. */
	public Driver connection(){
		driver = GraphDatabase.driver(uri,AuthTokens.basic(username,password));
		return driver;
	}

	@Override
	public void close() throws Exception {
		driver.close();
	}
	
	public void executeTransaction(Driver driver, String command){
		
		try(Session session = driver.session()){
			
			session.writeTransaction(new TransactionWork<String>(){

				@Override
				public String execute(Transaction tx) {
					StatementResult result = tx.run(command);
					
					return result.single().get(0).asString();
				}
				
			});
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
