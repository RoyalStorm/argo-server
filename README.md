<div align="center">
    <img src="assets/argo-logo.png" alt="ARGO">
</div>

# ARGO server
Server for AR service to create effects of augmented reality "ARGO".

## Requirements
 - JDK 1.8
 
## Database
API-server comes with MySQL dependency.

## Installation
Download project as '.zip' archive and extract it to whatever you like directory or use `git`:

```sh
git clone https://github.com/RoyalStorm/argo-server.git
```

Create database with name `argo` in MySQL.
Open this repository in IntelliJ IDEA and add `host`, `port`, `databasename`, `serverTimezone`, `datasourceUsername`
and `datasourcePassword` environment variables, see `application.yml`.

OR

Replace `url` field with your params. In my case it looks like:

```sh
jdbc:mysql://localhost:3306/argo?useLegacyDatetimeCode=false&serverTimezone=Asia/Vladivostok
```

After this go to `localhost:8080/swagger-ui.html`.