package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IReserveService {

    public void Save(Reserve reserve) throws Exception;

    public void Delete(Reserve reserve) throws Exception;

    public ArrayList<Reserve> SelectAll() throws Exception;

    public void Update(Reserve reserve) throws Exception;

    public ArrayList<Reserve> SelectReserveByGuest(Guest guestValue) throws Exception;

    public ArrayList<Reserve> SelectReserveByRoom(Room roomValue) throws Exception;
}
