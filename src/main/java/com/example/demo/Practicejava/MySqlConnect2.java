package com.example.demo.Practicejava;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;

class MysqlConnect2 {
    public static void main(String args[]) {
        Connection con = null;
        Statement stmt = null;
        List<Integer> saleOrderItemIds = new ArrayList<>();
        List<String> saleOrderItemCodes = new ArrayList<>();
        HashMap<Integer,String> facilityIdTosaleOrderItemCode=new HashMap<>();
        List<Integer> facilityIds=new ArrayList<>();
        List<Integer> tenantIds = new ArrayList<>();
        HashSet<String> tenantCodes = new HashSet<>();
        HashSet<Integer> reversePickupItemIds = new HashSet<>();
        HashSet<Integer> completedReversePickupItemIds = new HashSet<>();
        List<String> saleOrderCodes = new ArrayList<>();
        List<String> reversePickupCodes = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + args[0] + ":3306/uniware", "root", "uniware");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select rpi.sale_order_item_id,soi.code,t.code,so.code,rp.code,soi.facility_id from reverse_pickup_item rpi join sale_order_item soi on rpi.sale_order_item_id=soi.id join sale_order so on so.id=soi.sale_order_id join tenant t on so.tenant_id=t.id join reverse_pickup rp on rp.id=soi.reverse_pickup_id where soi.status_code='REPLACED'");
            while (rs.next()) {
                saleOrderItemIds.add(rs.getInt(1));
                saleOrderItemCodes.add(rs.getString(2));
                tenantCodes.add(rs.getString(3));
                saleOrderCodes.add(rs.getString(4));
                reversePickupCodes.add(rs.getString(5));
                facilityIds.add(rs.getInt(6));
            }
            //  rs.close();
            //stmt.close();
            //con.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }
        System.out.println("Sale Order item codes are : " + saleOrderItemCodes);
        System.out.println("Sale Order Codes are :" + saleOrderCodes);
        System.out.println("Reverse Pickup Codes are :" + reversePickupCodes);
        System.out.println("Tenant Codes are : " + tenantCodes);
        MongoClient mongo = new MongoClient(args[1], 27017);
        for (String tenantCode : tenantCodes) {
            //     System.out.println("saleOrderItem codes are " + saleOrderItemCodes);
            // Creating a Mongo client

            // Accessing the database
            MongoDatabase database = mongo.getDatabase(tenantCode);

            // Retieving a collection
            MongoCollection<Document> collection = database.getCollection("methodActivityMeta");
            System.out.println("Collection myCollection selected successfully");
            int j;
            reversePickupItemIds = new HashSet<>(saleOrderItemCodes.size());
            for (j = 0; j < saleOrderItemCodes.size(); j++) {
                BasicDBObject andQuery = new BasicDBObject();
                List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                obj.add(new BasicDBObject("log", java.util.regex.Pattern.compile(Pattern.quote(saleOrderItemCodes.get(j)))));
                obj.add(new BasicDBObject("log", java.util.regex.Pattern.compile("added to putaway")));
                obj.add(new BasicDBObject("entityName", "REVERSE_PICKUP"));
                obj.add(new BasicDBObject("tenantCode", tenantCode));
                obj.add(new BasicDBObject("groupIdentifier", saleOrderCodes.get(j)));
                obj.add(new BasicDBObject("identifier", reversePickupCodes.get(j)));
                andQuery.put("$and", obj);
                //    inQuery.put("log", java.util.regex.Pattern.compile(Pattern.quote(saleOrderItemCodes.get(j))));
            /*    inQuery.put("log", java.util.regex.Pattern.compile(Pattern.quote(saleOrderItemCodes.get(j))));
                inQuery.put("entityName", "REVERSE_PICKUP");
                inQuery.put("tenantCode", tenantCode);
                inQuery.put("groupIdentifier", saleOrderCodes.get(j));
                inQuery.put("identifier", reversePickupCodes.get(j));*/
                Long startTime = System.currentTimeMillis();
                System.out.println("Start time mongo is:     " + startTime);

                FindIterable<Document> iterDoc = collection.find(andQuery);
                Long endTime = System.currentTimeMillis();
                System.out.println("Time taken to get the sale_order_item from mongo " + (endTime - startTime));
                // System.out.println("Checking Document for sale_order_item code " + saleOrderItemCodes.get(j));
                int i = 1;
                // Getting the iterator
                Iterator it = iterDoc.iterator();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://" + args[0] + ":3306/uniware", "root", "uniware");
                    stmt = con.createStatement();
                } catch (Exception e) {

                }
                if (it.hasNext()) {
                    try {
                        Long startTime1 = System.currentTimeMillis();
                        System.out.println("Start  time 1111111 is:" + startTime1);
                        ResultSet rs = stmt.executeQuery(
                                "select rpi.id,soi.sale_order_id,rpi.sale_order_item_id,soi.facility_id,soi.status_code from reverse_pickup_item rpi join sale_order_item soi  on rpi.sale_order_item_id =soi.id where soi.code='"
                                        + saleOrderItemCodes.get(j) + "' and soi.facility_id="+facilityIds.get(j));
                        if (rs.next()) {
                            completedReversePickupItemIds.add(rs.getInt(1));
                              System.out.println("SaleOrderItemCode for reverse_pickup_item is "+saleOrderItemCodes.get(j)+","+rs.getInt(1)+","+rs.getInt(2)+","+rs.getInt(3)+","+rs.getInt(4)+","+rs.getString(5));
                            stmt.executeUpdate("update reverse_pickup_item set status_code='COMPLETE' where id=" + rs.getInt(1) + " and status_code is null");
                        }
                        Long endTime1 = System.currentTimeMillis();
                        System.out.println("Time taken to mark complete 11111111" + (endTime1 - startTime1));
                        // rs.close();
                        //stmt.close();
                        //con.close();
                    } catch (Exception e) {
                        System.out.println("Exception 111111 :" + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Long startTime2 = System.currentTimeMillis();
                        System.out.println("Start time is 222222 :" + startTime2);
                        ResultSet rs = stmt.executeQuery(
                                "select rpi.id from reverse_pickup_item rpi join sale_order_item soi  on rpi.sale_order_item_id =soi.id where soi.code ='"
                                        + saleOrderItemCodes.get(j) + "' and soi.facility_id="+facilityIds.get(j));
                        if (rs.next()) {
                            reversePickupItemIds.add(rs.getInt(1));
                            stmt.executeUpdate("update reverse_pickup_item set status_code='CREATED' where id=" + rs.getInt(1) + " and status_code is null");
                        }
                        Long endTime2 = System.currentTimeMillis();
                        System.out.println("Time taken to mark created 2222222 " + (endTime2 - startTime2));
                        //  rs.close();
                        // stmt.close();
                        //con.close();
                    } catch (Exception e) {
                        System.out.println("Exception 222222 :" + e.getMessage());
                        e.printStackTrace();
                    }
                }

            }
        }
        System.out.print("Created ReversePickupItem ids are " + reversePickupItemIds);
        System.out.print("Completed ReversePickupItem ids are " + completedReversePickupItemIds);

    }
}