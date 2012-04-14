
import entidade.Usuario;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.cfg.Configuration;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author italoney
 */
public class UsuarioDAO {
    private SessionFactory factory;
    
    public UsuarioDAO() throws Exception{
        factory = new Configuration().configure().buildSessionFactory();
    }
    
    public void UsInserir(Usuario us) throws Exception{
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(us);
        
        Usuario user = (Usuario)session.load(Usuario.class, us.getId());
        
        //slecionar todos os usuarios
        //Query q = session.createQuery("SELECT u FROM Usuario u");//usuario nao é a tabela é a class
   /*     Usuario as = new Usuario();
        as.setId(1);
        as.setNome("ITALO");
        session.delete(as);*/
        /*for(Object o: q.list()){
            Usuario as = (Usuario)o;
            System.out.println(as.getNome());
        }*/
        
        tx.commit();
        session.flush();
        session.close();
    }
}
