# Medical Data App

Backend application for medical data management via REST API.

### Doctors
Doctors have properties as id, department and list of patients. 
Implement REST operations to support basic UI requirements: 
• list all doctors  
• search doctor with given id

### Patients
Patients have properties as first name, last name and list of diseases. 
Implement REST operations to support basic UI requirements: 
• list all patients 
• search patient with given id  
• search patient's diseases

## Application run
Docker image is available at: https://hub.docker.com/repository/docker/ikostadinovska/medical-data

### Run with **docker-compose**

Go to ```/src/main/scripts``` and run ```docker-compose up``` in your console. Be sure to create folder **data** with subfolders **input**, **output** and **error** and placed it in ```C:/data```. You can choose different location, but be sure also to change the location in ```docker-compose.yml``` file.

To test the application reading from an input file, you can place ```doctor_report.xml``` (provided in the repo) file into **data/input** folder.

### Run with maven

You can also run the application using maven and command ```mvn spring-boot:run```, but be sure to change the database connection properties in the ```application.properties``` file.

## Documentation
Documentation will be available in OpenAPI format at ```/swagger-ui.html``` endpoint.
