package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Guest;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Service Interface to the Guest entity.
 * 
 * @author Italo Pessoa
 */
public interface IGuestService {

    /**
     * Create a new Guest
     * 
     * @param guest Guest to save
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Save(Guest guest) throws SQLException,Exception;

    /**
     * Remove a guest from database
     * 
     * @param guest Guest to remove
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Delete(Guest guest) throws SQLException,Exception;

    /**
     * Select all the Guests
     * 
     * @return All the guests
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Guest> SelectAll() throws SQLException,Exception;

    /***
     * Update the Guest information
     * 
     * @param guest Guest information to update
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Update(Guest guest) throws SQLException,Exception;

    /**
     * Select one, more or none Guests by name
     * 
     * @param name The guest's name
     * @return ArrayList<Guest>
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Guest> SelectGuestByName(String name) throws SQLException,Exception;
}
