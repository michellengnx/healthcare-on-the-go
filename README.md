# Healthcare On the Go :ambulance:

## Description of Project Domain

With insufficient accessibility and access to transportation services, hundreds of people, particularly seniors, are under threat of missing critical medical care. Subsequently, our project domain aims to create a specialised and convenient transportation service that will alleviate this problem by following an API similar to Uber. However, instead of offering rides to get customers to a certain destination, our application will help bring healthcare workers to you, your family members, and your friends.

## High-level Application Description

Healthcare On The Go addresses the challenge above by allowing caregivers and coordinators to link patients with essential medical services, using our extensive network and collaborative partnerships. 

Guardians or patients themselves will be able to request the necessary care needed on demand by creating a profile on the application. Through the Healthcare On The Go dashboard, patients will be able to select their desired medical care and the emergency level of the request. Patients will also be able to see the price of the service when ordering a ride, where the cost is calculated based on the distance from the nearest respective doctor and the patient’s location. Moreover, patients will be able to see a brief overview of a caregiver’s service when they accept a request, such as past patients’ comments and ratings.

After a ride is requested, patients will receive confirmation via email or text message with the details of their request. They will also receive another notification when the caregiver is en route. A trusted contact also has the ability to view the doctor’s credentials and receive confirmation once they arrive at the patient’s location.

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

- displaying a map for patients to see when ordering a ride
- connecting or storing a doctor database to the application
- creating a 'cancel order' method

## Authors :information_desk_person:

Group 163 - TUT0401
See the list of [contributors](https://github.com/michellengnx/csc207-project/contributors) who participated in this project.
