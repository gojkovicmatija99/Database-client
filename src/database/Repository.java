package database;

import resource.tree.DBNode;
import resource.data.Row;

import java.util.List;

public interface Repository {
    DBNode getSchema();
    List<Row> get(String from);
}
