package xyz.herther.service;

import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-18 18:44:06
* ��˵��
*/
public interface LoginService {
	
	
	Student StudentToLoginSevice(int username); //ѧ����¼

	Teacher TeacherToLoginSevice(int username); //��ʦ��¼
}

