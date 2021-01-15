package xyz.herther.utils;
/**
 * 	封装一个状态码的工具类
 * @author 34675
 *	1xx：指示信息--表示请求已接收，继续处理
 *	2xx：成功--表示请求已被成功接收、理解、接受
 *	3xx：重定向--要完成请求必须进行更进一步的操作
 *	4xx：客户端错误--请求有语法错误或请求无法实现
 *	5xx：服务器端错误--服务器未能实现合法的请求
 */
public class StateUtils {
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public StateUtils(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public void build(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	public void success(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	public StateUtils() {
		super();
	}
	
}
