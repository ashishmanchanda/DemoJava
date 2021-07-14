package com.example.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;

class MysqlConnect {
    public static void main(String args[]) {
        Connection con = null;
        Statement stmt = null;
        List<Integer> saleOrderItemIds = new ArrayList<>();
        List<String> saleOrderItemCodes = new ArrayList<>();
        List<Integer> tenantIds = new ArrayList<>();
        HashSet<String> tenantCodes = new HashSet<>();
        List<Integer> reversePickupItemIds = new ArrayList<>();
        List<String> saleOrderCodes = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniware", "root", "uniware");
            stmt = con.createStatement();
            //ResultSet rs = stmt.executeQuery(
            //       "select * from sale_order_item soi join reverse_pickup rp on soi.reverse_pickup_id =rp.id join reverse_pickup_item rpi on rpi.reverse_pickup_id =rp.id where soi.status_code='REPLACED'");
            ResultSet rs = stmt.executeQuery(
                    "select rpi.sale_order_item_id,soi.code,t.code,so.code from reverse_pickup_item rpi join sale_order_item soi on rpi.sale_order_item_id=soi.id join sale_order so on so.id=soi.sale_order_id join tenant t on so.tenant_id=t.id where soi.status_code='REPLACED'");
            while (rs.next()) {
                saleOrderItemIds.add(rs.getInt(1));
                saleOrderItemCodes.add(rs.getString(2));
                tenantCodes.add(rs.getString(3));
                saleOrderCodes.add(rs.getString(4));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("tenant codes are : " + tenantCodes);
        MongoClient mongo = new MongoClient("localhost", 27017);
        for (String tenantCode : tenantCodes) {
            //     System.out.println("saleOrderItem codes are " + saleOrderItemCodes);
            // Creating a Mongo client

            // Accessing the database
            MongoDatabase database = mongo.getDatabase(tenantCode);

            // Retieving a collection
            MongoCollection<Document> collection = database.getCollection("methodActivityMeta");
            System.out.println("Collection myCollection selected successfully");
            int j;
            reversePickupItemIds = new ArrayList<>(saleOrderItemCodes.size());
            for (j = 0; j < saleOrderItemCodes.size(); j++) {
                BasicDBObject inQuery = new BasicDBObject();
                inQuery.put("log", java.util.regex.Pattern.compile(Pattern.quote(saleOrderItemCodes.get(j))));
                // inQuery.put("entityName", "REVERSE_PICKUP");
                inQuery.put("tenantCode", tenantCode);
                inQuery.put("groupIdentifier", saleOrderCodes.get(j));

                FindIterable<Document> iterDoc = collection.find(inQuery);
                System.out.print("Checking Document for sale_order_item code " + saleOrderItemCodes.get(j));
                int i = 1;
                // Getting the iterator
                Iterator it = iterDoc.iterator();
                Long startTime = System.currentTimeMillis();
                System.out.print("Start time is:" + startTime);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uniware", "root", "uniware");
                    stmt = con.createStatement();
                } catch (Exception e) {

                }
                if (it.hasNext()) {
                    try {
                        ResultSet rs = stmt.executeQuery(
                                "select rpi.id from reverse_pickup_item rpi left join sale_order_item soi  on rpi.sale_order_item_id =soi.id where soi.code="
                                        + saleOrderItemCodes.get(j));
                        while (rs.next()) {
                            reversePickupItemIds.add(rs.getInt(1));
                            stmt.executeUpdate("update reverse_pickup_item set status_code='COMPLETE' where id=" + rs.getInt(1) + " and status_code is null");
                        }
                        rs.close();
                        stmt.close();
                        con.close();
                    } catch (Exception e) {

                    }
                } else {
                    try {
                        ResultSet rs = stmt.executeQuery(
                                "select rpi.id from reverse_pickup_item rpi left join sale_order_item soi  on rpi.sale_order_item_id =soi.id where soi.code="
                                        + saleOrderItemCodes.get(j).toString());
                        while (rs.next()) {
                            reversePickupItemIds.add(rs.getInt(1));
                            stmt.executeUpdate("update reverse_pickup_item set status_code='CREATED' where id=" + rs.getInt(1) + " and status_code is null");
                        }
                        rs.close();
                        stmt.close();
                        con.close();
                    } catch (Exception e) {

                    }
                }
                Long endTime = System.currentTimeMillis();
                System.out.println("Time taken to get the sale_order_item is " + (endTime - startTime));
                while (it.hasNext()) {
                    System.out.println(it.next());
                    i++;
                }
            }
        }
        System.out.print("ReversePickupItem ids are " + reversePickupItemIds);
    }
}