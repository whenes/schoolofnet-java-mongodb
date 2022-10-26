package com.schoolofnet.javamongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

public class DriverAsync {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		insertAsync();
		findAsync();
	}
	
	public static void findAsync() throws InterruptedException, ExecutionException {
		MongoClient conAsync = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));
		MongoDatabase dbAsync = conAsync.getDatabase("java_mongo");
		MongoCollection<Document> collectionAsync = dbAsync.getCollection("sectors");
		CompletableFuture<List> result = new CompletableFuture<List>();
		collectionAsync.find().into(new ArrayList<Document>(), 
				new SingleResultCallback<List<Document>>() {
					@Override
					public void onResult(List<Document> list, Throwable t) {
						result.complete(list);
					}
				});
		for (Object obj: result.get()) {
			System.out.println(obj);
		}
	}
	
	public static void insertAsync() throws InterruptedException, ExecutionException {
		MongoClient conAsync = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));
		MongoDatabase dbAsync = conAsync.getDatabase("java_mongo");
		MongoCollection<Document> collectionAsync = dbAsync.getCollection("sectors", Document.class);
		
		Document document = new Document();
		document.put("name", "teste async");
		document.put("company", "company asyn");
		
		collectionAsync.insertOne(document, 
				new SingleResultCallback<Void>() {
					@Override
					public void onResult(Void r, Throwable t) {
						System.out.println("inserted");
					}
				});
	}
}
