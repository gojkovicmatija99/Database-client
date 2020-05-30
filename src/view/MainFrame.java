package view;

import database.Database;
import database.DatabaseImplementation;
import database.Repository;
import database.settings.MSSQLrepository;
import database.settings.Settings;
import database.settings.SettingsImplementation;
import resource.DBNodeComposite;
import resource.tree.DBtree;
import resource.tree.DBtreeNode;
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
	private Settings settings;
	private Database database;

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
		initDBtree();
		JScrollPane scroll1=new JScrollPane(dbTree);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll1, dbView);
		splitPane.setDividerLocation(165);
		splitPane.setOneTouchExpandable(true);
		this.add(splitPane);
		setVisible(true);
	}

	private void initDBtree() {
		dbTree =new DBtree(dbView);
		database = new DatabaseImplementation(new MSSQLrepository(settings));
		DatabaseImplementation di = (DatabaseImplementation) database;
		dbTreeNode = new DBtreeNode((DBNodeComposite) di.getRepository().getSchema());
		dbTree.setModel(new DefaultTreeModel(dbTreeNode));
		//dbView se inicijalizuje za selektovanu tabelu, ovo treba promeniti
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

	public Database getDatabase() {
		return database;
	}

	public DBtree getDbTree() {
		return dbTree;
	}

	public DBtreeNode getDbTreeNode() {
		return dbTreeNode;
	}

	public DBview getDbView() {
		return dbView;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public void setDbTree(DBtree dbTree) {
		this.dbTree = dbTree;
	}

	public void setDbTreeNode(DBtreeNode dbTreeNode) {
		this.dbTreeNode = dbTreeNode;
	}

	public void setDbView(DBview dbView) {
		this.dbView = dbView;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}
