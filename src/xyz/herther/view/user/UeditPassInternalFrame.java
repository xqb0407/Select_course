package xyz.herther.view.user;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;

import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.StudentServiceImpl;
import xyz.herther.utils.StringUtils;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UeditPassInternalFrame extends JInternalFrame {
	private JPasswordField oldpassField;
	private JPasswordField newpassField;
	private JPasswordField newpassField2;
	private Student student; 

	//注入业务层
	StudentService studentService =new StudentServiceImpl();
	
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
					UeditPassInternalFrame frame = new UeditPassInternalFrame();
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
	public UeditPassInternalFrame() {
		setClosable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(UeditPassInternalFrame.class.getResource("/xyz/herther/img/uppass.png")));
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(UeditPassInternalFrame.class.getResource("/xyz/herther/img/uppass.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5BC6   \u7801\uFF1A");
		lblNewLabel_1_1.setIcon(new ImageIcon(UeditPassInternalFrame.class.getResource("/xyz/herther/img/uppass.png")));
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(UeditPassInternalFrame.class.getResource("/xyz/herther/img/upzl.png")));
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		oldpassField = new JPasswordField();
		
		newpassField = new JPasswordField();
		
		newpassField2 = new JPasswordField();
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//重置输入框
				Reset(event);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(UeditPassInternalFrame.class.getResource("/xyz/herther/img/re.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				editPass(event);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UeditPassInternalFrame.class.getResource("/xyz/herther/img/login.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 19));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(oldpassField, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(newpassField, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(newpassField2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(btnNewButton)
							.addGap(13)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldpassField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(newpassField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(newpassField2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		panel_1.add(lblNewLabel);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 367, 264);

	}
	/**
	 * 	修改密码
	 * @param event
	 */
	protected void editPass(ActionEvent event) {
		String oldPass= new String(this.oldpassField.getPassword()).trim();
		String newPass= new String(this.newpassField.getPassword()).trim();
		String newPass2= new String(this.newpassField2.getPassword()).trim();
		if(StringUtils.isEmpty(oldPass)) {
			JOptionPane.showMessageDialog(null,"原始密码不能为空");
		}else if(StringUtils.isEmpty(newPass)) {
			JOptionPane.showMessageDialog(null,"新密码不能为空");
		}else if(StringUtils.isEmpty(newPass2)){
			JOptionPane.showMessageDialog(null,"二次密码不能为空");
		}else if(!newPass.equals(newPass2)) {
			JOptionPane.showMessageDialog(null,"两次密码不一样");
		}else {
			int code = studentService.editPassWord(this.student.getSnum(),oldPass,newPass);
			switch(code) {
				case 1:   
					JOptionPane.showMessageDialog(null,"修改成功");
					dispose();
					break; 
					
				case 0:   
					JOptionPane.showMessageDialog(null,"系统错误");
					dispose();
					break; 
				case 500:
					JOptionPane.showMessageDialog(null,"原密码错误");
					break;
			}
		}
	}

	/**
	 * 重置文本框
	 * @param event
	 */
	protected void Reset(ActionEvent event) {
		this.oldpassField.setText("");
		this.newpassField.setText("");
		this.newpassField2.setText("");
	}
	public void getValue(Student student) {
		this.student=student;
	}
}
