package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-21 0:04:42
* ��˵��
*/
public class TshowGradelnternalFrame extends JInternalFrame {
	private JTextField CnameField;
	private JTable table;
	private Teacher teacher;

	//ע��ҵ�����
	TeacherService teacherService = new TeacherServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TshowGradelnternalFrame frame = new TshowGradelnternalFrame();
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
	public TshowGradelnternalFrame() {
		setTitle("\u67E5\u8BE2\u6210\u7EE9");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 384);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u8BFE\u7A0B\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		CnameField = new JTextField();
		CnameField.setFont(new Font("����", Font.BOLD, 20));
		panel.add(CnameField);
		CnameField.setColumns(13);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//�����γ������
				seachGread(event);
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 19));
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//�����
				showDelGrade(event);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.setFont(new Font("����", Font.BOLD, 15));
		table.getTableHeader().setFont(new Font("����", 0, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u6210\u7EE9", "\u5B66\u53F7", "\u59D3\u540D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);

	}
	
	//�����γ������
	protected void seachGread(ActionEvent event) {
		//������
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//��ձ��
		model.setRowCount(0);
		String cname = this.CnameField.getText();
		List<Vector> list =teacherService.seachCourseGreade1(this.teacher.getTid(),cname);
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "��ʱû����");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}
	}

	//�����
	protected void showDelGrade(MouseEvent event) {
		//������
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//��ձ��
		model.setRowCount(0);
		List<Vector> list =teacherService.selectCourseGreade1(this.teacher.getTid());
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "��ʱû��ѯ��ѧ��");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}
	
	
	
	
	//��ֵ
	public void getValue(Teacher teacher) {
		this.teacher =teacher;
	}

}

