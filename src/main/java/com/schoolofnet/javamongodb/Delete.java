package com.schoolofnet.javamongodb;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Delete {

	public static void main(String[] args) {
		deleteOne();
	}
	
	public static void findOneAndDelete() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId("6359997ae74c8353e89a8d9d"));
		collection.findOneAndDelete(query);
	}
	
	public static void deleteOne() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId("63599bade74c835792c1fd55"));
		collection.deleteOne(query);
	}
}
