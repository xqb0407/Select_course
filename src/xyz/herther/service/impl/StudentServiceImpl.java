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
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-2 22:38:25
* ��˵����ѧ��ҵ����
*/
public class StudentServiceImpl implements StudentService {
	
	//ע��־ò�
	StudentDao studentDao =new StudentDaoImpl();

	//ע��Teacher�־ò�
	TeacherDao teacherDao =new TeacherDaoImpl();
	
	//ע���¼�ĳ־ò���������  �޸�����
	LoginDao loginDao=new LoginDaoImpl();
	
	
	
	/**
	  * ��ѯ�ɼ�����һ��Vector�ļ��ϣ�ת���־ò��������
	 */
	@Override
	public List<Vector> selectGreade(int snum) {
		List<Vector> list = studentDao.selectGreade(snum);
//		System.out.println("�ɼ���"+list.get(0).get(2));
		return list;
	}
	/**
	 * ͨ�������γ����� ���ص�table
	 */
	@Override
	public List<Vector> searchGrade(int snum,String searchField) {
		List<Vector> list =studentDao.searchGrade(snum,searchField);
		return list;
		
	}
	/**
	 * 	��ѯ�γ�
	 */
	@Override
	public List<Vector> selectcourse() {
		List<Vector> list =studentDao.selectcourse();
		return list;
	}
	
	/**
	 * ������ѡ�γ�
	 */
	@Override
	public List<Vector> SelectCourseName(String cnameFiled) {
		List<Vector> list =studentDao.SelectCourseName(cnameFiled);
		return list;
	}
	
	//ѡ��
	@Override
	public int insertCourse(int cid, String tname,int snum) {
		//ȥ��ѯ��ʦ��ID;
		int tid = teacherDao.selectTid(tname);
		//��ѯʣ���������е�id
		int id = teacherDao.selectTCourse(cid,tname);
		//ִ�в���ѡ����Ϣ 
		//1����ȥ��ѯ�Ƿ��������һ���û������ظ�ѡ��
		Course course = studentDao.uniqueCourse(cid,snum);
		if(course!=null) {
			return 500;
		}else {
			int code = studentDao.insertCourse(cid,tid,id,snum);
			return code;
		}
		
	}
	//��ѯ�û�ѡ��Ŀγ�
	@Override
	public List<Vector> selectMycourse(int snum) {
		List<Vector> list = studentDao.selectMycourse(snum);
		return list;
	}
	
	//������ѡ�Ŀγ�
	@Override
	public List<Vector> seachCourseName(int snum,String cnameFiled) {
		List<Vector> list = studentDao.seachCourseName(snum,cnameFiled);
		return list;
	}
	//�޸�����
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
	//�˿�
	@Override
	public int RetReatCourse(int cid, String tname, int snum) {
		//ȥ��ѯ��ʦ��ID;
		int tid = teacherDao.selectTid(tname);
		//ִ�в���ѡ����Ϣ 
		int code = studentDao.RetReatCourse(cid,tid,snum);
		return code;
	}
	
	//�޸�����
	@Override
	public int editPerson(int snum, String sname, String phone, int age) {
		int code = studentDao.editPerson(snum,sname,phone,age);
		return code;
	}

}

