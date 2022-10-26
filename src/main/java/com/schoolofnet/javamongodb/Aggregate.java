package com.schoolofnet.javamongodb;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Aggregate {

	public static void main(String[] args) {
//		setUp();
//		aggregate();
		count();
	}
	
	public static void setUp() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<BasicDBObject> collection = db.getCollection("sectors", BasicDBObject.class);
		BasicDBObject document1 = new BasicDBObject();		
		document1.put("name", "it");
		document1.put("company", "itc");
		BasicDBObject document2 = new BasicDBObject();	
		document2.put("name", "it2");
		document2.put("company", "itc");	
		BasicDBObject document3 = new BasicDBObject();		
		document3.put("name", "it3");
		document3.put("company", "itc1");
		BasicDBObject document4 = new BasicDBObject();	
		document4.put("name", "it4");
		document4.put("company", "itc1");	
		BasicDBObject document5 = new BasicDBObject();	
		document5.put("name", "it5");
		document5.put("company", "itc2");
		
		collection.insertOne(document1);
		collection.insertOne(document2);
		collection.insertOne(document3);
		collection.insertOne(document4);
		collection.insertOne(document5);
	}
	
	public static void aggregate() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("sectors");
		
		AggregateIterable<Document> it = collection.aggregate(Arrays.asList(new Document("$group", new Document("_id", "$company"))));
		
		it.forEach(new Block<Document>() {
			public void apply(Document doc) {
				System.out.println(doc.toJson());
			}
		});
	}
	
	public static void count() {
		MongoClient con = Connection.getConnection();
		MongoDatabase db = con.getDatabase("java_mongo");
		MongoCollection<Document> collection = db.getCollection("sectors");
		
		System.out.println(collection.count());
	}
}
