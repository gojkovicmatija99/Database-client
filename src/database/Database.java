package database;

import resource.tree.DBNode;
import resource.data.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Database {
    DBNode loadResource();
    List<Row> readDataFromTable(String tableName);
    void addRow(Map<String, String> map, String tableName);
}
