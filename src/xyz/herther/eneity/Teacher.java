package xyz.herther.eneity;
/**
* @author 作者 :Herther
* @version 创建时间：2020-12-17 23:26:43
* 类说明
*/

import java.util.Date;

public class Teacher {
	
	private int Tid;
	private String Tname;
	private Long sex;
	private String password;
	private String phone;
	private String brace;
	private Date createTime;
	private Date updateTime;
	public Teacher(int tid, String tname, Long sex, String password, String phone, String brace, Date createTime,
			Date updateTime) {
		super();
		Tid = tid;
		Tname = tname;
		this.sex = sex;
		this.password = password;
		this.phone = phone;
		this.brace = brace;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [Tid=" + Tid + ", Tname=" + Tname + ", sex=" + sex + ", password=" + password + ", phone="
				+ phone + ", brace=" + brace + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public Long getSex() {
		return sex;
	}
	public void setSex(Long sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBrace() {
		return brace;
	}
	public void setBrace(String brace) {
		this.brace = brace;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
}

