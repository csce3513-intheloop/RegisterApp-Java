#Reminders on how to push and pull from command line
$ "git status" will show what files differs from local and master
$ "git add ." will add every file that differs to be uploaded. You can specify specific files or folder to be added, for example this will only add employeeDetail.html "git add .\src\main\resources\templates\employeeDetail.html"
$ "git commmit -m "Comment Here"" will commit on github, with your message to explain the changes.
$ "git push -u origin master" will push to the master

If you get a message such as "Updates were rejected because the tip of your current branch is behind its remote
counterpart. Integrate the remote changes (e.g. ‘git pull …’) before pushing again", then "$ git pull" and try again from "$ git add"

# Basic description
Browser based register application that interacts with a PostgreSQL database. Implemented in Java with Spring Boot and JPA. Edited in Visual Studio Code.  
  
The application defaults to port 8080.

To start from the IDE press F5 to run. This will open the debug and run view. You will need to create a launch configuration which Visual Studio Code will help you with.  

 # Landing page (list available products)
`https://uarkregappjava.herokuapp.com/`
