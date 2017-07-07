/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import interfaces.ContactDAO;
import java.util.List;
import models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ben
 */
@Controller
public class HomeController {
    
    @Autowired
    private ContactDAO contactDAO;
    
    @RequestMapping(value="/homes")
    public ModelAndView viewHome(ModelAndView model){
        List<Contact> listContact = contactDAO.listAllContacts();
        for (Contact listContact1 : listContact) {
            System.out.println(listContact1.getName());
            
        }
        model.addObject("listContact", listContact);
        model.setViewName("home");
        return model;

    }
    
}
