package csgbd.Hotel.Common.Service.Default;

import csgbd.Hotel.Common.DAO.Default.GuestDAO;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Service.IGuestService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Implementatio of IGuestService
 * @see csgbd.Hotel.Common.Service.IGuestService
 * 
 * @author Italo Pessoa
 */
public class GuestService implements IGuestService{

    private GuestDAO dao;
    
    /**
     * Default constructor
     * 
     * @author Italo Pessoa
     */
    public GuestService() {
        this.dao = new GuestDAO();
    }
    
    /**
     * 
     * @see csgbd.Hotel.Common.Service.IGuestService#Save(csgbd.Hotel.Common.Entity.Guest) 
     * @author Italo Pessoa
     */
    @Override
    public void Save(Guest guest) throws SQLException,Exception{
        this.dao.Save(guest);
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IGuestService#Delete(csgbd.Hotel.Common.Entity.Guest) 
     * @author Italo Pessoa
     */
    @Override
    public void Delete(Guest guest) throws SQLException,Exception{
        this.dao.Delete(guest);
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IGuestService#SelectAll()
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<Guest> SelectAll() throws SQLException,Exception{
        return this.dao.SelectAll();
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IGuestService#Update(csgbd.Hotel.Common.Entity.Guest) 
     * @author Italo Pessoa
     */
    @Override
    public void Update(Guest guest) throws SQLException,Exception{
        this.dao.Update(guest);
    }

    /**
     * 
     * @see csgbd.Hotel.Common.Service.IGuestService#SelectGuestByName(java.lang.String) 
     * @author Italo Pessoa
     */
    @Override
    public ArrayList<Guest> SelectGuestByName(String name) throws SQLException,Exception{
        return this.dao.SelectGuestByName(name);
    }
    
}
