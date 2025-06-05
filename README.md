# <span>KeycloakCon demo</span> Quickstarts

<span>Keycloak</span> is an Open Source Identity and Access Management solution for modern Applications and Services.

This project is an example for KeycloakCon demo 2025.

## Building, Testing, and Running the Quickstarts

Demo tested with those version:

* OpenJDK 21.0.7
* Apache Maven 3.9.9
* Wildfly 30
* Node 23.11.0
* Npm 10.9.2


1) Clone the Keycloak repository:

```
git clone https://github.com/mposolda/keycloakcon-2025.git
cd keycloakcon-2025
```

2) Download and unzip Keycloak server to some location on your laptop. The Keycloak server 26.2.4 or later should work. Assumption that server was unpacked to the directory `keycloak-26.2.4-demo`,
then server could be started on port 8180 with the command like this:
```
keycloak-26.2.4-demo/bin
./kc.sh start-dev --http-port=8180
```

3) Open the http://localhost:8180 and create user `admin`. Then login to the admin console and import the realm `realm-import.json` from this directory. See the Keycloak documentation
for the details about creating new user and importing the realm.

4) Run this to run `js-app`  

```
cd js-app
npm install
npm start
```

5) Go to http://localhost:8080 and login as `alice/alice`

6) Download and start Wildfly 30.0.0.Final to some location on your laptop. Will be referred to as $WILDFLY_HOME:

```
cd $WILDFLY_HOME/bin
./standalone.sh -Djboss.socket.binding.port-offset=200
```

7) Build the project with the demo and copy the deployed WAR file to the started Wildfly server:

```
mvn clean install
cp calendar-backend/target/calendar-backend.war $WILDFLY_HOME/standalone/deployments/
```

8) 





## Documentation

* [Documentation](https://www.keycloak.org/documentation.html)

## Related Projects

* [Keycloak](https://github.com/keycloak/keycloak) - Keycloak Server and Java adapters

## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)

