package use_case.edit_profile;

public class EditOutputData {
    private final Integer changes;
    private boolean useCaseFailed;

    public EditOutputData(Integer changes, boolean useCaseFailed) {
        this.changes = changes;
        this.useCaseFailed = useCaseFailed;
    }

    public Integer getChanges() {
        return changes;
    }
}
