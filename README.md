# employee
1.Run the SpringBoot Application "employee" by right clicking on SpringBoot App
2.I have used in-memory database h2 so to access the console of it you can use: http://localhost:5010/employeeservice/h2-console
To access the url:
userName:admin
Password:vmware
To get Connection :
databaseurl:jdbc:h2:mem:testdb
UserName:root
Password:root
3.I have created the below APIS
	1.POST api to save the employee data which accept the file as input(inputfile is there at resource folder)
		Note: To give input as a file, we should use postman client in which we should select the formdata option in the body section and then select the key as file and upload the inputfile which is there in resource folder.
	2.GET api to fetch the transaction status where we need to pass the transactionid which we will get it from the above POST API
	3.GET api to fetch the employee by specifying the ID
	4.GET api to fecth all the employees
	5.PUT api to update the employee data which already inserted
	6.Delete api to delete the empoyee from the database.
4.Use the username: admin and password: vmware for above all apis as Basic Auth.
	
5.I have created the Dockerfile which help us to create the docker app images to push to the private ECR/ACR repositories.