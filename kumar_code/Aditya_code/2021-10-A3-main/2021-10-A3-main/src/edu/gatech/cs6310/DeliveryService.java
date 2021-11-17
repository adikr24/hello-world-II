package edu.gatech.cs6310;
import com.mysql.cj.jdbc.result.UpdatableResultSet;
import java.util.Scanner;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;


public class DeliveryService {
    public void commandLoop() {
        Scanner commandLineInput = new Scanner(System.in);
        String wholeInputLine;
        String[] tokens;
        final String DELIMITER = ",";

        while (true) {
            try {
                // Determine the next command and echo it to the monitor for testing purposes
                wholeInputLine = commandLineInput.nextLine();
                tokens = wholeInputLine.split(DELIMITER);
                System.out.println("> " + wholeInputLine);

                if (tokens[0].equals("make_store")) {
                    int rev = Integer.parseInt(tokens[2]);
                    StoreClass UpdateStoreSettings = new StoreClass();
                    UpdateStoreSettings.MakeEntriesStore(tokens[1],rev);
                    UpdateStoreSettings.MakeStoreAlert();

                } else if (tokens[0].equals("display_stores")) {
                    System.out.println("DISPLAY STARTS");
                    StoreClass DispStores = new StoreClass();
                    DispStores.DisplayStore();

                } else if (tokens[0].equals("sell_item")) {
                    // System.out.println("store: " + tokens[1] + ", item: " + tokens[2] + ", weight: " + tokens[3]);
                    ItemClass  MakeAlert = new ItemClass();
                    MakeAlert.MakeEntriesItem(tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[1]+tokens[2]);
                    MakeAlert.MakeItemAlert();

                } else if (tokens[0].equals("display_items")) {
                    ItemClass DispItems = new ItemClass();
                    DispItems.ItemDisplay(tokens[1]);
                    System.out.println("store: " + tokens[1]);

                } else if (tokens[0].equals("make_pilot")) {
                    // System.out.print("account: " + tokens[1] + ", first_name: " + tokens[2] + ", last_name: " + tokens[3]);
                    // System.out.println(", phone: " + tokens[4] + ", tax: " + tokens[5] + ", license: " + tokens[6] + ", experience: " + tokens[7]);
                    PilotClass MakeAlert = new PilotClass();
                    MakeAlert.MakeEntriesPilot(tokens[1] , tokens[2] , tokens[3] , tokens[4] , tokens[5] , tokens[6] , Integer.parseInt(tokens[7]));
                    MakeAlert.MakePilotAlert();

                } else if (tokens[0].equals("display_pilots")) {
                    PilotClass DispPilot = new PilotClass();
                    DispPilot.PilotDisplay();

                }
                else if (tokens[0].equals("make_drone")) {
                    DroneClass DroneAlert = new DroneClass();
                    DroneAlert.MakeEntriesDrone(tokens[1],tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                    DroneAlert.MakeDroneAlert();
                }

                else if (tokens[0].equals("display_drones")) {
                    DroneClass DispDrones = new DroneClass();
                    DispDrones.DisplayDrones(tokens[1]);
                    // System.out.println("store: " + tokens[1]);
                }
                else if (tokens[0].equals("fly_drone")) {
                    System.out.println("store: " + tokens[1] + ", drone: " + tokens[2] + ", pilot: " + tokens[3]);

                } else if (tokens[0].equals("make_customer")) {
                    System.out.print("account: " + tokens[1] + ", first_name: " + tokens[2] + ", last_name: " + tokens[3]);
                    System.out.println(", phone: " + tokens[4] + ", rating: " + tokens[5] + ", credit: " + tokens[6]);

                } else if (tokens[0].equals("display_customers")) {
                    System.out.println("no parameters needed");

                } else if (tokens[0].equals("start_order")) {
                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2] + ", drone: " + tokens[3] + ", customer: " + tokens[4]);

                } else if (tokens[0].equals("display_orders")) {
                    System.out.println("store: " + tokens[1]);

                } else if (tokens[0].equals("request_item")) {
                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2] + ", item: " + tokens[3] + ", quantity: " + tokens[4] + ", unit_price: " + tokens[5]);

                } else if (tokens[0].equals("purchase_order")) {
                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2]);

                } else if (tokens[0].equals("cancel_order")) {
                    System.out.println("store: " + tokens[1] + ", order: " + tokens[2]);

                } else if (tokens[0].equals("stop")) {
                    System.out.println("stop acknowledged");
                    break;

                } else {
                    System.out.println("command " + tokens[0] + " NOT acknowledged");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println();
            }
        }

        System.out.println("simulation terminated");
        commandLineInput.close();
    }
}
