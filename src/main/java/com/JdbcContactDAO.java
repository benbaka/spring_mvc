/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.PreparedStatement;
import interfaces.ContactDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.sql.DataSource;
import models.Contact;

/**
 *
 * @author ben
 */
public class JdbcContactDAO implements ContactDAO{
    
    private DataSource dataSource;
    
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Contact findByContactById(int contactId) {
        
        String sql = "select * from contact where id = ?";
        
        
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, contactId);
            Contact contact = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();
            return contact;
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
