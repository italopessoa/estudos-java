package csgbd.Hotel.Common.Service;

import csgbd.Hotel.Common.Entity.Guest;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IGuestService {

    public void Save(Guest guest) throws Exception;

    public void Delete(Guest guest) throws Exception;

    public ArrayList<Guest> SelectAll() throws Exception;

    public void Update(Guest guest) throws Exception;

    public ArrayList<Guest> SelectGuestByName(String name) throws Exception;
}
