package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.ReserveDAO;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Service.IReserveService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public class ReserveService implements IReserveService {

    private ReserveDAO dao;

    public ReserveService() {
        this.dao = new ReserveDAO();
    }
    
    @Override
    public void Save(Reserve reserve) throws SQLException,Exception{
        this.dao.Save(reserve);
    }

    @Override
    public void Delete(Reserve reserve) throws SQLException,Exception{
        this.dao.Delete(reserve);
    }

    @Override
    public ArrayList<Reserve> SelectAll() throws SQLException,Exception{
        return this.dao.SelectAll();
    }

    @Override
    public void Update(Reserve reserve) throws SQLException,Exception{
        this.dao.Update(reserve);
    }

    @Override
    public ArrayList<Reserve> SelectReservesByRoomAndGuest(Room roomValue,Guest guestValue) throws SQLException,Exception{
        return this.dao.SelectReservesByRoomAndGuest(roomValue, guestValue);
    }
}
