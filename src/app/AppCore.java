package app;

import database.Database;
import database.DatabaseImplementation;
import database.MSSQLrepository;
import database.settings.Settings;
import database.settings.SettingsImplementation;
import model.TableModel;
import observer.Notification;
import observer.enums.NotificationCode;
import observer.implementation.PublisherImplementation;
import resource.implementation.Entity;
import resource.tree.DBNode;
import resource.implementation.InformationResource;
import utils.Constants;

public class AppCore extends PublisherImplementation {
    private Database database;
    private Settings settings;
    private TableModel tableModel1;
    private TableModel tableModel2;

    public AppCore() {
        this.settings = initSettings();
        this.database = new DatabaseImplementation(new MSSQLrepository(this.settings));
        tableModel1 = new TableModel();
        tableModel2 = new TableModel();
    }

    private Settings initSettings() {
        Settings settingsImplementation = new SettingsImplementation();
        settingsImplementation.addParameter("mssql_ip", Constants.MSSQL_IP);
        settingsImplementation.addParameter("mssql_database", Constants.MSSQL_DATABASE);
        settingsImplementation.addParameter("mssql_username", Constants.MSSQL_USERNAME);
        settingsImplementation.addParameter("mssql_password", Constants.MSSQL_PASSWORD);
        return settingsImplementation;
    }


    public void loadResource(){
        InformationResource ir = (InformationResource) this.database.loadResource();
        this.notifySubscribers(new Notification(NotificationCode.RESOURCE_LOADED,ir));
    }

    public void readDataFromTable(String fromTable){
        tableModel1.setRows(this.database.readDataFromTable(fromTable));
    }


    public TableModel getTableModel1() {
        return tableModel1;
    }

    public void setTableModel1(TableModel tableModel) {
        this.tableModel1 = tableModel;
    }

    public Settings getSettings() {
        return settings;
    }

    public Database getDatabase() {
        return database;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
