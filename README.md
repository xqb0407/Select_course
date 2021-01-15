# 一、实践项目名称

学生选课系统

# 二、实践目的及任务要求

1、实践目的

通过对java语言、sql数据库的应用以及sql语言的复习和锻炼，并且通过使用MyEclipse开发平台设计管理项目，以达到充分熟悉开发平台及应用设计。同时掌握并实践软件项目设计规范及其开发流程:需求分析、概要设计、详细设计、代码编写等，以便提前适应软件公司开发流程、环境和工作要求。

2、任务要求

使用图形用户界面用数据库建立1或2个表。（不限使用哪种数据库）能连接数据库并实现学生选课管理相关功能。

# 三、实践环境

1、硬件环境，硬件要求能运行windows10操作系统的微机系统。Java程序设计语言及Mysql数据库语言，eclipse集成开发环境和Navicat图形化工具。

2、软件环境集成开发环境: Eclipse，Navicat 

  数据库语言: SQL  

# 四、实践内容

**1****、程序流程图**

  **（1）E-R图**

<img src="https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image002.jpg" alt="img" style="zoom:80%;" />

**2****、数据字典**

  **（1）数据库设计**

  a.表student

| 表名    | 字段名      | 数据类型    | 备注     |
| ------- | ----------- | ----------- | -------- |
| student | Snum        | int(11)     | 学号     |
| student | Sname       | varchar(25) | 姓名     |
| student | password    | varchar(50) | 密码     |
| student | dept        | varchar(25) | 系别     |
| student | age         | int(100)    | 年龄     |
| student | phone       | varchar(25) |          |
| student | class_grade | varchar(25) | 班级     |
| student | create_time | datetime    | 创建时间 |
| student | update_time | datetime    | 更新时间 |

​    

  b.表tcourese

| 表名     | 字段名      | 数据类型 | 备注 |
| -------- | ----------- | -------- | ---- |
| tcourese | id          | int(11)  |      |
| tcourese | Tid         | int(11)  |      |
| tcourese | Cid         | int(11)  |      |
| tcourese | create_time | datetime |      |
| tcourese | update_time | datetime |      |
| tcourese | capacity    | int(11)  |      |

 

  c.表teacher

| 表名    | 字段名      | 数据类型    | 备注     |
| ------- | ----------- | ----------- | -------- |
| teacher | Tid         | int(11)     | 职工号   |
| teacher | Tname       | varchar(25) | 姓名     |
| teacher | sex         | bigint(20)  | 性别     |
| teacher | password    | varchar(50) | 密码     |
| teacher | phone       | varchar(13) | 手机号   |
| teacher | brace       | varchar(10) | 职称     |
| teacher | create_time | datetime    | 创建时间 |
| teacher | update_time | datetime    | 更新时间 |

 

  d.表course

| 表名   | 字段名      | 数据类型 | 备注           |
| ------ | ----------- | -------- | -------------- |
| course | id          | int(11)  | id             |
| course | Cid         | int(11)  | 课程号         |
| course | Snum        | int(11)  | 学号           |
| course | Gread       | double   | 成绩 默认为－1 |
| course | create_time | datetime |                |
| course | update_time | datetime |                |
| course | Tid         | int(11)  | 老师ID         |

 

  e.表curriculum

| 表名       | 字段名      | 数据类型     | 备注     |
| ---------- | ----------- | ------------ | -------- |
| curriculum | Cid         | int(11)      | 课程号   |
| curriculum | Cname       | varchar(255) | 课程名称 |
| curriculum | Credit      | double       | 学分     |
| curriculum | create_time | datetime     | 创建时间 |
| curriculum | update_time | datetime     | 更新时间 |

  

  f.表log4j

| 表名  | 字段名  | 数据类型      | 备注 |
| ----- | ------- | ------------- | ---- |
| log4j | id      | int(11)       |      |
| log4j | Message | varchar(8000) |      |

 

**（2）功能流程图**

![img](C:/Users/Herther/AppData/Local/Temp/msohtmlclip1/01/clip_image006.jpg)  a.用户端

  

b.教师端

 

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](C:/Users/Herther/AppData/Local/Temp/msohtmlclip1/01/clip_image008.jpg) |





  **（3）各层类图**



 

  a．持久层类图

![img](https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image008.jpg)


b．实体模型层类图

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image011.gif) |





c.业务逻辑层类图

![img](https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image015.jpg)

d.工具类

![img](https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image017.jpg)

 

**（2）****数据库连接**

  代码如下：

```properties
  driverClassName=com.mysql.jdbc.Driver  
  url=jdbc:mysql://127.0.0.1:3306/Select_course?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT  
  username=root  
  password=123456  
  initialSize=5  
  maxActive=10    
  maxWait=3000  
```

 

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image019.gif) |


  **（3）日志配置文件**

