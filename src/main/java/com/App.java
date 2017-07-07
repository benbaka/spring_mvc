/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import interfaces.ContactDAO;
import models.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ben
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ApplicationContext context =
    		new ClassPathXmlApplicationContext("bean.xml");
        
        ContactDAO contactDAO = (ContactDAO) context.getBean("contactDAO");
        
        Contact contact = contactDAO.findByContactById(1);
        System.out.println(contact.getId());
        System.out.println(contact.getName());
        

    }
    
}
