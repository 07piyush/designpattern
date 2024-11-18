package creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPoolManager {
	
	private static ConnectionPoolManager singleton = null;
	private Queue<Connection> connectionPool;
	private final int MAX_POOL_SIZE = 10;
	
	private ConnectionPoolManager(){
		connectionPool = new LinkedList<>();
		initializeConnectionPool();
	}

	//Whole purpose of singleton : to provide the interface to clients, to get a connection
	//of a database, which will always be same.
	public static synchronized ConnectionPoolManager getInstance() {
		if(null == singleton) {
			singleton = new ConnectionPoolManager();
		}
		return singleton;
	}
	
	public Connection getConnection() {
		if(connectionPool.isEmpty()) {
			return createNewConnection();
		}
		else {
			return connectionPool.poll();
		}
	}
	
	public synchronized void releaseConnection(Connection connection) {
		if(connectionPool.size() < MAX_POOL_SIZE) {
			connectionPool.offer(connection);
		}
	}
	
	private void initializeConnectionPool() {
		while(connectionPool.size() < MAX_POOL_SIZE) {
			connectionPool.add(createNewConnection());
		}
	}
	
	private Connection createNewConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:database_url");
		} catch (SQLException e) {
			throw new RuntimeException("Error creating connection.", e);
		}
	}
}
