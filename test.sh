#!/usr/bin/env bash
export VOTING_DB_URL=localhost
export VOTING_DB_USER=root
export VOTING_DB_PASSWORD=root
sh reset.sh
mvn clean
mvn install -DskipTests
mvn test -DVOTING_DB_URL=$VOTING_DB_URL -DVOTING_DB_PASSWORD=$VOTING_DB_PASSWORD -DVOTING_DB_USER=$VOTING_DB_USER
cd tests
mvn test -Dintegrate=true -DVOTING_DB_URL=$VOTING_DB_URL -DVOTING_DB_PASSWORD=$VOTING_DB_PASSWORD -DVOTING_DB_USER=$VOTING_DB_USER
