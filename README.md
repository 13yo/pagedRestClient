# Paged REST Client

This application attempts an implementation of the paged _Users_ endpoint provided by [Reqres](https://reqres.in/).

## Usage
### Configuration
The URL of the API can be configured in the `application.properties` file. These are the values:
```properties
service.user.url.base=https://reqres.in
service.user.url.path=/api/users
```

### First page
The command line tool prints the first _Users_ page if no argument is given. 

```bash
$ java -jar restclient.jar

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::            (v3.0.0-RC1)

Retrieving the first users page ...
User(id=1, email=george.bluth@reqres.in, firstName=George, lastName=Bluth)
User(id=2, email=janet.weaver@reqres.in, firstName=Janet, lastName=Weaver)
User(id=3, email=emma.wong@reqres.in, firstName=Emma, lastName=Wong)
User(id=4, email=eve.holt@reqres.in, firstName=Eve, lastName=Holt)
User(id=5, email=charles.morris@reqres.in, firstName=Charles, lastName=Morris)
User(id=6, email=tracey.ramos@reqres.in, firstName=Tracey, lastName=Ramos)
```
### All users
The option `-f|--full` will cause the tool to pull all _Users_.

```bash
$ java -jar restclient.jar --full

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::            (v3.0.0-RC1)

Getting the full list of users ...
User(id=1, email=george.bluth@reqres.in, firstName=George, lastName=Bluth)
User(id=2, email=janet.weaver@reqres.in, firstName=Janet, lastName=Weaver)
User(id=3, email=emma.wong@reqres.in, firstName=Emma, lastName=Wong)
User(id=4, email=eve.holt@reqres.in, firstName=Eve, lastName=Holt)
User(id=5, email=charles.morris@reqres.in, firstName=Charles, lastName=Morris)
User(id=6, email=tracey.ramos@reqres.in, firstName=Tracey, lastName=Ramos)
User(id=7, email=michael.lawson@reqres.in, firstName=Michael, lastName=Lawson)
User(id=8, email=lindsay.ferguson@reqres.in, firstName=Lindsay, lastName=Ferguson)
User(id=9, email=tobias.funke@reqres.in, firstName=Tobias, lastName=Funke)
User(id=10, email=byron.fields@reqres.in, firstName=Byron, lastName=Fields)
User(id=11, email=george.edwards@reqres.in, firstName=George, lastName=Edwards)
User(id=12, email=rachel.howell@reqres.in, firstName=Rachel, lastName=Howell)
```

## Building the code
The tool was created using Gradle. It can be built using the `gradlew build` command.

```bash
$ gradlew build

18:08:21: Executing 'build'...

> Task :compileJava
> Task :processResources
> Task :classes
> Task :resolveMainClassName
> Task :bootJar
> Task :jar
> Task :assemble
> Task :compileTestJava
> Task :processTestResources NO-SOURCE
> Task :testClasses
> Task :test
> Task :check
> Task :build

BUILD SUCCESSFUL in 18s
7 actionable tasks: 7 executed
18:08:41: Execution finished 'build'.
```
