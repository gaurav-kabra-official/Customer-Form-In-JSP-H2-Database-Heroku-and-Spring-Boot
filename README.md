## Customer Form 
### using JSP, H2 Database, Heroku and Spring Boot

#### Author : Gaurav Kabra

```
Set-up : Heroku (Optional), Postman (Optional) and Spring Boot in Eclipse Ide
```

## About

* http://localhost:{port_no}/ <br>
Form page where customer enters info (Id, Name and Email).<br>
Constraits : Id is primary key (PK) and Email must be of valid structure.<br>
Note : You can set {port_no} in <b>application.properties</b>. In this repo, it is 8083.

* http://localhost:{port_no}/getdetails <br>
Page where retrieve customer details with Id.<br>
Constraints : If customer with provided Id not found then instead of Whitelabel Error Page, must show appropriate message such as Invalid Id.

* http://localhost:{port_no}/h2-console/ <br>
In-memory database (H2-Db). Connect with your application by typing url provided in <b>application.properties</b> file.<br>
Type in SQL queries such as "SELECT * FROM Customers" and hit Run button to get all items in Database.

```
Postman GUI
> GET http://localhost:{port_no}/customers/
Equivalent to SELECT command in database console.
To get 
> DELETE http://localhost:{port_no}/customers/{cid}
Delete customer with Id={cid}.
```
# Deploying App with Heroku
Install Heroku CLI (Heroku is a Salesforce Company)
Type these commands:
> git init
> git add .
> git commit -m "initial commit"
> heroku login (Here browser will open, click LogIn)
> heroku create
> git push heroku master
> git open

<strong> Online demo using Heroku : https://still-temple-97030.herokuapp.com/ </strong>


