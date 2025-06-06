# <span>KeycloakCon demo</span> Quickstarts

<span>Keycloak</span> is an Open Source Identity and Access Management solution for modern Applications and Services.

This project is an example for KeycloakCon demo 2025.

## Building, Testing, and Running the Quickstarts

Demo tested with those version:

* OpenJDK 21.0.7
* Apache Maven 3.9.9
* Keycloak 26.2.4
* Wildfly 30
* Node 23.11.0
* Npm 10.9.2


1) Clone the Keycloak repository:

```
git clone https://github.com/mposolda/keycloakcon-2025.git
cd keycloakcon-2025
```

2) Download and unzip Keycloak server to some location on your laptop. The Keycloak server 26.2.4 or later should work. Assumption that
server was unpacked to the directory `$KEYCLOAK_HOME`, then server could be started on port 8180 with the command like this:
```
cd $KEYCLOAK_HOME/bin
./kc.sh start-dev --http-port=8180
```

3) Open the http://localhost:8180 and create user `admin`. Then login to the admin console and import the realm `realm-import.json` from this directory.
See the Keycloak documentation for the details about creating new user and importing the realm.

4) Run this to run `js-app`  

```
cd js-app
npm install
npm start
```

5) Download and start Wildfly 30.0.0.Final to some location on your laptop. Will be referred to as $WILDFLY_HOME:

```
cd $WILDFLY_HOME/bin
./standalone.sh -Djboss.socket.binding.port-offset=200
```

6) Build the project with the demo and copy the deployed WAR file to the started Wildfly server:

```
mvn clean install
cp calendar-backend/target/calendar-backend.war $WILDFLY_HOME/standalone/deployments/
```

7) Assumption is that tab 1 has admin console opened. So in different browser tab (browser tab 2) go to http://localhost:8080 and login as `alice/alice` .
Problems to solve during the demo:

- Displayed `birthdate` in the application is unknown. in tab 1 in the admin console, it is needed to create
user-profile attribute `birthdate` in the Keycloak admin console, mark it as required for the users and add
annotation `inputTye` with type `html5-date` . Then after refresh the page  http://localhost:8080 in tab 2, alice is required to fill her birthdate.
Now birthdate should be shown in the application. (Protocol mappers could be also shown during the demo).

- Alice cannot see events in the application due the 403. It is needed to assign her the realm role `user` in the admin console.
It can be also good to show the calendar-backend application code and the client-scopes switch `Full scope allowed`.
  

## Documentation

* [Documentation](https://www.keycloak.org/documentation.html)
* [Keycloak Getting started guides](https://www.keycloak.org/guides#getting-started)
* [Keycloak server admin guide](https://www.keycloak.org/docs/latest/server_admin/index.html) - Management of users, clients, roles, role mappings, etc.
* [Keycloak Javascript adapter](https://www.keycloak.org/securing-apps/javascript-adapter) - used to secure `js-app` application in this demo
* [Wildfly Elytron OIDC adapter documentation](https://docs.wildfly.org/30/Admin_Guide.html#Elytron_OIDC_Client) - used to secure `calendar-backend` application in this demo

## Related Projects

* [Keycloak](https://github.com/keycloak/keycloak) - Keycloak Server source code

## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)

