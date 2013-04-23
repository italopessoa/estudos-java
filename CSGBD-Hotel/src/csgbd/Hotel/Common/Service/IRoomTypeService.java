/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IRoomTypeService {

    public void Save(RoomType roomType) throws SQLException,Exception;

    public void Delete(RoomType object) throws SQLException,Exception;

    public ArrayList<RoomType> SelectAll() throws SQLException,Exception;

    public void Update(RoomType roomType) throws SQLException,Exception;
}
