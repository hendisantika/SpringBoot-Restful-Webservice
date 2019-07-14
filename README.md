# SpringBoot-Restful-Webservice
RestfulWebserviceSpringBoot

For Testing using postman

When the application is started it creates 10 employees with Id starting from 1 to 10. Id is AutoIncrement 

Get All Employees
```
GET http://localhost:8080/secure/allEmployee 
```

Get Employee by Id
```
GET http://localhost:8080/secure/employee/{id} 
```

Delete Employee By id
```
Delete http://localhost:8080/secure/employee/{id}
```

Add New Employee
```  
POST http://localhost:8080/secure/employee
RequestBody 
{"name":"Employee12","salary":20.5}
```

Update Employee data
```
http://localhost:8080/secure/employee/{id} PUT
RequestBody 
{"name":"Employee11 changed to","salary":20.5}
```
