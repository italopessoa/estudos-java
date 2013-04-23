package csgbd.Hotel.Common.Facade;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IHotelFacade {
    
    //<editor-fold defaultstate="collapsed" desc="Room">
    
    public void NewRoom(Room room) throws Exception;
    
    public void RemoveRoom(Room room) throws Exception;
    
    public ArrayList<Room> SelectAllRooms() throws Exception;
     
    public void UpdateRoom(Room room) throws Exception;
    
    public ArrayList<Room> SelectRoomsByType(RoomType roomType) throws Exception;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RoomType">
    
    public void NewRoomType(RoomType roomType) throws Exception;

    public void RemoveRoomType(RoomType object) throws Exception;

    public ArrayList<RoomType> SelectAllRoomTypes() throws Exception;

    public void UpdateRoomType(RoomType roomType) throws Exception;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Reserve">
    
    public void MakeSave(Reserve reserve) throws Exception;

    public void RemoveReserve(Reserve reserve) throws Exception;

    public ArrayList<Reserve> SelectAllReserves() throws Exception;

    public void UpdateReserve(Reserve reserve) throws Exception;

    public ArrayList<Reserve> SelectReservesByGuest(Guest guestValue) throws Exception;

    public ArrayList<Reserve> SelectReservesByRoom(Room roomValue) throws Exception;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Guest">
    
    public void NewGuest(Guest guest) throws Exception;

    public void RemoveGuest(Guest guest) throws Exception;

    public ArrayList<Guest> SelectAllGuests() throws Exception;

    public void UpdateGuest(Guest guest) throws Exception;

    public ArrayList<Guest> SelectGuestByName(String name) throws Exception;
    
    //</editor-fold>
}
