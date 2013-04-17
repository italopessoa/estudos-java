/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csgbd.Hotel.Common.DAO.Implements;

import csgbd.Hotel.Common.DAO.IDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italopessoa
 */
public class GuestDAO implements IDAO<Guest>{

    @Override
    public void Save(Guest guest) {
        try {
            String query = "insert into guest(guestname,guestage,guestemail,guestphone,dtcadastre)"
                    + " values (?,?,?,?,?);";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setString(3, guest.getEmail());
            ps.setString(4, guest.getPhone());
            
            Date actualDate = new Date();
            ps.setDate(5, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d", 
                    actualDate.getDate(),actualDate.getMonth(),actualDate.getYear()+1900)));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete(Guest guest) {
        try {
            String query = "delete from guest where idguest = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setInt(1, guest.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ArrayList<Guest> SelectAll() {
        ArrayList guests = new ArrayList();
        String sql_str = "SELECT * FROM guest";
        Guest guest;
        try {
            ResultSet rs = ConnectionManager.GetStatement().executeQuery(sql_str);
            while(rs.next()){
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
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return guests;
    }

    @Override
    public void Update(Guest guest) {
        try {
            String query = "update guest set guestname=?,guestage=?,guestemail=?,guestphone=?,dtupdate=? "
                    + "where idguest = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setString(1, guest.getName());
            ps.setInt(2, guest.getAge());
            ps.setString(3, guest.getEmail());
            ps.setString(4, guest.getPhone());
            
            Date actualDate = new Date();
            ps.setDate(5, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d", 
                    actualDate.getDate(),actualDate.getMonth(),actualDate.getYear()+1900)));
            
            ps.setInt(6, guest.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
