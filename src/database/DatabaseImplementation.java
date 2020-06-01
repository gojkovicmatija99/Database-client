package database;

import resource.tree.DBNode;
import resource.data.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseImplementation implements Database {
    private Repository repository;

    public DatabaseImplementation(Repository repository) {
        this.repository = repository;
    }

    @Override
    public DBNode loadResource() {
        return repository.getSchema();
    }

    @Override
    public List<Row> readDataFromTable(String tableName) {
        return repository.get(tableName);
    }

    @Override
    public void addRow(Map<String, String> map, String tableName) {
        repository.insertIntoQuery(map, tableName);
    }

    public Repository getRepository() {
        return repository;
    }
}
