package csgbd.Hotel.Common.Entity;

import java.util.Date;

/**
 *
 * @author italopessoa
 */
public class Reserve {

    private int id;
    private Guest guest;
    private Room room;
    private Date entryDate;
    private Date outDate;
    private Date dtCadastre;
    private Date dtUpdate;

    public Reserve() {
    }

    public Reserve(int id) {
        this.id = id;
    }

    public Reserve(Guest guest, Room room, Date entryDate, Date outDate) {
        this.guest = guest;
        this.room = room;
        this.entryDate = entryDate;
        this.outDate = outDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
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
}
