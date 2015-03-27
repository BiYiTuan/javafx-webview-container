/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubricode.javafxbridge;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chidieberennadi
 */
public class Bridge {
    private ActiveRecord conn;
    
    public Bridge() {
        
    }
    
    public void initializeSQL(String tableName) {
        try {
            conn = ActiveRecord.createConnection("org.sqlite.JDBC", "jdbc:sqlite:teachsticksdata.sqlite"); 
            System.out.println("Initialized SQLite Support");
        } catch(SQLException e) {
            System.err.println("Could not initialize SQL support");
        } catch (ClassNotFoundException ex) {
            System.err.println("Could not find installed JDBC connectors");
            Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * Application Endpoints
     */
    public void activateApplication() {
        System.out.println("Done Activating application");
    }
    public String getApplicationDetails() {
        System.out.println("Getting application details");
        return "Application Details";
    }
    public void registerApplication() {
        
    }
    public String createUser() {
        return null;
    }
    
    public String loginUser() {
        return null;
    }
    
    public boolean resetPassword() {
        return false;
    }
    
    public String getUserInformation() {
        return null;
    }
    
    public String getUserProgress() {
        return null;
    }
    
    public String getUserBadges() {
        return null;
    }
    
    public String getAnnouncements() {
        return null;
    }
    
    public String getAllTopics() {
        return null;
    }
    
    public String getTopicsFor() {
        return null;
    }
    
    public String getSectionsFor() {
        return null;
    }
    
    public String getResource() {
        return null;
    }
    
    public String getTest() {
        return null;
    }
    
    public String saveTestResult() {
        return null;
    }
    
    public String getSettings() {
        return null;
    }
}
