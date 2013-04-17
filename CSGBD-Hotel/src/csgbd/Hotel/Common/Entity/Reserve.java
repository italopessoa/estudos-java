/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
