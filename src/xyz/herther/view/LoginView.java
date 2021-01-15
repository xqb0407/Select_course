package xyz.herther.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.crypto.SecureUtil;
import xyz.herther.eneity.Student;
import xyz.herther.eneity.Teacher;
import xyz.herther.service.LoginService;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.LoginServiceImpl;
import xyz.herther.service.impl.StudentServiceImpl;
import xyz.herther.utils.StateUtils;
import xyz.herther.utils.StringUtils;
import xyz.herther.view.teacher.TindexView;
import xyz.herther.view.user.UIndexView;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField veriField;
	private JPasswordField password;
	private ShearCaptcha lineCaptcha; //验证码
	private CaptchaUtil captchaUtil = new CaptchaUtil();//验证码工具类
	private int shenfen;
	private ImageIcon icon;
	private JLabel lblNewLabel_2;
	
	
	//注入登录 业务层
	 LoginService loginSevice = new LoginServiceImpl();
	
	
	
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
					LoginView frame = new LoginView();
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
	public LoginView() {
		setTitle("选课系统-登录");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/xyz/herther/img/bottom-logo111.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178,190,195));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("选课系统-登录");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 36));
		
		JLabel lblNewLabel_1 = new JLabel("账号：");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/xyz/herther/img/user.png")));
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 23));
		
		JLabel lblNewLabel_1_1 = new JLabel("密码：");
		lblNewLabel_1_1.setIcon(new ImageIcon(LoginView.class.getResource("/xyz/herther/img/pass.png")));
		lblNewLabel_1_1.setFont(new Font("黑体", Font.BOLD, 23));
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.BOLD, 20));
		username.setColumns(10);
		
		veriField = new JTextField();
		veriField.setFont(new Font("宋体", Font.BOLD, 20));
		veriField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("验证：");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(LoginView.class.getResource("/xyz/herther/img/yzm.png")));
		lblNewLabel_1_1_1.setFont(new Font("黑体", Font.BOLD, 23));
		password = new JPasswordField();
		JComboBox comboBox = new JComboBox();
		JButton btnNewButton = new JButton("登 录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//获取选中的值
				shenfen =comboBox.getSelectedIndex();
				StudenttoLogig(event);  //登录
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/xyz/herther/img/login.png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		
		
		comboBox.setFont(new Font("宋体", Font.BOLD, 23));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"学生", "教师"}));
		
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				versImg();
				lblNewLabel_2.setIcon(icon);
			}
		});
		
		
//		lineCaptcha=captchaUtil.createLineCaptcha(106,34);
//		System.out.println(lineCaptcha.getCode());
//		BufferedImage image2 = lineCaptcha.getImage();
//		ImageIcon icon = new ImageIcon(image2);
		versImg();
		lblNewLabel_2.setIcon(icon);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(139)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1))
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(veriField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(6)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
								.addComponent(password, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
							.addGap(123))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_1)
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(username, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(veriField, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(162))
		);
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(106, 34);
		BufferedImage image = captcha.getImage();
		contentPane.setLayout(gl_contentPane);
		//窗口居中
		this.setLocationRelativeTo(null);
	}
	/**
	  * 学生端登录方法
	 */

	protected void StudenttoLogig(ActionEvent event) {
		String username = this.username.getText().trim();
		String password = new String(this.password.getPassword()).trim();
		String code = this.lineCaptcha.getCode(); //图片生成时的验证码
		String code1 = this.veriField.getText().trim();  //用户输入的验证码
		String md5=null;
		int identity = this.shenfen;
		//验证用户名和密码是否为空
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
		int usernameInt = Integer.valueOf(username).intValue();
		switch (identity) {
		case 0:
			//学生登录
			Student  student =	loginSevice.StudentToLoginSevice(usernameInt);
			if(student ==null) {
				 JOptionPane.showMessageDialog(null,"用户不存在");
				 versImg();
				 lblNewLabel_2.setIcon(icon);
			}else if(!student.getPassword().equals(md5)) {
				JOptionPane.showMessageDialog(null,"密码错误");
				versImg();
				lblNewLabel_2.setIcon(icon);
			}else {
				//登录成功
				 JOptionPane.showMessageDialog(null,"登录成功");
				 dispose();  //1、关闭窗口
				 UIndexView index = new UIndexView();
				 index.getValues(student);
				 index.setVisible(true);
			}
			break;
		case 1:
			Teacher  teacher =	loginSevice.TeacherToLoginSevice(usernameInt);
			if(teacher ==null) {
				JOptionPane.showMessageDialog(null,"用户不存在");
				versImg();
				lblNewLabel_2.setIcon(icon);
			}else if(!teacher.getPassword().equals(md5)) {
				JOptionPane.showMessageDialog(null,"密码错误");
				versImg();
				lblNewLabel_2.setIcon(icon);
			}else {
				//登录成功
				 JOptionPane.showMessageDialog(null,"登录成功");
				 dispose();  //1、关闭窗口
				 TindexView tindexView = new TindexView();
				 tindexView.getValues(teacher);
				 tindexView.setVisible(true);
			}
			break;
		}
	}
	/**
	  * 验证码生成函数
	 */
	public void versImg() {
	 	lineCaptcha=CaptchaUtil.createShearCaptcha(120,34);
		System.out.println(lineCaptcha.getCode());
		BufferedImage image2 = lineCaptcha.getImage();
		icon = new ImageIcon(image2);
		
	}
}
