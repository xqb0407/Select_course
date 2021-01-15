package xyz.herther.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import cn.hutool.db.DbUtil;
import xyz.herther.dao.StudentDao;
import xyz.herther.eneity.Course;
import xyz.herther.eneity.Student;
import xyz.herther.utils.DBUtils;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-2 22:46:54
* ��˵��
*/
public class StudentDaoImpl implements StudentDao {

	
	
	
	/**
	 * ��ѯ�ɼ�����
	 * @throws SQLException 
	 */
	@Override
	public List<Vector> selectGreade(int snum)  {
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		List<Vector> list =new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT Gread, Cname  from course c JOIN student s on c.Snum=s.Snum  JOIN curriculum cur ON c.Cid=cur.Cid WHERE s.Snum=? AND Gread <> -1";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, snum);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v= new Vector();
				double Gread = rs.getDouble("Gread");
				String Cname = rs.getString("Cname");
				v.add(Cname);
				v.add(Gread+"��");
				list.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * ͨ���γ��������ɼ�
	 */
	@Override
	public List<Vector> searchGrade(int snum,String searchField) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<Vector> list = new  ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT Gread, Cname  from course c JOIN student s on c.Snum=s.Snum  JOIN curriculum cur ON c.Cid=cur.Cid WHERE cur.cname  like  ? and Gread <> -1 and c.snum = ?";
			String sqlLike = "%" +searchField+"%";
			ps = conn.prepareStatement(sql);
			ps.setString(1,sqlLike);
			ps.setInt(2,snum);
			//������ ִ�ж���sql���
//			ps.addBatch();
//			int[] batch = ps.executeBatch();
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Cname"));
				v.add(rs.getDouble("Gread")+"��");
				list.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * ��ѯ��ѡ�γ�
	 */
	@Override
	public List<Vector> selectcourse() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Vector> list =new ArrayList<Vector>();
		
		try {
			conn = DBUtils.getConnection();
			String sql="select t.Tname ,tc.cid ,cu.Cname, tc.capacity,cu.Credit from tcourese tc JOIN teacher t ON tc.Tid=t.Tid JOIN curriculum cu ON tc.cid=cu.cid WHERE tc.capacity>0;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector  v = new Vector();
				v.add(rs.getInt("Cid"));
				v.add(rs.getString("Cname"));
				v.add(rs.getString("Tname"));
				v.add(rs.getInt("Credit")+"��");
				v.add(rs.getInt("capacity")+"��");
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * ������ѡ�γ�
	 */
	@Override
	public List<Vector> SelectCourseName(String cnameFiled) {
		Connection conn=null;
		PreparedStatement ps=null;
		//�����
		ResultSet rs=null;
		List<Vector> list =new ArrayList<Vector>();
		try {
			//��������
			conn  = DBUtils.getConnection();
			String sql="select t.Tname ,tc.cid ,cu.Cname, tc.capacity,cu.Credit from tcourese tc JOIN teacher t ON tc.Tid=t.Tid JOIN curriculum cu ON tc.cid=cu.cid WHERE tc.capacity>0 and cu.Cname like ?";
			String sqlLike ='%'+cnameFiled+'%';
			ps = conn.prepareStatement(sql);
			ps.setString(1, sqlLike);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Vector  v = new Vector();
				v.add(rs.getInt("Cid"));
				v.add(rs.getString("Cname"));
				v.add(rs.getString("Tname"));
				v.add(rs.getInt("Credit")+"��");
				v.add(rs.getInt("capacity")+"��");
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * ִ��ѡ�β���
	 */
	@Override
	public int insertCourse(int cid, int tid,int id,int snum) {
		Connection conn=null;
		PreparedStatement ps= null;
		PreparedStatement ps1= null;
		try {
			conn = DBUtils.getConnection();
		//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
		//��һ������Ŀ�к��п�����Ҫִ�ж���SQL�����Ϊһ������
		//����һ��ִ�в��ɹ�,�ͻ�rollback()
		//��true��ʱ��������Զ��ύģʽ��false�ɽ��ø�ģʽ
		//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
			conn.setAutoCommit(false);
			String sql1="insert into  course (Cid,snum,Gread,create_time,update_time,Tid) values(?,?,?,?,?,?)";
			String sql2= "update tcourese set capacity=capacity-1 where id = ?";
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, cid);
			ps.setInt(2, snum);
			ps.setInt(3, -1); //���ѡ��Ĭ�ϳɼ�Ϊ-1
			ps.setObject(4, new Date());
			ps.setObject(5, new Date());
			ps.setInt(6, tid);
			int code = ps.executeUpdate();
			ps1 = conn.prepareStatement(sql2);
			ps1.setInt(1, id);
			int code1 = ps1.executeUpdate();
			//���û���쳣����ִ�д˶δ���  
		   //�ύ�������������ݿ����ύ����  
			conn.commit();
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
		return 200;
	}
	/**
	 * 	��ѯ�Ƿ�����ظ�ѡ��
	 */
	@Override
	public Course uniqueCourse(int cid, int snum) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Course course=null;
		try {
			conn  = DBUtils.getConnection();
			String sql="select * from  course WHERE cid=?  and snum=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, snum);
			rs = ps.executeQuery();
			while (rs.next()) {
				course = new  Course(rs.getInt("id"), rs.getInt("Cid"), rs.getInt("Snum"),
						rs.getDouble("Gread"), rs.getDate("create_time"), rs.getDate("update_time"),rs.getInt("Tid")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return course;
	}
	/**
	 * 	��ѯ�û��Լ���ѡ�γ�
	 */
	@Override
	public List<Vector> selectMycourse(int snum) {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Vector> list =	new ArrayList<Vector>();
		try {
			conn = DBUtils.getConnection();
			String sql="Select t.tname,cu.cname,cu.credit,c.cid from course c JOIN teacher t ON c.Tid = t.Tid JOIN curriculum cu ON c.Cid = cu.Cid WHERE c.Snum = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, snum);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getString("tname"));
				v.add(rs.getInt("credit")+"��");
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 	������ѡ��Ŀγ�
	 */
	@Override
	public List<Vector> seachCourseName(int snum,String cnameFiled) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Vector> list =new ArrayList<Vector>();
		try {
			conn  = DBUtils.getConnection();
			String sql="Select t.tname,cu.cname,cu.credit,c.cid from course c JOIN teacher t ON c.Tid = t.Tid JOIN curriculum cu ON c.Cid = cu.Cid WHERE c.Snum = ? and cname like ?";
			String sqlLike ='%'+cnameFiled+'%';
			ps = conn.prepareStatement(sql);
			ps.setInt(1, snum);
			ps.setString(2, sqlLike);
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("cid"));
				v.add(rs.getString("cname"));
				v.add(rs.getString("tname"));
				v.add(rs.getInt("credit")+"��");
				list.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * �޸�����
	 */
	@Override
	public int editPassWord(int snum, String md5NewPass) {
		Connection conn=null;
		PreparedStatement ps=null;
		int code=0;
		try {
			conn = DBUtils.getConnection();
			String sql="UPDATE student SET password = ? WHERE Snum= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, md5NewPass);
			ps.setInt(2, snum);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return code;
	}
	/**
	 * 	�˿�
	 */
	@Override
	public int RetReatCourse(int cid, int tid, int snum) {
		Connection conn=null;
		PreparedStatement ps= null;
		PreparedStatement ps1= null;
		try {
			conn = DBUtils.getConnection();
		//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
		//��һ������Ŀ�к��п�����Ҫִ�ж���SQL�����Ϊһ������
		//����һ��ִ�в��ɹ�,�ͻ�rollback()
		//��true��ʱ��������Զ��ύģʽ��false�ɽ��ø�ģʽ
		//conn.setAutoCommit()�Ĺ�����ÿִ��һ��SQL��䣬����Ϊһ�������ύ��
			conn.setAutoCommit(false);
			String sql1="update tcourese set capacity=capacity+1 where Tid = ? and cid= ?";
			String sql2= "DELETE  from course WHERE cid=? AND snum=? AND Tid = ?";
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, tid);
			ps.setInt(2, cid);
			int code = ps.executeUpdate();
			ps1 = conn.prepareStatement(sql2);
			ps1.setInt(1, cid);
			ps1.setInt(2, snum);
			ps1.setInt(3, tid);
			int code1 = ps1.executeUpdate();
			//���û���쳣����ִ�д˶δ���  
		   //�ύ�������������ݿ����ύ����  
			conn.commit();
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
		return 200;
	}
	/**
	 * �޸�����
	 */
	@Override
	public int editPerson(int snum, String sname, String phone, int age) {
		Connection conn=null;
		PreparedStatement ps= null;
		try {
			conn = DBUtils.getConnection();
			String sql1="update student set Sname= ? , phone= ? ,age =? where Snum =?";
			ps = conn.prepareStatement(sql1);
			ps.setString(1, sname);
			ps.setString(2, phone);
			ps.setInt(3, age);
			ps.setInt(4, snum);
			int code = ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return 200;
	}
}

