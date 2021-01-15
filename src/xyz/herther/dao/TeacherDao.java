package xyz.herther.dao;

import java.util.List;
import java.util.Vector;

import xyz.herther.eneity.Teacher;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-14 22:52:34
* ��˵��
*/
public interface TeacherDao {

	List<Vector> searchGrade(int tid); //��ѯѡ��

	Teacher SelectPersonInfo(int Tid); //��ѯ������Ϣ

	int selectTid(String tname); //������ʦ������ѯ��ʦ��tid�˺�

	int selectTCourse(int cid, String tname); //��ѯʣ����������iD

	int editPassWorld(int tid, String newPass); //�޸�����

	int editPersonInfo(int tid, String tname, int sex, String phone, String brace); //�޸���Ϣ

	List<Vector> selectCourseGreade(int tid); //��ѯѡ���ҿγ̵�ѧ�� û�гɼ���

	List<Vector> seachCourseGreade(int tid, String cname); //������ѯѡ���ҿγ̵�ѧ�� û�гɼ���

	int addGread(int cid, int snum,double gread); //��ӳɼ�

	List<Vector> selectCourseGreade1(int tid);//��ѯѡ���ҿγ̵�ѧ�� �гɼ���

	List<Vector> seachCourseGreade1(int tid, String cname);//������ѯѡ���ҿγ̵�ѧ�� �гɼ���

	int delGread(int cid, int snum); //ɾ��ѡ���гɼ���

	int addCurriculum(int cid, int tid, String cname, double credit, int capacity); //��ӿγ�

	List<Vector> showTableCurriculum(int tid); //��Ⱦ�γ̱�

	List<Vector> SeachCurriculum(int tid, String cname); //�����γ�

	int editCurriculum(int tid, int cid, double credit, String cname, int capacity);//�޸Ŀγ�

	int delCurriculum(int tid, int cid); //ɾ���γ�

	int addStudent(int snum, String md5Pass, String dept, String sname, String classDept, int age, String phone); //���ѧ��

	List<Vector> SelectStuden(); //��ѯ����ѧ��
 
	int deleteStuden(int snum); //ɾ��ѧ��

	int ditStudent(int snum, String sname, String dept, int age, String classGrade, String phone);//�޸�ѧ����Ϣ


	int editGrade(int snum, double grade, int cid);//�޸ĳɼ�



}

