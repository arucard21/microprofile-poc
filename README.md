# Microprofile PoC

This is a proof-of-concept implementation of a REST API using the Microprofile specifications.

This is tested using a TomEE 9.x server, which contains Tomcat 10.x and supports Jakarta EE 9.1 and Microprofile 5.0.

## Requirements
You must add the `tomee.mp.scan = all` property to TomEE's system.properties file to ensure that it scans for all Microprofile libraries.

To run the application at the root, this must be configured in TomEE. You can either use `ROOT.war` as the name of the war file (which is configured as such in this project through Gradle). 
When running from your IDE, you can run the project on the server. Once it's added to the server, you can change its path. If you provide an empty path, it will be running on the root. You need to restart the server to apply this setting.

## Available URLs
http://localhost:8080/visits
http://localhost:8080/openapi (return YAML by default, set Accept header to application/json for JSON response)
http://localhost:8080/openapi?format=json (alternative approach to get JSON response)
http://localhost:8080/metrics
http://localhost:8080/health
http://localhost:8080/health/live
http://localhost:8080/health/ready
http://localhost:8080/health/started

other untested Microprofile functionality
config
telemetry
restclient
fault tolerance
jwt authentication
