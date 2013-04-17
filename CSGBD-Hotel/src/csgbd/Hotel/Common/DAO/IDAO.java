/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csgbd.Hotel.Common.DAO;

import java.util.ArrayList;

/**
 *
 * @author italopessoa
 */
public interface IDAO<T> {
    
    void Save(T object);
    
    void Delete(T object);
    
    ArrayList<T> SelectAll();
    
    void Update(T object);
}
