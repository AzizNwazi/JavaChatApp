package com.example.demo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class islemler {
    private Connection con= null;


    private Statement statement= null; // veri tabanını projeye dahil etmek

    private PreparedStatement preparedStatement = null;



    public void kullaniciEkle(String userName,String password){
        String sorgu = "Insert Into register (userName,password) VALUES (?,?) ";
        try {

            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);


            preparedStatement.executeUpdate();



        } catch (SQLException ex) {
            System.out.println();
        }


    }
    public boolean girisYap(String userName,String password){
        String sorgu = "Select * From register where userName = ? and password = ?";

        try {

            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


    }

}
