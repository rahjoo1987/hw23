package base.service.impl;


import base.domain.BaseEntity;
import base.repository.BaseEntityRepository;
import base.service.BaseEntityService;

import java.util.List;
import java.util.Optional;

public class BaseEntityServiceImpl<T extends BaseEntity,R extends BaseEntityRepository<T>>
implements BaseEntityService<T> {
    protected final R repository;

    public BaseEntityServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        repository.beginTransaction();
        repository.save(t);
        repository.commitTransaction();
        return t;
    }

    @Override
    public T update(T t) {
        repository.beginTransaction();
        repository.update(t);
        repository.commitTransaction();
        return t;
    }

    @Override
    public T loadById(Long id) {
        return repository.loadById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.beginTransaction();
        repository.deleteById(id);
        repository.commitTransaction();
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }



    @Override
    public long count() {
        return repository.count();
    }
}
