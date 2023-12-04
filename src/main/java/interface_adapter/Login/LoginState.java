package interface_adapter.Login;

public class LoginState {
    private String username = "";
    private String password = "";
    private String error = null;

//    public LoginState(LoginState copy) {
//        username = copy.username;
//        password = copy.password;
//        error = copy.error;
//    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoginState() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setError(String error) {
        this.error = error;
    }
}
