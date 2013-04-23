package csgbd.Hotel.Common.DAO;

import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IDAO<T> {

    void Save(T object) throws Exception;

    void Delete(T object) throws Exception;

    ArrayList<T> SelectAll() throws Exception;

    void Update(T object) throws Exception;
}
