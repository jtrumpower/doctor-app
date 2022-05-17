# Doctor App

## How To Run
1. Install java 11 (ideally, add java to your $PATH so its easier to run)
2. Run MySql and NGINX from docker-compose file in the "run-me" folder
   1. verify you don't have port 80 or 3306 used already
3. Run `java -jar doctor-app.jar` in the "run-me" folder
4. Open [http://localhost](http://localhost:8080)

## Guide to App
### Perform a Data Load
To perform a data load open [http://localhost/jobs](http://localhost/jobs) and run a job.
Running a data load will lock the table from any other data load interacting with it. 
The jobs will automatically update on a 3-second interval so there is no need to reload the page.

### View/delete table locks
To view or delete a table lock either delete the job holding the lock or visit
[http://localhost/locks](http://localhost/locks) and delete the lock.

### Search and Export Data
Go to [http://localahost](http://localhost) and perform searches against data points.
Click the export button to export the table results.
