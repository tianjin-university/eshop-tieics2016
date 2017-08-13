package cn.edu.tju.tiei.eshop.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Data;

import cn.edu.tju.tiei.eshop.model.Customer;
import cn.edu.tju.tiei.eshop.model.Login;
import cn.edu.tju.tiei.eshop.model.Rank;


/**
 * 用户管理Service
 * @author <a href="mailto:wutong00001@126.com">wutong</a>
 * @since 2016年04月08日 上午10:59
 */
public interface LoginService {

	 	List<Login> findAll();

		Login findById(Integer id);

		void create(Login login);

		boolean isExist(Login login);

		void update(Login login);

		void deleteById(Integer id);

		void deleteAll();

	//public void updateVisitorUser(String id,String userRealName,String userAccountNumber,String officeTelephone,String fax,String email,String mobilePhone,String homePhone,String postcode,String cardNum,String isUse,String schoolId);

	
}
