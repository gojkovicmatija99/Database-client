package database;

import resource.implementation.Entity;
import resource.tree.DBNode;
import resource.data.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Database {
    DBNode loadResource();
    List<Row> readDataFromTable(String tableName);
    void addRow(Map<String, String> map, Entity entity);
    void updateRow(Map<String, String> map, Entity entity, String wherePK);
    void deleteRow(Map<String, String> map, Entity entity);
}
