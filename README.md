# <span>KeycloakCon demo</span> Quickstarts

<span>Keycloak</span> is an Open Source Identity and Access Management solution for modern Applications and Services.

This project is an example for KeycloakCon demo 2025.

## Building, Testing, and Running the Quickstarts

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





## Documentation

* [Documentation](https://www.keycloak.org/documentation.html)

## Related Projects

* [Keycloak](https://github.com/keycloak/keycloak) - Keycloak Server and Java adapters

## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)

