package xyz.herther.utils;
/**
 * 	��װһ��״̬��Ĺ�����
 * @author 34675
 *	1xx��ָʾ��Ϣ--��ʾ�����ѽ��գ���������
 *	2xx���ɹ�--��ʾ�����ѱ��ɹ����ա���⡢����
 *	3xx���ض���--Ҫ������������и���һ���Ĳ���
 *	4xx���ͻ��˴���--�������﷨����������޷�ʵ��
 *	5xx���������˴���--������δ��ʵ�ֺϷ�������
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
