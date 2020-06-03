package actions;

import exception.ExceptionHandler;
import exception.ExceptionType;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OkCountAverageDialogAction implements ActionListener {
    private Entity entity;
    private List<JCheckBox> columnCheckBox;
    private String countOrAverage;
    private String selectedColumn;
    private List<String> groupBy;

    public OkCountAverageDialogAction(Entity entity, String countOrAverage, String selectedColumn, List<JCheckBox> columnCheckBox) {
        this.entity = entity;
        this.countOrAverage = countOrAverage;
        this.selectedColumn = selectedColumn;
        this.columnCheckBox = columnCheckBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        groupBy = new ArrayList<>();
        for (int i = 0; i < columnCheckBox.size(); i++) {
            if (columnCheckBox.get(i).isSelected())
                groupBy.add(columnCheckBox.get(i).getName());
        }
        MainFrame.getInstance().getAppCore().countOrAverage(entity.getName(), countOrAverage, selectedColumn, groupBy);
    }
}
