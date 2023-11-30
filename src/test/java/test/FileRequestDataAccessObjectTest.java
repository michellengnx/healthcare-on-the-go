package test;

import data_access.FileRequestDataAccessObject;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CreateRequest.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileRequestDataAccessObjectTest {
    private final Service xRay = new Service("X-Ray", 200);
    private CreateRequestInputData inputData;
    private Doctor doctor;
    private float price;
    private boolean completed;
    List<Service> xRayList = new ArrayList<>();
    private float eta;
    private ServiceRequest request;

    @BeforeEach
    void init() {
        xRayList.add(xRay);
        // random input data object
        Float distance  = 20.0F;
        price = 10.0F;
        completed = false;
        eta = 20.0F;
        doctor =  new Doctor(
                "xrayDoc",
                "pass1",
                "mail1@mail.com",
                "123-123-1231",
                "male",
                new Date(),
                1,
                "23 Road Lane",
                new ArrayList<>(),
                xRayList);
        Patient patient = new Patient(
                "patient1",
                "pass1",
                "patient@mail.com",
                "123-123-1231",
                "male",
                "ins.",
                new Date(),
                new CreditCard(
                        "1234567890",
                        123,
                        "09/12",
                        "patient smith"),
                new EmergencyContact("dad smith", "123-123-1231", "dad"));
        Date date = new Date();
        Service service = new Service("X-ray", 200);
        Integer urgencyLevel = 1;
        String destination = "123 street avenue";
        request = new ServiceRequest(patient,date,doctor,urgencyLevel,destination,service,price,eta,distance);
    }

    @Test
    void getRequestUser() throws IOException {
        /**
         * Initialize an input data object, and common data access objects.
         */
        FileRequestDataAccessObject fileRequestDataAccessObject = new FileRequestDataAccessObject("/Users/ismaelchona/IdeaProject/csc207-project/src/main/java/data/requests.csv");
        fileRequestDataAccessObject.addRequest(request);






    }

    @Test
    void addRequest() {
    }


}