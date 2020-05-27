package view;

import database.settings.MSSQLrepository;
import resource.DBtree;
import resource.implementation.DBTreeNode;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame extends JFrame {

	private static MainFrame instance = null;
	private DBTreeNode dbTreeNode;
	private DBtree dbTree;
	private DBview dbView;
	private MSSQLrepository mssqlRepository;
	
	public static MainFrame getInstance() {
		if (instance == null) 
			instance = new MainFrame();
		return instance;
	}
	
	public MainFrame() {
		setTitle("Data Base Project");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2, screenHeight/2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mssqlRepository=new MSSQLrepository();
		initDBtree();
		JScrollPane scroll=new JScrollPane(dbTree);
		this.add(scroll);
		setVisible(true);
	}

	private void initDBtree() {
		dbTree =new DBtree(dbView);
		dbTreeNode = (DBTreeNode) mssqlRepository.getSchema();
		dbTree.setModel(new DefaultTreeModel(dbTreeNode));
		dbView =new DBview(dbTreeNode);
	}

}
