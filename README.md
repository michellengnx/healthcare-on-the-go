# Healthcare On the Go :ambulance:

## How to Run :

1. Clone the repo to your local device
2. Retrieve an API key from the [MapQuest API](https://developer.mapquest.com/)
3. Run the `main(String args[])` method in `src/main/java/app/App.java`, and ensure your run configuration is set such that the `API_KEY` environment variable corresponds your personally generated API key

## Description of Project Domain

With insufficient accessibility and access to transportation services, hundreds of people, particularly seniors, are under threat of missing critical medical care. Subsequently, our project domain is a **ride-hailing platform**, where _patients_ can request _doctors_ to visit them at the comfort of their homes.

## Software Specification

Healthcare On The Go addresses the challenge above by linking patients with essential medical services. Patients can request the necessary care needed on demand by creating a profile on the application, with the possibility to edit their details whenever requested by the user. Through the Healthcare On The Go dashboard, patients will be able to select their desired medical care, the urgency level of the request, and their location. The program will then display a visual representation of the distance between the patient and the doctor, the price of the service when ordering a ride, and the ETA of the doctor.

## Built With :hammer:

* [Java](https://www.java.com/en/)
* [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/)

### APIs

* [MapQuest API](https://developer.mapquest.com/documentation/directions-api/route/get)
  

#### Screenshot of calling the API with Hoppscotch

![image](https://github.com/michellengnx/csc207-project/assets/62626538/eb91427b-ca1e-450b-ae4b-2aac29f409a9)

#### Output when running sample Java code

- For the code itself, see [`MapQuest.java`](https://github.com/michellengnx/csc207-project/blob/master/MapQuest.java)

```
Response : Response{protocol=h2, code=200, message=, url=https://www.mapquestapi.com/directions/v2/route?key=KEY&from=University%20of%20Toronto&to=York%20Univerisity}
Distance : 10.617559 miles, ETA : 6596 seconds
```

## List of Technical Problems Blocking Progress

- displaying a map for patients to see when ordering a ride _[completed]_

## Authors :information_desk_person:

Group 163 - TUT0401

See the list of [contributors](https://github.com/michellengnx/csc207-project/contributors) who participated in this project.
