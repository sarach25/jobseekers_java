/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.membre;
import entities.publication;
import entities.publicationSig;
import interfaces.IDAOPUBSIG;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author user
 */
public class publicationsigDAO implements IDAOPUBSIG<publicationSig> {
    private Connection connection;
    private PreparedStatement pst;
    
    public publicationsigDAO() {

        connection = DataSource.getInstance().getConnection();

    }

    
        
        
    }