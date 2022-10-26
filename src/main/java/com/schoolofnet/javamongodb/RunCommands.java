package com.schoolofnet.javamongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RunCommands {

	public static void main(String[] args) {
		runCommand();
	}
	
	public static void runCommand() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("sectors");
		Document command = db.runCommand(new Document("$eval", "function a() { return 1 + 1 }"));
		System.out.println(command.toJson());
	}
}
