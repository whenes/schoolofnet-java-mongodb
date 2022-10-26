package com.schoolofnet.javamongodb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class Insert {

	public static void main(String[] args) {
    	insertSubDocumentDocument();
	}
	
	public static void insertDocument() {
    	MongoClient con = Connection.getConnection();
    	con.getDatabase("java_mongo").createCollection("person");
    	BasicDBObject document = new BasicDBObject();
    	document.put("name", "Whenes");
    	document.put("age", 20);
    	document.put("techs", Arrays.asList("java", "javascript", "html"));
    	MongoDatabase db = con.getDatabase("java_mongo");
    	MongoCollection<BasicDBObject> personCollection = db.getCollection("person", BasicDBObject.class);
    	personCollection.insertOne(document);
    }

    public static void insertMapDocument() {
    	MongoClient con = Connection.getConnection();
    	Map<String, Object> mapDocument = new HashMap<String, Object>();
    	mapDocument.put("name", "Whenes");
    	mapDocument.put("age", 20);
    	mapDocument.put("techs", Arrays.asList("java", "javascript", "html"));
    	MongoDatabase db = con.getDatabase("java_mongo");
    	MongoCollection<BasicDBObject> personCollection = db.getCollection("person", BasicDBObject.class);
    	personCollection.insertOne(new BasicDBObject(mapDocument));
    }

    public static void insertJsonDocument() {
    	MongoClient con = Connection.getConnection();
    	Map<String, Object> mapDocument = new HashMap<String, Object>();
    	String jsonDocument = "{ 'name': 'whenes', 'age': 21, 'techs': ['py', 'js', 'java'] }";
    	DBObject dbObject = (DBObject) JSON.parse(jsonDocument);
    	
    	MongoDatabase db = con.getDatabase("java_mongo");
    	MongoCollection<DBObject> personCollection = db.getCollection("person", DBObject.class);
    	personCollection.insertOne(dbObject);
    }
    
    public static void insertSubDocumentDocument() {
    	MongoClient con = Connection.getConnection();
    	Map<String, Object> subDocument = new HashMap<String, Object>();
    	subDocument.put("info", "value");
    	
    	Map<String, Object> mapDocument = new HashMap<String, Object>();
    	mapDocument.put("name", "Whenes");
    	mapDocument.put("age", 20);
    	mapDocument.put("techs", Arrays.asList("java", "javascript", "html"));
    	mapDocument.put("subdocument", subDocument);
    	
    	MongoDatabase db = con.getDatabase("java_mongo");
    	MongoCollection<BasicDBObject> personCollection = db.getCollection("person", BasicDBObject.class);
    	personCollection.insertOne(new BasicDBObject(mapDocument));
    }
}
