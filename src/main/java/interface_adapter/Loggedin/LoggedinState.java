package interface_adapter.Loggedin;

public class LoggedinState {
    private String username = "";

    public LoggedinState(LoggedinState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedinState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
