package use_case.edit_profile;

public class EditInputData {

    final private String username;
    final private String password;
    final private String newParameter;

    public EditInputData(String username, String password, String newParameter) {
        this.username = username;
        this.password = password;
        this.newParameter = newParameter;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getNewParameter() {
        return newParameter;
    }
}
