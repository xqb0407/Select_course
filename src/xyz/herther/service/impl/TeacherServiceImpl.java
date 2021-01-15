package xyz.herther.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import xyz.herther.dao.TeacherDao;
import xyz.herther.dao.impl.TeacherDaoImpl;
import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-14 22:39:26
* 类说明
*/
public class TeacherServiceImpl implements TeacherService {
	
	//注入持久层
	TeacherDao teacherDao = new TeacherDaoImpl(); 
	
	/**
	 * 查询选课人数
	 */
	@Override
	public List<Vector> selectNum(int tid) {
		List<Vector> list =teacherDao.searchGrade(tid);
		return list;
	}
	/**
	 * 	查询老师个人信息
	 */
	@Override
	public Teacher SelectPersonInfo(int Tid) {
		Teacher teacher= teacherDao.SelectPersonInfo(Tid);
		return teacher;
	}
	/**
	 * 	修改密码
	 */
	@Override
	public int editPassWorld(int tid, String oldPass, String newPass) {
		Teacher teacher = teacherDao.SelectPersonInfo(tid);
		String oldMd5Pass = SecureUtil.md5(oldPass);
		String newMd5Pass = SecureUtil.md5(newPass);
		if(!(teacher.getPassword().equals(oldMd5Pass))) {
			return -1;
		}else if(teacher==null){
			return 500;
		}else {
			return teacherDao.editPassWorld(tid,newMd5Pass);
		}
		
	}
	/**
	 * 	修改信息
	 */
	@Override
	public int editPersonInfo(int tid, String tname, int sex, String phone, String brace) {
		int code = teacherDao.editPersonInfo(tid,tname,sex,phone,brace);
		if(code ==0) {
			return code;
		}else {
			return code;
		}
	}
	/**
	 * 	查询选择我课程的学生 没有成绩的
	 */
	@Override
	public List<Vector> selectCourseGreade(int tid) {
		return teacherDao.selectCourseGreade(tid);
	}
	/**
	 * 	搜索查询选择我课程的学生 没有成绩的
	 */
	@Override
	public List<Vector> seachCourseGreade(int tid, String cname) {
		return teacherDao.seachCourseGreade(tid,cname);
	}
	
	/**
	 * 	添加成绩
	 */
	@Override
	public int addGread(int cid, int snum,double gread) {
		return teacherDao.addGread(cid,snum,gread);
	}
	/**
	 * 	搜索查询选择我课程的学生 有成绩的
	 */
	@Override
	public List<Vector> selectCourseGreade1(int tid) {
		return teacherDao.selectCourseGreade1(tid);
	}
	/**
	 * 	搜索查询选择我课程的学生 有成绩的
	 */
	@Override
	public List<Vector> seachCourseGreade1(int tid, String cname) {
		return teacherDao.seachCourseGreade1(tid,cname);
	}
	/**
	 * 	删除选中有成绩
	 */
	@Override
	public int delGread(int cid, int snum) {
		return teacherDao.delGread(cid,snum);
	}
	/**
	 * 	添加课程
	 */
	@Override
	public int addCurriculum(int tid, String cname, double credit, int capacity) {
		//随机生成五位数来用作课程号
		int cid = (int)((Math.random()*9+1)*10000);
		int code = teacherDao.addCurriculum(cid,tid,cname,credit,capacity);
		return code;
	}
	
	//渲染表格
	@Override
	public List<Vector> showTableCurriculum(int tid) {
	
		return teacherDao.showTableCurriculum(tid);
	}
	
	//搜索课程
	@Override
	public List<Vector> SeachCurriculum(int tid, String cname) {
		return teacherDao.SeachCurriculum(tid,cname);
	}
	//修改课程
	@Override
	public int editCurriculum(int tid,int cid, double credit, String cname, int capacity) {
		return teacherDao.editCurriculum(tid,cid,credit,cname,capacity);
	}
	//删除课程
	@Override
	public int delCurriculum(int tid, int cid) {
		return teacherDao.delCurriculum(tid,cid);
	}
	//添加学生
	@Override
	public int addStudent(String Sname, String dept, String classDept, int age, String phone) {
		Student student = new Student();
		//获取年份
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);  
		
		//随机生成六位数 拼接学号
		int append = (int)((Math.random()*9+1)*100000);
		StringBuilder snum1= new StringBuilder();
		snum1.append(year);
		snum1.append(append);
		System.out.println(snum1.toString());
		String md5Pass = SecureUtil.md5("123");
		int snum = Integer.parseInt(snum1.toString());
		int code =teacherDao.addStudent(snum,md5Pass,dept,Sname,classDept,age,phone);
		return code;
	}
	//查询学生
	@Override
	public List<Vector> SelectStudent() {
		return teacherDao.SelectStuden();
	}
	
	//删除学生
	@Override
	public int deleteStuden(int snum) {
		return teacherDao.deleteStuden(snum);
	}
	//修改学生信息
	@Override
	public int editStudent(int snum, String sname, String dept, int age, String classGrade, String phone) {
		return teacherDao.ditStudent( snum, sname,dept, age,classGrade,phone);
	}
	//修改成绩
	@Override
	public int editGrade(int snum, double grade ,int cid) {
		return teacherDao.editGrade(snum,grade,cid);
	}
	
}

