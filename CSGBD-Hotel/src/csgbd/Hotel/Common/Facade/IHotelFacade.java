package csgbd.Hotel.Common.Facade;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IHotelFacade {
    
    //<editor-fold defaultstate="collapsed" desc="Room">
    
    public void NewRoom(Room room) throws SQLException,Exception;
    
    public void RemoveRoom(Room room) throws SQLException,Exception;
    
    public ArrayList<Room> SelectAllRooms() throws SQLException,Exception;
     
    public void UpdateRoom(Room room) throws SQLException,Exception;
    
    public ArrayList<Room> SelectRoomsByTypeOrPrice(RoomType roomType,Double price,boolean greaterThan) throws SQLException,Exception;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RoomType">
    
    public void NewRoomType(RoomType roomType) throws SQLException,Exception;

    public void RemoveRoomType(RoomType object) throws SQLException,Exception;

    public ArrayList<RoomType> SelectAllRoomTypes() throws SQLException,Exception;

    public void UpdateRoomType(RoomType roomType) throws SQLException,Exception;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Reserve">
    
    public void MakeSave(Reserve reserve) throws SQLException,Exception;

    public void RemoveReserve(Reserve reserve) throws SQLException,Exception;

    public ArrayList<Reserve> SelectAllReserves() throws SQLException,Exception;

    public void UpdateReserve(Reserve reserve) throws SQLException,Exception;

    public ArrayList<Reserve> SelectReservesByRoomAndGuest(Room roomValue,Guest guesValue) throws SQLException,Exception;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Guest">
    
    public void NewGuest(Guest guest) throws SQLException,Exception;

    public void RemoveGuest(Guest guest) throws SQLException,Exception;

    public ArrayList<Guest> SelectAllGuests() throws SQLException,Exception;

    public void UpdateGuest(Guest guest) throws SQLException,Exception;

    public ArrayList<Guest> SelectGuestByName(String name) throws SQLException,Exception;
    
    //</editor-fold>
}
