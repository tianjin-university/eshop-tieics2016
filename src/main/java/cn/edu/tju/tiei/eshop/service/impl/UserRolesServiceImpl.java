package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.eshop.dao.UserRolesMapper;
import cn.edu.tju.tiei.eshop.model.UserRoles;
import cn.edu.tju.tiei.eshop.service.IUserRolesService;

@Service("userrolesService")
public class UserRolesServiceImpl implements IUserRolesService{
	

    @Resource
    private UserRolesMapper userRolesMapper;

    public UserRolesMapper getUserRolesMapper() {
        return userRolesMapper;
    }

    @Autowired
    public void setPersonMapper(UserRolesMapper userRolesMapper) {
        this.userRolesMapper = userRolesMapper;
    }
    
	@Override
	public List<UserRoles> findAll() {
		return userRolesMapper.selectByExample(null);
	}

	@Override
	public UserRoles findById(int id) {
		return userRolesMapper.selectByPrimaryKey(id);
	}

	@Override
	public void create(UserRoles userroles) {
		userRolesMapper.insert(userroles);
	}

	@Override
	public boolean isExist(UserRoles userroles) {
		return userRolesMapper.selectByPrimaryKey(userroles.getId()) != null;
	}

	@Override
	public void update(UserRoles userroles) {
		userRolesMapper.updateByPrimaryKey(userroles);
	}

	@Override
	public void deleteById(int id) {
		userRolesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		userRolesMapper.deleteByExample(null);
	}

}
