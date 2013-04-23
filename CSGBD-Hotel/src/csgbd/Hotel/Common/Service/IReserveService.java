package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Service Interface to the Guest entity.
 * 
 * @author Italo Pessoa
 */
public interface IReserveService {

    /**
     * Create a new Reserve
     * 
     * @param reserve New Reserve
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Save(Reserve reserve) throws SQLException,Exception;

    /**
     * Remove a Reserve
     * 
     * @param reserve Reserve to remove
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Delete(Reserve reserve) throws SQLException,Exception;

    /**
     * Select all the Reserves
     * 
     * @return All the reserves
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Reserve> SelectAll() throws SQLException,Exception;

    /**
     * Update the Reserve information
     * 
     * @param reserve reserve to update
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Update(Reserve reserve) throws SQLException,Exception;

    /**
     * Select one, more or none Reservers by Room/Guest values.
     * 
     * @param roomValue Room of the Reserve
     * @param guestValue Guest of the Reserve
     * @return All the reserves tha match with the parameters
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Reserve> SelectReservesByRoomAndGuest(Room roomValue,Guest guestValue) throws SQLException,Exception;
}
