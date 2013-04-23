package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.RoomTypeDAO;
import csgbd.Hotel.Common.Entity.RoomType;
import csgbd.Hotel.Common.Service.IRoomTypeService;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public class RoomTypeService implements IRoomTypeService{

    private RoomTypeDAO dao;
    
    public RoomTypeService() {
        this.dao = new RoomTypeDAO();
    }

    @Override
    public void Save(RoomType roomType) throws Exception{
        this.dao.Save(roomType);
    }

    @Override
    public void Delete(RoomType roomType) throws Exception{
        this.dao.Delete(roomType);
    }

    @Override
    public ArrayList<RoomType> SelectAll() throws Exception{
        return this.dao.SelectAll();
    }

    @Override
    public void Update(RoomType roomType) throws Exception{
        this.dao.Update(roomType);
    }
}
