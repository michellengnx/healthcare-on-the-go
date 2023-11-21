package org.example.src.use_case.edit_profile;

public class EditOutputData {
    private final String changes;
    private boolean useCaseFailed;

    public EditOutputData(String changes, boolean useCaseFailed) {
        this.changes = changes;
        this.useCaseFailed = useCaseFailed;
    }

    public String getChanges() {
        return changes;
    }
}
