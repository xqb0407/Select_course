package xyz.herther.Test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import xyz.herther.utils.DBUtils;
/**
 * 	���ݿ������
 * @author 34675
 *
 */
public class dbTest {	

	
	/**
	* @author  ���� E-mail:34675628@qq.com
	* @version ����ʱ�䣺2020-12-2 21:49:29
	*   ��˵��:       ��������  
	 */
	@Test
	public void dbUtils() {
		Connection conn = null;
		try {
			  conn = DBUtils.getConnection();
			  System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
		
	}
}
