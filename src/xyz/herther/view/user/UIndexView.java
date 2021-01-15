package xyz.herther.view.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import xyz.herther.eneity.Student;
import xyz.herther.view.LoginView;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UIndexView extends JFrame {

	private JPanel contentPane;
	
	private JDesktopPane desktopPane;
	static Student student ;
	private JLabel usernameField;
	
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
					UIndexView frame = new UIndexView();
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
	public UIndexView() {
		setTitle("\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF-\u5B66\u751F\u7AEF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UIndexView.class.getResource("/xyz/herther/img/bottom-logo111.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178,190,195));
		setBounds(200, 100, 1100, 700);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 248, 255));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("\u57FA\u672C\u64CD\u4F5C");
		mnNewMenu_1.setBackground(new Color(240, 248, 255));
		mnNewMenu_1.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/cz.png")));
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 19));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6210\u7EE9\u67E5\u8BE2");
		mntmNewMenuItem_3.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/blog.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SelectGrade(event);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 19));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u9009\u8BFE\u76F8\u5173");
		mnNewMenu_2.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/retReat.png")));
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 19));
		mnNewMenu_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5F00\u59CB\u9009\u8BFE");
		mntmNewMenuItem_7.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/cha.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//开始选课
				SelectCourse(event);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u6211\u7684\u9009\u8BFE");
		mntmNewMenuItem_4.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/grade.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//查看我的选课
				mySelectCourse(event);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u9000\u9009\u8BFE\u7A0B");
		mntmNewMenuItem_6.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/Info.png")));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//打开退选页面
				showRetreat(event);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu.setBackground(new Color(240, 248, 255));
		mnNewMenu.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/setting.png")));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 19));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_3 = new JMenu("\u4FEE\u6539\u4FE1\u606F");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 19));
		mnNewMenu_3.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/edit.png")));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//打开修改密码窗口
				editPass(event);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_2.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/uppass.png")));
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u8D44\u6599");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//调出修改个人资料的页面函数
				showEditPersonDate(event);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_1.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/uplzz.png")));
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//退出
				SignOut(event);
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/logout.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//调用关于我的界面函数
				showAbout(event);
			}
		});
		mnNewMenu_4.setBackground(new Color(240, 248, 255));
		mnNewMenu_4.setIcon(new ImageIcon(UIndexView.class.getResource("/xyz/herther/img/about.png")));
		mnNewMenu_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 19));
		menuBar.add(mnNewMenu_4);
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblNewLabel.setBounds(48, 21, 72, 29);
		desktopPane.add(lblNewLabel);
		
		usernameField = new JLabel("Herther");
		usernameField.setFont(new Font("宋体", Font.BOLD, 28));
		usernameField.setBounds(115, 22, 123, 29);
		desktopPane.add(usernameField);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u7CFB\u7EDF");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(241, 22, 108, 29);
		desktopPane.add(lblNewLabel_2);
		//窗口居中
		this.setLocationRelativeTo(null);

		
	}
	/**
	 * 	打开退选课程
	 * @param event
	 */
	protected void showRetreat(ActionEvent event) {
		UretReatInternalFrameView uretReatInternalFrameView = new UretReatInternalFrameView();
		uretReatInternalFrameView.setLocation(400, 45);
		uretReatInternalFrameView.setVisible(true);
		uretReatInternalFrameView.getValue(student);
		desktopPane.add(uretReatInternalFrameView);
	}

	/**
	 * 	查看我的选课
	 * @param event
	 */
	protected void mySelectCourse(ActionEvent event) {
		UmyCourseInternalFrameView umyCourseInternalFrameView = new UmyCourseInternalFrameView();
		umyCourseInternalFrameView.setLocation(400, 45);
		umyCourseInternalFrameView.setVisible(true);
		umyCourseInternalFrameView.getValue(student);
		desktopPane.add(umyCourseInternalFrameView);
	}

	/**
	 * 	开始选课
	 * @param event
	 */
	protected void SelectCourse(ActionEvent event) {
		UcourseInternalFrameView ucourseInternalFrameView = new UcourseInternalFrameView();
		ucourseInternalFrameView.setLocation(400, 45);
		ucourseInternalFrameView.setVisible(true);
		ucourseInternalFrameView.getvlaue(student);
		desktopPane.add(ucourseInternalFrameView);
	}

	/**
	 * 	调出成绩查询
	 * @param event
	 */
	protected void SelectGrade(ActionEvent event) {
		UGradeInternalFrame uGradeInternalFrame = new UGradeInternalFrame();
		uGradeInternalFrame.setVisible(true);
		uGradeInternalFrame.setLocation(400, 45);
//		System.out.println("student:"+student.toString());
		uGradeInternalFrame.getValue(student);
		desktopPane.add(uGradeInternalFrame);
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

	//修改个人资料
	protected void showEditPersonDate(ActionEvent event) {
		UeditPersonInternalFrame editPersonInternalFrame = new UeditPersonInternalFrame();
		editPersonInternalFrame.setVisible(true);
		editPersonInternalFrame.getValue(student);
		desktopPane.add(editPersonInternalFrame);
	}

	//查看关于我
	protected void showAbout(MouseEvent event) {
		AboutInternalFrame aboutview = new AboutInternalFrame();
		aboutview.setVisible(true);
		aboutview.setLocation(530, 45);
		desktopPane.add(aboutview);
	}

	//修改密码窗口
	protected void editPass(ActionEvent event) {
		UeditPassInternalFrame editpassview = new UeditPassInternalFrame(); //打开注册窗口并显示
		editpassview.setVisible(true);
		editpassview.setLocation(530, 45);
		editpassview.getValue(student);
		desktopPane.add(editpassview);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	//传入值进行操作
	public void getValues(Student  student) {
		usernameField.setText(new String(student.getSname()));
		this.student  = student;
	}
	
}
