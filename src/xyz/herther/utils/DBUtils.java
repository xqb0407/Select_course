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
	 //资源文件
	private static DataSource dataSource;
    /**
	   * 文件读取，会执行一次，使用静态代码块
	 */
    static {  
           
			try {
				 //加载资源文件
	            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
	            Properties p=new Properties();
				if(in == null) {
	                throw new FileNotFoundException("配置文件未找到");
	            }
				p.load(in); 
				dataSource = DruidDataSourceFactory.createDataSource(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
           
    }
     
    /**
           * 获取数据库连接
     * @return Connection
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    /**
           * 关闭io资源
     * @param io
     */
    public static void closeFile(Closeable ... io) {
        for(Closeable temp : io) {
            if(temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    System.out.println("文件关闭失败");
                    e.printStackTrace();
                }
            }
        }
    }
     /**
      *	 返回数据源对象
      * @return
      */
    public static DataSource getDataSource() {
    	return dataSource;
    }
    
    
    //关闭JDBC资源  注意顺序
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
