package com.primeton.wujun.mongodb;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoDBCRUDTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eos730","root","root");
//		
//		
//		PreparedStatement ps = conn.prepareStatement("select * from cap_user where username = ?");
//		ps.setInt(1, 3);
//		int a = 1;
//		System.out.println(a);
		
		
		Mongo mongo = null;
		try {
			mongo = new Mongo("127.0.0.1",27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return;
		}
		DB db = mongo.getDB("wujun");
		DBCollection dbCollection = db.getCollection("wujun");
		int i = 0;
		while (i++<1000) {
			DBObject dbo = new BasicDBObject();
			dbo.put("name", "ะกร๗");
			dbo.put("age", new Random().nextInt()%8000);
			dbo.put("addressId", new Random().nextInt()%8000);
			dbCollection.insert(dbo);
		}
		DBCursor dbCursor = dbCollection.find();
		System.out.println(dbCursor.count());
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			System.out.println(dbObject);
		}
		System.out.println(mongo.getAddress());
	}

}
