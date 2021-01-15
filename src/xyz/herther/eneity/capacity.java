package xyz.herther.eneity;
/**
* @author 作者 :Herther
* @version 创建时间：2020-12-14 22:49:19
* 类说明
*/
public class capacity {
	
	
	private int id;
	private int Tid;
	private int cid;
	private int caoacity;
	public capacity(int id, int tid, int cid, int caoacity) {
		super();
		this.id = id;
		Tid = tid;
		this.cid = cid;
		this.caoacity = caoacity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCaoacity() {
		return caoacity;
	}
	public void setCaoacity(int caoacity) {
		this.caoacity = caoacity;
	}
	@Override
	public String toString() {
		return "capacity [id=" + id + ", Tid=" + Tid + ", cid=" + cid + ", caoacity=" + caoacity + "]";
	}
	public capacity() {
		super();
	}
	
	
	
	
	
}

