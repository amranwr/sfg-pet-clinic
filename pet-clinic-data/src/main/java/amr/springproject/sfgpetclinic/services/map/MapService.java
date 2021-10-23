package amr.springproject.sfgpetclinic.services.map;

import amr.springproject.sfgpetclinic.model.BaseEntity;
import amr.springproject.sfgpetclinic.services.CRUDService;

import java.util.*;

public abstract class MapService<T extends BaseEntity,ID extends Long> {
    protected Map<Long,T> map;
    public MapService(){
        this.map = new HashMap<>();
    }

    public T save(T object) {
        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;

    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public void delete(T object) {
        for(Map.Entry<Long,T> item: map.entrySet()){
            if( item.getValue().equals(object)){
                map.remove(item.getKey());
                break;
            }
        }
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId(){
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
