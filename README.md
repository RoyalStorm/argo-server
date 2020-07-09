# ARGO server
[![Build Status](https://travis-ci.com/array-team/argo-server.svg?branch=develop)](https://travis-ci.com/array-team/argo-server) [![codecov](https://codecov.io/gh/array-team/argo-server/branch/develop/graph/badge.svg)](https://codecov.io/gh/array-team/argo-server)

Server for AR service to create effects of augmented reality "ARGO".

## Requirements
 - Java 8
 
## Database
API-server comes with MySQL dependency.

## Installation
Download project as '.zip' archive and extract it to whatever you like directory or use `git`:

```sh
git clone https://github.com/RoyalStorm/argo-server.git
```

Create a database with name `argo` in MySQL.
Open this repository in IntelliJ IDEA and add `host`, `port`, `database`, `serverTimezone`, `username` and `password`
environment variables, see `application.yml`.

OR

Replace `url` field with your params. In my case it looks like:

```sh
jdbc:mysql://localhost:3306/argo?useLegacyDatetimeCode=false&serverTimezone=Asia/Vladivostok
```

After this go to `localhost:8080`.