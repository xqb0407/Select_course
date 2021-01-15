package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;
import xyz.herther.view.LoginView;
import xyz.herther.view.user.AboutInternalFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-10 19:46:10
* 类说明
*/
public class TindexView extends JFrame {

	//注入业务逻辑层
	TeacherService  teacherService =new TeacherServiceImpl();
	private JLabel usernameField;
	private Teacher teacher;
	
	
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
	    {
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	    	
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TindexView frame = new TindexView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TindexView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TindexView.class.getResource("/xyz/herther/img/bottom-logo111.png")));
		setTitle("\u9009\u8BFE\u7CFB\u7EDF\u2014\u6559\u5E08\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u64CD\u4F5C");
		mnNewMenu.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/cha.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_4 = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		mnNewMenu_4.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/Info.png")));
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u4FE1\u606F\u66F4\u65B0");
		mntmNewMenuItem_4.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/edit.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//个人信息
				PersonInfo(event);
			}
		});
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_15.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/ofter.png")));
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//修改信息
				editPersonInfo(event);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_15);
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_5.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/logout.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SignOut(event);
			} 
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BFE\u7A0B\u64CD\u4F5C");
		mnNewMenu_1.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/add.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_6 = new JMenu("\u6210\u7EE9\u6A21\u5757");
		mnNewMenu_6.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/grade.png")));
		mnNewMenu_1.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6DFB\u52A0\u6210\u7EE9");
		mntmNewMenuItem_2.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/add.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//给学生添加成绩
				addGrade(event);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5220\u9664\u6210\u7EE9");
		mntmNewMenuItem_3.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/del.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//删除成绩
				deletGrade(event);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("\u4FEE\u6539\u6210\u7EE9");
		mntmNewMenuItem_13.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/uplzz.png")));
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//修改成绩
				editGrade(event);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("\u67E5\u8BE2\u6210\u7EE9");
		mntmNewMenuItem_14.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/seach.png")));
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//查看学生成绩
				showGrade(event);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_5 = new JMenu("\u8BFE\u7A0B\u6A21\u5757");
		mnNewMenu_5.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/blog.png")));
		mnNewMenu_1.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		mntmNewMenuItem_9.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/add.png")));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addCrriCulum(event);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u4FEE\u6539\u8BFE\u7A0B");
		mntmNewMenuItem_10.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/ofter.png")));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				editCurriculum(event);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u5220\u9664\u8BFE\u7A0B");
		mntmNewMenuItem_11.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/del.png")));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//删除课程
				showDeleteCurriculum(event);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E\u6211");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//关于我
				AboutLoaction(event);
			}
		});
		
		JMenu mnNewMenu_3 = new JMenu("\u7528\u6237\u64CD\u4F5C");
		mnNewMenu_3.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/cha.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6DFB\u52A0\u5B66\u751F");
		mntmNewMenuItem_1.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/add.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//打开查看学生
				ShowAddStudent(event);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u7F16\u8F91\u5B66\u751F");
		mntmNewMenuItem_8.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/edit.png")));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//编辑学生
				showEditStudent(event);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		mnNewMenu_2.setIcon(new ImageIcon(TindexView.class.getResource("/xyz/herther/img/about.png")));
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(176, 196, 222));
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\uFF1A");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblNewLabel.setBounds(70, 42, 120, 29);
		desktopPane.add(lblNewLabel);
		
		usernameField = new JLabel("");
		usernameField.setForeground(new Color(0, 0, 0));
		usernameField.setFont(new Font("宋体", Font.PLAIN, 27));
		usernameField.setBounds(141, 42, 120, 29);
		desktopPane.add(usernameField);
		
		JLabel lblNewLabel_1 = new JLabel("\u767B\u5F55\u7CFB\u7EDF");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(245, 42, 108, 29);
		desktopPane.add(lblNewLabel_1);
		
		//窗口居中
		this.setLocationRelativeTo(null);
	}
	//打开编辑学生信息
	protected void showEditStudent(ActionEvent event) {
		TeditStudentInternalFrame teditStudentInternalFrame = new TeditStudentInternalFrame();
		teditStudentInternalFrame.setLocation(400, 30);
		teditStudentInternalFrame.getValue(teacher);
		teditStudentInternalFrame.setVisible(true);
		desktopPane.add(teditStudentInternalFrame);
	}

	//打开添加课程
	protected void ShowAddStudent(ActionEvent event) {
		TaddStudentInternalFrame taddStudentInternalFrame= new TaddStudentInternalFrame();
		taddStudentInternalFrame.setLocation(450, 45);
		taddStudentInternalFrame.getValue(teacher);
		taddStudentInternalFrame.setVisible(true);
		desktopPane.add(taddStudentInternalFrame);
	}

	//删除课程
	protected void showDeleteCurriculum(ActionEvent event) {
		TDelCurriculumInternalFrame tDelCurriculumInternalFrame= new TDelCurriculumInternalFrame();
		tDelCurriculumInternalFrame.setLocation(450, 45);
		tDelCurriculumInternalFrame.getValue(teacher);
		tDelCurriculumInternalFrame.setVisible(true);
		desktopPane.add(tDelCurriculumInternalFrame);
	}

	//修改课程
	protected void editCurriculum(ActionEvent event) {
		TeditCurriculumlnternalFrame teditCurriculumlnternalFrame=new TeditCurriculumlnternalFrame();
		teditCurriculumlnternalFrame.setLocation(450, 45);
		teditCurriculumlnternalFrame.getValue(teacher);
		teditCurriculumlnternalFrame.setVisible(true);
		desktopPane.add(teditCurriculumlnternalFrame);
	}

	/**
	 * 	查看成绩
	 * @param event
	 */
	protected void showGrade(ActionEvent event) {
		TshowGradelnternalFrame tshowGradelnternalFrame = new  TshowGradelnternalFrame();
		tshowGradelnternalFrame.setVisible(true);
		tshowGradelnternalFrame.setLocation(450, 45);
		tshowGradelnternalFrame.getValue(teacher);
		desktopPane.add(tshowGradelnternalFrame);
	}

	/**
	  * 退出系统
	 * @param event
	 */
	protected void SignOut(ActionEvent event) {
		int dialog = JOptionPane.showConfirmDialog(null,"是否退出","退出",JOptionPane.YES_NO_OPTION);
		if(dialog==0) {
			dispose();
			LoginView login = new LoginView();
			login.setVisible(true);
		}
	}
	
	
	/**
	 *	 修改成绩
	 * @param event
	 */
	protected void editGrade(ActionEvent event) {
		TeditGradelnternalFrame teditGradelnternalFrame = new  TeditGradelnternalFrame();
		teditGradelnternalFrame.getValue(teacher);
		teditGradelnternalFrame.setVisible(true);
		teditGradelnternalFrame.setLocation(450, 45);
		desktopPane.add(teditGradelnternalFrame);
	}

	/**
	 *	 删除成绩
	 * @param event
	 */
	protected void deletGrade(ActionEvent event) {
		TdelGradelnternalFrame tdelGradelnternalFrame = new  TdelGradelnternalFrame();
		tdelGradelnternalFrame.setVisible(true);
		tdelGradelnternalFrame.setLocation(450, 45);
		tdelGradelnternalFrame.getValue(teacher);
		desktopPane.add(tdelGradelnternalFrame);
	}

	/**
	 * 	添加成绩
	 * @param event
	 */
	protected void addGrade(ActionEvent event) {
		TaddGradelnternalFrame taddGradelnternalFrame = new  TaddGradelnternalFrame();
		taddGradelnternalFrame.setVisible(true);
		taddGradelnternalFrame.setLocation(450, 45);
		taddGradelnternalFrame.getValue(teacher);
		desktopPane.add(taddGradelnternalFrame);
	}

	/**
	 * 	查看信息
	 * @param event
	 */
	protected void editPersonInfo(ActionEvent event) {
		
		TeditPassInfolnternalFrame teditPersonInfolnternalFramenew = new  TeditPassInfolnternalFrame();
		teditPersonInfolnternalFramenew.setVisible(true);
		teditPersonInfolnternalFramenew.setLocation(450, 45);
		teditPersonInfolnternalFramenew.getValue(teacher);
		desktopPane.add(teditPersonInfolnternalFramenew);
	}

	/**
	 * 	添加课程页面
	 * @param event
	 */
	protected void addCrriCulum(ActionEvent event) {
		TaddCurriculumInternalFrame taddCourseInternalFrame = new TaddCurriculumInternalFrame();
		taddCourseInternalFrame.setVisible(true);
		taddCourseInternalFrame.getValue(teacher);
		taddCourseInternalFrame.setLocation(450, 45);
		desktopPane.add(taddCourseInternalFrame);
	}

	/**
	 * 	查看个人新消息
	 * @param event
	 */
	protected void PersonInfo(ActionEvent event) {
//		int Tid=1249511835;
		Teacher teacher =teacherService.SelectPersonInfo(this.teacher.getTid());
//		if(teacher==null) {
//			JOptionPane.showMessageDialog(null, "系统错误");
//		}else {
			TPersonInfoInternalFrame tPersonInfoInternalFrame = new TPersonInfoInternalFrame();
			tPersonInfoInternalFrame.SetTeacherInfo(teacher);
			tPersonInfoInternalFrame.setLocation(450, 45);
			tPersonInfoInternalFrame.setVisible(true);
			desktopPane.add(tPersonInfoInternalFrame);
//		}
	}
	/**
	 * 	关于我
	 * @param event
	 */
	protected void AboutLoaction(MouseEvent event) {
		AboutInternalFrame aboutFrame = new AboutInternalFrame();
		aboutFrame.setVisible(true);
		aboutFrame.setLocation(530, 45);
		desktopPane.add(aboutFrame);	
	}
	//获取老师信息
	public void getValues(Teacher teacher) {
		this.teacher=teacher;
		usernameField.setText(this.teacher.getTname());
	}
}

