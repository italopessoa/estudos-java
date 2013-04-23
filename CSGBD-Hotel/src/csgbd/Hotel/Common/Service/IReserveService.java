package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IReserveService {

    public void Save(Reserve reserve) throws SQLException,Exception;

    public void Delete(Reserve reserve) throws SQLException,Exception;

    public ArrayList<Reserve> SelectAll() throws SQLException,Exception;

    public void Update(Reserve reserve) throws SQLException,Exception;

    public ArrayList<Reserve> SelectReservesByRoomAndGuest(Room roomValue,Guest guestValue) throws SQLException,Exception;
}
