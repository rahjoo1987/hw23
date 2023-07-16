package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static final EntityManager em =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();
    private static  BusRepository busRepository;
    private static BusService busService;
    private static CityRepository cityRepository;
    private static CityService cityService;
    private static PermissionRepository permissionRepository;
    private static PermissionService permissionService;
    private static PersonRepository personRepository;
    private static PersonService personService;
    private static RoleRepository roleRepository;
    private static RoleService roleService;
    private static TicketRepository ticketRepository;
    private static TicketService ticketService;

    private static BusRepository getBusRepository(){
        if (busRepository==null)
            busRepository=new BusRepositoryImpl(em);
        return busRepository;
    }
    public static BusService getBusService(){
        if(busService==null)
            busService=new BusServiceImpl(getBusRepository());
        return busService;
    }
    private static CityRepository getCityRepository(){
        if (cityRepository==null)
            cityRepository=new CityRepositoryImpl(em);
        return cityRepository;
    }
    public static CityService getCityService(){
        if (cityService==null)
            cityService=new CityServiceImpl(getCityRepository());
        return cityService;
    }
    private static PermissionRepository getPermissionRepository(){
        if (permissionRepository==null)
            permissionRepository=new PermissionRepositoryImpl(em);
        return permissionRepository;
    }
    public static PermissionService getPermissionService(){
        if (permissionService==null)
            permissionService=new PermissionServiceImpl(getPermissionRepository());
        return permissionService;
    }
    private static PersonRepository getPersonRepository(){
        if (personRepository==null)
            personRepository=new PersonRepositoryImpl(em);
        return personRepository;
    }
    public static PersonService getPersonService(){
        if (permissionService==null)
            personService=new PersonServiceImpl(getPersonRepository());
        return personService;
    }
    private static RoleRepository getRepository(){
        if (roleRepository==null)
            roleRepository=new RoleRepositoryImpl(em);
        return roleRepository;
    }
    public static RoleService getRoleService(){
        if (roleService==null)
            roleService=new RoleServiceImpl(getRepository());
        return roleService;
    }
    private static TicketRepository getTicketRepository(){
        if (ticketRepository==null)
            ticketRepository=new TicketRepositoryImpl(em);
        return ticketRepository;
    }
    public static TicketService getTicketService(){
        if (ticketService==null)
            ticketService=new TicketServiceImpl(getTicketRepository());
        return ticketService;
    }

}
