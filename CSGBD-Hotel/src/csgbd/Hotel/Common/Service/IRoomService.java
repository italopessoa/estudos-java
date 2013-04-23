package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IRoomService {
 
    public void Save(Room room) throws SQLException,Exception;
    
    public void Delete(Room room) throws SQLException,Exception;
    
    public ArrayList<Room> SelectAll() throws SQLException,Exception;
     
    public void Update(Room room) throws SQLException,Exception;
    
    public ArrayList<Room> SelectRoomsByTypeOrPrice(RoomType roomType,Double price,boolean greaterThan) throws SQLException,Exception;
}
