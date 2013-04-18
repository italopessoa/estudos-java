/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csgbd.Hotel.Common.DAO.Implements;

import csgbd.Hotel.Common.DAO.IDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italopessoa
 */
public class ReserveDAO implements IDAO<Reserve> {

    @Override
    public void Save(Reserve reserve) {
        try {
            String query = "insert into reserve (guestid,roomid,dtEntry,dtOut,dtCadastre)"
                    + " values (?,?,?,?,?);";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setInt(1, reserve.getGuest().getId());
            ps.setInt(2, reserve.getRoom().getId());
            ps.setDate(3, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    reserve.getEntryDate().getDate(), reserve.getEntryDate().getMonth(),
                    reserve.getEntryDate().getYear() + 1900)));

            ps.setDate(4, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    reserve.getOutDate().getDate(), reserve.getOutDate().getMonth(), reserve.getOutDate().getYear() + 1900)));

            Date actualDate = new Date();
            ps.setDate(5, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    actualDate.getDate(), actualDate.getMonth(), actualDate.getYear() + 1900)));

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete(Reserve reserve) {
        try {
            String query = "delete from reserve where idreserv = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setInt(1, reserve.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Reserve> SelectAll() {
        ArrayList<Reserve> reserves = new ArrayList<Reserve>();
        String sql_str = "SELECT * FROM reserve re "
                + "inner join room ro on ro.idroom = re.roomid "
                + "inner join guest g on g.idguest = re.guestid "
                + "inner join roomtype rt on rt.idroomtype = ro.roomtype";
        Reserve reserve;
        Room room;
        Guest guest;
        try {
            ResultSet rs = ConnectionManager.GetStatement().executeQuery(sql_str);
            while (rs.next()) {

                reserve = new Reserve(rs.getInt(1));
                reserve.setEntryDate(rs.getDate(4));
                reserve.setOutDate(rs.getDate(5));
                reserve.setDtCadastre(rs.getDate(6));
                reserve.setDtUpdate(rs.getDate(7));

                room = new Room(rs.getInt(8));
                room.setPrice(rs.getDouble(9));
                room.setDtCadastre(rs.getDate(11));
                room.setDtUpdate(rs.getDate(12));

                guest = new Guest(rs.getInt(13));
                guest.setName(rs.getString(14));
                guest.setAge(rs.getInt(15));
                guest.setEmail(rs.getString(16));
                guest.setPhone(rs.getString(17));
                guest.setDtCadastre(rs.getDate(18));
                guest.setDtUpdate(rs.getDate(19));

                RoomType roomType = new RoomType(rs.getInt(20));
                roomType.setName(rs.getString(21));
                roomType.setDtCadastre(rs.getDate(22));
                roomType.setDtUpdate(rs.getDate(23));

                room.setType(roomType);
                reserve.setRoom(room);
                reserve.setGuest(guest);

                reserves.add(reserve);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reserves;
    }

    @Override
    public void Update(Reserve reserve) {
        try {
            
            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            int auxCount = 2;
            StringBuilder sb = new StringBuilder("update reserve set dtupdate=? ");
            
            if(reserve.getGuest() != null && reserve.getGuest().getId() >0){
                indexMap.put("guestid", auxCount);
                sb.append(" ,guestid=? ");
                auxCount++;
            }
            
            if(reserve.getRoom()!= null && reserve.getRoom().getId() >0){
                indexMap.put("roomid", auxCount);
                sb.append(" ,roomid=? ");
                auxCount++;
            }
            
            if(reserve.getEntryDate()!= null){
                indexMap.put("dtEntry", auxCount);
                sb.append(" ,dtEntry=? ");
                auxCount++;
            }
            
            if(reserve.getOutDate()!= null){
                indexMap.put("dtOut", auxCount);
                sb.append(" ,dtOut=? ");
                auxCount++;
            }
            
            indexMap.put("idreserve", auxCount);
            sb.append(" where idreserve = ? " );
            
            String query = "update reserve set guestid=?,roomid=?,dtEntry=?,dtOut=?,dtupdate=? "
                    + "where idreserve = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            
            
            if(indexMap.containsKey("guestid")){
                ps.setInt(indexMap.get("guestid"), reserve.getGuest().getId());
            }
            
            if(indexMap.containsKey("roomid")){
                ps.setInt(indexMap.get("roomid"), reserve.getRoom().getId());
            }
            
            if(indexMap.containsKey("dtEntry")){
                ps.setDate(indexMap.get("dtEntry"), (java.sql.Date)reserve.getEntryDate());
            }
            
            if(indexMap.containsKey("dtOut")){
                ps.setDate(indexMap.get("dtOut"), (java.sql.Date)reserve.getEntryDate());
            }
            
            ps.setDate(1, (java.sql.Date) new Date());

            ps.setInt(indexMap.get("idreserve"), reserve.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
