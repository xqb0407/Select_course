package xyz.herther.eneity;
/**
* @author 作者 :Herther
* @version 创建时间：2020-12-19 22:45:16
* 类说明
*/

import java.util.Date;

public class Course {
	private int id;
	private int Cid;
	private int Snum;
	private double Gread;
	private Date createTime;
	private Date updateTime;
	private int Tid;
	@Override
	public String toString() {
		return "course [id=" + id + ", Cid=" + Cid + ", Snum=" + Snum + ", Gread=" + Gread + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", Tid=" + Tid + "]";
	}
	public Course() {
		super();
	}
	
	public Course(int id, int cid, int snum, double gread, Date createTime, Date updateTime, int tid) {
		super();
		this.id = id;
		Cid = cid;
		Snum = snum;
		Gread = gread;
		this.createTime = createTime;
		this.updateTime = updateTime;
		Tid = tid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public int getSnum() {
		return Snum;
	}
	public void setSnum(int snum) {
		Snum = snum;
	}
	public double getGread() {
		return Gread;
	}
	public void setGread(double gread) {
		Gread = gread;
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
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	
	
	
}

