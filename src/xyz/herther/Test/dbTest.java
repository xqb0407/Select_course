package xyz.herther.Test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import xyz.herther.utils.DBUtils;
/**
 * 	数据库测试类
 * @author 34675
 *
 */
public class dbTest {	

	
	/**
	* @author  作者 E-mail:34675628@qq.com
	* @version 创建时间：2020-12-2 21:49:29
	*   类说明:       测试连接  
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
