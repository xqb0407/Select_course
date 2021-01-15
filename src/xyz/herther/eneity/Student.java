package xyz.herther.eneity;

import java.util.Date;
/** 
   *  学生实体类
 * @author 34675
 * 2020/12/2
 */
public class Student {
	private int Snum;
	private String Sname;
	private String password;
	private String dept;
	private int age;
	private String phone;
	private String classGradel;
	private Date createTime;
	private Date updateTime;
	
	public Student(int snum, String sname, String password, String dept, int age, String phone, String classGradel,
			Date createTime, Date updateTime) {
		super();
		Snum = snum;
		Sname = sname;
		this.password = password;
		this.dept = dept;
		this.age = age;
		this.phone = phone;
		this.classGradel = classGradel;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	public Student() {
		super();
	}
	public int getSnum() {
		return Snum;
	}
	public void setSnum(int snum) {
		Snum = snum;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClassGradel() {
		return classGradel;
	}
	public void setClassGradel(String classGradel) {
		this.classGradel = classGradel;
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
	
	@Override
	public String toString() {
		return "Student [Snum=" + Snum + ", Sname=" + Sname + ", password=" + password + ", dept=" + dept + ", age="
				+ age + ", phone=" + phone + ", classGradel=" + classGradel + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
}
