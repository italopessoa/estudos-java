package csgbd.Hotel.Common.Facade.Default;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import csgbd.Hotel.Common.Facade.IHotelFacade;
import csgbd.Hotel.Common.Service.*;
import csgbd.Hotel.Common.Service.Default.*;
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
    public void NewRoom(Room room) throws Exception {
        this.roomService.Save(room);
    }

    @Override
    public void RemoveRoom(Room room) throws Exception {
        this.roomService.Delete(room);
    }

    @Override
    public ArrayList<Room> SelectAllRooms() throws Exception {
        return this.roomService.SelectAll();
    }

    @Override
    public void UpdateRoom(Room room) throws Exception {
        this.roomService.Update(room);
    }

    @Override
    public ArrayList<Room> SelectRoomsByType(RoomType roomType) throws Exception {
        return this.roomService.SelectRoomsByType(roomType);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RoomType">
    
    @Override
    public void NewRoomType(RoomType roomType) throws Exception {
        this.roomTypeService.Save(roomType);
    }

    @Override
    public void RemoveRoomType(RoomType roomType) throws Exception {
        this.roomTypeService.Delete(roomType);
    }
    
    @Override
    public ArrayList<RoomType> SelectAllRoomTypes() throws Exception {
        return this.roomTypeService.SelectAll();
    }

    @Override
    public void UpdateRoomType(RoomType roomType) throws Exception {
        this.roomTypeService.Update(roomType);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Reserve">
    
    @Override
    public void MakeSave(Reserve reserve) throws Exception {
        this.reserveService.Save(reserve);
    }

    @Override
    public void RemoveReserve(Reserve reserve) throws Exception {
        this.reserveService.Delete(reserve);
    }

    @Override
    public ArrayList<Reserve> SelectAllReserves() throws Exception {
        return this.reserveService.SelectAll();
    }

    @Override
    public void UpdateReserve(Reserve reserve) throws Exception {
        this.reserveService.Update(reserve);
    }

    @Override
    public ArrayList<Reserve> SelectReservesByGuest(Guest guestValue) throws Exception {
        return this.reserveService.SelectReserveByGuest(guestValue);
    }

    @Override
    public ArrayList<Reserve> SelectReservesByRoom(Room roomValue) throws Exception {
        return this.reserveService.SelectReserveByRoom(roomValue);
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Guest">
    
    @Override
    public void NewGuest(Guest guest) throws Exception {
        this.guestService.Save(guest);
    }

    @Override
    public void RemoveGuest(Guest guest) throws Exception {
        this.guestService.Delete(guest);
    }

    @Override
    public ArrayList<Guest> SelectAllGuests() throws Exception {
        return this.guestService.SelectAll();
    }

    @Override
    public void UpdateGuest(Guest guest) throws Exception {
        this.guestService.Update(guest);
    }

    @Override
    public ArrayList<Guest> SelectGuestByName(String name) throws Exception {
        return this.guestService.SelectGuestByName(name);
    }
    
    //</editor-fold>
    
}
