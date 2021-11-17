package edu.gatech.cs6310;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ItemClass {
public void MakeItemAlert(){
    System.out.println("OK:change_completed");
}

public void MakeEntriesItem(String StoreName, String ItemName , int Weight, String StoreNameAndItem) {
        try{
            String makeitem;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            makeitem = "Insert INTO items " + "VALUES ( '" + StoreName + "','" + ItemName + "','" + Weight + "','" + StoreNameAndItem + "');";
            statement.executeUpdate(makeitem);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ItemDisplay(String StoreName){
         // System.out.println("Getting Started with your connection");
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            String Getquery = "select ItemName, ItemWeight from items where StoreName in ('" + StoreName + "') order by 1;";
            // System.out.println(Getquery);
            ResultSet resultSet = statement.executeQuery(Getquery);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("ItemName") + "," + resultSet.getInt("ItemWeight") );
            }
            System.out.println("OK:display_completed");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }







}
