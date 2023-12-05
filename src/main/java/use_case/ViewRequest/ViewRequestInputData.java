package use_case.ViewRequest;

/**
 * Represents input data for viewing request details associated with a specific user.
 */
public class ViewRequestInputData {

    private String userName;
    /**
     * Retrieves the username associated with the request details.
     *
     * @return The username for retrieving request details.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Constructs ViewRequestInputData with the provided username.
     *
     * @param userName The username associated with the request details to be viewed.
     */
    public ViewRequestInputData(String userName){
        this.userName = userName;

    }
}
