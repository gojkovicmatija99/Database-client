package actions;

public class ActionManager {

    private static ActionManager instance = null;

    public static ActionManager getInstance() {
        if (instance == null)
            instance = new ActionManager();
        return instance;
    }

    private AddAction addAction;
    private DeleteAction deleteAction;
    private UpdateAction updateAction;
    private FilterSortAction filterSortAction;
    private ReportsAction reportsAction;

    public ActionManager() {
        addAction = new AddAction();
        deleteAction = new DeleteAction();
        updateAction = new UpdateAction();
        filterSortAction = new FilterSortAction();
        reportsAction = new ReportsAction();
    }

    public AddAction getAddAction() {
        return addAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public UpdateAction getUpdateAction() {
        return updateAction;
    }

    public FilterSortAction getFilterSortAction() {
        return filterSortAction;
    }

    public ReportsAction getReportsAction() {
        return reportsAction;
    }

    public void setAddAction(AddAction addAction) {
        this.addAction = addAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public void setUpdateAction(UpdateAction updateAction) {
        this.updateAction = updateAction;
    }
}

