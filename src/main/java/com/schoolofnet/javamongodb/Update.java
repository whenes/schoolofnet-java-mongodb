package com.schoolofnet.javamongodb;

import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Update {

	public static void main(String[] args) {
		updateOne();
	}
	
	public static void findOneAndUpdate() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		Bson query = new Document("_id", new ObjectId("63599a4de74c8354f8b645f0"));
		Bson update = new Document("techs", Arrays.asList("php", "go"));
		collection.findOneAndUpdate(query, new Document("$set", update));
	}
	
	public static void updateOne() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		Bson query = new Document("_id", new ObjectId("63599a4de74c8354f8b645f0"));
		Bson update = new Document("techs", Arrays.asList("kubernetes", "docker"));
		collection.updateOne(query, new Document("$set", update));
	}
}
