# Microprofile PoC

This is a proof-of-concept implementation of a REST API using the Microprofile specifications.

This is tested using a TomEE 9.x server, which contains Tomcat 10.x and supports Jakarta EE 9.1 and Microprofile 5.0.

## Requirements
You must add the `tomee.mp.scan = all` property to TomEE's system.properties file to ensure that it scans for all Microprofile libraries.

To run the application at the root, this must be configured in TomEE. You can either use `ROOT.war` as the name of the war file (which is configured as such in this project through Gradle). 
When running from your IDE, you can run the project on the server. Once it's added to the server, you can change its path. If you provide an empty path, it will be running on the root. You need to restart the server to apply this setting.

## Implemented Microprofile specifications
This lists the Microprofile specifications that have been implemented in this project. It mainly shows how you can trigger them to see how they work.

### Jakarta EE 9.1 (JAX-RS 3.0)
http://localhost:8080/hello
Shows a basic JAX-RS web resource that return plain text.

http://localhost:8080/visits
Shows a proper JAX-RS web resource, though limited to showing a list of a few hard-coded API resources.

### OpenAPI 3.0
http://localhost:8080/openapi
Returns YAML by default, set Accept header to application/json for JSON response.

http://localhost:8080/openapi?format=json
This is an alternative approach to get a JSON response.

### Metrics 4.0
http://localhost:8080/metrics
Shows metrics in Prometheus format.

### Health 4.0
http://localhost:8080/health
http://localhost:8080/health/live
http://localhost:8080/health/ready
http://localhost:8080/health/started
Shows the health checks that are implemented in the project.

### Fault Tolerance 4.0
http://localhost:8080/hello/timeout
This API request will always timeout so it shows how the fallback mechanism is triggered.

### Config 3.0
http://localhost:8080/hello/config-property
This API request returns a property defined in the `microprofile-config.properties` file in `src/main/resources`. 

### JWT RBAC 2.0
TODO

### OpenTracing 3.0
TODO
This has been replaced with Telemetry 1.0 in the Microprofile 6.0.

### Rest Client 3.0
TODO
