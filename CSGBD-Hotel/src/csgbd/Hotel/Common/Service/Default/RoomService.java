package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.RoomDAO;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import csgbd.Hotel.Common.Service.IRoomService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public class RoomService implements IRoomService {

    private RoomDAO dao;

    public RoomService() {
        this.dao = new RoomDAO();
    }

    @Override
    public void Save(Room room) throws SQLException,Exception {
        this.dao.Save(room);
    }

    @Override
    public void Delete(Room room) throws SQLException,Exception {
        this.dao.Delete(room);
    }

    @Override
    public ArrayList<Room> SelectAll() throws SQLException,Exception {
        return this.dao.SelectAll();
    }

    @Override
    public void Update(Room room) throws SQLException,Exception {
        this.dao.Update(room);
    }

    @Override
    public ArrayList<Room> SelectRoomsByTypeOrPrice(RoomType roomType, Double price, boolean greaterThan) throws SQLException,Exception {
        return this.dao.SelectRoomsByTypeOrPrice(roomType, price, greaterThan);
    }
}
