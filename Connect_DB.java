package com.jun.hollymolly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//HollyMollyPlugIn ver.0.0.2(latest release on 2020.09.29)
public class Connect_DB {
	
	public Connection connection;
    public String host, database, username, password;
    public int port;
    
	public Connect_DB() {
		
		this.host = "localhost";
        this.port = 3309;
        this.database = "hollymolly_db";
        this.username = "root";
        this.password = "root"; 
        
        try {    
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        try {
        	this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?useSSL=false", this.username, this.password);
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
	}
            
		public boolean JoinQueryCommand(String command) {
        
     // prepare the statement to be executed
        try {
        	PreparedStatement stmt = connection.prepareStatement(command);
        	// I use executeUpdate() to update the databases table.
        	stmt.executeUpdate();
        	//ResultSet rs = stmt.executeQuery();
        
        	} catch (SQLException e) {
        	e.printStackTrace();
        	}   
        return true;
		}
		
		
		
		public void Disconnect() {
			try { 
		        if (connection!=null && !connection.isClosed()){
		            
		            connection.close(); 
		        }
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
}

