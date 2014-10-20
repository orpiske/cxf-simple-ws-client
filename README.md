Otavio's Apache CXF Examples: WebService Client
============

This example shows how to create a simple WebService client using Apache CXF

Usage
----

To compile the client code, using Apache Maven: 

```
mvn -P Delivery clean package
```

Note: you will need to have installed the CXF WS Types before doing so.

To install, just unpack it to your preferred location. To run, go to its directory and run:

```
java -jar cxf-simple-ws-client-1.0.0-SNAPSHOT.jar
```

By default, the transactions will be sent to http://localhost:80/TimeService. If you are 
running the server on a different port, you can use: 


```
 java -jar cxf-simple-ws-client-1.0.0-SNAPSHOT.jar http://orpiske:8080/camel-cxf-web/TimeService
```

References
----

* [Main Site](http://orpiske.net/)
* [Apache Maven](http://maven.apache.org/)
* [Apache CXF](http://cxf.apache.org/)
