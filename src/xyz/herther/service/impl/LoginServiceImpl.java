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
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-18 18:45:26
* ��˵��
*/
public class LoginServiceImpl implements LoginService {
	
	//ע��־ò�
	LoginDao loginDao =new LoginDaoImpl();
	
	/**
	  * ѧ����¼����
	 */
	@Override
	public Student StudentToLoginSevice(int username) {
		return loginDao.StudentToLoginSevice(username);
	}
	/**
	 * ��ʦ��¼
	 */
	@Override
	public Teacher TeacherToLoginSevice(int username) {
		Teacher teacher = loginDao.TeacherToLoginSevice(username);
		return teacher;
	}
}

