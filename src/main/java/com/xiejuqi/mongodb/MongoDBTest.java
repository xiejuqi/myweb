package com.xiejuqi.mongodb;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import com.xiejuqi.base.BaseLogger;

/**
 * 
 * @Filename MongoDBTest.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2015年12月29日 下午3:48:47
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class MongoDBTest extends BaseLogger {

	public void test() throws UnknownHostException {
		try {
			
			// 实例化Mongo对象，连接27017端口
			Mongo mongo = new Mongo("localhost", 27017);
			// 连接名为yourdb的数据库，假如数据库不存在的话，mongodb会自动建立
			DB db = mongo.getDB("test");
			// Get collection from MongoDB, database named "yourDB"
			// 从Mongodb中获得名为yourColleection的数据集合，如果该数据集合不存在，Mongodb会为其新建立
			DBCollection collection = db.getCollection("foo");
			// 使用BasicDBObject对象创建一个mongodb的document,并给予赋值。
			BasicDBObject document = new BasicDBObject();
			document.put("id", 1001);
			document.put("msg", "hello world mongoDB in Java");
			// 将新建立的document保存到collection中去
			collection.insert(document);
			// 创建要查询的document
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("id", 1001);
			// 使用collection的find方法查找document
			DBCursor cursor = collection.find(searchQuery);
			// 循环输出结果
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			System.out.println("Done");

			// 查询所有的Database
			for (String name : mongo.getDatabaseNames()) {

				System.out.println("dbName: " + name);

			}

			DB dbc = mongo.getDB("test");

			// 查询所有的聚集集合
			for (String name : db.getCollectionNames()) {

				System.out.println("collectionName: " + name);

			}

			DBCollection users = db.getCollection("users");

			// 查询所有的数据
			DBCursor cur = users.find();

			while (cur.hasNext()) {

				System.out.println(cur.next());

			}

			System.out.println(cur.count());

			System.out.println(cur.getCursorId());

			System.out.println(JSON.serialize(cur));

		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws UnknownHostException {
		new MongoDBTest().test();
	}
}
