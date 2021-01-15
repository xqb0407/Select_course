package xyz.herther.view.user;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.StudentServiceImpl;
import xyz.herther.utils.StateUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-10 22:24:48
* 类说明
*/
public class UGradeInternalFrame extends JInternalFrame {
	private JTable table;
	private JTextField SearchField;
	private Student student=null;
	private int snum;
	//注入业务逻辑层
	StudentService studentservice =new StudentServiceImpl();
	private int showConfirmDialog;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UGradeInternalFrame frame = new UGradeInternalFrame();
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
	public UGradeInternalFrame() {
		setFrameIcon(new ImageIcon(UGradeInternalFrame.class.getResource("/xyz/herther/img/kecheng.png")));
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//填充表格
				StuffTable();
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		
		SearchField = new JTextField();
		SearchField.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		SearchField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				searchGrade(event);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(SearchField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(SearchField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u540D\u79F0", "\u6210\u7EE9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getTableHeader().setFont(new Font("微软雅黑", 0, 20));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		setClosable(true);
		setIconifiable(true);
		setEnabled(false);
		setTitle("\u6210\u7EE9\u67E5\u8BE2");
		setBounds(100, 100, 524, 447);
		
	}
	/**
	  *  搜索
	 * @param event
	 */
	protected void searchGrade(ActionEvent event) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		String SearchField = this.SearchField.getText();
		List<Vector> list = studentservice.searchGrade(snum,SearchField);
		if(list.size()== 0) {
			JOptionPane.showMessageDialog(null, "内容不存在");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}
	}

	/**
	 * 	 填充表格
	 *	 清空表格
	 */
	private void StuffTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//清空表格
		model.setRowCount(0);
		//去业务层处理逻辑  假设学号为sum= 2006191258
		List<Vector> list =studentservice.selectGreade(this.snum);
		if(list.size() == 0) {
			showConfirmDialog = JOptionPane.showConfirmDialog(null, "暂时没查询到成绩");
			dispose();
//			System.out.println("showConfirmDialog"+showConfirmDialog);
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}
	
	public void getValue(Student student) {
		this.snum=student.getSnum();
		this.student = student;
	}
}

