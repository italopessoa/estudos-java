package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.RoomDAO;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import csgbd.Hotel.Common.Service.IRoomService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementatio of IRoomService
 * @see csgbd.Hotel.Common.Service.IRoomService
 * 
 * @author Italo Pessoa
 */
public class RoomService implements IRoomService {

    private RoomDAO dao;

    /**
     * Default constructor
     * @author Italo Pessoa
     */
    public RoomService() {
        this.dao = new RoomDAO();
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomService#Save(csgbd.Hotel.Common.Entity.Room) 
     * @author Italo Pessoa
     */
    @Override
    public void Save(Room room) throws SQLException,Exception {
        this.dao.Save(room);
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomService#Delete(csgbd.Hotel.Common.Entity.Room) 
     * @author Italo Pessoa
     */
    @Override
    public void Delete(Room room) throws SQLException,Exception {
        this.dao.Delete(room);
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomService#SelectAll() 
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<Room> SelectAll() throws SQLException,Exception {
        return this.dao.SelectAll();
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomService#Update(csgbd.Hotel.Common.Entity.Room) 
     * @author Italo Pessoa
     */
    @Override
    public void Update(Room room) throws SQLException,Exception {
        this.dao.Update(room);
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomService#SelectRoomsByTypeOrPrice(csgbd.Hotel.Common.Entity.RoomType, java.lang.Double, boolean) 
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<Room> SelectRoomsByTypeOrPrice(RoomType roomType, Double price, boolean greaterThan) throws SQLException,Exception {
        return this.dao.SelectRoomsByTypeOrPrice(roomType, price, greaterThan);
    }
}
