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
 * @author Carlos
 * @param <commentaire>
 */
public interface IDAO_comm<commentaire> {
    
    void add(commentaire p);
    void update(commentaire p, int idCommentaire);
    void removeById(int idCommentaire);
    List<commentaire> findAll();
    commentaire findById(int idCommentaire);
    
    
    
}