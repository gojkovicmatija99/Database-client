package view;

import database.settings.MSSQLrepository;
import database.settings.Settings;
import database.settings.SettingsImplementation;
import resource.DBNodeComposite;
import resource.tree.DBtree;
import resource.tree.DBtreeNode;
import resource.tree.DBview;
import utils.Constants;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame extends JFrame {

	private static MainFrame instance = null;
	private DBtreeNode dbTreeNode;
	private DBtree dbTree;
	private DBview dbView;
	private MSSQLrepository mssqlRepository;
	private Settings settings;
	
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

		settings=initSettings();
		mssqlRepository=new MSSQLrepository(settings);
		initDBtree();
		JScrollPane scroll=new JScrollPane(dbTree);
		this.add(scroll);
		setVisible(true);
	}

	private void initDBtree() {
		dbTree =new DBtree(dbView);
		dbTreeNode = new DBtreeNode((DBNodeComposite) mssqlRepository.getSchema());
		dbTree.setModel(new DefaultTreeModel(dbTreeNode));
		dbView =new DBview(dbTreeNode);
	}

	private Settings initSettings() {
		Settings settingsImplementation = new SettingsImplementation();
		settingsImplementation.addParameter("mssql_ip", Constants.MSSQL_IP);
		settingsImplementation.addParameter("mssql_database", Constants.MSSQL_DATABASE);
		settingsImplementation.addParameter("mssql_username", Constants.MSSQL_USERNAME);
		settingsImplementation.addParameter("mssql_password", Constants.MSSQL_PASSWORD);
		return settingsImplementation;
	}

}
