package xyz.herther.service;

import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-18 18:44:06
* 类说明
*/
public interface LoginService {
	
	
	Student StudentToLoginSevice(int username); //学生登录

	Teacher TeacherToLoginSevice(int username); //老师登录
}

