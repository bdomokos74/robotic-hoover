# robotic-hoover

This project is a solution to the task described [here](https://github.com/lampkicking/java-backend-test).

This project requires Java 8 and Maven.

To build the package, run

mvn clean package

This will create a war file which can be deployed.

To run the web service, the database needs to be created (the first time):

```Bash
mvn sql:execute
```

This will create a derby database at './data/db'. If deployed externally,
make sure that the database is available.

To run the web service:

```Bash
mvn jetty:run-war
```

After starting up, the following url is accessible in the browser:

http://localhost:8080/api/simulations

To test the web service, a POST request needs to be sent to this url,
e.g. using curl the following way:

```Bash
curl -i -X POST -H "Content-type: application/json" -d "@data/test.in" localhost:8080/api/simulations
```

Which results:

```
HTTP/1.1 200 OK
Date: Fri, 06 May 2016 00:20:25 GMT
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Server: Jetty(9.3.7.v20160115)

{"coords":[1,3],"patches":1}
```

After this poing the simulation is added to the database, and is visible at
http://localhost:8080/api/simulations

or with curl:

```Bash
curl -i http://localhost:8080/api/simulations
```
