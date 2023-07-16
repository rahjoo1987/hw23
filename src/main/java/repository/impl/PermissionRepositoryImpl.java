package repository.impl;

import base.repository.BaseEntityRepository;
import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Permission;
import repository.PermissionRepository;

import javax.persistence.EntityManager;

public class PermissionRepositoryImpl extends BaseEntityRepositoryImpl<Permission> implements PermissionRepository {
    public PermissionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Permission> getEntityClass() {
        return Permission.class;
    }
}
