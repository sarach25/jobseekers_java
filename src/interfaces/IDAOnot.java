package interfaces;

import entities.*;
import java.util.List;


public interface IDAOnot<notifications> {

    void add(notification n);

    void update(notification n, int idNotif);

    void removeById(int idNotif);

    List<notification> findAll();

    notification findById(int idNotif);

}