package xyz.herther.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.hutool.db.DbUtil;
import xyz.herther.dao.LoginDao;
import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;
import xyz.herther.utils.DBUtils;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-18 19:31:48
* ��˵��
*/
public class LoginDaoImpl implements LoginDao {
	/**
	 * 	ѧ����¼
	 */
	@Override
	public Student StudentToLoginSevice(int username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student =null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("SELECT * FROM Student where Snum = ? ");
			ps.setInt(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				student =
						new Student(rs.getInt("Snum"),rs.getString("Sname"),
								rs.getString("password"),rs.getString("dept"),
								rs.getInt("age"),rs.getString("phone"),rs.getString("class_grade"),
								rs.getDate("create_time"),rs.getDate("update_time"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return student;
	}
	/**
	 * 	��ʦ��¼
	 */
	@Override
	public Teacher TeacherToLoginSevice(int username) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Teacher teacher =null;
		try {
			conn = DBUtils.getConnection();
			String sql="select *from teacher where Tid =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				teacher = new Teacher(rs.getInt("Tid"), 
						rs.getString("Tname"), rs.getLong("sex"),
						rs.getString("password"), rs.getString("phone"), rs.getString("brace"), 
						rs.getDate("create_time"), rs.getDate("update_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		
		return teacher;
	}
}

