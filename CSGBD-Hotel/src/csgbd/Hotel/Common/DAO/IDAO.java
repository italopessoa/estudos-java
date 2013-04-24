package csgbd.Hotel.Common.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IDAO<T> {

    /**
     * Create new object and persiste at the database.
     * 
     * @param object Object to save.
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    void Save(T object) throws SQLException, Exception;
    
    /**
     * Remove a object from database.
     * 
     * @param object Object to remove.
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    void Delete(T object) throws SQLException, Exception;
    
    /**
     * Recovere all the a object defined in T. 
     * 
     * @return ArrayList<T>.
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    ArrayList<T> SelectAll() throws SQLException, Exception;

    /**
     * Update the object.
     * 
     * @param object Object to update.
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    void Update(T object) throws SQLException, Exception;
}
