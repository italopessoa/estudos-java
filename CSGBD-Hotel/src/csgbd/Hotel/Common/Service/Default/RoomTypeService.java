package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.RoomTypeDAO;
import csgbd.Hotel.Common.Entity.RoomType;
import csgbd.Hotel.Common.Service.IRoomTypeService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementatio of IRoomTypeService
 * @see csgbd.Hotel.Common.Service.IRoomTypeService
 * 
 * @author Italo Pessoa
 */
public class RoomTypeService implements IRoomTypeService{

    private RoomTypeDAO dao;
    
    /**
     * Default constructor
     */
    public RoomTypeService() {
        this.dao = new RoomTypeDAO();
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomTypeService#Save(csgbd.Hotel.Common.Entity.RoomType) 
     * @author Italo Pessoa
     */
    @Override
    public void Save(RoomType roomType) throws SQLException,Exception{
        this.dao.Save(roomType);
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomTypeService#Delete(csgbd.Hotel.Common.Entity.RoomType) 
     * @author Italo Pessoa
     */
    @Override
    public void Delete(RoomType roomType) throws SQLException,Exception{
        this.dao.Delete(roomType);
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomTypeService#SelectAll() 
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<RoomType> SelectAll() throws SQLException,Exception{
        return this.dao.SelectAll();
    }

    /**
     * @see csgbd.Hotel.Common.Service.IRoomTypeService#Update(csgbd.Hotel.Common.Entity.RoomType) 
     * @author Italo Pessoa
     */
    @Override
    public void Update(RoomType roomType) throws SQLException,Exception{
        this.dao.Update(roomType);
    }
}
