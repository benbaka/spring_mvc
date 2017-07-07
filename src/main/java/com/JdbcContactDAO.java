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
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import models.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ben
 */
public class JdbcContactDAO implements ContactDAO{
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
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

    @Override
    public List<Contact> listAllContacts() {
        
        String sql = "Select * from contact";
        
        List<Contact> listOfContacts = this.jdbcTemplate.query(sql, new RowMapper<Contact>(){

            @Override
            public Contact mapRow(ResultSet rs, int i) throws SQLException {
                Contact innerContact = new Contact();
                innerContact.setId(rs.getInt("id"));
                innerContact.setName(rs.getString("name"));
                return innerContact;
            }
            
            
        });
        
        return listOfContacts;
        
    }
    
}
