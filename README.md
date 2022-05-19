# Doctor App

## How To Run
There are two ways to run the app. Using docker is the easiest:

### Docker
1. Run docker compose in the run-me directory `docker compose up -d`
   1. docker will bind ports 80, 8080 and 3306. Please make sure those ports are available
   2. If this doesn't work for you then try the second option below

### Run via Java installed on your machine
2. Install java 11 (ideally, add java to your $PATH so it's easier to run)
3. Run MySql and NGINX from docker-compose file in the "run-me" folder
   1. verify you don't have port 80 or 3306 used already
   2. if you don't run the services manually make sure you comment out the app service that runs java
4. Run `java -jar doctor-app.jar` in the "run-me" folder
5. Open [http://localhost](http://localhost)

## Guide to App
### Perform a Data Load
To perform a data load open [http://localhost/jobs](http://localhost/jobs) and run a job.
Running a data load will lock the table from any other data load interacting with it. 
The jobs will automatically update on a 3-second interval so there is no need to reload the page.  
Note: Loading all rows can take a bit. You can monitor the java log to see how many lines have been processed. 
Due to network things running everything within docker gives the best performance. Running using the second option
makes the dataload take a bit longer due to networking between host machine and docker.

### View/delete table locks
To view or delete a table lock either delete the job holding the lock or visit
[http://localhost/locks](http://localhost/locks) and delete the lock.

### Search and Export Data
Go to [http://localahost](http://localhost) and perform searches against data points.
Click the export button to export the table results.  
Note: the search is setup to do a "like" query for typeahead and an "equal" query for submitting the search form. Therefore, searching
for "matt" will only yield results for "matt" not "matthew". The typeahead, on the other hand, will return "matt" and "matthew" search results.
