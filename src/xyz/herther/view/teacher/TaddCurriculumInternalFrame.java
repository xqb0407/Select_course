package xyz.herther.view.teacher;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import xyz.herther.eneity.Teacher;
import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;
import xyz.herther.utils.StringUtils;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-18 17:54:49
* 类说明
*/
public class TaddCurriculumInternalFrame extends JInternalFrame {
	private JTextField CnameField;
	private JTextField GreditField;
	private Teacher teacher;
	private JTextField capacityField;

	
	//注入业务逻辑层
	TeacherService teacherService=new TeacherServiceImpl();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaddCurriculumInternalFrame frame = new TaddCurriculumInternalFrame();
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
	public TaddCurriculumInternalFrame() {
		setFrameIcon(new ImageIcon(TaddCurriculumInternalFrame.class.getResource("/xyz/herther/img/kecheng.png")));
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 321, 260);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u8BFE\u7A0B");
		lblNewLabel.setIcon(new ImageIcon(TaddCurriculumInternalFrame.class.getResource("/xyz/herther/img/cccc.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		CnameField = new JTextField();
		CnameField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5B66\u5206\uFF1A");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		GreditField = new JTextField();
		GreditField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//添加课程
				addCurriculum(event);
			}
		});
		btnNewButton.setIcon(new ImageIcon(TaddCurriculumInternalFrame.class.getResource("/xyz/herther/img/add.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		capacityField = new JTextField();
		capacityField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u4EBA\u6570\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CnameField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1_1)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(capacityField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(GreditField))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(CnameField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(GreditField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(capacityField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);

	}
	//添加课程
	protected void addCurriculum(ActionEvent event) {
		String Cname = this.CnameField.getText().trim();
		String Gredit = this.GreditField.getText().trim();
		String Capacity1 = this.capacityField.getText().trim();
		
		if(StringUtils.isEmpty(Cname)||StringUtils.isEmpty(Gredit)||StringUtils.isEmpty(Capacity1)) {
			JOptionPane.showMessageDialog(null, "信息不能为空");
		}else {
			double credit = Double.parseDouble(Gredit);
			int Capacity =Integer.parseInt(Capacity1);
			System.out.println(this.teacher.getTid());
			int code= teacherService.addCurriculum(this.teacher.getTid(),Cname,credit,Capacity);
			if(code!=200) {
				JOptionPane.showMessageDialog(null, "添加失败");
			}else {
				JOptionPane.showMessageDialog(null, "添加成功");
			}
		}
		
	}

	//传值
	public void getValue(Teacher teacher) {
		this.teacher=teacher;
	}
}

