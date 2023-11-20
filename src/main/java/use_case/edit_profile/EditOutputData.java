package use_case.edit_profile;

// what is the actual function of output data in this use case and in the log in use case?
public class EditOutputData {
    private final String username;
    private boolean useCaseFailed;

    public EditOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }
}
