package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.services.CRUDService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class MapService<T,ID> implements CRUDService<T,ID> {
    Map<ID,T> map;
    public MapService(){
        this.map = new HashMap<>();
    }

    public T save(ID id , T object){
        return this.map.put(id,object);
    }

    @Override
    public T save(T object) {
        return null;
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public void delete(T object) {
        for(Map.Entry<ID,T> item: map.entrySet()){
            if( item.getValue().equals(object)){
                map.remove(item.getKey());
                break;
            }
        }
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
