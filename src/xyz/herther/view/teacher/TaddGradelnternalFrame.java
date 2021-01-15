package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;
import xyz.herther.utils.StringUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-20 23:31:53
* ��˵��
*/
public class TaddGradelnternalFrame extends JInternalFrame {
	private JTextField CnameField;
	private JTextField GreadField;
	private JTable table;

	
	//ע��ҵ���
	TeacherService teacherService =new TeacherServiceImpl();
	private Teacher teacher;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaddGradelnternalFrame frame = new TaddGradelnternalFrame();
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
	public TaddGradelnternalFrame() {
		setTitle("\u6DFB\u52A0\u6210\u7EE9");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 491);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u68C0\u7D22\u8BFE\u7A0B");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 19));
		panel.add(lblNewLabel);
		
		CnameField = new JTextField();
		CnameField.setFont(new Font("����", Font.BOLD, 20));
		panel.add(CnameField);
		CnameField.setColumns(15);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//�����ɼ�
				seachGrade(event);
			}
		});
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u4E2D\u4E00\u4E2A\u5B66\u751F\u540E\u6DFB\u52A0\u6210\u7EE9");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_1);
		
		GreadField = new JTextField();
		GreadField.setFont(new Font("����", Font.BOLD, 16));
		panel_1.add(GreadField);
		GreadField.setColumns(12);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//��ӳɼ�
				addGread(event);
			}
		});
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//��Ⱦ���
				showGrade(event);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.setFont(new Font("����", Font.BOLD, 15));
		table.getTableHeader().setFont(new Font("����", 0, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u53F7", "\u59D3\u540D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(147);
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);

	}
	//��ӳɼ�
	protected void addGread(ActionEvent event) {
		int selectedRow = table.getSelectedRow();	//��ȡѡ����
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null,"û��ѡ���κ�����");
		}else {
			//��ȡѡ���еĵ�0�е�ֵ������ת��int����   Cid
			int cid = (int)table.getValueAt(selectedRow, 0);
			//��ȡѡ���еĵ�2�е�ֵ,����ת��int����  snum
			int snum = (int)table.getValueAt(selectedRow, 2);
			
			if(StringUtils.isEmpty(this.GreadField.getText())){
				JOptionPane.showMessageDialog(null,"�ɼ�����Ϊ��");
			}else {
				double gread = Double.parseDouble(this.GreadField.getText());
				int code =teacherService.addGread(cid,snum,gread);
				if(code==1) {
					JOptionPane.showMessageDialog(null,"��ӳɹ�");
				}else {
					JOptionPane.showMessageDialog(null,"���ʧ��");
				}
			}
		}
	}

	//�����γ��������
	protected void seachGrade(ActionEvent event) {
		//������
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//��ձ��
		model.setRowCount(0);
		String cname = this.CnameField.getText();
		List<Vector> list =teacherService.seachCourseGreade(this.teacher.getTid(),cname);
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "��ʱû����");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
	
		}
	}

	//��Ⱦ���
	protected void showGrade(MouseEvent event) {
		//������
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//��ձ��
		model.setRowCount(0);
		List<Vector> list =teacherService.selectCourseGreade(this.teacher.getTid());
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "��ʱû��ѯ��ѧ��");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}
		
	public void getValue(Teacher teacher) {
		this.teacher= teacher;
	}

}

