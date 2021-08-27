package amr.springproject.sfgpetclinic.services;

import java.util.Set;

public interface CRUDService<T,ID>{
    T save(T object);
    Set<T> findAll();
    T findById(ID id);
    void delete(T object);
    void deleteById(ID id);
}
