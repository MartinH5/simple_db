/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple_db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Hansen
 */
public class Simple_db {

    static Scanner sc = new Scanner(System.in);
    static int n;
    static HashMap hm = new HashMap();
    
    public static void main(String[] args) throws IOException {

        while (true) {
            
            System.out.println("Press '1' for Read from file, '2' for inserting to file, '3' for Generating Test Data");
            n = sc.nextInt();
            
            switch (n) {
                case 1:
                    read();
                    break;
                case 2:
                    insert();
                    break;
                case 3:
                    generateTestData();
                    break;
                default:
                    System.out.println("Output not valid, it has to be an int between 1-4 and nothing else");
            }
        }
    }

//    public static void hashIndexing() {
//
//    }

    public static void insert() throws FileNotFoundException, IOException {

        Properties properties = new Properties();
        properties.putAll(hm);
        properties.store(new FileOutputStream("data.properties"), null);
        
    }

    public static void read() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("data.properties"));
            hm = new HashMap(properties);
        } catch (IOException ex) {
            Logger.getLogger(Simple_db.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Our Hashmap consists of: " + hm.size() + " elements.");
    }

    public static void generateTestData() {
        hm.put("1", "First");
        hm.put("2", "Second");
        hm.put("3", "Third");
        hm.put("4", "Fourth");
        hm.put("5", "Sixth");
        hm.put("6", "Eigth");
        hm.put("7", "Ninth");
        hm.put("8", "Tenth");
        System.out.println("The size of the map is now: " + hm.size());
    }
}
