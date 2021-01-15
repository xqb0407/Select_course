package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alibaba.druid.util.StringUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-23 18:52:40
* 类说明
*/
public class TeditCurriculumlnternalFrame extends JInternalFrame {
	
	protected static final String String = null;
	private Teacher teacher;
	private JTextField CnameField;
	private JTextField CreditField;
	private JTextField capacityField;
	private JTextField CnameField2;
	private JTable table;
	
	
	//注入业务逻辑层
	TeacherService teacherService=new TeacherServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeditCurriculumlnternalFrame frame = new TeditCurriculumlnternalFrame();
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
	public TeditCurriculumlnternalFrame() {
		setTitle("\u4FEE\u6539\u8BFE\u7A0B");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 469, 504);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));
		panel.add(lblNewLabel);
		
		CnameField = new JTextField();
		CnameField.setFont(new Font("宋体", Font.PLAIN, 17));
		panel.add(CnameField);
		CnameField.setColumns(14);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//搜索
				SeachCurriculum(event);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 17));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u5206\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 17));
		
		CreditField = new JTextField();
		CreditField.setFont(new Font("宋体", Font.BOLD, 17));
		CreditField.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EBA\u6570\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 17));
		
		capacityField = new JTextField();
		capacityField.setFont(new Font("宋体", Font.BOLD, 17));
		capacityField.setColumns(5);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 17));
		
		CnameField2 = new JTextField();
		CnameField2.setFont(new Font("宋体", Font.BOLD, 17));
		CnameField2.setColumns(12);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addGap(5)
					.addComponent(CreditField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(1)
					.addComponent(capacityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblNewLabel_4)
					.addGap(5)
					.addComponent(CnameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(CreditField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(capacityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel_4))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(CnameField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("\u9009\u4E2D\u67D0\u4E00\u884C\u6267\u884C\u4FEE\u6539");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 17));
		panel_5.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//修改课程信息
				editCurriculum(event);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 17));
		panel_5.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//渲染表格
				showTableCurriculum();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.setFont(new Font("宋体", Font.BOLD, 15));
		table.getTableHeader().setFont(new Font("宋体", 0, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u5B66\u5206", "\u8BFE\u7A0B\u540D", "\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				int selectedRow = table.getSelectedRow();
				CreditField.setText((String)table.getValueAt(selectedRow,1));
				capacityField.setText(String.valueOf(table.getValueAt(selectedRow,3)));
				CnameField2.setText((String) table.getValueAt(selectedRow,2));
			}
		});
		
		
		
	}
	/**
	 * 	修改课程信息
	 * @param event
	 */
	protected void editCurriculum(ActionEvent event) {
		//学分
		String Credit1 =this.CreditField.getText();
		//课程号
		int selectedRow = table.getSelectedRow();
		int Cid = (int)table.getValueAt(selectedRow, 0);
		//人数
		String capacity1 = this.capacityField.getText();
		//课程名
		String Cname = this.CnameField2.getText().trim();
		if(StringUtils.isEmpty(Credit1)||StringUtils.isEmpty(capacity1)||StringUtils.isEmpty(Cname)) {
			JOptionPane.showMessageDialog(null, "信息不能为空");
		}else{
			
			//强转
			String substring = Credit1.substring(0,Credit1.length()-1);
			double Credit = Double.parseDouble(substring.trim());
			int  capacity = Integer.parseInt(this.capacityField.getText().trim());
			//跳转到业务层
			int code = teacherService.editCurriculum(this.teacher.getTid(),Cid,Credit,Cname,capacity);
			if(code == 200) {
				JOptionPane.showMessageDialog(null, "修改成功");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}
		
		
		
	}



	/**
	 * 	搜索课程
	 * @param event
	 */
	protected void SeachCurriculum(ActionEvent event) {
		//定义表格
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//清空表格
		model.setRowCount(0);
		String cname = this.CnameField.getText();
		List<Vector> list =teacherService.SeachCurriculum(this.teacher.getTid(),cname);
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "暂时没搜索");
			showTableCurriculum();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}
	}
	
	


	//渲染表格MouseEvent event
	private void showTableCurriculum() {
		//定义表格
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//清空表格
		model.setRowCount(0);
		List<Vector> list =teacherService.showTableCurriculum(this.teacher.getTid());
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "暂时没查询到课程");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}



	public void getValue(Teacher teacher) {
		this.teacher=teacher;
	}
}

