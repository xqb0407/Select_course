package xyz.herther.dao;

import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-18 19:31:24
* ��˵��
*/
public interface LoginDao {

	Student StudentToLoginSevice(int username); //ѧ����¼

	Teacher TeacherToLoginSevice(int username); //��ʦ��¼
	
}

