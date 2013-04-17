package csgbd.Hotel.Common.Entity;

/**
 *
 * @author italopessoa
 */
public class Room {
    private int id;
    private double price;
    private RoomType type;

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
