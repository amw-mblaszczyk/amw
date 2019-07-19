package amw.statki.model.dao;

import java.util.List;

public interface Dao<K, E> {
      void persist(E entity);
      void remove(E entity);
      E findById(K id);
      List<E> findAll();
      
}
