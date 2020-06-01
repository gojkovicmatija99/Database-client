package view;

import app.AppCore;
import observer.Notification;
import observer.Subscriber;
import observer.enums.NotificationCode;
import resource.implementation.Entity;
import resource.implementation.InformationResource;
import resource.tree.DBtree;
import resource.tree.DBtreeCellRenderer;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultTreeModel;

public class MainFrame extends JFrame implements Subscriber {

	private static MainFrame instance = null;
	private DBtree dbTree;
	private JTabbedPane topTab;
	private JTabbedPane bottomTab;
	private AppCore appCore;

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

		appCore = new AppCore();
		appCore.addSubscriber(this);
		appCore.loadResource();
		JScrollPane scroll1=new JScrollPane(dbTree);
		topTab = new JTabbedPane();
		topTab.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (topTab.getTabCount() != 0) {
					RightTopPanel selectedTab = (RightTopPanel)topTab.getSelectedComponent();
					appCore.readDataFromTable(selectedTab.getEntity().getName());
				}
			}
		});
		bottomTab = new JTabbedPane();
		initBottomPanel();
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topTab, bottomTab);
		splitPane1.setDividerLocation(screenHeight/2);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll1, splitPane1);
		splitPane.setDividerLocation(165);
		splitPane.setOneTouchExpandable(true);
		this.add(splitPane);
		setVisible(true);
	}

	public void initBottomPanel() {
		RightTopPanel selectedTopTab = topTab.getSelectedComponent();
		Entity entity = selectedTopTab.getEntity();
		for (int i = 0; i < entity)
	}

	public JTabbedPane getTopTab() {
		return topTab;
	}

	public AppCore getAppCore() {
		return appCore;
	}

	public void setAppCore(AppCore appCore) {
		this.appCore = appCore;
	}

	@Override
	public void update(Notification notification) {
		if (notification.getCode() == NotificationCode.RESOURCE_LOADED){
			dbTree =new DBtree();
			InformationResource root = (InformationResource)notification.getData();
			dbTree.setModel(new DefaultTreeModel(root));
		} else {
			//jTable.setModel((TableModel) notification.getData());
		}
	}
}
