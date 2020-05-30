package view;

import database.Database;
import view.table.TableModel;

import java.awt.*;

import javax.swing.*;

public class RightTopPanel extends JPanel{

	private MyToolbar toolbar;
	private JTable jTable;
	private TableModel tableModel;
	private JScrollPane scrollPane;
	
	public RightTopPanel() {
		super(new BorderLayout());

		toolbar=new MyToolbar();
		this.add(toolbar, BorderLayout.NORTH);

		tableModel = new TableModel();
		jTable = new JTable();
		this.add(new JScrollPane(jTable), BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public void readDataFromTable(String fromTable){
		tableModel.setRows(MainFrame.getInstance().getDatabase().readDataFromTable(fromTable));
	}

}
