package xyz.herther.dao;

import java.util.List;
import java.util.Vector;

import xyz.herther.eneity.Course;
import xyz.herther.eneity.Student;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-2 22:46:20
* �ӿ�˵�� ѧ����Ϣ�־ò����ݿ�Ĳ���
*/
public interface StudentDao {


	List<Vector> selectGreade(int snum); //��ѯ�ɼ� 

	List<Vector> searchGrade(int snum,String searchField); //�����ɼ�

	List<Vector> selectcourse(); //��ѯ��ѡ�γ�

	List<Vector> SelectCourseName(String cnameFiled); //������ѡ�γ�

	int insertCourse(int cid, int tid,int id,int snum); //ִ��ѡ��

	Course uniqueCourse(int cid, int snum); //��ѯ�Ƿ����ͬһ��ѧ�������ظ�ѡ��

	List<Vector> selectMycourse(int snum); //��ѯ�û��Լ���ѡ�γ�

	List<Vector> seachCourseName(int snum,String cnameFiled); //������ѡ��γ�

	int editPassWord(int snum, String md5NewPass); //�޸�����

	int RetReatCourse(int cid, int tid, int snum); //�˿�

	int editPerson(int snum, String sname, String phone, int age); //�޸�����

}

