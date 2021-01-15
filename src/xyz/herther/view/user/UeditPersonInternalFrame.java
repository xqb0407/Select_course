package xyz.herther.view.user;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import xyz.herther.eneity.Student;
import xyz.herther.service.StudentService;
import xyz.herther.service.impl.StudentServiceImpl;
import xyz.herther.utils.StringUtils;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author ×÷Õß :Herther
* @version ´´½¨Ê±¼ä£º2020-12-3 22:40:58
* ÀàËµÃ÷
*/
public class UeditPersonInternalFrame extends JInternalFrame {
	private JTextField SnumField;
	private JTextField SdeptField;
	private JTextField ageField;
	private JTextField ClassField;
	private JTextField PhoneField;
	private JTextField SnameField;
	private Student student;

	//×¢ÈëÂß¼­²ã
	StudentService studentServie=new StudentServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
	    {
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	    	
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UeditPersonInternalFrame frame = new UeditPersonInternalFrame();
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
	public UeditPersonInternalFrame() {
		setFrameIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/up.png")));
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBackground(SystemColor.inactiveCaptionBorder);
		setTitle("\u4FEE\u6539\u4E2A\u4EBA\u8D44\u6599");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 378, 426);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u8D44\u6599");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		
		SnumField = new JTextField();
		SnumField.setEnabled(false);
		SnumField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		SnumField.setText("2006190128");
		SnumField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setText("28");
		ageField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		ageField.setColumns(10);
		
		PhoneField = new JTextField();
		PhoneField.setText("12345678911");
		PhoneField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		PhoneField.setColumns(10);
		
		SdeptField = new JTextField();
		SdeptField.setText("\u8BA1\u7B97\u673A\u4E0E\u4EBA\u5DE5\u667A\u80FD\u7CFB");
		SdeptField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		SdeptField.setEnabled(false);
		SdeptField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/pid.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		
		ClassField = new JTextField();
		ClassField.setEditable(false);
		ClassField.setEnabled(false);
		ClassField.setText("\u8F6F\u4EF6\u5DE5\u7A0B\u4E13\u5347\u672C1\u73ED");
		ClassField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		ClassField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("\u624B\u673A\uFF1A");
		lblNewLabel_1_1_1_2.setIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/phone.png")));
		lblNewLabel_1_1_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/name.png")));
		lblNewLabel_1_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/age.png")));
		lblNewLabel_1_1_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/class.png")));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u7CFB\u522B\uFF1A");
		lblNewLabel_1_1.setIcon(new ImageIcon(UeditPersonInternalFrame.class.getResource("/xyz/herther/img/dept.png")));
		lblNewLabel_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		SnameField = new JTextField();
		SnameField.setText("\u8D3A\u6F47\u7136");
		SnameField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		SnameField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//ÐÞ¸Ä×ÊÁÏ
				editPerson(event);
			}
		});
		btnNewButton_1.setFont(new Font("ËÎÌå", Font.BOLD, 19));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1_1_1_1_1)
										.addComponent(lblNewLabel_1_1)
										.addComponent(lblNewLabel_1_1_1_2)
										.addComponent(lblNewLabel_1_1_1_1)
										.addComponent(lblNewLabel_1_1_1))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ageField)
								.addComponent(SnumField)
								.addComponent(SdeptField)
								.addComponent(ClassField)
								.addComponent(PhoneField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(SnameField)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addComponent(lblNewLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(SnumField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(SdeptField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ClassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(SnameField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * ÐÞ¸Ä×ÊÁÏ
	 * @param event
	 */
	protected void editPerson(ActionEvent event) {
		//ÐÕÃû
		String Sname = this.SnameField.getText().trim();
		//ÊÖ»ú
		String phone = this.PhoneField.getText().trim();
		//ÄêÁä
		String ageStr =this.ageField.getText().trim();
		
		if(StringUtils.isEmpty(Sname)||StringUtils.isEmpty(phone)||StringUtils.isEmpty(ageStr)) {
			JOptionPane.showMessageDialog(null,"×ÊÁÏ²»ÄÜÎª¿Õ");
		}else if(phone.length()!=11) {
			JOptionPane.showMessageDialog(null,"ÊÖ»ú³¤¶È±ØÐëÎª11Î»");
		}else {
			int age = Integer.parseInt(ageStr);
			int code = studentServie.editPerson(this.student.getSnum(),Sname,phone,age);
			if(!(code == 200)) {
				JOptionPane.showMessageDialog(null,"¸üÐÂÊ§°Ü");
			}else {
				JOptionPane.showMessageDialog(null,"ÐÞ¸Ä³É¹¦");
				dispose();
			}
		}
	}

	public void getValue(Student student) {
		SnumField.setText(String.valueOf(student.getSnum()));
		SnameField.setText(student.getSname());
		SdeptField.setText(student.getDept());
		ageField.setText(String.valueOf(student.getAge()));
		ClassField.setText(student.getClassGradel());
		PhoneField.setText(student.getPhone());
		this.student=student;
	}
}

