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
 * Implementatio of IReserveService
 * @see csgbd.Hotel.Common.Service.IReserveService
 * 
 * @author italopessoa
 */
public class ReserveService implements IReserveService {

    private ReserveDAO dao;

    /**
     * Default constructor
     * @author Italo Pessoa
     */
    public ReserveService() {
        this.dao = new ReserveDAO();
    }
    
    /**
     * 
     * @see csgbd.Hotel.Common.Service.IReserveService#Save(csgbd.Hotel.Common.Entity.Reserve) 
     * @author Italo Pessoa
     */
    @Override
    public void Save(Reserve reserve) throws SQLException,Exception{
        this.dao.Save(reserve);
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IReserveService#Delete(csgbd.Hotel.Common.Entity.Reserve) 
     * @author Italo Pessoa
     */
    @Override
    public void Delete(Reserve reserve) throws SQLException,Exception{
        this.dao.Delete(reserve);
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IReserveService#SelectAll() 
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<Reserve> SelectAll() throws SQLException,Exception{
        return this.dao.SelectAll();
    }
    
    /**
     * 
     * @see csgbd.Hotel.Common.Service.IReserveService#Update(csgbd.Hotel.Common.Entity.Reserve) 
     * @author Italo Pessoa
     */
    @Override
    public void Update(Reserve reserve) throws SQLException,Exception{
        this.dao.Update(reserve);
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IReserveService#SelectReservesByRoomAndGuest(csgbd.Hotel.Common.Entity.Room, csgbd.Hotel.Common.Entity.Guest) 
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<Reserve> SelectReservesByRoomAndGuest(Room roomValue,Guest guestValue) throws SQLException,Exception{
        return this.dao.SelectReservesByRoomAndGuest(roomValue, guestValue);
    }
}
