package org.mohamed.pha.medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.regex.*;

import javax.faces.validator.RegexValidator;
import javax.json.Json;

import org.mohamed.pha.model.product;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class productaccess {

	public List getProductDetails() {

		DBCollection coll = MongoUtils.getCollection();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("quantity", 0);
		DBCursor cursor = coll.find(searchQuery);
		List<DBObject> dbObjects = cursor.toArray();
		List<product> listProducts = new ArrayList<>();
		for (int i = 0; i < dbObjects.size(); i++) {
			product Product = new product();

			DBObject dbObject = dbObjects.get(i);
			Product.setDrugName(dbObject.get("drug_name").toString());
			Product.setDrugPrice(dbObject.get("price").toString());
			Product.setDrugQuantity(Integer.parseInt(dbObject.get("quantity")
					.toString()));

			listProducts.add(Product);

		}

		return listProducts;
	}

	public List<product> getProductDetailsByDrugName(String name) {
		DBCollection coll = MongoUtils.getCollection();
		BasicDBObject searchQuery = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("drug_name", Pattern.compile(name,
				Pattern.CASE_INSENSITIVE)));
		obj.add(new BasicDBObject("quantity", new BasicDBObject("$ne", 0)));
		searchQuery.put("$and", obj);
		DBCursor cursor = coll.find(searchQuery);
		List<DBObject> dbObjects = cursor.toArray();
		List<product> listProducts = new ArrayList<>();
		for (int i = 0; i < dbObjects.size(); i++) {
			product Product = new product();
			DBObject dbObject = dbObjects.get(i);
			Product.setDrugName(dbObject.get("drug_name").toString());
			Product.setDrugPrice(dbObject.get("price").toString());
			Product.setDrugQuantity(Integer.parseInt(dbObject.get("quantity")
					.toString()));
			listProducts.add(Product);
		}
		return listProducts;
	}

}
