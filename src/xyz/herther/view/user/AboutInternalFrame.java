package xyz.herther.view.user;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

/**
* @author ×÷Õß :Herther
* @version ´´½¨Ê±¼ä£º2020-12-3 22:06:02
* ÀàËµÃ÷
*/
public class AboutInternalFrame extends JInternalFrame {

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
					AboutInternalFrame frame = new AboutInternalFrame();
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
	public AboutInternalFrame() {
		setFrameIcon(new ImageIcon(AboutInternalFrame.class.getResource("/xyz/herther/img/about.png")));
		setTitle("\u5173\u4E8E\u6211");
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 280, 198);
		
		JLabel lblNewLabel = new JLabel("\u5173\u4E8E");
		lblNewLabel.setIcon(new ImageIcon(AboutInternalFrame.class.getResource("/xyz/herther/img/about.png")));
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AboutInternalFrame.class.getResource("/xyz/herther/img/github.png")));
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("<html><a href='https://github.com/xqb0407'>github.com/xqb0407</a></html>");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AboutInternalFrame.class.getResource("/xyz/herther/img/blog.png")));
		lblNewLabel_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("<html><a href='http://www.herther.xyz:8090/'>www.herther.xyz:8090</a></html>");
		lblNewLabel_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(AboutInternalFrame.class.getResource("/xyz/herther/img/qq.png")));
		lblNewLabel_1_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_2 = new JLabel("<html><p style=\"color:red\">34675628</p></html>");
		lblNewLabel_2_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_2)
									.addGap(4)
									.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
							.addGap(62))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		//´°¿Ú¾ÓÖÐ
	}
}

