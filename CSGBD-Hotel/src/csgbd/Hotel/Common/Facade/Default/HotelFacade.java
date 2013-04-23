package csgbd.Hotel.Common.Facade.Default;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import csgbd.Hotel.Common.Facade.IHotelFacade;
import csgbd.Hotel.Common.Service.*;
import csgbd.Hotel.Common.Service.Default.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public class HotelFacade implements IHotelFacade{

    private IGuestService guestService;
    private IReserveService reserveService;
    private IRoomService roomService;
    private IRoomTypeService roomTypeService;

    public HotelFacade() {
        this.guestService = new GuestService();
        this.reserveService = new ReserveService();
        this.roomService = new RoomService();
        this.roomTypeService = new RoomTypeService();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Room">
    
    @Override
    public void NewRoom(Room room) throws SQLException,Exception {
        this.roomService.Save(room);
    }

    @Override
    public void RemoveRoom(Room room) throws SQLException,Exception {
        this.roomService.Delete(room);
    }

    @Override
    public ArrayList<Room> SelectAllRooms() throws SQLException,Exception {
        return this.roomService.SelectAll();
    }

    @Override
    public void UpdateRoom(Room room) throws SQLException,Exception {
        this.roomService.Update(room);
    }

    @Override
    public ArrayList<Room> SelectRoomsByTypeOrPrice(RoomType roomType, Double price, boolean greaterThan) throws SQLException,Exception {
        return this.roomService.SelectRoomsByTypeOrPrice(roomType, price, greaterThan);
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RoomType">
    
    @Override
    public void NewRoomType(RoomType roomType) throws SQLException,Exception {
        this.roomTypeService.Save(roomType);
    }

    @Override
    public void RemoveRoomType(RoomType roomType) throws SQLException,Exception {
        this.roomTypeService.Delete(roomType);
    }
    
    @Override
    public ArrayList<RoomType> SelectAllRoomTypes() throws SQLException,Exception {
        return this.roomTypeService.SelectAll();
    }

    @Override
    public void UpdateRoomType(RoomType roomType) throws SQLException,Exception {
        this.roomTypeService.Update(roomType);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Reserve">
    
    @Override
    public void MakeSave(Reserve reserve) throws SQLException,Exception {
        this.reserveService.Save(reserve);
    }

    @Override
    public void RemoveReserve(Reserve reserve) throws SQLException,Exception {
        this.reserveService.Delete(reserve);
    }

    @Override
    public ArrayList<Reserve> SelectAllReserves() throws SQLException,Exception {
        return this.reserveService.SelectAll();
    }

    @Override
    public void UpdateReserve(Reserve reserve) throws SQLException,Exception {
        this.reserveService.Update(reserve);
    }

    @Override
    public ArrayList<Reserve> SelectReservesByRoomAndGuest(Room roomValue,Guest guesValue) throws SQLException,Exception{
        return this.reserveService.SelectReservesByRoomAndGuest(roomValue, guesValue);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Guest">
    
    @Override
    public void NewGuest(Guest guest) throws SQLException,Exception {
        this.guestService.Save(guest);
    }

    @Override
    public void RemoveGuest(Guest guest) throws SQLException,Exception {
        this.guestService.Delete(guest);
    }

    @Override
    public ArrayList<Guest> SelectAllGuests() throws SQLException,Exception {
        return this.guestService.SelectAll();
    }

    @Override
    public void UpdateGuest(Guest guest) throws SQLException,Exception {
        this.guestService.Update(guest);
    }

    @Override
    public ArrayList<Guest> SelectGuestByName(String name) throws SQLException,Exception {
        return this.guestService.SelectGuestByName(name);
    }
    
    //</editor-fold>   
}
