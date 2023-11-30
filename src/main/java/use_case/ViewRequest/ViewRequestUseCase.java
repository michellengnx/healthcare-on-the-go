package use_case.ViewRequest;


import entities.ServiceRequest;
import data_access.RequestDataAccess;
import entities.Service;
import entities.ServiceRequest;

import java.util.ArrayList;

public class ViewRequestUseCase {
    private RequestDataAccess requestDataAccess;

    public ViewRequestUseCase(RequestDataAccess requestDataAccess) {
        this.requestDataAccess = requestDataAccess;
    }

    public ArrayList<ArrayList<String>> getRequestDetails(String userName) {
        return requestDataAccess.getRequestUser(userName);
    }

}