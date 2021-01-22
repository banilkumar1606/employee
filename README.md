# employee
Run the SpringBoot Application "employee" by right clicking on SpringBoot App

I have used in-memory database h2 so to access the console of it you can use: http://localhost:5010/employeeservice/h2-console
To access the url:
userName:admin
Password:vmware
To get Connection :
databaseurl:jdbc:h2:mem:testdb
UserName:root
Password:root


I have created the below APIS
**POST api to save the employee data which accept the file as input(inputfile is there at resource folder)
		Note: To give input as a file, we should use postman client in which we should select the formdata option in the body section and then select the key as file and upload the inputfile which is there in resource folder.
                
                
**GET api to fetch the transaction status where we need to pass the transactionid which we will get it from the above POST API
        
        
**GET api to fetch the employee by specifying the ID
        
        
**GET api to fecth all the employees
        
        
**PUT api to update the employee data which already inserted
        
**Delete api to delete the empoyee from the database.
        
        
Use the username: admin and password: vmware for above all apis as Basic Auth.
	


I have created the Dockerfile which help us to create the docker app images to push to the private ECR/ACR repositories.
