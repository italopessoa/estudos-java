package csgbd.Hotel.Common.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to manager the database connection
 * 
 * @author Italo Pessoa.
 */
public class ConnectionFactory {
    private static Connection connection;
    private static Statement statement;

    /**
     * Configure the driver for PostgresSQL.
     * 
     * @author Italo Pessoa
     */
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
    
    /**
     * Open the connection with the database.
     * 
     * @author Italo Pessoa
     */
    public static void OpenConnection(){
        if(connection == null){
            ConfigDriver();
            try {
                //jdbc:postgresql://localhost:5432/minhabase
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/csgbd","postgres","postgres");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Get the class statement.
     * 
     * @return java.sql.Statement.
     * @author Italo Pessoa
     */
    public static Statement GetStatement()
    {
        if(statement != null) {
            return statement;
        }
        else{
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return statement;
    }
    
    /**
     * Get the PrepearedStatement to the query.
     * @param query Query to get the PreparedStatement.
     * @return java.sql.PreparedStatement.
     * @author Italo Pessoa.
     */
    public static PreparedStatement PreparedStatement(String query){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ps;
    }
    
    /**
     * Close the connection.
     * @author Italo Pessoa
     */
    public static void CloseConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Get the actual connection.
     * @return java.sql.Connection.
     * @author Italo Pessoa.
     */
    public static Connection GetConnection(){
        return connection;
    }
}
