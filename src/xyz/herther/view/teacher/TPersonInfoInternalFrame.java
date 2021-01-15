package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;
import xyz.herther.utils.StringUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-18 0:14:11
* 类说明
*/
public class TPersonInfoInternalFrame extends JInternalFrame {
	private JTextField textField;
	private JTextField TnameField;
	private JTextField phoneField;
	private JTextField braceField;
	private Teacher teacher=null;
	private JComboBox comboBox ;
	
	
	
	//注入业务层
	TeacherService teacherService = new TeacherServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TPersonInfoInternalFrame frame = new TPersonInfoInternalFrame();
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
	public TPersonInfoInternalFrame() {
		setFrameIcon(new ImageIcon(TPersonInfoInternalFrame.class.getResource("/xyz/herther/img/Info.png")));
		setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		setIconifiable(true);
		setEnabled(false);
		setClosable(true);
		setBounds(100, 100, 346, 370);
		
		JLabel lblNewLabel = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 20));
		textField.setEnabled(false);
		textField.setColumns(8);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u624B\u673A\uFF1A");
		lblNewLabel_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\u804C\u79F0\uFF1A");
		lblNewLabel_1_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		TnameField = new JTextField();
		TnameField.setFont(new Font("宋体", Font.BOLD, 20));
		TnameField.setColumns(8);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("宋体", Font.BOLD, 20));
		phoneField.setColumns(8);
		
		braceField = new JTextField();
		braceField.setFont(new Font("宋体", Font.BOLD, 20));
		braceField.setColumns(8);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//修改信息
				editPersonInfo(event);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(TnameField, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(braceField, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(lblNewLabel)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(242, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(21)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(24)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TnameField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(braceField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		getContentPane().setLayout(groupLayout);
		//窗口居中
		
	}
	/**
	 *	修改信息
	 * @param event
	 */
	protected void editPersonInfo(ActionEvent event) {
		int tid = Integer.parseInt(this.textField.getText().trim());
		String Tname =this.TnameField.getText().trim();
		int sex = comboBox.getSelectedIndex();
		String phone = this.phoneField.getText().trim();
		String brace = this.braceField.getText().trim();
		if(StringUtils.isEmpty(Tname)||StringUtils.isEmpty(phone)||StringUtils.isEmpty(brace)) {
			JOptionPane.showMessageDialog(null, "信息不能为空");
		}else if(!(phone.length()==11)) {
			JOptionPane.showMessageDialog(null, "手机格式不对");
		}else {
			int code = teacherService.editPersonInfo(tid,Tname,sex,phone,brace);
			switch (code) {
			case 0:
				JOptionPane.showMessageDialog(null, "用户不存在");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "更新成功");
				dispose();
				break;
			}
		}
		
	}

	public void SetTeacherInfo(Teacher teacher) {
		this.teacher=teacher;
		this.textField.setText(String.valueOf(teacher.getTid()));
		this.TnameField.setText(teacher.getTname());
		this.phoneField.setText(teacher.getPhone());
		this.braceField.setText(teacher.getBrace());
		comboBox.setSelectedIndex(teacher.getSex().intValue());
	}
}

