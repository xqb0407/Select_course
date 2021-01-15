package xyz.herther.view.teacher;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xyz.herther.service.TeacherService;
import xyz.herther.service.impl.TeacherServiceImpl;

/**
* @author 作者 :Herther
* @version 创建时间：2020-12-14 22:04:45
* 类说明
*/
public class TCoursNumInternalFrame extends JInternalFrame {
	private JTable table;
	
	
	//注入业务逻辑层
	TeacherService teacherService = new TeacherServiceImpl();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		try
//	    {
//	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//	    }
//	    catch(Exception e)
//	    {
//	    	
//	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCoursNumInternalFrame frame = new TCoursNumInternalFrame();
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
	public TCoursNumInternalFrame() {
		setEnabled(false);
		setTitle("\u9009\u8BFE\u4EBA\u6570");
		setIconifiable(true);
		setFrameIcon(new ImageIcon(TCoursNumInternalFrame.class.getResource("/xyz/herther/img/kecheng.png")));
		setClosable(true);
		setBounds(100, 100, 542, 388);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u9009\u8BFE\u4EBA\u6570"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(118);
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.getTableHeader().setFont(new Font("微软雅黑", 0, 20));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		
		
		//查询选课人数
		selectNum();
		
		
		
	}
	/**
	 * 查询选课人数
	 */
	private void selectNum() {
		
		//定义表格
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		//清空表格
		model.setRowCount(0);
		//去业务层处理逻辑  假设教师编号为sum= 1155415399
		int Tid =1155415399;
		List<Vector> list = teacherService.selectNum(Tid);
		
		for (Vector v : list) {
			model.addRow(v);
		}
		
	}
}

