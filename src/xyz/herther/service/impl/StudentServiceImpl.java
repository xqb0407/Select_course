package xyz.herther.service.impl;

import java.util.List;
import java.util.Vector;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import xyz.herther.dao.LoginDao;
import xyz.herther.dao.StudentDao;
import xyz.herther.dao.TeacherDao;
import xyz.herther.dao.impl.LoginDaoImpl;
import xyz.herther.dao.impl.StudentDaoImpl;
import xyz.herther.dao.impl.TeacherDaoImpl;
import xyz.herther.eneity.Course;
import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.utils.StateUtils;
import xyz.herther.utils.StringUtils;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-2 22:38:25
* 类说明：学生业务类
*/
public class StudentServiceImpl implements StudentService {
	
	//注入持久层
	StudentDao studentDao =new StudentDaoImpl();

	//注册Teacher持久层
	TeacherDao teacherDao =new TeacherDaoImpl();
	
	//注入登录的持久层用来处理  修改密码
	LoginDao loginDao=new LoginDaoImpl();
	
	
	
	/**
	  * 查询成绩返回一个Vector的集合，转到持久层操作数据
	 */
	@Override
	public List<Vector> selectGreade(int snum) {
		List<Vector> list = studentDao.selectGreade(snum);
//		System.out.println("成绩："+list.get(0).get(2));
		return list;
	}
	/**
	 * 通过检索课程名称 返回到table
	 */
	@Override
	public List<Vector> searchGrade(int snum,String searchField) {
		List<Vector> list =studentDao.searchGrade(snum,searchField);
		return list;
		
	}
	/**
	 * 	查询课程
	 */
	@Override
	public List<Vector> selectcourse() {
		List<Vector> list =studentDao.selectcourse();
		return list;
	}
	
	/**
	 * 检索可选课程
	 */
	@Override
	public List<Vector> SelectCourseName(String cnameFiled) {
		List<Vector> list =studentDao.SelectCourseName(cnameFiled);
		return list;
	}
	
	//选课
	@Override
	public int insertCourse(int cid, String tname,int snum) {
		//去查询老师的ID;
		int tid = teacherDao.selectTid(tname);
		//查询剩余人数表中的id
		int id = teacherDao.selectTCourse(cid,tname);
		//执行插入选课信息 
		//1、先去查询是否出出现用一个用户出现重复选课
		Course course = studentDao.uniqueCourse(cid,snum);
		if(course!=null) {
			return 500;
		}else {
			int code = studentDao.insertCourse(cid,tid,id,snum);
			return code;
		}
		
	}
	//查询用户选择的课程
	@Override
	public List<Vector> selectMycourse(int snum) {
		List<Vector> list = studentDao.selectMycourse(snum);
		return list;
	}
	
	//检索我选的课程
	@Override
	public List<Vector> seachCourseName(int snum,String cnameFiled) {
		List<Vector> list = studentDao.seachCourseName(snum,cnameFiled);
		return list;
	}
	//修改密码
	@Override
	public int editPassWord(int snum, String oldPass, String newPass) {
		Student student = loginDao.StudentToLoginSevice(snum);
		String md5NewPass = SecureUtil.md5(newPass);
		String md5oldPass = SecureUtil.md5(oldPass);
		
		String password = student.getPassword();
		
		if(!(md5oldPass.equals(password))) {
			return 500;
		}else {
			return studentDao.editPassWord(snum,md5NewPass);
		}
		
		
	}
	//退课
	@Override
	public int RetReatCourse(int cid, String tname, int snum) {
		//去查询老师的ID;
		int tid = teacherDao.selectTid(tname);
		//执行插入选课信息 
		int code = studentDao.RetReatCourse(cid,tid,snum);
		return code;
	}
	
	//修改资料
	@Override
	public int editPerson(int snum, String sname, String phone, int age) {
		int code = studentDao.editPerson(snum,sname,phone,age);
		return code;
	}

}

