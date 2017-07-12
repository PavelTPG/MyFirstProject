package AirLines.controller;

import AirLines.DAL.dao.RoleDAO;

public class Manager {

    public static RoleDAO getDAO() {
        
        return new RoleDAO();
        
        
    }
    
}
