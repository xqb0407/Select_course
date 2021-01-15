package xyz.herther.service;

import java.util.List;
import java.util.Vector;

import xyz.herther.eneity.Student;
import xyz.herther.utils.StateUtils;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-2 22:37:38
*  学生端功能接口
*/
public interface StudentService {


	List<Vector> selectGreade(int snum); //查询成绩table表格

	List<Vector> searchGrade(int snum,String searchField); //检索成绩

	List<Vector> selectcourse(); //查询可选课程

	List<Vector> SelectCourseName(String cnameFiled); //检索可选课程


	int insertCourse(int cid, String tname,int snum);//选课

	List<Vector> selectMycourse(int snum); //查询我选课的


	List<Vector> seachCourseName(int snum, String cnameFiled); //检索我的选课

	int editPassWord(int snum, String oldPass, String newPass); //修改密码

	int RetReatCourse(int cid, String tname, int snum); //退课

	int editPerson(int snum, String sname, String phone, int age); //修改资料


}

