package xyz.herther.dao;

import java.util.List;
import java.util.Vector;

import xyz.herther.eneity.Teacher;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-14 22:52:34
* 类说明
*/
public interface TeacherDao {

	List<Vector> searchGrade(int tid); //查询选课

	Teacher SelectPersonInfo(int Tid); //查询个人信息

	int selectTid(String tname); //根据老师姓名查询老师的tid账号

	int selectTCourse(int cid, String tname); //查询剩余人数主键iD

	int editPassWorld(int tid, String newPass); //修改密码

	int editPersonInfo(int tid, String tname, int sex, String phone, String brace); //修改信息

	List<Vector> selectCourseGreade(int tid); //查询选择我课程的学生 没有成绩的

	List<Vector> seachCourseGreade(int tid, String cname); //搜索查询选择我课程的学生 没有成绩的

	int addGread(int cid, int snum,double gread); //添加成绩

	List<Vector> selectCourseGreade1(int tid);//查询选择我课程的学生 有成绩的

	List<Vector> seachCourseGreade1(int tid, String cname);//搜索查询选择我课程的学生 有成绩的

	int delGread(int cid, int snum); //删除选中有成绩的

	int addCurriculum(int cid, int tid, String cname, double credit, int capacity); //添加课程

	List<Vector> showTableCurriculum(int tid); //渲染课程表

	List<Vector> SeachCurriculum(int tid, String cname); //搜索课程

	int editCurriculum(int tid, int cid, double credit, String cname, int capacity);//修改课程

	int delCurriculum(int tid, int cid); //删除课程

	int addStudent(int snum, String md5Pass, String dept, String sname, String classDept, int age, String phone); //添加学生

	List<Vector> SelectStuden(); //查询所有学生
 
	int deleteStuden(int snum); //删除学生

	int ditStudent(int snum, String sname, String dept, int age, String classGrade, String phone);//修改学生信息


	int editGrade(int snum, double grade, int cid);//修改成绩



}

