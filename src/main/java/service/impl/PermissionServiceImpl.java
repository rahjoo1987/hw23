package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Permission;
import repository.PermissionRepository;
import service.PermissionService;

public class PermissionServiceImpl extends BaseEntityServiceImpl<Permission, PermissionRepository>implements PermissionService {
    public PermissionServiceImpl(PermissionRepository repository) {
        super(repository);
    }
}
