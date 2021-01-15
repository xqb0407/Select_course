package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;
import xyz.herther.utils.StringUtils;
import xyz.herther.view.LoginView;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-20 22:29:42
* 类说明
*/
public class TeditPassInfolnternalFrame extends JInternalFrame {
	private JPasswordField oldPassField;
	private JPasswordField newPassField;
	private JPasswordField newPass2Field;
	private Teacher teacher;
	
	//注入业务逻辑层
	private TeacherService teacherService =new TeacherServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeditPassInfolnternalFrame frame = new TeditPassInfolnternalFrame();
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
	public TeditPassInfolnternalFrame() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 338, 231);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1)
							.addGap(11))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(13)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				editPassWord(event);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 19));
		
		oldPassField = new JPasswordField();
		
		newPassField = new JPasswordField();
		
		newPass2Field = new JPasswordField();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addGap(156)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(newPass2Field, Alignment.TRAILING)
								.addComponent(newPassField, Alignment.TRAILING)
								.addComponent(oldPassField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(6)
					.addComponent(oldPassField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newPassField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(newPass2Field, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);

	}
	/**
	 * 	修改密码
	 * @param event
	 */
	private void editPassWord(ActionEvent event) {
		String oldPass= new String(this.oldPassField.getPassword()).trim();
		String newPass=new String(this.newPassField.getPassword()).trim();
		String newPass2 =new String(this.newPass2Field.getPassword()).trim();
		
		if(StringUtils.isEmpty(oldPass)||StringUtils.isEmpty(newPass)||StringUtils.isEmpty(newPass2)) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
		}else if(!(newPass.equals(newPass2))){
			JOptionPane.showMessageDialog(null, "两次密码不一致");
		}else {
			int tid =this.teacher.getTid();
			int code =teacherService.editPassWorld(tid,oldPass,newPass);
			switch (code) {
			case -1:
				JOptionPane.showMessageDialog(null, "原密码错误");
				break;
			case 500:
				JOptionPane.showMessageDialog(null, "用户不存在");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "修改成功");
				dispose();
				break;
			}
		}
		
		
	}

	//获取信息
	public void getValue(Teacher teacher) {
		this.teacher=teacher;
//		System.out.println(this.teacher.getTid());
	}
}