![](https://cdn.jsdelivr.net/gh/xqb0407/imgurl/img/clip_image019.gif)

  **（4）设计模式**

使用J2EE多层分布式的应用模型，Mvc（Model Controller View）模式这个多层通常通过三层或四层来实现。

 **（5）项目包结构**

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](C:/Users/Herther/AppData/Local/Temp/msohtmlclip1/01/clip_image023.gif) |



**3、程序功能实现**

  a.登录时，凡是账号密码未填写、输入错误账号密码或验证码错误都会提出错误提示框。在填写好账号密码后，会读取数据库里数据库表，并查询其输入是否存在，若无误，则登录到用户界面，部分代码如下：

```java
if(StringUtils.isEmpty(username)) {
			JOptionPane.showMessageDialog(null,"用户名不能为空");
		}else if(StringUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null,"密码不能为空");
			//验证验证码是否为空
		}else if(StringUtils.isEmpty(code1)){
			JOptionPane.showMessageDialog(null,"验证码不能为空");
		}else if(!code.equals(code1)) {
			//验证验证码是正确
			JOptionPane.showMessageDialog(null,"验证码输入错误");
		}else {
			md5 = SecureUtil.md5(password); // 把用户输入的密码进行加密处理
		}
		int usernameInt = Integer.parseInt(username); 
		switch (identity) {
		case 0:

```

 

  b.用户界面能菜单栏有4个一级菜单，基础操作、课程操作、用户操作、关于我，都能添加、修改、删除数据，分别操作数据库里的course表、student表、tcourese表(以教师端为例)。

![img](C:/Users/Herther/AppData/Local/Temp/msohtmlclip1/01/clip_image025.jpg)

 

c．教师可通过搜索课程名搜索对应课程，或点击空白处即可显示所有课程，还可修改课程功能修改课程信息（学分、人数、课程名）。

部分代码如下：

```java
public int editCurriculum(int tid,int cid, double credit, String cname, int capacity) {
		Connection conn=null;
		PreparedStatement ps= null;
		PreparedStatement ps1= null;
		int num=0;
		try {
			conn = DBUtils.getConnection();
			//conn.setAutoCommit()的功能是每执行一条SQL语句，就作为一次事务提交。
			//但一般在项目中很有可能需要执行多条SQL语句作为一个事务。
			//若有一个执行不成功,就会rollback()
			//当true的时候可启用自动提交模式，false可禁用该模式
			//conn.setAutoCommit()的功能是每执行一条SQL语句，就作为一次事务提交。
			conn.setAutoCommit(false);
			String sql1="update   curriculum SET Cname=?, credit=?,update_time=?  where cid = ?";
			String sql2= "update  tcourese SET update_time=?,capacity=? where tid = ? and cid= ?";
			ps = conn.prepareStatement(sql1);
			ps.setString(1, cname);
			ps.setDouble(2, credit); 
			ps.setObject(3, new Date());
			ps.setInt(4, cid);
			int code = ps.executeUpdate();
			ps1 = conn.prepareStatement(sql2);
			ps1.setObject(1, new Date());
			ps1.setInt(2, capacity);
			ps1.setInt(3, tid);
			ps1.setInt(4, cid);
			int code1 = ps1.executeUpdate();
			//如果没有异常，则执行此段代码  
		   //提交事务，真正向数据库中提交数据  
			conn.commit();
			if(code!=code1) {
				num=0;
			}else if(code1==0&&code==0) {
				num = 0;
			}else {
				num=200;
			}
			
		} catch (SQLException e) {
				try {
					//事务回滚
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
		}finally {
			DBUtils.close(ps, conn);
		}
		return num;
	}

```

 

修改课程功能截图：

![img](C:/Users/Herther/AppData/Local/Temp/msohtmlclip1/01/clip_image027.jpg)

 

d.学生选课功能

学生可通过检索课程搜索对应课程，部分代码如下：



 

```java
//开始选课
	protected void startCourse(ActionEvent event) {
		int selectedRow = table.getSelectedRow();	//获取选中行
		//System.out.println("selectedRow:"+selectedRow);
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null,"没有选中任何数据");
		}else {
			//获取选中行的第0列的值，并且转成int 类型 Cid
			int cid =Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 0)));
			//获取选中行的第2列的值,并且强转String类型 Tname
			String Tname =String.valueOf(table.getValueAt(selectedRow, 2));
			int code =studentService.insertCourse(cid,Tname,student.getSnum());
			if(code==500) {
				JOptionPane.showMessageDialog(null,"不能重复选课");
			}else if(code==200){
				JOptionPane.showMessageDialog(null,"选课成功");
			}else {
				JOptionPane.showMessageDialog(null,"选课失败");
			}
		}
	}

```

开始选课界面（学生端）

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](C:/Users/Herther/AppData/Local/Temp/msohtmlclip1/01/clip_image029.jpg) |