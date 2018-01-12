/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.*;

import java.util.List;

/**
 *
 * @author bejaoui
 */
public interface IDAOMSG<T> {

    void add(T t);

    void update(T t, int id);

    void removeById(int id);
    
    
    List<T> findAll();

    T findById(int id);

}