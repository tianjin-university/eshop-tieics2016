package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.UserRoles;


public interface IUserRolesService {
	
	/**
     * Load all user_roles
     * @return
     */
	List<UserRoles> findAll();

	UserRoles findById(int id);

    void create(UserRoles userroles);

    boolean isExist(UserRoles userroles);

    void update(UserRoles userroles);

    void deleteById(int id);

    void deleteAll();
	
}
