package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Service Interface to the RoomType entity.
 * 
 * @author Italo Pessoa
 */
public interface IRoomTypeService {

    /**
     * Create new RoomType
     * 
     * @param roomType New RoomType
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Save(RoomType roomType) throws SQLException,Exception;

    /**
     * Remove RoomType
     * 
     * @param object RoomType to remove
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Delete(RoomType object) throws SQLException,Exception;

    /**
     * Select all RoomTypes
     * 
     * @return All RoomTypes
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<RoomType> SelectAll() throws SQLException,Exception;

    /**
     * Update a RoomType's information
     * @param roomType RoomType to update
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public void Update(RoomType roomType) throws SQLException,Exception;
}
