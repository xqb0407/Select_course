package xyz.herther.service.impl;

import cn.hutool.crypto.SecureUtil;
import xyz.herther.dao.LoginDao;
import xyz.herther.dao.impl.LoginDaoImpl;
import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;
import xyz.herther.service.LoginService;
import xyz.herther.utils.StateUtils;
import xyz.herther.utils.StringUtils;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-18 18:45:26
* 类说明
*/
public class LoginServiceImpl implements LoginService {
	
	//注入持久层
	LoginDao loginDao =new LoginDaoImpl();
	
	/**
	  * 学生登录方法
	 */
	@Override
	public Student StudentToLoginSevice(int username) {
		return loginDao.StudentToLoginSevice(username);
	}
	/**
	 * 老师登录
	 */
	@Override
	public Teacher TeacherToLoginSevice(int username) {
		Teacher teacher = loginDao.TeacherToLoginSevice(username);
		return teacher;
	}
}

