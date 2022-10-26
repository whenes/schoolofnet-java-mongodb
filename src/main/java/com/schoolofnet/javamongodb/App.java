package com.schoolofnet.javamongodb;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class App {
    public static void main( String[] args ) {
//    	mongoClient();
//    	mongoClientURI();
//    	mongoOld();
//    	getDatabases();
//    	createCollection();
//    	dropCollection();
    	getCollections();
    }
    
    public static void mongoClient() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("java_mongo");
        
        System.out.println(db);
    }
    
    public static void mongoClientURI() {
    	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongo = new MongoClient(uri);
        MongoDatabase db = mongo.getDatabase("java_mongo");
        
        System.out.println(db);
    }
    
    // < 2.10
    public static void mongoOld() {
    	Mongo mongoOld = new Mongo("localhost", 27017);
    	DB db = mongoOld.getDB("java_mongo");
    	
    	System.out.println(db);
    }
    
    public static void mongoCredential() {
    	try {
    		MongoCredential credential = MongoCredential.createCredential("root", "java_mongo", "123".toCharArray());
            MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
            MongoDatabase db = mongo.getDatabase("java_mongo");
            
            System.out.println(db);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void mongoReplicaSet() {
    	MongoClient mongoReplicaSet = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017), 
    																new ServerAddress("localhost", 27018), 
    																new ServerAddress("localhost", 27019)));
    }
    
    public static void getDatabases() {
    	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongo = new MongoClient(uri);
        MongoDatabase db = mongo.getDatabase("java_mongo");
        
        List<String> databases = mongo.getDatabaseNames();
        
        for (String database: databases) {
        	System.out.println(database);
        }
    }
    
    public static void createCollection() {
    	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongo = new MongoClient(uri);
        MongoDatabase db = mongo.getDatabase("java_mongo");
        
        db.createCollection("teste2");
    }
    
    public static void dropCollection() {
    	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongo = new MongoClient(uri);
        MongoDatabase db = mongo.getDatabase("java_mongo");
        
        MongoCollection<Document> dbCollection =  db.getCollection("teste");
        dbCollection.drop();
    }
    
    public static void getCollections() {
    	MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongo = new MongoClient(uri);
        MongoDatabase db = mongo.getDatabase("java_mongo");
        
        for (String collection: db.listCollectionNames()) {
        	System.out.println(collection);
        }
    }
}
