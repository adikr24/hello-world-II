package edu.gatech.cs6310;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;


public class StoreClass {
    public void MakeStoreAlert(){
        System.out.println("OK:change_completed");
    }
    public void MakeEntriesStore(String StoreName, int Revenue) {
        try{
            String makestore;
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            makestore = "Insert INTO store " + "VALUES ( '" + StoreName + "'," + Revenue + ");";
            // throw new java.lang.Error("this is very bad"); // include an If else statement before updating the sql
            statement.executeUpdate(makestore);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DisplayStore(){
        System.out.println("Getting Started with your connection");
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from store order by 1;");
            while (resultSet.next()) {
                System.out.println("name:" + resultSet.getString("StoreName") + ",revenue:" + resultSet.getInt("Revenue") );
            }
            System.out.println("OK:display_completed");
        }
        catch (Exception e){
            // throw new java.lang.Error("this is very bad");
            e.printStackTrace();
        }

    }


}
