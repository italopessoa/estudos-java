/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.RoomType;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IRoomTypeService {

    public void Save(RoomType roomType) throws Exception;

    public void Delete(RoomType object) throws Exception;

    public ArrayList<RoomType> SelectAll() throws Exception;

    public void Update(RoomType roomType) throws Exception;
}
