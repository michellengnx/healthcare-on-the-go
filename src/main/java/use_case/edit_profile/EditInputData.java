package use_case.edit_profile;

public class EditInputData {
    // should optional be here too?
    // initalize to current one?
    final private String username;
    final private String password;
    final private String email;
    final private String phoneNumber;
    final private String insurance;

    public EditInputData(String username, String password, String email, String phoneNumber, String insurance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.insurance = insurance;
    }

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
}
