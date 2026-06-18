# Viva / Interview Questions

##  Basic

- What is Spring Boot?
  Answer->>>  Spring Boot is a Java framework used to create standalone, production-ready Spring applications with minimal configuration. It provides auto-configuration, embedded servers, and starter dependencies.

- What is MVC architecture?
  Answer->>>>  MVC stands for Model-View-Controller.

Model: Handles data and business logic.
View: Displays data to the user.
Controller: Handles user requests and connects Model with View.

---

##  Intermediate

- What is Service layer?
Answer->>>>  The Service Layer contains business logic of the application. It receives requests from the Controller, processes them, and interacts with the Repository layer.
  
- What is Repository in Spring Data JPA?
  Answer->>>>> Repository is an interface used to perform database operations such as save, update, delete, and fetch data. It acts as a bridge between the application and the database.
  

- Difference between GET and POST?
  Answer->>>>
GET: Used to retrieve data from the server.
POST: Used to send data to the server and create new records.

---

##  Advanced (Project Based)

- How does subscription flow work?
  Answer->>>>  The user selects a Skill Pack and submits the subscription form. The Controller receives the request, the Service Layer processes the business logic, and the Repository saves the subscription details in the database.

  
- How do you link User and SkillPack?
Answer->>>> User and SkillPack are linked using JPA relationships. A Subscription entity stores references to both User and SkillPack using foreign keys.

- Why do we use Service layer?
  Answer-> We use the Service Layer to separate business logic from the Controller. It improves code reusability, maintainability, and follows a layered architecture.

- How does JSP get data from Controller?
 Answer->>> The Controller adds data to the Model object and returns the JSP page name. JSP accesses the data using Expression Language (EL) or JSTL tags.

Example:

model.addAttribute("user", user);
return "profile";

In JSP:

${user.name}
