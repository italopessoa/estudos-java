package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Guest;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IGuestService {

    public void Save(Guest guest) throws SQLException,Exception;

    public void Delete(Guest guest) throws SQLException,Exception;

    public ArrayList<Guest> SelectAll() throws SQLException,Exception;

    public void Update(Guest guest) throws SQLException,Exception;

    public ArrayList<Guest> SelectGuestByName(String name) throws SQLException,Exception;
}
