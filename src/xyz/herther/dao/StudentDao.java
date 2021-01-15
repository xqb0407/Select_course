package xyz.herther.dao;

import java.util.List;
import java.util.Vector;

import xyz.herther.eneity.Course;
import xyz.herther.eneity.Student;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-2 22:46:20
* 接口说明 学生信息持久层数据库的操作
*/
public interface StudentDao {


	List<Vector> selectGreade(int snum); //查询成绩 

	List<Vector> searchGrade(int snum,String searchField); //检索成绩

	List<Vector> selectcourse(); //查询可选课程

	List<Vector> SelectCourseName(String cnameFiled); //检索可选课程

	int insertCourse(int cid, int tid,int id,int snum); //执行选课

	Course uniqueCourse(int cid, int snum); //查询是否出现同一个学生出现重复选课

	List<Vector> selectMycourse(int snum); //查询用户自己所选课程

	List<Vector> seachCourseName(int snum,String cnameFiled); //检索我选择课程

	int editPassWord(int snum, String md5NewPass); //修改密码

	int RetReatCourse(int cid, int tid, int snum); //退课

	int editPerson(int snum, String sname, String phone, int age); //修改资料

}

