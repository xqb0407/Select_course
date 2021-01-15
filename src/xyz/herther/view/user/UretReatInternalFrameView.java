package xyz.herther.view.user;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.StudentServiceImpl;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
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
* @version ����ʱ�䣺2020-12-20 12:59:36
* ��˵��
*/
public class UretReatInternalFrameView extends JInternalFrame {
	private JTable table;
	private Student student;
	private int showConfirmDialog;
	
	//ע��ҵ���
	StudentService studentService =new StudentServiceImpl();

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UretReatInternalFrameView frame = new UretReatInternalFrameView();
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
	public UretReatInternalFrameView() {
		setTitle("\u9000\u9009");
		setFrameIcon(new ImageIcon(UretReatInternalFrameView.class.getResource("/xyz/herther/img/kecheng.png")));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 447, 451);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u9000\u9009\u8BFE\u7A0B");
		lblNewLabel.setIcon(new ImageIcon(UretReatInternalFrameView.class.getResource("/xyz/herther/img/retReat.png")));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				//���ر��
				showTable();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u4E2D\u67D0\u4E00\u884C\uFF0C\u6267\u884C\u9000\u9009\uFF0C\u4E00\u6B21\u53EA\u80FD\u9009\u4E00\u884C");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton("\u9000\u9009");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//�˿�
				RetReat(event);
			}
		});
		btnNewButton.setForeground(new Color(0, 191, 255));
		btnNewButton.setIcon(new ImageIcon(UretReatInternalFrameView.class.getResource("/xyz/herther/img/retReat.png")));
		btnNewButton.setFont(new Font("����", Font.BOLD, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFont(new Font("΢���ź� Light", Font.BOLD, 15));
		table.getTableHeader().setFont(new Font("΢���ź�", 0, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u8001\u5E08", "\u5B66\u5206"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);

	}
	protected void RetReat(ActionEvent event) {
		int selectedRow = table.getSelectedRow();	//��ȡѡ����
		System.out.println(selectedRow);
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null,"û��ѡ���κ�����");
		}else {
			//��ȡѡ���еĵ�0�е�ֵ������ת��int ���� Cid
			int cid =Integer.parseInt(String.valueOf(table.getValueAt(selectedRow, 0)));
			//��ȡѡ���еĵ�2�е�ֵ,����ǿתString���� Tname
			String Tname =String.valueOf(table.getValueAt(selectedRow, 2));
			int code =studentService.RetReatCourse(cid,Tname,student.getSnum());
			if(code==200) {
				JOptionPane.showMessageDialog(null,"��ѡ�ɹ�");
				showTable();
			}else {
				JOptionPane.showMessageDialog(null,"ѡ��ʧ��");
			}
		}
		
	}

	/**
	 * 	���ر��
	 * @param event
	 */
	protected void showTable() {
		//��ȡ���
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//��ձ��
		model.setRowCount(0);
		//ȥҵ��㴦���߼�  
		List<Vector> list =studentService.selectMycourse(this.student.getSnum()); //this.student.getSnum()
		if(list.size() == 0) {
			showConfirmDialog = JOptionPane.showConfirmDialog(null, "û��ѡ��");
			dispose();
		}else {
			for (Vector v : list) {
				model.addRow(v);
			}

		}
	}

	public void getValue(Student student) {
		this.student=student;
		
	}
}

