/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.membre;
import entities.message;
import java.util.List;

/**
 *
 * @author user
 */
public interface IDAOADMIN<T> {
    

    void update(T t, int id);

    void removeById(int id);
    void bloquermembre(int id);
    void supprimermsg(message msg);
    void supprimerpub();

    List<T> findAll();

    T findById(int id);
    
}