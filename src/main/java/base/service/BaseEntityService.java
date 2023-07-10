package base.service;



import base.domain.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseEntityService<T extends BaseEntity>{
    T save(T t);
    T update(T t);
    T loadById(Long id);
    void deleteById(Long id);
    List<T> findAll();
    public Optional<T> findById(Long id);
    public boolean existsById(Long id);
    long count();

}
