package xyz.herther.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import cn.hutool.core.lang.ClassScanner;
import xyz.herther.dao.TeacherDao;
import xyz.herther.eneity.Teacher;
import xyz.herther.utils.DBUtils;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-14 22:52:52
* ��˵��
*/
public class TeacherDaoImpl implements TeacherDao {
	/**
	 * 	��ѯѡ������
	 * @throws SQLException 
	 */
	@Override
	public List<Vector> searchGrade(int tid) {
		
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list = new  ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql ="select ca.capacity,ca.cid,cu.cname from capacity ca JOIN curriculum cu ON ca.cid= cu.Cid JOIN teacher t ON t.Tid=ca.tid WHERE  ca.Tid=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Vector v =new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getInt("capacity"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	
	/**
	 *	 ��ѯ������Ϣ
	 */
	@Override
	public Teacher SelectPersonInfo(int Tid) {
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Teacher teacher=null;
		try {
			conn = DBUtils.getConnection();
			String sql="SELECT * FROM teacher where Tid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Tid);
			rs = ps.executeQuery();
			while (rs.next()) {
				teacher=new Teacher(
				rs.getInt("Tid"),rs.getString("Tname"),
				rs.getLong("sex"),rs.getString("password"),
				rs.getString("phone"),rs.getString("brace"),
				rs.getDate("create_time"),rs.getDate("update_time"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return teacher;
	}

	/**
	 * ����������ѯ��ʦ��Tid
	 */
	@Override
	public int selectTid(String tname) {
		Connection conn=null;
		int tid=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConnection();
			String sql="Select tid from Teacher where tname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,tname);
			rs = ps.executeQuery();
			while (rs.next()) {
				tid =rs.getInt("Tid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return tid;
	}

	/**
	 *	 ��ѯʣ��ѡ��������ID
	 */
	@Override
	public int selectTCourse(int cid, String tname) {
		Connection conn=null;
		int id=0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConnection();
			String sql="Select T.id from Tcourese T JOIN teacher te ON T.tid=te.tid where  cid=? and te.tname= ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,cid);
			ps.setString(2,tname);
			rs = ps.executeQuery();
			while (rs.next()) {
				id =rs.getInt("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return id;
	}

	/**
	 * 	�޸�����
	 */
	@Override
	public int editPassWorld(int tid, String newPass) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE teacher SET password = ? ,update_time = ? WHERE tid= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setObject(2, new Date());
			ps.setInt(3, tid);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}

	/**
	 * 	���³ɼ�
	 */
	@Override
	public int editPersonInfo(int tid, String tname, int sex, String phone, String brace) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE teacher SET Tname = ?,sex = ? , phone = ? ,brace=? ,update_time = ? WHERE tid= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tname);
			ps.setInt(2, sex);
			ps.setString(3, phone);
			ps.setString(4, brace);
			ps.setObject(5, new Date());
			ps.setInt(6, tid);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}

	/**
	 * 	��ѯѡ���ҿγ̵�ѧ�� û�гɼ���
	 */
	@Override
	public List<Vector> selectCourseGreade(int tid) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select c.cid,cu.cname,c.snum,S.sname from course c JOIN curriculum cu ON c.Cid = cu.Cid JOIN student s ON c.snum = s.snum WHERE c.Tid = ? and c.Gread = -1 ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sname"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 *	 ������ѯѡ���ҿγ̵�ѧ�� û�гɼ���
	 */
	@Override
	public List<Vector> seachCourseGreade(int tid, String cname) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select c.cid,cu.cname,c.snum,S.sname from course c JOIN curriculum cu ON c.Cid = cu.Cid JOIN student s ON c.snum = s.snum WHERE c.Tid = ? and c.Gread = -1 and cu.cname LIKE ? ";
			String LIkeSql = '%'+cname+'%';
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setString(2, LIkeSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sname"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 	��ӳɼ�
	 */
	@Override
	public int addGread(int cid, int snum,double gread) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE course SET gread = ? WHERE cid= ? and snum=? and gread = -1";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, gread);
			ps.setInt(2, cid);
			ps.setInt(3, snum);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}

	/**
	 *	 ��ѯѡ���ҿγ̵�ѧ�� �гɼ���
	 */
	@Override
	public List<Vector> selectCourseGreade1(int tid) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select c.gread,c.cid,cu.cname,c.snum,S.sname from course c JOIN curriculum cu ON c.Cid = cu.Cid JOIN student s ON c.snum = s.snum WHERE c.Tid = ? and c.Gread <> -1 ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getDouble("gread")+"��");
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sname"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 *	 ������ѯѡ���ҿγ̵�ѧ�� �гɼ���
	 */
	@Override
	public List<Vector> seachCourseGreade1(int tid, String cname) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select c.gread, c.cid,cu.cname,c.snum,S.sname from course c JOIN curriculum cu ON c.Cid = cu.Cid JOIN student s ON c.snum = s.snum WHERE c.Tid = ? and c.Gread <> -1 and cu.cname LIKE ? ";
			String LIkeSql = '%'+cname+'%';
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			ps.setString(2, LIkeSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getDouble("gread")+"��");
				v.add(rs.getInt("snum"));
				v.add(rs.getString("sname"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}


	@Override
	public int delGread(int cid, int snum) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE course SET gread = -1 WHERE cid= ? and snum=? and gread <> -1";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, snum);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}


	@Override
	public int addCurriculum(int cid, int tid, String cname, double credit, int capacity) {
			Connection conn=null;
			PreparedStatement ps= null;
			PreparedStatement ps1= null;
			int num=0;
			try {
				conn = DBUtils.getConnection();
				//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
				//��һ������Ŀ�к��п�����Ҫִ�ж���SQL�����Ϊһ������
				//����һ��ִ�в��ɹ�,�ͻ�rollback()
				//��true��ʱ��������Զ��ύģʽ��false�ɽ��ø�ģʽ
				//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
				conn.setAutoCommit(false);
				String sql1="insert into  curriculum (Cid,Cname,credit,create_time,update_time) values(?,?,?,?,?)";
				String sql2= "insert into  tcourese (Tid,cid,create_time,update_time,capacity) values(?,?,?,?,?)";
				ps = conn.prepareStatement(sql1);
				ps.setInt(1, cid);
				ps.setString(2, cname);
				ps.setDouble(3, credit); 
				ps.setObject(4, new Date());
				ps.setObject(5, new Date());
				int code = ps.executeUpdate();
				ps1 = conn.prepareStatement(sql2);
				ps1.setInt(1, tid);
				ps1.setInt(2, cid);
				ps1.setObject(3, new Date());
				ps1.setObject(4, new Date());
				ps1.setInt(5, capacity);
				int code1 = ps1.executeUpdate();
				//���û���쳣����ִ�д˶δ���  
			   //�ύ�������������ݿ����ύ����  
				conn.commit();
				
				if(code!=code1) {
					num=0;
				}else if(code1==0&&code==0) {
					num = 0;
				}else {
					num=200;
				}
				
			} catch (SQLException e) {
					try {
						//����ع�
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					e.printStackTrace();
			}finally {
				DBUtils.close(ps, conn);
			}
			return num;
	}

	/**
	 * 	��Ⱦ�γ̱�
	 */
	@Override
	public List<Vector> showTableCurriculum(int tid) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select cu.Cname, cu.cid,cu.Credit,tc.capacity from tcourese tc JOIN curriculum cu  ON cu.Cid = tc.Cid  WHERE tc.tid  = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getDouble("credit")+"��");
				v.add(rs.getString("Cname"));
				v.add(rs.getInt("capacity"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 	�����γ�
	 */
	@Override
	public List<Vector> SeachCurriculum(int tid, String cname) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select cu.Cname, cu.cid,cu.Credit,tc.capacity from tcourese tc JOIN curriculum cu  ON cu.Cid = tc.Cid  WHERE tc.tid  = ? and cu.cname LIKE ?  ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			String sqlLike = "%"+cname+"%";
			ps.setString(2, sqlLike);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getDouble("credit")+"��");
				v.add(rs.getString("Cname"));
				v.add(rs.getInt("capacity"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * �޸Ŀγ�
	 */
	@Override
	public int editCurriculum(int tid,int cid, double credit, String cname, int capacity) {
		Connection conn=null;
		PreparedStatement ps= null;
		PreparedStatement ps1= null;
		int num=0;
		try {
			conn = DBUtils.getConnection();
			//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
			//��һ������Ŀ�к��п�����Ҫִ�ж���SQL�����Ϊһ������
			//����һ��ִ�в��ɹ�,�ͻ�rollback()
			//��true��ʱ��������Զ��ύģʽ��false�ɽ��ø�ģʽ
			//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
			conn.setAutoCommit(false);
			String sql1="update   curriculum SET Cname=?, credit=?,update_time=?  where cid = ?";
			String sql2= "update  tcourese SET update_time=?,capacity=? where tid = ? and cid= ?";
			ps = conn.prepareStatement(sql1);
			ps.setString(1, cname);
			ps.setDouble(2, credit); 
			ps.setObject(3, new Date());
			ps.setInt(4, cid);
			int code = ps.executeUpdate();
			ps1 = conn.prepareStatement(sql2);
			ps1.setObject(1, new Date());
			ps1.setInt(2, capacity);
			ps1.setInt(3, tid);
			ps1.setInt(4, cid);
			int code1 = ps1.executeUpdate();
			//���û���쳣����ִ�д˶δ���  
		   //�ύ�������������ݿ����ύ����  
			conn.commit();
			if(code!=code1) {
				num=0;
			}else if(code1==0&&code==0) {
				num = 0;
			}else {
				num=200;
			}
			
		} catch (SQLException e) {
				try {
					//����ع�
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return num;
	}


	@Override
	public int delCurriculum(int tid, int cid) {
		Connection conn=null;
		PreparedStatement ps= null;
		PreparedStatement ps1= null;
		int num=0;
		try {
			conn = DBUtils.getConnection();
			//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
			//��һ������Ŀ�к��п�����Ҫִ�ж���SQL�����Ϊһ������
			//����һ��ִ�в��ɹ�,�ͻ�rollback()
			//��true��ʱ��������Զ��ύģʽ��false�ɽ��ø�ģʽ
			//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
			conn.setAutoCommit(false);
			String sql1="delete from  curriculum where cid = ?";
			String sql2= "delete  from tcourese  where tid = ? and cid= ?";
			ps1 = conn.prepareStatement(sql2);
			ps1.setInt(1,tid);
			ps1.setInt(2, cid);
			int code1 = ps1.executeUpdate();
			
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, cid);
			int code = ps.executeUpdate();
			//���û���쳣����ִ�д˶δ���  
		   //�ύ�������������ݿ����ύ����  
			conn.commit();
			if(code!=code1) {
				num=0;
			}else if(code1==0&&code==0) {
				num = 0;
			}else {
				num=200;
			}
			
		} catch (SQLException e) {
				try {
					//����ع�
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return num;
	}

	/**
	 *	 ���ѧ��
	 */

	@Override
	public int addStudent(int snum, String md5Pass, String dept, String sname, String classDept, int age,
			String phone) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code = 0;
		try {
			conn = DBUtils.getConnection();
			String sql="insert into student values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, snum);
			ps.setString(2,sname);
			ps.setString(3,md5Pass);
			ps.setString(4,dept);
			ps.setInt(5,age);
			ps.setString(6, phone);
			ps.setString(7, classDept);
			ps.setObject(8, new Date());
			ps.setObject(9, new Date());
			code = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}	
		return code;
	}

	/**
	 * ��ѯ����ѧ��
	 */
	@Override
	public List<Vector> SelectStuden() {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select * from student ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("snum"));
				v.add(rs.getString("Sname"));
				v.add(rs.getInt("age"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("dept"));
				v.add(rs.getString("class_grade"));
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 	ɾ��ѧ��
	 */
	@Override
	public int deleteStuden(int snum) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="DELETE FROM STUDENT where snum = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, snum);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}

	
	//ѧ����Ϣ
	@Override
	public int ditStudent(int snum, String sname, String dept, int age, String classGrade, String phone) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE Student SET  Sname= ?,dept=?,age=?,class_grade=?,update_time=?,phone=? where snum = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setString(2, dept);
			ps.setInt(3, age);
			ps.setString(4, classGrade);
			ps.setObject(5, new Date());
			ps.setString(6, phone);
			ps.setInt(7, snum);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}

	//�޸ĳɼ�
	@Override
	public int editGrade(int snum, double grade,int cid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE course SET  gread = ?,update_time=? where snum = ? and cid = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, grade);
			ps.setObject(2, new Date());
			ps.setInt(3, snum);
			ps.setInt(4, cid);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}
}

