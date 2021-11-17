package edu.gatech.cs6310;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PilotClass {
    public void MakePilotAlert(){
        System.out.println("OK:change_completed");
    }

    public void MakeEntriesPilot(String AccountID, String FirstName, String LastName ,String PhoneNumber, String TaxID, String LicenseID, int ExperienceLevel )
    {
        try{
            String makePilot;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            makePilot = "Insert INTO pilots " + "VALUES ( '" + AccountID + "','" + FirstName + "','" + LastName + "','" + PhoneNumber + "','" + TaxID + "','" + LicenseID + "','" + ExperienceLevel + "','" + "N" + "');";
            System.out.println(makePilot);
            statement.executeUpdate(makePilot);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void PilotDisplay(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            String Getquery = "select concat(concat(FirstName,'_'),LastName) as name_, PhoneNumber, TaxId, LicenseID, ExperienceLevel from pilots order by 1;";
            ResultSet resultSet = statement.executeQuery(Getquery);
            while (resultSet.next()) {
                System.out.println("name:" + resultSet.getString("name_") + ",phone:" + resultSet.getString("PhoneNumber") + ",taxID:" +  resultSet.getString("TaxId") +
                ",licenseID:" +resultSet.getString("LicenseID")  + ",experience:" +  resultSet.getInt("ExperienceLevel") );
            }
            System.out.println("OK:display_completed");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }









}
