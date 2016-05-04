#!/usr/bin/env bash
sh reset.sh
mvn clean
mvn install -DskipTests
mvn test -DVOTING_DB_URL=localhost -DVOTING_DB_PASSWORD=root -DVOTING_DB_USER=root
cd tests
mvn test -Dintegrate=true -DVOTING_DB_URL=localhost -DVOTING_DB_PASSWORD=root -DVOTING_DB_USER=root
