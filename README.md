## Purpose 

Showcase a simple Quarkus application with the Fabric8 Kubernetes Client in native mode

## Setup

### Prerequisites

* Checkout `https://github.com/geoand/quarkus/tree/kubernetes-client`  

* Build it locally using:


    mvn clean install -DskipTests
    
* Have access to a Kubernetes / Openshift cluster (which you can verify by issuing `kubectl version` and ensuring the response contains both the client and server version)
    
## Build application

To create the native application issue:

    mvn clean package -Dnative
    
## Launch application

Simply execute:

    target/hello-kubernetes-client-1.0-SNAPSHOT-runner         
    
## Test it

    
Execute the following command (using one of the namespaces you have access to)

    curl -i -H "Accept: application/json" -X GET http://localhost:8080/pods/somenamespace
    
The result should a (possibly large) json object    
