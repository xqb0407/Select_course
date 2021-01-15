package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;
import xyz.herther.utils.StringUtils;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-23 21:40:47
* 类说明
*/
public class TaddStudentInternalFrame extends JInternalFrame {
	private Teacher teacher;
	
	//注入业务层
	TeacherService teacherService = new TeacherServiceImpl();
	private JTextField SnameField;
	private JTextField ClassField;
	private JTextField ageField;
	private JTextField phoneField;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaddStudentInternalFrame frame = new TaddStudentInternalFrame();
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
	public TaddStudentInternalFrame() {
		setTitle("\u6DFB\u52A0\u5B66\u751F(\u9ED8\u8BA4\u5BC6\u7801\uFF1A123\uFF0C\u5B66\u53F7\u968F\u673A\u751F\u6210)");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 336, 335);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u5B66\u751F");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u6DFB \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//添加学生
				addStudent(event);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7CFB\u522B\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_1_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1_1)
									.addComponent(lblNewLabel_1, Alignment.TRAILING))
								.addComponent(lblNewLabel_1_1_1, Alignment.TRAILING))
							.addComponent(lblNewLabel_1_1_1_1, Alignment.TRAILING))
						.addComponent(lblNewLabel_1_1_1_1_1, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1_1)
					.addGap(25)
					.addComponent(lblNewLabel_1_1_1_1)
					.addGap(18)
					.addComponent(lblNewLabel_1_1_1_1_1)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		SnameField = new JTextField();
		SnameField.setColumns(10);
		
		ClassField = new JTextField();
		ClassField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u8BA1\u7B97\u673A\u4E0E\u4EBA\u5DE5\u667A\u80FD\u7CFB", "\u519C\u4E1A\u5DE5\u7A0B\u7CFB", "\u4EBA\u7C7B\u5B66\u7CFB", "\u5DE5\u5546\u7BA1\u7406\u7CFB", "\u7535\u5B50\u5DE5\u7A0B\u7CFB", "\u673A\u68B0\u5DE5\u7A0B\u7CFB", "\u56FD\u9645\u5173\u7CFB\u5B66\u7CFB"}));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(SnameField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.TRAILING, 0, 206, Short.MAX_VALUE)
						.addComponent(ClassField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(ageField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addComponent(phoneField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addComponent(SnameField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ClassField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ageField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);

	}
	//添加学生
	protected void addStudent(ActionEvent event) {
		String Sname = this.SnameField.getText().trim();
		String dept = (String)this.comboBox.getSelectedItem();
		String ClassDept = this.ClassField.getText().trim();
		String age1 = this.ageField.getText().trim();
		String phone1 = this.phoneField.getText().trim();
		if(StringUtils.isEmpty(Sname)||StringUtils.isEmpty(ClassDept)||StringUtils.isEmpty(age1)||StringUtils.isEmpty(phone1)) {
			JOptionPane.showMessageDialog(null, "信息不能为空");
		}else if(phone1.length()!=11) {
			JOptionPane.showMessageDialog(null, "手机号必须为11位");
		}else {
			int age = Integer.parseInt(age1);
			int code = teacherService.addStudent(Sname,dept,ClassDept,age,phone1);
			if(code == 1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		}
	}

	//赋值
	public void getValue(Teacher teacher) {
		this.teacher=teacher;
		
	}
}

