package use_case.edit_profile;

public class EditOutputData {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber;
    private final String insurance;
    private boolean useCaseFailed;

    public EditOutputData(String username, String password, String email,
                          String phoneNumber, String insurance, boolean useCaseFailed) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.insurance = insurance;
        this.useCaseFailed = useCaseFailed;
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
