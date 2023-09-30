# Healthcare On the Go :ambulance:

## **_Description of Project Domain_**

With insufficient accessibility and access to transportation services, hundreds of people, particularly seniors, are under threat of missing critical medical care. Subsequently, our project domain aims to create a specialised and convenient transportation service that will alleviate this problem by following an API similar to Uber. However, instead of offering rides to get customers to a certain destination, our application will help bring healthcare workers to you, your family members, and your friends.

## **_High-level Application Description_**

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
Response{protocol=h2, code=200, message=, url=https://www.mapquestapi.com/directions/v2/route?key=KEY&from=University%20of%20Toronto&to=York%20Univerisity}
{"route":{"hasTollRoad":true,"hasBridge":true,"bo ...
Distance : 10.742450 miles, ETA : 6707 seconds
Process finished with exit code 0
```

## Authors :information_desk_person:

See the list of [contributors](https://github.com/michellengnx/csc207-project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments :bow:

* Hat tip to anyone whose code was used
* Inspiration
* etc
