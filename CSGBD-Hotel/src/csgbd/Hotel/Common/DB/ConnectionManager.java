package csgbd.Hotel.Common.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italopessoa
 */
public class ConnectionManager {
    private static Connection connection;
    private static Statement statement;

    private static void ConfigDriver(){
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch ( java.lang.ClassNotFoundException e )
        {
            System.err.print("ClassNotFoundException: ");
            System.err.println( e.getMessage () );
        }

        System.out.println("Driver do PostgreSQL selecionado.");
    }
    
    public static void OpenConnection(){
        if(connection == null){
            ConfigDriver();
            try {
                //jdbc:postgresql://localhost:5432/minhabase
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/csgbd","postgres","postgres");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Statement GetStatement()
    {
        if(statement != null) {
            return statement;
        }
        else{
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return statement;
    }
    
    public static PreparedStatement PreparedStatement(String query){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ps;
    }
}
