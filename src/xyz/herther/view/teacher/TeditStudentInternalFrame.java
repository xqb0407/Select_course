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
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-23 22:26:24
* 类说明
*/
public class TeditStudentInternalFrame extends JInternalFrame {
	private Teacher teacher;
	//注入业务层
	TeacherService teacherService =new TeacherServiceImpl();
	
	
	private JTable table;
	private JTextField SnameField;
	private JTextField deptField;
	private JTextField ClassField;
	private JTextField ageField;
	private JTextField phoneField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeditStudentInternalFrame frame = new TeditStudentInternalFrame();
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
	public TeditStudentInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7F16\u8F91\u5B66\u751F");
		setBounds(100, 100, 594, 541);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u8F91\u5B66\u751F");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("\u9009\u4E2D\u4E00\u884C\u64CD\u4F5C");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u4FEE \u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//修改学生信息
				editStudent(event);
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220 \u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//删除学生
				deleteStuden(event);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				
//				showStudentTable();
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		SnameField = new JTextField();
		SnameField.setFont(new Font("宋体", Font.BOLD, 19));
		SnameField.setColumns(13);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7CFB\u522B\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		deptField = new JTextField();
		deptField.setFont(new Font("宋体", Font.BOLD, 21));
		deptField.setColumns(13);
		
		ClassField = new JTextField();
		ClassField.setFont(new Font("宋体", Font.BOLD, 18));
		ClassField.setColumns(13);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		ageField = new JTextField();
		ageField.setFont(new Font("宋体", Font.BOLD, 18));
		ageField.setColumns(13);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("宋体", Font.PLAIN, 18));
		phoneField.setColumns(13);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(deptField, 181, 181, 181)
						.addComponent(ClassField, 181, 181, 181)
						.addComponent(SnameField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ageField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
					.addGap(29))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(SnameField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(deptField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(ClassField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
//		table.setFont(new Font("宋体", Font.BOLD, 15));
		table.getTableHeader().setFont(new Font("宋体", 0, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u5E74\u9F84", "\u7535\u8BDD", "\u7CFB\u522B", "\u73ED\u7EA7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("宋体", Font.BOLD, 13));
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		//渲染表格
		showStudentTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			//获取选中后行赋值到下列文本框
			@Override
			public void valueChanged(ListSelectionEvent event) {
				int selectedRow = table.getSelectedRow();
				SnameField.setText((String)table.getValueAt(selectedRow, 1));
				phoneField.setText((String)table.getValueAt(selectedRow, 3));
				ClassField.setText((String)table.getValueAt(selectedRow, 5));
				deptField.setText((String)table.getValueAt(selectedRow, 4));
				ageField.setText(String.valueOf(table.getValueAt(selectedRow, 2)));
			}
		});
		
		
		
		

	}
	//修改信息
	protected void editStudent(ActionEvent event) {
		String Sname = this.SnameField.getText();
		String dept= this.deptField.getText();
		String age1 = this.ageField.getText();
		String ClassGrade= this.ClassField.getText();
		String phone = this.phoneField.getText();
		int selectedRow = table.getSelectedRow();
		int Snum = (int)table.getValueAt(selectedRow, 0);
		if(selectedRow==-1) {
			JOptionPane.showMessageDialog(null, "没有选中");
		}else {
			if(StringUtils.isEmpty(Sname)||StringUtils.isEmpty(dept)||StringUtils.isEmpty(age1)||StringUtils.isEmpty(ClassGrade)||StringUtils.isEmpty(phone)) {
				JOptionPane.showMessageDialog(null, "信息不能为空");
			}else if(phone.length()!=11) {
				JOptionPane.showMessageDialog(null, "手机不能低于11位");
			}else {
				int age = Integer.parseInt(age1);
				int code = teacherService.editStudent(Snum,Sname,dept,age,ClassGrade,phone);
				if(code !=1) JOptionPane.showMessageDialog(null, "修改失败");
				else {
					JOptionPane.showMessageDialog(null, "修改成功");
					dispose();
				}
			}
		}		
		
		
	}


	//删除学生
	protected void deleteStuden(ActionEvent event) {
		int selectedRow = table.getSelectedRow();
		if(selectedRow ==-1) {
			JOptionPane.showMessageDialog(null, "你还没有选中");
		}else {
			int snum = Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 0)));
			int code = teacherService.deleteStuden(snum);
			if(code == 1) {
				JOptionPane.showMessageDialog(null, "删除成功");
				dispose();
			}else JOptionPane.showMessageDialog(null, "用户不存在");
		}
		
	}


	//渲染表格
	protected void showStudentTable() {
		//定义表格
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//清空表格
		model.setRowCount(0);
		List<Vector> list =teacherService.SelectStudent();
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "暂时没查询到学生");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}


	//赋值
	public void getValue(Teacher teacher) {
		this.teacher=teacher;
	}
}

