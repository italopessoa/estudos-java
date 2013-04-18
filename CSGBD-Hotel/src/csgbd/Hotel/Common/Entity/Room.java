package csgbd.Hotel.Common.Entity;

import java.util.Date;

/**
 *
 * @author italopessoa
 */
public class Room {

    private int id;
    private double price;
    private RoomType type;
    private Date dtCadastre;
    private Date dtUpdate;

    public Room() {
    }

    public Room(int id) {
        this.id = id;
    }

    public Date getDtCadastre() {
        return dtCadastre;
    }

    public void setDtCadastre(Date dtCadastre) {
        this.dtCadastre = dtCadastre;
    }

    public Date getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}
