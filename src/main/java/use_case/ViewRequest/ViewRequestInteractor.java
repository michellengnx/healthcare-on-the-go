package use_case.ViewRequest;


import java.util.ArrayList;

public class ViewRequestInteractor implements ViewRequestInputBoundary {
    private final RequestDataAccess requestDataAccess;
    private final ViewRequestOutputBoundary viewData;


    public ViewRequestInteractor(RequestDataAccess requestDataAccess, ViewRequestOutputBoundary viewRequestOutputBoundary) {
        this.requestDataAccess = requestDataAccess;
        this.viewData = viewRequestOutputBoundary;
    }

    public ArrayList<ArrayList<String>> getRequestDetails(String userName) {
        return requestDataAccess.getRequestUser(userName);
    }

    /**
     * @param viewRequestInputData
     */
    @Override
    public void execute(ViewRequestInputData viewRequestInputData) {
        ArrayList<ArrayList<String>> data = getRequestDetails(viewRequestInputData.getUserName());
        ViewRequestOutputData viewRequestOutputData = new ViewRequestOutputData(data);

        viewData.prepareSuccessView(viewRequestOutputData);


    }
}