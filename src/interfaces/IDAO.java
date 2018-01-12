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

public interface IDAO<T> {

    void add(T t);

    void update(T t, int id);

    void removeById(int id);
    public List<membre> findById(int id);
     //void envoimsg(membre m, message msg,notification n);
    void envoimsg(membre m, message msg);
    void addGroup(membre m, groupe p);
    void addOffre(membre m, offreemp p);
    void addPub(membre m, publication p);
    void ajouterCommentaire(membre m,commentaire c);
    void signalerpub(membre m, publicationSig p);
    void addcontact(membre m1,membre m2);
    //void createnotif(message m,notification n);
    public membre findObjectByLoginPassword(String mail,String pwd);

    

    List<T> findAll();

    

}
