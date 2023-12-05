package interface_adapter.Loggedin;

/**
 * Represents the state of a user being logged in.
 */
public class LoggedinState {
    private String username = "";

    /**
     * Constructs a LoggedinState by copying another instance.
     *
     * @param copy The LoggedinState instance to copy.
     */
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
