import csgbd.Hotel.Common.DAO.Implements.GuestDAO;
import csgbd.Hotel.Common.DAO.Implements.ReserveDAO;
import csgbd.Hotel.Common.DAO.Implements.RoomDAO;
import csgbd.Hotel.Common.DAO.Implements.RoomTypeDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
import csgbd.Hotel.Common.Entity.Guest;
import csgbd.Hotel.Common.Entity.Reserve;
import csgbd.Hotel.Common.Entity.Room;
import csgbd.Hotel.Common.Entity.RoomType;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author italopessoa
 */
public class Main {
    private static int i;
    
    public static void main(String[] args){
        
        ConnectionManager.OpenConnection();
//Guest g = new Guest();
//g.setName("jhkjhk");
//g.setEmail("kjhkjh");
//g.setAge(20);
//g.setPhone("kjhkjg");
//
//GuestDAO gsd = new GuestDAO();
//
//        Reserve re = new Reserve(1);
//        re.setEntryDate(new Date());
//        re.setOutDate(new Date());
//        //re.setRoom(new Room(1));
//        re.setGuest(new Guest(2));
//        
        ReserveDAO res = new ReserveDAO();
//        //res.Save(re);
//        
//        re.setGuest(new Guest(3));
//        res.Update(re);
        
        res.SelectAll();
        
        
        
       
    }
}
