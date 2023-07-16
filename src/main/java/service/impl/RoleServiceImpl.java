package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Role;
import repository.RoleRepository;
import service.RoleService;

public class RoleServiceImpl extends BaseEntityServiceImpl<Role, RoleRepository>implements RoleService {
    public RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }
}
