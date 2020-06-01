package database;

import resource.implementation.Entity;
import resource.tree.DBNode;
import resource.data.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Repository {
    DBNode getSchema();
    List<Row> get(String from);
    void insertIntoQuery(Map<String, String> map, Entity entity);
}
