package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Service Interface to the Reserve entity.
 * 
 * @author Italo Pessoa
 */
public interface IRoomService {
 
    /**
     * Create new Room
     * 
     * @param room New Room
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Save(Room room) throws SQLException,Exception;
    
    /**
     * Remove the Room
     * 
     * @param room Room to remove
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Delete(Room room) throws SQLException,Exception;
    
    /**
     * 
     * Select all the Rooms 
     * 
     * @return All the Roooms
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Room> SelectAll() throws SQLException,Exception;
     
    /**
     * Update the Room's information
     * 
     * @param room Room to update
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Update(Room room) throws SQLException,Exception;
    
    /**
     * Select one, more or none Rooms by Room/Price values.
     * 
     * @param roomType RoomType
     * @param price Room's price
     * @param greaterThan if true te comparison of the price will be > else <=
     * @return All the Rooms tha match with the parameters
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Room> SelectRoomsByTypeOrPrice(RoomType roomType,Double price,boolean greaterThan) throws SQLException,Exception;
}
