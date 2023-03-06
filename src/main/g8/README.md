# Sample Pekko HTTP server

This is a sample Pekko HTTP endpoint keeping an in-memory database of users that can be created and listed.

Sources in the sample:

* `QuickstartApp.java` -- contains the main method which bootstraps the application
* `UserRoutes.java` -- Pekko HTTP `routes` defining exposed endpoints
* `UserRegistry.java` -- the actor which handles the registration requests

## Running

Once inside the project folder, to run this code:

```
sbt run
```

This template also provides build descriptors for maven and gradle. You can use any of the following commands to run
the application:

```
mvn compile
mvn exec:java
```

or

```
gradle run
```

All three commands run `com.lightbend.pekko.http.sample.QuickstartServer` by default.

## Interacting with the sample

After starting the following requests can be made:

List all users:

    curl http://localhost:8080/users

Create a user:

    curl -XPOST http://localhost:8080/users -d '{"name": "Liselott", "age": 32, "countryOfResidence": "Norway"}' -H "Content-Type:application/json"

Get the details of one user:

    curl http://localhost:8080/users/Liselott

Delete a user:

    curl -XDELETE http://localhost:8080/users/Liselott