package data_access;

import data_access.FileRequestDataAccessObject;
import entities.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestPresenter;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.*;
import use_case.ViewRequest.ViewRequestInteractor;
import use_case.ViewRequest.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileRequestDataAccessInterfaceObjectTest {
    private final Service xRay = new Service("X-Ray", 200);
    private CreateRequestInputData inputData;
    private Doctor doctor;
    private float price;
    private boolean completed;
    List<Service> xRayList = new ArrayList<>();
    private float eta;
    private ServiceRequest request;
    private Patient patient;
    private Date date;
    private Service service;
    private Integer urgencyLevel;
    private String destination;

    @BeforeEach
    void init() {
        xRayList.add(xRay);
        // random input data object
        float distance  = 20;
        price = 10;
        completed = false;
        eta = 20.0F;
        doctor =  new Doctor(
                "xrayDoc",
                "pass1",
                "mail1@mail.com",
                "123-123-1231",
                "male",
                date,
                1,
                "23 Road Lane",
                new ArrayList<>(),
                xRayList);
        patient = new Patient(
                "Izora",
                "pass1",
                "patient@mail.com",
                "123-123-1231",
                "male",
                "ins.",
                date,
                new CreditCard(
                        "1234567890",
                        123,
                        "09/12",
                        "patient smith"),
                new EmergencyContact("dad smith", "123-123-1231", "dad"));
        date = new Date();
        service = new Service("X-ray", 200);
        urgencyLevel = 1;
        destination = "123 street avenue";
        request = new ServiceRequest(date,doctor,urgencyLevel,destination,service,price,eta,distance);
    }


    @Test
    void addRequestAndGetRequest()  throws IOException {
        /**
         * Initialize an input data object, and common data access objects.
         *
         */

        ArrayList<String> temp = new ArrayList<String>();
        temp.add(0, patient.getUsername());
        temp.add(1, date.toString());
        temp.add(2, doctor.getUsername());
        temp.add(3, urgencyLevel.toString());
        temp.add(4, destination);
        temp.add(5, service.getName());
        temp.add(6, Float.toString(price));
        temp.add(7, Float.toString(eta));
        temp.add(8, Float.toString(request.getDistance()));
        temp.add(9, "false");

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        result.add(0, temp);
        result.add(1, temp);
        result.add(2, temp);
        FileRequestDataAccessObject fileRequestDataAccessObject = new FileRequestDataAccessObject("test_data/requests_test.csv");
        fileRequestDataAccessObject.clear();
        String userName = "Izora";
        fileRequestDataAccessObject.addRequest(request, "Izora");
        fileRequestDataAccessObject.addRequest(request, "Izora");
        fileRequestDataAccessObject.addRequest(request, "Izora");
        ViewRequestPresenter viewRequestPresenter = new ViewRequestPresenter(new ViewManagerModel(), new ViewRequestViewModel());
        ViewRequestInteractor viewRequestInteractor = new ViewRequestInteractor(fileRequestDataAccessObject, viewRequestPresenter);
        ArrayList<ArrayList<String>> patientRequests = viewRequestInteractor.getRequestDetails("Izora");

        for (int i = 0; i < result.size(); i++) {
            ArrayList<String> expected = result.get(i);
            ArrayList<String> actual = patientRequests.get(i);

            // Assert each row of 'result' and 'patientRequests'
            assertEquals(expected.size(), actual.size(), "Sizes of rows should be equal");
            for (int j = 0; j < expected.size(); j++) {
                assertEquals(expected.get(j), actual.get(j), "Values should be equal");
            }



        }
    }




}