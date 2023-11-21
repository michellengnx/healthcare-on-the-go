package interface_adapter.edited_profile;

public class EditedState {
    private String username = "";
    // should password be asterisked?
    private String password = "";
    private String email = "";
    private String phoneNumber = "";
    private String insurance = "";

    public EditedState(EditedState copy) {
        username = copy.username;
        password = copy.password;
        email = copy.email;
        phoneNumber = copy.phoneNumber;
        insurance = copy.insurance;
    }

    public EditedState() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

}
