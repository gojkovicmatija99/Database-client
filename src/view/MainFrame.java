package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	
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
		
		JPanel leftPanel = new JPanel();
		JPanel rightTopPanel = new JPanel();
		JPanel rightBottomPanel = new JPanel();
		
		JScrollPane leftScroll = new JScrollPane(leftPanel);
		JScrollPane rightTopScroll = new JScrollPane(rightTopPanel);
		JScrollPane rightBottomScroll = new JScrollPane(rightBottomPanel);
		
		JSplitPane vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rightTopScroll, rightBottomScroll);
		JSplitPane horizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScroll, vertical);
		this.add(horizontal);
		
		setVisible(true);
	}

}
