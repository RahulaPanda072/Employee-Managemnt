# Employee-Managemnt
To add the emp object use as the below url
url:
http://localhost:8080/employees
body: 
[{
	"employeeID" : 12,
	"firstName" :"Sam",
	"lastName" : "Winchester",
	"gender" : "Male",
	"dept" : 20,
	"salary": 11000
},
{
	"employeeID" : 13,
	"firstName" :"Sam1",
	"lastName" : "Wincheste1r",
	"gender" : "Male",
	"dept" : 30,
	"salary": 12000
}]

To get all employee use below url
http://localhost:8080/employees

To get a perticular employee details 
http://localhost:8080/employees/20
here 20 is employee id

Get the employee count by Department and emp id whose Salary is >=10000 .
http://localhost:8080/employees/20/10
here 20 is employee id and 10 is dept
