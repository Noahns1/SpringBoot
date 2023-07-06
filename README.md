# SpringBoot

---
### :man_technologist: About me:
I have a strong background in Quality Assurance and automation, and I am equally passionate about software development. Additionally, I have received comprehensive training in Java full-stack development, and I possess proficient programming skills in Python.

[LinkedIn](https://www.linkedin.com/in/noah-schlaupitz-786a04195/)

---
Languages and Tools:
<div>
  <img src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" width="40" height="40"/>&nbsp;
  <img src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" width="40" height="40"/>&nbsp;
  <img src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" width="40" height="40"/>&nbsp;
  <img src="https://user-images.githubusercontent.com/25181517/192109061-e138ca71-337c-4019-8d42-4792fdaa7128.png" width="40" height="40"/>&nbsp;
  <img src="https://user-images.githubusercontent.com/25181517/117533873-484d4480-afef-11eb-9fad-67c8605e3592.png" width="40" height="40"/>&nbsp;
  <img src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png" width="50" height="40"/>&nbsp;
  <img src="https://user-images.githubusercontent.com/25181517/183894676-137319b5-1364-4b6a-ba4f-e9fc94ddc4aa.png" width="50" height="40"/>&nbsp;
</div>

---
### What Is My Project?
The project entails developing a RESTful API backend using Java SpringBoot and Maven. It revolves around a single table named 'Animals,' with data stored in memory using h2 for a lightweight and easily manageable startup. This setup is primarily employed for conducting unit and API testing purposes.


---
### Why Is This Project Useful?
With the objective of showcasing my proficiency in Java Spring Boot and my comprehensive understanding of REST APIs, I developed this project. Alongside the implementation of REST API endpoints, I focused on testing various methods such as GET, POST, and DELETE. To ensure the accuracy and functionality of the RESTful API, I utilized JUnit for thorough unit testing and employed Postman for effective verification and testing purposes.

---
### Dependencies
- Springboot
- Spring Web
- Spring JPA
- H2 Database
- Lombok
- Maven
- Junit

---
### How To Use This Project

Assuming that all the necessary dependencies have been downloaded, starting up and testing the application is a straightforward process. To run the Tomcat server, execute the "SpringBootApplication" class. Once the server is up and running, you can access the REST endpoint through a web browser or Postman by navigating to "localhost:9090".

For running the JUnit tests, you can follow these steps:

1. Go to the following directory: "src > test > java > com.example.SpringBootApp". This is where the testing files are located.
2. Right-click on the desired test file.
3. Select "Run" to execute the test cases associated with that file.

### REST API Junit tests
I have arranged these tests in a specific order to ensure that they can be executed seamlessly and as intended when the system starts up.

Tests:

1. shouldCreate
   - To transmit JSON data to the API endpoint "/addAnimal," it utilizes the POST method.
2. shouldReadAll
   - To verify the functionality of the endpoint, it employs the GET method to check the API endpoint "/getAllAnimals" and verifies that the size is equal to 1.
3. shouldReadById
   - By utilizing the GET method, it retrieves the item by its ID from the endpoint "/getAnimalById/{id}".
4. shouldUpdateById
   - I utilized the POST method to update the data through the endpoint "/updateAnimalById/{id}".
5. shouldDelete
   - I utilized the DELETE method to remove the data through the endpoint "/deleteAnimalById/{id}".

















