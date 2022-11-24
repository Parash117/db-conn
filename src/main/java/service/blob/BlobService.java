package service.blob;

import config.DBConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobService {

    private Connection connection = DBConnection.connect();

    public void insertBlob(){
        String query = "INSERT INTO images(data) VALUES(?)";

        try{
            PreparedStatement sqlQuery = connection.prepareStatement("INSERT INTO file" +
                    "(file_name, blob) VALUES ( ? , ? ) ");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


}
