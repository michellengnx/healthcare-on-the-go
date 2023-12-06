package interface_adapter.ViewRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewRequestStateTest {

    private ViewRequestState viewRequestState;

    @BeforeEach
    void setUp() {
        viewRequestState = new ViewRequestState();
    }

    @Test
    void setAndGetUserName() {
        ArrayList<String> userName = new ArrayList<>();
        userName.add("user1");
        userName.add("user2");
        viewRequestState.setUserName(userName);
        assertEquals(userName, viewRequestState.getUserName());
    }

    @Test
    void setAndGetCreationTime() {
        ArrayList<String> creationTime = new ArrayList<>();
        creationTime.add("time1");
        creationTime.add("time2");
        viewRequestState.setCreationTime(creationTime);
        assertEquals(creationTime, viewRequestState.getCreationTime());
    }

    @Test
    void setAndGetDoctorNames() {
        ArrayList<String> doctorNames = new ArrayList<>();
        doctorNames.add("doctor1");
        doctorNames.add("doctor2");
        viewRequestState.setDoctorNames(doctorNames);
        assertEquals(doctorNames, viewRequestState.getDoctorNames());
    }

    @Test
    void setAndGetServices() {
        ArrayList<String> services = new ArrayList<>();
        services.add("service1");
        services.add("service2");
        viewRequestState.setServices(services);
        assertEquals(services, viewRequestState.getServices());
    }

    @Test
    void setAndGetDestinations() {
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("destination1");
        destinations.add("destination2");
        viewRequestState.setDestinations(destinations);
        assertEquals(destinations, viewRequestState.getDestinations());
    }

    @Test
    void setAndGetUrgencies() {
        ArrayList<Integer> urgencies = new ArrayList<>();
        urgencies.add(1);
        urgencies.add(2);
        viewRequestState.setUrgencies(urgencies);
        assertEquals(urgencies, viewRequestState.getUrgencies());
    }

    @Test
    void setAndGetEtas() {
        ArrayList<Float> etas = new ArrayList<>();
        etas.add(1.5f);
        etas.add(2.5f);
        viewRequestState.setEtas(etas);
        assertEquals(etas, viewRequestState.getEtas());
    }

    @Test
    void setAndGetDistances() {
        ArrayList<Float> distances = new ArrayList<>();
        distances.add(10.0f);
        distances.add(20.0f);
        viewRequestState.setDistances(distances);
        assertEquals(distances, viewRequestState.getDistances());
    }

    @Test
    void setAndGetCompleted() {
        ArrayList<Boolean> completed = new ArrayList<>();
        completed.add(true);
        completed.add(false);
        viewRequestState.setCompleted(completed);
        assertEquals(completed, viewRequestState.getCompleted());
    }

    @Test
    void copyConstructor() {
        ArrayList<String> userName = new ArrayList<>();
        userName.add("user1");
        ArrayList<String> creationTime = new ArrayList<>();
        creationTime.add("time1");
        ArrayList<String> doctorNames = new ArrayList<>();
        doctorNames.add("doctor1");
        ArrayList<String> services = new ArrayList<>();
        services.add("service1");
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("destination1");
        ArrayList<Integer> urgencies = new ArrayList<>();
        urgencies.add(1);
        ArrayList<Float> etas = new ArrayList<>();
        etas.add(1.5f);
        ArrayList<Float> distances = new ArrayList<>();
        distances.add(10.0f);
        ArrayList<Boolean> completed = new ArrayList<>();
        completed.add(true);

        ViewRequestState original = new ViewRequestState();
        original.setUserName(userName);
        original.setCreationTime(creationTime);
        original.setDoctorNames(doctorNames);
        original.setServices(services);
        original.setDestinations(destinations);
        original.setUrgencies(urgencies);
        original.setEtas(etas);
        original.setDistances(distances);
        original.setCompleted(completed);

        ViewRequestState copy = new ViewRequestState(original);
        assertEquals(original.getUserName(), copy.getUserName());
        assertEquals(original.getCreationTime(), copy.getCreationTime());
        assertEquals(original.getDoctorNames(), copy.getDoctorNames());
        assertEquals(original.getServices(), copy.getServices());
        assertEquals(original.getDestinations(), copy.getDestinations());
        assertEquals(original.getUrgencies(), copy.getUrgencies());
        assertEquals(original.getEtas(), copy.getEtas());
        assertEquals(original.getDistances(), copy.getDistances());
        assertEquals(original.getCompleted(), copy.getCompleted());
    }

    @Test
    void constructorWithArrayList() {
        ArrayList<ArrayList<String>> requestData = new ArrayList<>();
        ArrayList<String> request1 = new ArrayList<>();
        request1.add("user1");
        request1.add("time1");
        request1.add("doctor1");
        request1.add("1");
        request1.add("destination1");
        request1.add("service1");
        request1.add("");
        request1.add("1.5");
        request1.add("10.0");
        request1.add("true");
        ArrayList<String> request2 = new ArrayList<>();
        request2.add("user2");
        request2.add("time2");
        request2.add("doctor2");
        request2.add("2");
        request2.add("destination2");
        request2.add("service2");
        request2.add("");
        request2.add("2.5");
        request2.add("20.0");
        request2.add("false");
        requestData.add(request1);
        requestData.add(request2);

        ViewRequestState state = new ViewRequestState(requestData);
        assertEquals(requestData.get(0).get(0), state.getUserName().get(0));
        assertEquals(requestData.get(0).get(1), state.getCreationTime().get(0));
        assertEquals(requestData.get(0).get(2), state.getDoctorNames().get(0));
        assertEquals(requestData.get(0).get(3), String.valueOf(state.getUrgencies().get(0)));
        assertEquals(requestData.get(0).get(4), state.getDestinations().get(0));
        assertEquals(requestData.get(0).get(5), state.getServices().get(0));
        assertEquals(Float.parseFloat(requestData.get(0).get(7)), state.getEtas().get(0));
        assertEquals(Float.parseFloat(requestData.get(0).get(8)), state.getDistances().get(0));
        assertEquals(Boolean.parseBoolean(requestData.get(0).get(9)), state.getCompleted().get(0));
        assertEquals(requestData.get(1).get(0), state.getUserName().get(1));
        assertEquals(requestData.get(1).get(1), state.getCreationTime().get(1));
        assertEquals(requestData.get(1).get(2), state.getDoctorNames().get(1));
        assertEquals(requestData.get(1).get(3), String.valueOf(state.getUrgencies().get(1)));
        assertEquals(requestData.get(1).get(4), state.getDestinations().get(1));
        assertEquals(requestData.get(1).get(5), state.getServices().get(1));
        assertEquals(Float.parseFloat(requestData.get(1).get(7)), state.getEtas().get(1));
        assertEquals(Float.parseFloat(requestData.get(1).get(8)), state.getDistances().get(1));
        assertEquals(Boolean.parseBoolean(requestData.get(1).get(9)), state.getCompleted().get(1));
    }
}
