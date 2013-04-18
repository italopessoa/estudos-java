package csgbd.Hotel.Common.Entity;

import java.util.Date;

/**
 *
 * @author italopessoa
 */
public class RoomType {
    private int id;
    private String name;
    private Date dtCadastre;
    private Date dtUpdate;
    
    public RoomType() {
    }

    public RoomType(int id) {
        this.id = id;
    }
    
    public Date getDtCadastre() {
        return dtCadastre;
    }

    public void setDtCadastre(Date dtCadastre) {
        this.dtCadastre = dtCadastre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

}
