package view;

import java.awt.*;

import javax.swing.*;

public class RightTopPanel extends JPanel{

	private MyToolbar toolbar;
	private JTable jTable;
	private JScrollPane scrollPane;
	
	public RightTopPanel() {
		super(new BorderLayout());

		toolbar=new MyToolbar();
		this.add(toolbar, BorderLayout.NORTH);

		jTable = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(jTable);
		this.add(scrollPane, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public JTable getjTable() {
		return jTable;
	}
}
