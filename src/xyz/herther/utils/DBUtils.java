package xyz.herther.utils;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtils {
	 //��Դ�ļ�
	private static DataSource dataSource;
    /**
	   * �ļ���ȡ����ִ��һ�Σ�ʹ�þ�̬�����
	 */
    static {  
           
			try {
				 //������Դ�ļ�
	            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
	            Properties p=new Properties();
				if(in == null) {
	                throw new FileNotFoundException("�����ļ�δ�ҵ�");
	            }
				p.load(in); 
				dataSource = DruidDataSourceFactory.createDataSource(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
           
    }
     
    /**
           * ��ȡ���ݿ�����
     * @return Connection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    /**
           * �ر�io��Դ
     * @param io
     */
    public static void closeFile(Closeable ... io) {
        for(Closeable temp : io) {
            if(temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    System.out.println("�ļ��ر�ʧ��");
                    e.printStackTrace();
                }
            }
        }
    }
     /**
      *	 ��������Դ����
      * @return
      */
    public static DataSource getDataSource() {
    	return dataSource;
    }
    
    
    //�ر�JDBC��Դ  ע��˳��
    public static void close(ResultSet rs,Statement ps,Connection conn) {
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    public static void close(Statement ps,Connection conn){
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    public static void close(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
