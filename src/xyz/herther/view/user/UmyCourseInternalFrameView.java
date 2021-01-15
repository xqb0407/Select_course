package xyz.herther.view.user;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.StudentServiceImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-20 1:50:11
* 类说明
*/
public class UmyCourseInternalFrameView extends JInternalFrame {
	private JTextField CnameField;
	private JTable table;
	private Student student;
	private int showConfirmDialog;
	private int snum;
	//注入业务层
	StudentService studentService =new StudentServiceImpl();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UmyCourseInternalFrameView frame = new UmyCourseInternalFrameView();
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
	public UmyCourseInternalFrameView() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6211\u7684\u9009\u8BFE");
		setFrameIcon(new ImageIcon(UmyCourseInternalFrameView.class.getResource("/xyz/herther/img/kecheng.png")));
		setBounds(100, 100, 454, 428);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8BFE\u7A0B\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		
		CnameField = new JTextField();
		CnameField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//搜索
				seachCourse(event);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CnameField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(CnameField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showTable();
			}
		});
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u8001\u5E08", "\u5B66\u5206"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(84);
		table.setFont(new Font("宋体", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		;
	}
	/**
	 * 搜索我的选课
	 * @param event
	 */
	protected void seachCourse(ActionEvent event) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		String CnameFiled = this.CnameField.getText();
		List<Vector> list = studentService.seachCourseName(this.student.getSnum(),CnameFiled);
		if(list.size()== 0) {
			JOptionPane.showMessageDialog(null, "内容不存在");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}	
	}

	/**
	 * 	加载表格
	 * @param event
	 */
	private void showTable() { //ActionEvent event
		//获取表格
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//清空表格
		model.setRowCount(0);
		//去业务层处理逻辑  
		List<Vector> list =studentService.selectMycourse(snum); //this.student.getSnum()
		if(list.size() == 0) {
			showConfirmDialog = JOptionPane.showConfirmDialog(null, "没有选课");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}

	public void getValue(Student student) {
		this.student =student;
		this.snum=student.getSnum();
	}

}

