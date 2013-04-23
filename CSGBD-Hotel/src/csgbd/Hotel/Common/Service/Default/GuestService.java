package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.GuestDAO;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Service.IGuestService;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public class GuestService implements IGuestService{

    private GuestDAO dao;
    
    public GuestService() {
        this.dao = new GuestDAO();
    }
    
    @Override
    public void Save(Guest guest) throws Exception{
        this.dao.Save(guest);
    }

    @Override
    public void Delete(Guest guest) throws Exception{
        this.dao.Delete(guest);
    }

    @Override
    public ArrayList<Guest> SelectAll() throws Exception{
        return this.dao.SelectAll();
    }

    @Override
    public void Update(Guest guest) throws Exception{
        this.dao.Update(guest);
    }

    @Override
    public ArrayList<Guest> SelectGuestByName(String name) throws Exception{
        return this.dao.SelectGuestByName(name);
    }
    
}
