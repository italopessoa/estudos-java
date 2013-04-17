package csgbd.Hotel.Common.DAO.Implements;

import csgbd.Hotel.Common.DAO.IDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
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
public class RoomTypeDAO implements IDAO<RoomType>{

    @Override
    public void Save(RoomType object) {
        RoomType roomType;
        if(object.getClass().equals(RoomType.class)){
            roomType = (RoomType)object;
        }else{
            throw new ClassCastException("O valor informado não corresponde ao esperado!");
        }
        try {
            String query = "insert into roomtype(RoomTypeName,DtCadastre) values (?,?);";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setString(1, roomType.getName());
            Date actualDate = new Date();
            //mes 0 = 12
            ps.setDate(2, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d", 
                    actualDate.getDate(),actualDate.getMonth(),actualDate.getYear()+1900)));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete(RoomType object) {
        RoomType roomType;
        if(object.getClass().equals(RoomType.class)){
            roomType = (RoomType)object;
        }else{
            throw new ClassCastException("O valor informado não corresponde ao esperado!");
        }
        try {
            String query = "delete from roomtype where idroomtype = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setInt(1, roomType.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<RoomType> SelectAll() {
        ArrayList roomTypes = new ArrayList();
        String sql_str = "SELECT * FROM roomtype";
        RoomType roomType;
        try {
            ResultSet rs = ConnectionManager.GetStatement().executeQuery(sql_str);
            while(rs.next()){
                roomType = new RoomType();
                roomType.setId(rs.getInt("IdRoomType"));
                roomType.setName(rs.getString("RoomTypeName"));
                roomType.setDtCadastre(rs.getDate("DtCadastre"));
                roomTypes.add(roomType);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roomTypes;
    }

    @Override
    public void Update(RoomType object) {
        RoomType roomType;
        if(object.getClass().equals(RoomType.class)){
            roomType = (RoomType)object;
        }else{
            throw new ClassCastException("O valor informado não corresponde ao esperado!");
        }
        try {
            String query = "update roomtype set RoomTypeName = ?,DtUpdate = ? where idroomtype = ?;";
            PreparedStatement ps = ConnectionManager.PreparedStatement(query);
            ps.setString(1, roomType.getName());
            Date actualDate = new Date();
            //mes 0 = 12
            ps.setDate(2, java.sql.Date.valueOf(String.format("%3$d-%2$d-%1$d", 
                    actualDate.getDate(),actualDate.getMonth(),actualDate.getYear()+1900)));
            
            ps.setInt(3, roomType.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
