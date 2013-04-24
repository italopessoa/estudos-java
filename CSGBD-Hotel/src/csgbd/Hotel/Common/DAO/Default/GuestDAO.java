package csgbd.Hotel.Common.DAO.Default;

import csgbd.Hotel.Common.DAO.IDAO;
import csgbd.Hotel.Common.DB.ConnectionFactory;
import csgbd.Hotel.Common.Entity.Guest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Implementarion of DAO
 * 
 * @author Italo Pessoa
 * @see csgbd.Hotel.Common.DAO#IDAO
 */
public class GuestDAO implements IDAO<Guest> {

    //<editor-fold defaultstate="collapsed" desc="IDAO Members">  

    /**
     * 
     * @see csgbd.Hotel.Common.DAO.IDAO#Save
     */
    @Override
    public void Save(Guest guest) throws SQLException, Exception{
        try {
            String query = "insert into guest(guestname,guestage,guestemail,guestphone,dtcadastre)"
                    + " values (?,?,?,?,?);";
            PreparedStatement ps = ConnectionFactory.PreparedStatement(query);
            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setString(3, guest.getEmail());
            ps.setString(4, guest.getPhone());

            Date actualDate = new Date();
            ps.setDate(5, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    actualDate.getDate(), actualDate.getMonth(), actualDate.getYear() + 1900)));
            ps.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.GetConnection().rollback();
            throw  ex;
        }
    }

    /**
     * 
     * @see csgbd.Hotel.Common.DAO.IDAO#Delete
     */
    @Override
    public void Delete(Guest guest) throws SQLException, Exception {
        try {
            String query = "delete from guest where idguest = ?;";
            PreparedStatement ps = ConnectionFactory.PreparedStatement(query);
            ps.setInt(1, guest.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.GetConnection().rollback();
            throw  ex;
        }

    }

    /**
     * 
     * @see csgbd.Hotel.Common.DAO.IDAO#SelectAll
     */
    @Override
    public ArrayList<Guest> SelectAll() throws SQLException, Exception{
        ArrayList<Guest> guests = new ArrayList<Guest>();
        String sql_str = "SELECT * FROM guest";
        Guest guest;
        try {
            ResultSet rs = ConnectionFactory.GetStatement().executeQuery(sql_str);
            while (rs.next()) {
                guest = new Guest();
                guest.setId(rs.getInt("IdGuest"));
                guest.setName(rs.getString("GuestName"));
                guest.setAge(rs.getInt("GuestAge"));
                guest.setEmail(rs.getString("GuestEmail"));
                guest.setPhone(rs.getString("GuestPhone"));
                guest.setDtCadastre(rs.getDate("DtCadastre"));
                guest.setDtUpdate(rs.getDate("DtUpdate"));
                guests.add(guest);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return guests;
    }

    /**
     * 
     * @see csgbd.Hotel.Common.DAO.IDAO#Update
     */
    @Override
    public void Update(Guest guest) throws SQLException, Exception{
        try {

            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            int auxCount = 2;
            StringBuilder sb = new StringBuilder("update guest set dtupdate=? ");

            if (guest.getName() != null && !guest.getName().equals("")) {
                sb.append(",guestname=? ");
                indexMap.put("guestname", auxCount);
                auxCount++;
            }

            if (guest.getAge() > 0) {
                sb.append(",guestage=? ");
                indexMap.put("guestage", auxCount);
                auxCount++;
            }

            if (guest.getPhone() != null && !guest.getPhone().equals("")) {
                sb.append(",guestphone=? ");
                indexMap.put("guestphone", auxCount);
                auxCount++;
            }

            if (guest.getEmail() != null && !guest.getEmail().equals("")) {
                sb.append(",guestemail=? ");
                indexMap.put("guestemail", auxCount);
                auxCount++;
            }

            sb.append("where idguest = ? ;");
            indexMap.put("idguest", auxCount);

            PreparedStatement ps = ConnectionFactory.PreparedStatement(sb.toString());
            if (indexMap.containsKey("guestname")) {
                ps.setString(indexMap.get("guestname"), guest.getName());
            }

            if (indexMap.containsKey("guestage")) {
                ps.setInt(indexMap.get("guestage"), guest.getAge());
            }

            if (indexMap.containsKey("guestemail")) {
                ps.setString(indexMap.get("guestemail"), guest.getEmail());
            }

            if (indexMap.containsKey("guestphone")) {
                ps.setString(indexMap.get("guestphone"), guest.getPhone());
            }

            Date actualDate = new Date();
            ps.setDate(1, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    actualDate.getDate(), actualDate.getMonth(), actualDate.getYear() + 1900)));

            ps.setInt(indexMap.get("idguest"), guest.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.GetConnection().rollback();
            throw  ex;
        }
    }

    // </editor-fold>

    /**
     * Recover the guests that have the substrig informed in your name.
     * 
     * @param name Guest name
     * @return ArrayList<Guest>
     * @throws SQLException
     * @throws Exception 
     * @author Italo Pessoa
     */
    public ArrayList<Guest> SelectGuestByName(String name) throws SQLException, Exception {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        String sql_str = "SELECT * FROM guest where GuestName like '%"+name+"%'";
        Guest guest;
        try {
            ResultSet rs = ConnectionFactory.GetStatement().executeQuery(sql_str);
            while (rs.next()) {
                guest = new Guest();
                guest.setId(rs.getInt("IdGuest"));
                guest.setName(rs.getString("GuestName"));
                guest.setAge(rs.getInt("GuestAge"));
                guest.setEmail(rs.getString("GuestEmail"));
                guest.setPhone(rs.getString("GuestPhone"));
                guest.setDtCadastre(rs.getDate("DtCadastre"));
                guest.setDtUpdate(rs.getDate("DtUpdate"));
                guests.add(guest);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return guests;
    }
}
