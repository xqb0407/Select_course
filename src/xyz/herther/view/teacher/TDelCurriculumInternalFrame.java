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
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author ���� :Herther
* @version ����ʱ�䣺2020-12-23 21:02:34
* ��˵��
*/
public class TDelCurriculumInternalFrame extends JInternalFrame {
	private Teacher teacher;
	private JTextField CnameField;
	private JTable table;
	
	
	//ע��ҵ���
	TeacherService  teacherService =new TeacherServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TDelCurriculumInternalFrame frame = new TDelCurriculumInternalFrame();
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
	public TDelCurriculumInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5220\u9664\u8BFE\u7A0B");
		setBounds(100, 100, 450, 359);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u4E2D\u4E00\u884C\u6267\u884C\u5220\u9664");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel_1.setForeground(Color.RED);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				delCurriculum(event);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 17));
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		panel_1.add(lblNewLabel);
		
		CnameField = new JTextField();
		CnameField.setFont(new Font("����", Font.PLAIN, 17));
		panel_1.add(CnameField);
		CnameField.setColumns(12);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//����
				SeachCurriculum(event);
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 17));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//��Ⱦ���
				showTableCurriculum(event);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addGap(5))
		);
		
		table = new JTable();
		table.setFont(new Font("����", Font.BOLD, 15));
		table.getTableHeader().setFont(new Font("����", 0, 20));
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

	}
	
	//ɾ���γ�
	protected void delCurriculum(ActionEvent event) {
		//�γ̺�
		int selectedRow = table.getSelectedRow();
		int Cid = (int)table.getValueAt(selectedRow, 0);
		
		if(selectedRow == -1 ) {
			JOptionPane.showMessageDialog(null, "û��ѡ���κ�����");
		}else {
			int code = teacherService.delCurriculum(this.teacher.getTid(),Cid);
			if(code == 200) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			}
		}
	}


	//����
	protected void SeachCurriculum(ActionEvent event) {
		//������
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//��ձ��
		model.setRowCount(0);
		String cname = this.CnameField.getText();
		List<Vector> list =teacherService.SeachCurriculum(this.teacher.getTid(),cname);
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "��ʱû����");
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}
		}
		
	}


	//��Ⱦ���
	protected void showTableCurriculum(MouseEvent event) {
		//������
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//��ձ��
		model.setRowCount(0);
		List<Vector> list =teacherService.showTableCurriculum(this.teacher.getTid());
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(null, "��ʱû��ѯ���γ�");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}

	
	//���ֵ
	public void getValue(Teacher teacher) {
		this.teacher= teacher;
		
	}
}

