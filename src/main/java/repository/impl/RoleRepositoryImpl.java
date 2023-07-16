package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Role;
import repository.RoleRepository;

import javax.persistence.EntityManager;

public class RoleRepositoryImpl extends BaseEntityRepositoryImpl<Role>implements RoleRepository {
    public RoleRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Role> getEntityClass() {
        return Role.class;
    }
}
