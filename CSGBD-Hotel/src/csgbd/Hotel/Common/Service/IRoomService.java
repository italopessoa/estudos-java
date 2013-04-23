package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IRoomService {
 
    public void Save(Room room) throws Exception;
    
    public void Delete(Room room) throws Exception;
    
    public ArrayList<Room> SelectAll() throws Exception;
     
    public void Update(Room room) throws Exception;
    
    public ArrayList<Room> SelectRoomsByType(RoomType roomType) throws Exception;
}
