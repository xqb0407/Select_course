package xyz.herther.view.user;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.StudentServiceImpl;

import java.awt.SystemColor;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-19 18:15:48
* 类说明
*/
public class UcourseInternalFrameView extends JInternalFrame {
	private JTextField CnameField;
	private JTable table;
	
	private Student student;

	//	注入业务逻辑层
	StudentService studentService =new StudentServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UcourseInternalFrameView frame = new UcourseInternalFrameView();
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
	public UcourseInternalFrameView() {
		setEnabled(false);
		getContentPane().setBackground(new Color(240, 248, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u68C0\u7D22\u8BFE\u7A0B\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		CnameField = new JTextField();
		CnameField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//检索可选课程
				SelectCourseName(event);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(57)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(CnameField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(69))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(CnameField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton, 0, 0, Short.MAX_VALUE)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.BOLD, 16));
		table.getTableHeader().setFont(new Font("微软雅黑", 0, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u8BB2\u5E08", "\u5B66\u5206", "\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483642);
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u9009\u62E9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				//开始选课
				startCourse(event);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u8868\u683C\u4E2D\u67D0\u4E00\u884C\u7684\u6570\u636E\u786E\u8BA4\uFF0C\u4E00\u6B21\u53EA\u80FD\u9009\u4E00\u95E8");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(UcourseInternalFrameView.class.getResource("/xyz/herther/img/kecheng.png")));
		setClosable(true);
		setTitle("\u5F00\u59CB\u9009\u8BFE");
		setBounds(100, 100, 495, 488);

		
		//填充表格
		StuffTable();
	}
	
	//开始选课
	protected void startCourse(ActionEvent event) {
		int selectedRow = table.getSelectedRow();	//获取选中行
//		System.out.println("selectedRow:"+selectedRow);
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


	
	
	/**
	 *	 检索可选课程
	 * @param event
	 */
	protected void SelectCourseName(ActionEvent event) {
		//获取当前表格
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//把表格清空
		model.setRowCount(0);
		//获取文本框的值
		String CnameFiled = this.CnameField.getText();
		//把CnameFiled当做参数传值到另外方法当中
		List<Vector> list = studentService.SelectCourseName(CnameFiled);
		
		if(list.size()== 0) {
			JOptionPane.showMessageDialog(null, "内容不存在");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}	
	}

	/**
	 * 	填充表格
	 */
	private void StuffTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//清空表格
		model.setRowCount(0);
		List<Vector> list =studentService.selectcourse();
		if(list.size() == 0 ) {
			JOptionPane.showConfirmDialog(null, "暂时没查询课程");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}
	public void getvlaue(Student student) {
		this.student =student;
	}
}

