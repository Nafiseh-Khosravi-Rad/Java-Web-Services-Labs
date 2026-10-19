# Java web services labs

I programmed these Java servlet applications, REST services and REST consumers as college web-services exercises. The labs progress from request handling and domain classes to JSON APIs and HTTP clients.

## Projects

| Lab | Implementations |
|---|---|
| Lab-01 | Greeting, course and billing servlets with Java domain classes |
| Lab-02 | Postman request collection; the supplied submission contains no Java source |
| Lab-03 | Greeting, mathematics, car and billing REST resources |
| Lab-04 | REST consumers, a graphical greeting client, and greeting, mathematics, car and faculty services |

Projects remain separate so their endpoint paths, dependencies and runtime configurations can be inspected independently. Servlet and REST resource classes handle requests; model classes represent exercise data. Client projects use the Jakarta REST client API to call the services.

## Requirements and build

Use JDK 17 and Maven for projects containing pom.xml. These applications require a compatible Jakarta servlet/REST runtime; building a WAR does not start a server. For example, from the repository root:

```sh
mvn -f Lab-03/WebHelloRESTProject/pom.xml package
```

On 19 October 2026, all eleven supplied Maven projects passed package builds using cached dependencies. Tests were skipped for that build check; no automated runtime-test pass is claimed. A fresh dependency installation and live servlet/API deployment were not verified.

Lab-01 contains servlet source and deployment descriptors but no Maven POM. Configure a compatible servlet runtime before compiling/deploying those projects. Lab-04/WebMathOperationsRESTProject2 also lacks a POM in the supplied archive; it is retained as source rather than presented as a verified Maven build.

## API exercises

Import Lab-02/Lab 2 Testing.postman_collection.json into Postman. Some saved entries have empty URLs and need configuration before use. Inspect the configured URLs and adapt the local server port/context to your deployment before sending requests. The collection has not been run during this publication check.

Lab-04 consumers use local service URLs, including port 8081 in some projects. Deploy the matching service and confirm its path before launching a client. Java console consumers and the graphical client are separate entry points.

## Boundaries

Submission reports, instructor handouts, build output, IDE configuration, private datasets and complete finance applications are excluded. The repository documents programming exercises; it does not claim authentication, persistent multi-user storage or production deployment.
