package com.schoolofnet.javamongodb;

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Find {

	public static void main(String[] args) {
		find();
	}
	
	public static void find() {
		MongoClient con = new Connection().getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		for (Document doc: collection.find()) {
			System.out.println(doc.toJson());
		}
	}
	
	public static void findById() {
		MongoClient con = new Connection().getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		BasicDBObject query = new BasicDBObject();
		query.append("_id", new ObjectId("6359997ae74c8353e89a8d9d"));

		for (Document doc: collection.find(query)) {
			System.out.println(doc.toJson());
		}
	}
	
	public static void findByTechs() {
		MongoClient con = new Connection().getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("person");
		BasicDBObject query = new BasicDBObject();
		query.put("techs", new BasicDBObject("$in", Arrays.asList("js")));

		for (Document doc: collection.find(query)) {
			System.out.println(doc.toJson());
		}
	}

}