package csgbd.Hotel.Common.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IDAO<T> {

    void Save(T object) throws SQLException,Exception;

    void Delete(T object) throws SQLException,Exception;

    ArrayList<T> SelectAll() throws SQLException,Exception;

    void Update(T object) throws SQLException,Exception;
}
