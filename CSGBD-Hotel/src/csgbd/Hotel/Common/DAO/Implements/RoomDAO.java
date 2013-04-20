package csgbd.Hotel.Common.DAO.Implements;

import csgbd.Hotel.Common.DAO.IDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
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
public class RoomDAO implements IDAO<Room> {

    //<editor-fold defaultstate="collapsed" desc="IDAO Members">  
    
    @Override
    public void Save(Room room) {
        try {
            String query = "insert into room (roomprice,roomtype,dtCadastre)"
                    + " values (?,?,?);";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setDouble(1, room.getPrice());
            ps.setDouble(2, room.getType().getId());

            Date actualDate = new Date();
            ps.setDate(3, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    actualDate.getDate(), actualDate.getMonth(), actualDate.getYear() + 1900)));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete(Room room) {
        try {
            String query = "delete from room where idroom = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setInt(1, room.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Room> SelectAll() {
        ArrayList<Room> rooms = new ArrayList<Room>();
        String sql_str = "SELECT * FROM room r "
                + "inner join roomtype rt on rt.idroomtype = r.roomtype";
        Room room;
        try {
            ResultSet rs = ConnectionManager.GetStatement().executeQuery(sql_str);
            while (rs.next()) {
                room = new Room();
                room.setId(rs.getInt(1));
                room.setPrice(rs.getDouble(2));
                room.setDtCadastre(rs.getDate(4));
                room.setDtUpdate(rs.getDate(5));

                RoomType roomType = new RoomType(rs.getInt(6));
                roomType.setName(rs.getString(7));
                roomType.setDtCadastre(rs.getDate(8));
                roomType.setDtUpdate(rs.getDate(9));

                room.setType(roomType);
                rooms.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }

    @Override
    public void Update(Room room) {
        try {

            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            int auxCount = 2;

            StringBuilder sb = new StringBuilder("update room set dtUpdate=? ");


            if (room.getPrice() > 0) {
                indexMap.put("roomprice", auxCount);
                sb.append(" ,roomprice=? ");
                auxCount++;
            }

            if (room.getType() != null && room.getType().getId() > 0) {
                indexMap.put("roomtype", auxCount);
                sb.append(" ,roomtype=? ");
                auxCount++;
            }

            sb.append(" where idroom=?;");
            indexMap.put("idroom", auxCount);

            PreparedStatement ps = ConnectionManager.PreparedStatement(sb.toString());

            if (indexMap.containsKey("roomprice")) {
                ps.setDouble(indexMap.get("roomprice"), room.getPrice());
            }

            if (indexMap.containsKey("roomtype")) {
                ps.setInt(indexMap.get("roomtype"), room.getType().getId());
            }

            Date actualDate = new Date();
            ps.setDate(1, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d",
                    actualDate.getDate(), actualDate.getMonth(), actualDate.getYear() + 1900)));

            ps.setInt(indexMap.get("idroom"), room.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // </editor-fold>
    
    public ArrayList<Room> SelectRoomsByType(RoomType roomType){
        ArrayList<Room> rooms = new ArrayList<Room>();
        
        String sql_str = "SELECT * FROM room r "
                + "inner join roomtype rt on rt.idroomtype = r.roomtype "
                + "where r.roomtype = "+roomType.getId();
        Room room;
        RoomType type;
        try {
            ResultSet rs = ConnectionManager.GetStatement().executeQuery(sql_str);
            while (rs.next()) {
                room = new Room();
                room.setId(rs.getInt(1));
                room.setPrice(rs.getDouble(2));
                room.setDtCadastre(rs.getDate(4));
                room.setDtUpdate(rs.getDate(5));

                type = new RoomType(rs.getInt(6));
                type.setName(rs.getString(7));
                type.setDtCadastre(rs.getDate(8));
                type.setDtUpdate(rs.getDate(9));

                room.setType(type);
                rooms.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  rooms;
    }
}
