package base.repository.impl;



import base.domain.BaseEntity;
import base.repository.BaseEntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public abstract class BaseEntityRepositoryImpl
        <T extends BaseEntity>implements BaseEntityRepository<T> {
    protected final EntityManager em;

    public BaseEntityRepositoryImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }
    @Override
    public T update(T t){
        em.merge(t);
        return t;
    }

    @Override
    public T loadById(Long id) {
        return em.find(getEntityClass(),id);
    }

    @Override
    public void deleteById(Long id) {
        em.remove(findById(id).orElseThrow
                (()->new RuntimeException("entity not found")));

    }

    @Override
    public List<T> findAll() {
        return em.createQuery(" from " + getEntityClass().getSimpleName()
                ,getEntityClass()).getResultList();
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(
                em.find(
                        getEntityClass(), id
                )
        );
    }

    @Override
    public boolean existsById(Long id) {
        TypedQuery<Long> query =
                em.createQuery("select count(e) from " + getEntityClass().getSimpleName()
                + " e where e.id = :id", Long.class);
        query.setParameter("id",id);
        return query.getSingleResult() > 0;
    }

    @Override
    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive())
            transaction.begin();

    }

    @Override
    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive())
            transaction.commit();

    }

    @Override
    public void rollbackTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive())
            transaction.rollback();

    }

    @Override
    public long count() {
        return em.createQuery
                (" select count(e) from "+getEntityClass().getSimpleName()
                        +" e",Long.class).getSingleResult();
    }
    public abstract Class<T> getEntityClass();
}
