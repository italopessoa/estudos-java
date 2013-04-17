import csgbd.Hotel.Common.DAO.Implements.GuestDAO;
import csgbd.Hotel.Common.DAO.Implements.RoomTypeDAO;
import csgbd.Hotel.Common.DB.ConnectionManager;
import csgbd.Hotel.Common.Entity.Guest;
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
        RoomTypeDAO dao = new RoomTypeDAO();
        GuestDAO gdao = new GuestDAO();
        
        Guest g = new Guest(1);
        g.setName("italo ney silva pessoa");
        
        //gdao.Save(g);
        gdao.Delete(g);

        RoomType r= new RoomType();
        r.setName("asdasdasdas");
        
        dao.Save(r);
        ArrayList<RoomType> d = dao.SelectAll();
        ArrayList<Guest> ggg = gdao.SelectAll();
        dao.Delete(d.get(0));
        d = dao.SelectAll();
        //Date  a = new Date();
    }
}
