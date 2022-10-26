package com.schoolofnet.javamongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Connection {
	
	private static final String HOST = "localhost";
	private static final Integer PORT = 27017;
	private static final String URI = "mongodb://localhost:27017";
	private static MongoClient INSTANCE = null;
	
	public static MongoClient getConnection() {
		if (INSTANCE == null) {
			MongoClientURI con = new MongoClientURI(URI);
			INSTANCE = new MongoClient(con);			
		}
		return INSTANCE;
	}
	
	public static void closeConnection() {
		INSTANCE.close();
	}

}
