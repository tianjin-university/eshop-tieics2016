package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.eshop.dao.LoginMapper;
import cn.edu.tju.tiei.eshop.model.Login;
import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginMapper loginMapper;

	public LoginMapper getLoginMapper() {
		return loginMapper;
	}

	@Autowired
	public void setPersonMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

	
	@Override
	public void deleteById(Integer id) {
		loginMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void deleteAll() {
		loginMapper.deleteByExample(null);
		
	}

	@Override
	public Login findById(Integer id) {
		// TODO Auto-generated method stub
		return loginMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean isExist(Login login) {
		// TODO Auto-generated method stub
		return loginMapper.selectByPrimaryKey(login.getId()) != null;
	}



	@Override
	public void update(Login login) {
		loginMapper.updateByPrimaryKey(login);
		
	}

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return loginMapper.selectByExample(null);
	}

	@Override
	public void create(Login login) {
		loginMapper.insert(login);
		
	}



}
