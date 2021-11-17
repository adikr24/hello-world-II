package edu.gatech.cs6310;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Flow;

public class DroneClass {
    public void MakeDroneAlert(){
        System.out.println("OK:change_completed");
    }

    public void MakeEntriesDrone(String StoreName, String DroneID, int WeightCapacity, int RemainingCapacity)
    {
        try{
            String makedrones;
            int Num_orders= 0;
            String FlownBy;
            FlownBy = "N";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();

            makedrones = "Insert INTO drones " + "VALUES ( '" + StoreName + "','" + DroneID + "','" + WeightCapacity + "','" + RemainingCapacity + "','" + "N', '" + Num_orders + "','" + FlownBy + "');";
            // System.out.println(makedrones);
            statement.executeUpdate(makedrones);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void DisplayDrones(String StoreName){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","Admin","8002326024aA!");
            Statement statement = connection.createStatement();
            String Getquery = "select DroneID, WeightCapacity, NumOrders, RemainingDeliveries ,WeightCapacity from drones where StoreName in ('" + StoreName + "') and FlownBy in ('N')  order by 1;";
            String Getquery_II = "select DroneID, WeightCapacity, NumOrders, RemainingDeliveries ,WeightCapacity from drones where StoreName in ('" + StoreName + "') and FlownBy not in ('N')  order by 1;";
            System.out.println(Getquery);
            ResultSet resultSet = statement.executeQuery(Getquery);
            System.out.println("get executed");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("DroneID") + resultSet.getRow());
                // System.out.println("droneID:" + resultSet.getString("DroneID") + ",total_cap:" + resultSet.getString("WeightCapacity") + ",num_orders:" +  resultSet.getString("NumOrders") +
                //         ",remaining_cap:" +resultSet.getString("WeightCapacity")  + ",trips_left:" +  resultSet.getInt("RemainingDeliveries") );
            }
            // to display drones with assigned pilots
            ResultSet rs_II = statement.executeQuery(Getquery_II);
            while (rs_II.next()){
                System.out.println(rs_II.getString("DroneID"));
            }
            System.out.println("OK:display_completed");
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }




}
