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
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-19 18:15:48
* ��˵��
*/
public class UcourseInternalFrameView extends JInternalFrame {
	private JTextField CnameField;
	private JTable table;
	
	private Student student;

	//	ע��ҵ���߼���
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
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		
		CnameField = new JTextField();
		CnameField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//������ѡ�γ�
				SelectCourseName(event);
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
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
		table.setFont(new Font("����", Font.BOLD, 16));
		table.getTableHeader().setFont(new Font("΢���ź�", 0, 18));
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
				
				//��ʼѡ��
				startCourse(event);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u8868\u683C\u4E2D\u67D0\u4E00\u884C\u7684\u6570\u636E\u786E\u8BA4\uFF0C\u4E00\u6B21\u53EA\u80FD\u9009\u4E00\u95E8");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
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

		
		//�����
		StuffTable();
	}
	
	//��ʼѡ��
	protected void startCourse(ActionEvent event) {
		int selectedRow = table.getSelectedRow();	//��ȡѡ����
//		System.out.println("selectedRow:"+selectedRow);
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null,"û��ѡ���κ�����");
		}else {
			//��ȡѡ���еĵ�0�е�ֵ������ת��int ���� Cid
			int cid =Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 0)));
			//��ȡѡ���еĵ�2�е�ֵ,����ǿתString���� Tname
			String Tname =String.valueOf(table.getValueAt(selectedRow, 2));
			int code =studentService.insertCourse(cid,Tname,student.getSnum());
			if(code==500) {
				JOptionPane.showMessageDialog(null,"�����ظ�ѡ��");
			}else if(code==200){
				JOptionPane.showMessageDialog(null,"ѡ�γɹ�");
			}else {
				JOptionPane.showMessageDialog(null,"ѡ��ʧ��");
			}
		}
	}


	
	
	/**
	 *	 ������ѡ�γ�
	 * @param event
	 */
	protected void SelectCourseName(ActionEvent event) {
		//��ȡ��ǰ���
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//�ѱ�����
		model.setRowCount(0);
		//��ȡ�ı����ֵ
		String CnameFiled = this.CnameField.getText();
		//��CnameFiled����������ֵ�����ⷽ������
		List<Vector> list = studentService.SelectCourseName(CnameFiled);
		
		if(list.size()== 0) {
			JOptionPane.showMessageDialog(null, "���ݲ�����");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}	
	}

	/**
	 * 	�����
	 */
	private void StuffTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//��ձ��
		model.setRowCount(0);
		List<Vector> list =studentService.selectcourse();
		if(list.size() == 0 ) {
			JOptionPane.showConfirmDialog(null, "��ʱû��ѯ�γ�");
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

