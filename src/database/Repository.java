package database;

import resource.tree.DBNode;
import resource.data.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Repository {
    DBNode getSchema();
    List<Row> get(String from);
    void insertIntoQuery(Map<String, String> map, String tableName);
}
