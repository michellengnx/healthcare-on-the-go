package use_case.ViewRequest;


import java.util.ArrayList;

/**
 * Interactor responsible for handling the viewing of request details.
 */
public class ViewRequestInteractor implements ViewRequestInputBoundary {
    private final RequestDataAccessInterface requestDataAccess;
    private final ViewRequestOutputBoundary viewData;


    /**
     * Constructs a ViewRequestInteractor.
     *
     * @param requestDataAccessInterface       The data access object for retrieving request details.
     * @param viewRequestOutputBoundary The output boundary for presenting view request data.
     */
    public ViewRequestInteractor(RequestDataAccessInterface requestDataAccessInterface, ViewRequestOutputBoundary viewRequestOutputBoundary) {
        this.requestDataAccess = requestDataAccessInterface;
        this.viewData = viewRequestOutputBoundary;
    }

    /**
     * Retrieves request details associated with a specific user.
     *
     * @param userName The username associated with the request details to be retrieved.
     * @return The list of request details for the given user.
     */
    public ArrayList<ArrayList<String>> getRequestDetails(String userName) {
        return requestDataAccess.getRequestUser(userName);
    }

    /**
     * Executes the view request operation based on the provided input data.
     *
     * @param viewRequestInputData The input data specifying the username for request details.
     */
    @Override
    public void execute(ViewRequestInputData viewRequestInputData) {
        ArrayList<ArrayList<String>> data = getRequestDetails(viewRequestInputData.getUserName());
        ViewRequestOutputData viewRequestOutputData = new ViewRequestOutputData(data);

        viewData.prepareSuccessView(viewRequestOutputData);


    }
}