package xyz.herther.service;

import java.util.List;
import java.util.Vector;

import xyz.herther.eneity.Student;
import xyz.herther.utils.StateUtils;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-2 22:37:38
*  ѧ���˹��ܽӿ�
*/
public interface StudentService {


	List<Vector> selectGreade(int snum); //��ѯ�ɼ�table���

	List<Vector> searchGrade(int snum,String searchField); //�����ɼ�

	List<Vector> selectcourse(); //��ѯ��ѡ�γ�

	List<Vector> SelectCourseName(String cnameFiled); //������ѡ�γ�


	int insertCourse(int cid, String tname,int snum);//ѡ��

	List<Vector> selectMycourse(int snum); //��ѯ��ѡ�ε�


	List<Vector> seachCourseName(int snum, String cnameFiled); //�����ҵ�ѡ��

	int editPassWord(int snum, String oldPass, String newPass); //�޸�����

	int RetReatCourse(int cid, String tname, int snum); //�˿�

	int editPerson(int snum, String sname, String phone, int age); //�޸�����


}

