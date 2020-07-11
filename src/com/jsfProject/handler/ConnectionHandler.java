package com.jsfProject.handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jsfProject.util.LoadConfig;


public class ConnectionHandler {

public ConnectionHandler(){
		
	}
	
	  public Connection getConnection() throws IOException{
		   
	        Connection connection = null;
	        try {
	        	
	        	LoadConfig properties = new LoadConfig();
	    		
		        // Load the JDBC driver
//		        String driverName = "org.gjt.mm.mysql.Driver"; // MySQL MM JDBC driver
	        	String driverName = properties.getPropValues("DBDriverName"); // MySQL MM JDBC driver
		        Class.forName(driverName);
		
		        // Create a connection to the database
		        // String serverName = "localhost";
//		        String mydatabase = "jpost";
		        String serverName = properties.getPropValues("DBServer");
		        String mydatabase = properties.getPropValues("DBName");
		        int connTimeout = Integer.parseInt(properties.getPropValues("connTimeout"));
		        String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC URL
		        
		        
		
//		         String username = "jpost";
//		         String password = "jpost123";
		         String username = properties.getPropValues("DBUser");
		         String password = properties.getPropValues("DBPassword");
		         String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
		         String autoReconnect = "&autoReconnect="+properties.getPropValues("autoReconnect");;
		         
		         DriverManager.setLoginTimeout((int) connTimeout); 
		          connection = DriverManager.getConnection(url+unicode+autoReconnect, username, password);


		        
//	                if(connection!=null) {
//	                	System.out.println("connection successful");
//	                }	   else {
//	                	System.out.println("connection faild");
//
//	             	
//                }     
		           
		        
		    } catch (ClassNotFoundException e) {
		        // Could not find the database driver
		        e.printStackTrace();
		    } catch (SQLException e) {
		        // Could not connect to the database
		    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    	Date date = new Date();
		    	System.out.println(dateFormat.format(date)+" :: Not Able to connect");
		        e.printStackTrace();
	        } 
	        
	        return connection;
	
	
}
	  
	    
	    public void closeConnection(Connection connection){
	        try {
	            if(connection != null){
	                connection.close();
	                connection = null;
	            }
	        }
	        catch (SQLException e) {
	            connection = null;
	        }
	  }}
