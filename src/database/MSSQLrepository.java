package database;

import database.settings.Settings;
import resource.tree.DBNode;
import resource.data.Row;
import resource.enums.AttributeType;
import resource.enums.ConstraintType;
import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MSSQLrepository implements Repository {
    private Connection connection;
    private Settings settings;

    public MSSQLrepository(Settings settings) {
        this.settings = settings;
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String ip = (String) settings.getParameter("mssql_ip");
        String database = (String) settings.getParameter("mssql_database");
        String username = (String) settings.getParameter("mssql_username");
        String password = (String) settings.getParameter("mssql_password");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:jtds:sqlserver://"+ ip +"/"+ database, username, password);
    }

    private void closeConnection(){
        try{
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection=null;
        }
    }

    // TODO: Ova metoda vraca root stabla
    @Override
    public DBNode getSchema() {
        try {
            this.initConnection();

            DatabaseMetaData metaData=connection.getMetaData();
            InformationResource ir=new InformationResource("tim_31_bp2020");

            String tableType[]={"TABLE"};
            ResultSet tables=metaData.getTables(connection.getCatalog(), null, null, tableType);

            while(tables.next()) {
                String tableName=tables.getString("TABLE_NAME");
                Entity newTable =new Entity(tableName, ir);
                ir.addChild(newTable);

                ResultSet columns= metaData.getColumns(connection.getCatalog(), null, tableName, null);
                while(columns.next()) {
                    String columnsName=columns.getString("COLUMN_NAME");
                    String columnType=columns.getString("TYPE_NAME");
                    int columnSize=Integer.parseInt(columns.getString("COLUMN_SIZE"));
                    Attribute attribute=new Attribute(columnsName, newTable, AttributeType.valueOf((columnType.toUpperCase())), columnSize);
                    newTable.addChild(attribute);

                    String isNullable=columns.getString("IS_NULLABLE");
                    if(isNullable.equals("NO")) {
                        AttributeConstraint attributeConstraint=new AttributeConstraint("NOT NULL",attribute, ConstraintType.NOT_NULL);
                        attribute.addChild(attributeConstraint);
                    }

                    String defaultValue=columns.getString("COLUMN_DEF");
                    if(defaultValue!=null){
                        AttributeConstraint attributeConstraint=new AttributeConstraint(defaultValue, attribute, ConstraintType.DEFAULT_VALUE);
                        attribute.addChild(attributeConstraint);
                    }

                    ResultSet primaryKeys=metaData.getPrimaryKeys(connection.getCatalog(), null, tableName);
                    while(primaryKeys.next()) {
                        if(columnsName.equals(primaryKeys.getString("COLUMN_NAME"))) {
                            AttributeConstraint attributeConstraint=new AttributeConstraint("PRIMARY KEY",attribute,ConstraintType.PRIMARY_KEY);
                            attribute.addChild(attributeConstraint);
                        }
                    }

                    ResultSet foreignKeys=metaData.getImportedKeys(connection.getCatalog(), null, tableName);
                    while(foreignKeys.next()) {
                        if(columnsName.equals(foreignKeys.getString("FKCOLUMN_NAME"))) {
                            AttributeConstraint attributeConstraint=new AttributeConstraint("FOREIGN KEY",attribute,ConstraintType.FOREIGN_KEY);
                            attribute.addChild(attributeConstraint);
                        }
                    }
                }
            }

            return ir;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return null;
    }

    @Override
    public List<Row> get(String from) {
        List<Row> rows=new ArrayList<>();

        try {
            this.initConnection();

            String query = "SELECT * FROM " + from;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Row row=new Row();
                row.setName(from);

                ResultSetMetaData resultSetMetaData=rs.getMetaData();
                for(int i=1;i<=resultSetMetaData.getColumnCount();i++) {
                    row.addField(resultSetMetaData.getColumnName(i), rs.getString(i));
                }
                rows.add(row);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return rows;
    }
}
